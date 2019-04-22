package toxicityprediction;

import java.util.*;

/**
 *
 * @author Γρηγόρης
 */
public class kvantomechanicIndexes {
    
    private String name;
    
    private double[] initialValues;
    private double maxOfInitialValues;
    private double minOfInitialValues;
    private double diffMaxMinOfInitialValues;
    private double sumOfInitialValues;
    private double meanOfInitialValues;
    
    private double[] normalizedValues;
    private double sumOfNormalizedValues;
    private double meanOfNormalizedValues;
    
    private double[] normalizedValueAbstractMeanOfNormalizedValues;
    private double[] normalizedValueAbstractMeanOfNormalizedValuesSquare;
    private double sumOfNormalizedValueAbstractMeanOfNormalizedValuesSquare;
    private double sqrtOfSumOfNormalizedValueAbstractMeanOfNormalizedValuesSquare;
    
    private List<metalOxide> metals;
    private Calculations calculation;

    public kvantomechanicIndexes(String name) {
        this.name = name;
        metals = new ArrayList<>();
    }

    
    public kvantomechanicIndexes(String name, double[] initialValues) {
        this.name = name;
        this.initialValues = initialValues;
        metals = new ArrayList<>();
    }

    public kvantomechanicIndexes(String name, double[] initialValues, List<metalOxide> metals) {
        this.name = name;
        this.initialValues = initialValues;
        this.metals = metals;
    }
    
    public String getName() {
        return name;
    }

    public double[] getInitialValues() {
        return initialValues;
    }

    public double getMaxOfInitialValues() {
        return maxOfInitialValues;
    }

    public double getMinOfInitialValues() {
        return minOfInitialValues;
    }

    public double getDiffMaxMinOfInitialValues() {
        return diffMaxMinOfInitialValues;
    }

    public double getSumOfInitialValues() {
        return sumOfInitialValues;
    }

    public double getMeanOfInitialValues() {
        return meanOfInitialValues;
    }

    public double[] getNormalizedValues() {
        return normalizedValues;
    }

    public double getSumOfNormalizedValues() {
        return sumOfNormalizedValues;
    }

    public double getMeanOfNormalizedValues() {
        return meanOfNormalizedValues;
    }

    public List<metalOxide> getMetals() {
        return metals;
    }

    public Calculations getCalculation() {
        return calculation;
    }

    public double[] getNormalizedValueAbstractMeanOfNormalizedValues() {
        return normalizedValueAbstractMeanOfNormalizedValues;
    }

    public double[] getNormalizedValueAbstractMeanOfNormalizedValuesSquare() {
        return normalizedValueAbstractMeanOfNormalizedValuesSquare;
    }

    public double getSumOfNormalizedValueAbstractMeanOfNormalizedValuesSquare() {
        return sumOfNormalizedValueAbstractMeanOfNormalizedValuesSquare;
    }

    public double getSqrtOfSumOfNormalizedValueAbstractMeanOfNormalizedValuesSquare() {
        return sqrtOfSumOfNormalizedValueAbstractMeanOfNormalizedValuesSquare;
    }
        
    public void setName(String name) {
        this.name = name;
    }

    public void setInitialValues(double[] initialValues) {
        this.initialValues = initialValues;
    }

    public void setMaxOfInitialValues(double maxOfInitialValues) {
        this.maxOfInitialValues = maxOfInitialValues;
    }

    public void setMinOfInitialValues(double minOfInitialValues) {
        this.minOfInitialValues = minOfInitialValues;
    }

    public void setDiffMaxMinOfInitialValues(double diffMaxMinOfInitialValues) {
        this.diffMaxMinOfInitialValues = diffMaxMinOfInitialValues;
    }

    public void setSumOfInitialValues(double sumOfInitialValues) {
        this.sumOfInitialValues = sumOfInitialValues;
    }

    public void setMeanOfInitialValues(double meanOfInitialValues) {
        this.meanOfInitialValues = meanOfInitialValues;
    }

    public void setNormalizedValues(double[] normalizedValues) {
        this.normalizedValues = normalizedValues;
    }

    public void setSumOfNormalizedValues(double sumOfNormalizedValues) {
        this.sumOfNormalizedValues = sumOfNormalizedValues;
    }

    public void setMeanOfNormalizedValues(double meanOfNormalizedValues) {
        this.meanOfNormalizedValues = meanOfNormalizedValues;
    }

    public void setMetals(List<metalOxide> metals) {
        this.metals = metals;
    }

    public void setCalculation(Calculations calculation) {
        this.calculation = calculation;
    }

