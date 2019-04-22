package toxicityprediction;

import java.util.*;

/**
 *
 * @author Γρηγόρης
 */
public class Calculations {
    
    private String name;
    private List<kvantomechanicIndexes> indexes;
    private List<metalOxide> metals;

    public Calculations() {
    }

    public Calculations(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<kvantomechanicIndexes> getIndexes() {
        return indexes;
    }

    public List<metalOxide> getMetals() {
        return metals;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIndexes(List<kvantomechanicIndexes> indexes) {
        this.indexes = indexes;
    }

    public void setMetals(List<metalOxide> metals) {
        this.metals = metals;
    }
    
    public void normalization(List<metalOxide> metals, List<kvantomechanicIndexes> indexes){
        
        double tempMax = 0;
        double tempMin = 0;
        double tempSum = 0;
        double tempMean = 0;
        double tempDiff = 0;
        double[] tempNormalizedValues = new double[metals.size()];
        
        for (kvantomechanicIndexes indexe : indexes) {
            //Max, min, sum, max-min difference, mean value of each kvantomechanicIndexes item
            tempMax = indexe.maxValueOfEachIndex(indexe.getInitialValues());
            tempMin = indexe.minValueOfEachIndex(indexe.getInitialValues());
            tempSum = indexe.sumOfValuesOfEachIndex(indexe.getInitialValues());
            tempDiff = tempMax - tempMin;
            tempMean = tempSum/metals.size();
            
            indexe.setMaxOfInitialValues(tempMax);
            indexe.setMinOfInitialValues(tempMin);
            indexe.setSumOfInitialValues(tempSum);
            indexe.setDiffMaxMinOfInitialValues(tempDiff);
            indexe.setMeanOfInitialValues(tempMean);
            
            tempNormalizedValues = indexe.calculateNormalizeVales(indexe);
            indexe.setNormalizedValues(tempNormalizedValues);
            
            tempSum = indexe.sumOfValuesOfEachIndex(tempNormalizedValues);
            tempMean = tempSum/metals.size();
            
            indexe.setSumOfNormalizedValues(tempSum);
            indexe.setMeanOfNormalizedValues(tempMean);
        }
    }
    
    public List<String> PearsonCoefficientCalculation(List<metalOxide> metals, List<kvantomechanicIndexes> indexes){
        
        double tempSum = 0;
        double tempSqrt = 0;
        double[] tempNormalizedValueAbstractMeanOfNormalizedValues = new double[metals.size()];
        double[] tempNormalizedValueAbstractMeanOfNormalizedValuesSquare = new double[metals.size()];
        
        double tempSumOfPearson = 0;
        double tempValueOfPearson = 0;
        double firstTempMaxOfPearson = 0;
        double secondTempMaxOfPearson = 0;
        String firstMaxOfPearson = null;
        String secondMaxOfPearson = null;
        List<String> inputVariablesNames = new ArrayList<>();
        
        for (kvantomechanicIndexes indexe : indexes){
            
            tempNormalizedValueAbstractMeanOfNormalizedValues = indexe.calculateNormalizedValueAbstractMeanOfNormalizedValues(indexe.getNormalizedValues(), indexe.getMeanOfNormalizedValues());
            indexe.setNormalizedValueAbstractMeanOfNormalizedValues(tempNormalizedValueAbstractMeanOfNormalizedValues);
            
            tempNormalizedValueAbstractMeanOfNormalizedValuesSquare = indexe.calculateNormalizedValueAbstractMeanOfNormalizedValuesSquare(indexe.getNormalizedValueAbstractMeanOfNormalizedValues());
            indexe.setNormalizedValueAbstractMeanOfNormalizedValuesSquare(tempNormalizedValueAbstractMeanOfNormalizedValuesSquare);
            
            tempSum = indexe.sumOfValuesOfEachIndex(indexe.getNormalizedValueAbstractMeanOfNormalizedValuesSquare());
            tempSqrt = Math.sqrt(tempSum);
            
            indexe.setSumOfNormalizedValueAbstractMeanOfNormalizedValuesSquare(tempSum);
            indexe.setSqrtOfSumOfNormalizedValueAbstractMeanOfNormalizedValuesSquare(tempSqrt);
        }
        
        for(int i=0;i<(indexes.size()-1);i++){
                tempSumOfPearson = 0;
                for(int k=0;k<(metals.size()-1);k++){
                    tempSumOfPearson += indexes.get(i).getNormalizedValueAbstractMeanOfNormalizedValues()[k] * indexes.get(indexes.size()-1).getNormalizedValueAbstractMeanOfNormalizedValues()[k];
                }
                tempValueOfPearson = tempSumOfPearson / (indexes.get(i).getSqrtOfSumOfNormalizedValueAbstractMeanOfNormalizedValuesSquare()*indexes.get(indexes.size()-1).getSqrtOfSumOfNormalizedValueAbstractMeanOfNormalizedValuesSquare());
                
                if(tempValueOfPearson>firstTempMaxOfPearson || tempValueOfPearson>secondTempMaxOfPearson){
                    if(firstTempMaxOfPearson>secondTempMaxOfPearson){
                        secondTempMaxOfPearson = tempValueOfPearson;
                        secondMaxOfPearson = indexes.get(i).getName();
                    }else{
                        firstTempMaxOfPearson = tempValueOfPearson;
                        firstMaxOfPearson = indexes.get(i).getName();
                    }
                }
        }
        inputVariablesNames.add(firstMaxOfPearson);
        inputVariablesNames.add(secondMaxOfPearson);
        
        
        return inputVariablesNames;
    }
    
    
    public List<metalOxide> calculateTrainingSet(List<metalOxide> metals, List<kvantomechanicIndexes> indexes){
        
        List<metalOxide> metalTrainingSet = new ArrayList<>();
        String firstTempSelectedMetal = null;
        String secondTempSelectedMetal = null;
        double tempEukleidiaDistance = 0;
        double tempSumOfEukleidiaDistance = 0;
        double maxEukleidiaDistance = 0;
        
        double minEukleidiaDistance = 100000000;
        String minTempSelectedMetal = null;
        boolean metalExistsInTrainingSet = false;
        String maxEukleidiaDistanceBetweenMinDistancesInTrainingSet = null;
        double maxValueEukleidiaDistanceBetweenMinDistancesInTrainingSet = 0;
        List<Integer> integersIntoTrainingSet = new ArrayList<>();
        Map<String, Double> minValuesWithTheirMetals = new HashMap<>();
        
        //first 2 elements of Training Set
        for(int i=0;i<(metals.size()-2);i++){
            for(int j=i+1;j<(metals.size()-1);j++){
                tempSumOfEukleidiaDistance = 0;
                for(int k=0;k<(indexes.size()-1);k++){
                    tempSumOfEukleidiaDistance += Math.pow((indexes.get(k).getNormalizedValues()[i] - indexes.get(j).getNormalizedValues()[j]), 2) ;
                }
                tempEukleidiaDistance = Math.sqrt(tempSumOfEukleidiaDistance);
                if(tempEukleidiaDistance>maxEukleidiaDistance){
                    maxEukleidiaDistance = tempEukleidiaDistance;
                    firstTempSelectedMetal = metals.get(i).getName();
                    secondTempSelectedMetal = metals.get(j).getName();
                }
            }
        }
        
        for (metalOxide metal : metals) {
            if(metal.getName().equals(firstTempSelectedMetal) || metal.getName().equals(secondTempSelectedMetal))
                metalTrainingSet.add(metal);
        }
        
        //rest 8 elements of Training Set
        while(metalTrainingSet.size()<10){
            maxEukleidiaDistanceBetweenMinDistancesInTrainingSet = null;
            maxValueEukleidiaDistanceBetweenMinDistancesInTrainingSet = 0;
            for(int i=0;i<(metals.size()-1);i++){
                metalExistsInTrainingSet = false;
                for(int l=0;l<metalTrainingSet.size();l++){
                    if(metals.get(i).getName().equals(metalTrainingSet.get(l).getName())){
                        metalExistsInTrainingSet = true;
                    }
                }
                if(metalExistsInTrainingSet==false){
                    minEukleidiaDistance = 100000000;
                    for(int j=0;j<metalTrainingSet.size();j++){
                        if(!metals.get(i).getName().equals(metalTrainingSet.get(j))){
                            tempSumOfEukleidiaDistance = 0;
                            for(int k=0;k<(indexes.size()-1);k++){
                                tempSumOfEukleidiaDistance += Math.pow((indexes.get(k).getNormalizedValues()[i] - indexes.get(j).getNormalizedValues()[j]), 2) ;
                            }
                            tempEukleidiaDistance = Math.sqrt(tempSumOfEukleidiaDistance);
                            if(tempEukleidiaDistance<minEukleidiaDistance){
                                minEukleidiaDistance = tempEukleidiaDistance;
                                minTempSelectedMetal = metals.get(i).getName();
                            }
                        }
                    }
                minValuesWithTheirMetals.put(minTempSelectedMetal, minEukleidiaDistance);
                }  
            }
        
            for(Map.Entry<String, Double> maxValue : minValuesWithTheirMetals.entrySet()){
                if (maxValue.getValue() > maxValueEukleidiaDistanceBetweenMinDistancesInTrainingSet) {
                    maxEukleidiaDistanceBetweenMinDistancesInTrainingSet = maxValue.getKey();
                    maxValueEukleidiaDistanceBetweenMinDistancesInTrainingSet = maxValue.getValue();
                }
            }
        
            for (metalOxide metal : metals) {
                if(metal.getName().equals(maxEukleidiaDistanceBetweenMinDistancesInTrainingSet))
                    metalTrainingSet.add(metal);
            }
        
            minValuesWithTheirMetals.clear();
        }
        return metalTrainingSet;
    }
}