    public void setNormalizedValueAbstractMeanOfNormalizedValues(double[] normalizedValueAbstractMeanOfNormalizedValues) {
        this.normalizedValueAbstractMeanOfNormalizedValues = normalizedValueAbstractMeanOfNormalizedValues;
    }

    public void setNormalizedValueAbstractMeanOfNormalizedValuesSquare(double[] normalizedValueAbstractMeanOfNormalizedValuesSquare) {
        this.normalizedValueAbstractMeanOfNormalizedValuesSquare = normalizedValueAbstractMeanOfNormalizedValuesSquare;
    }

    public void setSumOfNormalizedValueAbstractMeanOfNormalizedValuesSquare(double sumOfNormalizedValueAbstractMeanOfNormalizedValuesSquare) {
        this.sumOfNormalizedValueAbstractMeanOfNormalizedValuesSquare = sumOfNormalizedValueAbstractMeanOfNormalizedValuesSquare;
    }

    public void setSqrtOfSumOfNormalizedValueAbstractMeanOfNormalizedValuesSquare(double sqrtOfSumOfNormalizedValueAbstractMeanOfNormalizedValuesSquare) {
        this.sqrtOfSumOfNormalizedValueAbstractMeanOfNormalizedValuesSquare = sqrtOfSumOfNormalizedValueAbstractMeanOfNormalizedValuesSquare;
    }
        
    public void addMetals(metalOxide metal){
        metals.add(metal);
    }
    
    public void removeMetals(metalOxide metal){
        metals.remove(metal);
    }
    
    public void printInfo(){
        System.out.println("\nIndex name: " + name);
        System.out.println("Initial values:");
        for(int i=0;i<initialValues.length;i++){
            System.out.println("\t" + initialValues[i]);
        }
        System.out.println("\tInitial max value: " + maxOfInitialValues);
        System.out.println("\tInitial min value: " + minOfInitialValues);
        System.out.println("\tSum of initial values: " + sumOfInitialValues);
        System.out.println("\tMean of initial values: " + meanOfInitialValues);
        System.out.println("Normalized values:");
        for(int i=0;i<normalizedValues.length;i++){
            System.out.println("\t" + normalizedValues[i]);
        }
        System.out.println("\tSum of normalized values: " + sumOfNormalizedValues);
        System.out.println("\tMean of normalized values: " + meanOfNormalizedValues);
        System.out.println("Abstracted values: ");
        for(int i=0;i<normalizedValueAbstractMeanOfNormalizedValues.length;i++){
            System.out.println("\t" + normalizedValueAbstractMeanOfNormalizedValues[i]);
        }
        System.out.println("Abstracted values poweres by 2: ");
        for(int i=0;i<normalizedValueAbstractMeanOfNormalizedValuesSquare.length;i++){
            System.out.println("\t" + normalizedValueAbstractMeanOfNormalizedValuesSquare[i]);
        }
        System.out.println("\tSum of normalized abstracted values: " + sumOfNormalizedValueAbstractMeanOfNormalizedValuesSquare);
        System.out.println("\tSquare of sumof normalized abstracted values: " + sqrtOfSumOfNormalizedValueAbstractMeanOfNormalizedValuesSquare);
        
    }
    
    public double maxValueOfEachIndex(double[] values){
        
        double max = Arrays.stream(values).max().getAsDouble();
        
        return max;
    }
    
    public double minValueOfEachIndex(double[] values){
        
        double min = Arrays.stream(values).min().getAsDouble();
        
        return min;
    }
    
    public double sumOfValuesOfEachIndex(double[] values){
        
        double sum = 0;
        for(int i=0;i<values.length;i++){
            sum += values[i];
        }
        
        return sum;
    }
    
    public double[] calculateNormalizedValueAbstractMeanOfNormalizedValues(double[] values, double meanValue){
        
        double[] results = new double[values.length];
        
        for(int i=0;i<values.length;i++){
            results[i] = (values[i] - meanValue);
        }
        
        return results;
    }
    
    public double[] calculateNormalizedValueAbstractMeanOfNormalizedValuesSquare(double[] values){
        
        double[] results = new double[values.length];
        
        for(int i=0;i<values.length;i++){
            results[i] = Math.pow(values[i], 2);
        }
        
        return results;
    }
    
    public double[] calculateNormalizeVales(kvantomechanicIndexes index){
        
        double[] results = new double[index.getInitialValues().length];
        
        for(int i=0;i<index.getInitialValues().length;i++){
            results[i] = ((index.getInitialValues()[i] - index.getMinOfInitialValues()) / index.getDiffMaxMinOfInitialValues());
        }
        
        return results;
    }
}
