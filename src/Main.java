package toxicityprediction;

import java.util.*;

/**
 *
 * @author Γρηγόρης
 */
public class Main {

    public static void main(String[] args) throws Exception{
        
        metalOxide oxide1 = new metalOxide("Al2O3");
        metalOxide oxide2 = new metalOxide("Bl2O3");
        metalOxide oxide3 = new metalOxide("CoO");
        metalOxide oxide4 = new metalOxide("Cr2O3");
        metalOxide oxide5 = new metalOxide("Fe2O3");
        metalOxide oxide6 = new metalOxide("In2O3");
        metalOxide oxide7 = new metalOxide("Mn2O3");
        metalOxide oxide8 = new metalOxide("NiO");
        metalOxide oxide9 = new metalOxide("Sb2O3");
        metalOxide oxide10 = new metalOxide("SiO2");
        metalOxide oxide11 = new metalOxide("SnO2");
        metalOxide oxide12 = new metalOxide("TiO2");
        metalOxide oxide13 = new metalOxide("V2O3");
        metalOxide oxide14 = new metalOxide("WO3");
        metalOxide oxide15 = new metalOxide("Y2O3");
        metalOxide oxide16 = new metalOxide("ZnO");
        metalOxide oxide17 = new metalOxide("ZrO2");
        metalOxide oxide18 = new metalOxide("La2O3");
        
        List<metalOxide> allMetalOxides = new ArrayList<>();
        allMetalOxides.add(oxide1);
        allMetalOxides.add(oxide2);
        allMetalOxides.add(oxide3);
        allMetalOxides.add(oxide4);
        allMetalOxides.add(oxide5);
        allMetalOxides.add(oxide6);
        allMetalOxides.add(oxide7);
        allMetalOxides.add(oxide8);
        allMetalOxides.add(oxide9);
        allMetalOxides.add(oxide10);
        allMetalOxides.add(oxide11);
        allMetalOxides.add(oxide12);
        allMetalOxides.add(oxide13);
        allMetalOxides.add(oxide14);
        allMetalOxides.add(oxide15);
        allMetalOxides.add(oxide16);
        allMetalOxides.add(oxide17);
        allMetalOxides.add(oxide18);     
        
        
        double[] initialValues1 = {-600,-148.5,-786.8,-235.3,-378.5,-52.1,-96.3,68,-206.7,-618.3,-266.6,-1492,-139.5,-715.4,-135.3,-449.4,-638.1,-157.7};
        kvantomechanicIndexes index1 = new kvantomechanicIndexes("standardEnthalpyOfFormationDHcf", initialValues1);
        index1.setMetals(allMetalOxides);
                        
        double[] initialValues2 = {-2755.8,-2864.3,-5378.2,-2507.8,-3480.9,-1961,-5269.3,-4671,-2504.8,-2764.2,-3511,-2782.9,-2168.1,-4310.9,-2179.8,-1320.2,-1331.3,-2486.1};
        kvantomechanicIndexes index2 = new kvantomechanicIndexes("totalEnergyTE", initialValues2);
        index2.setMetals(allMetalOxides);
        
        double[] initialValues3 = {-11997.7,-11242.7,-45466.7,-10028.3,-13651.6,-6085.1,-34774.7,-22764.2,-10756.3,-10201.7,-17713,-12685.1,-7623.9,-21750.8,-9171.1,-3221.7,-3510.7,-8602.4};
        kvantomechanicIndexes index3 = new kvantomechanicIndexes("electronicEnergyEE", initialValues3);
        index3.setMetals(allMetalOxides);
        
        double[] initialValues4 = {9242,8378.4,40088.5,7520.4,10170.7,4124.1,29505.4,18093.2,8251.5,7437.6,14202,9902.2,5455.8,17439.9,6991.3,1901.5,2179.4,6116.2};
        kvantomechanicIndexes index4 = new kvantomechanicIndexes("repulsionEnergyCore", initialValues4);
        index4.setMetals(allMetalOxides);
        
        double[] initialValues5 = {307.16,251.04,347.56,167.3,172.57,191.2,321.38,179.35,255.24,262.92,359.32,271.58,206.12,302.37,636.97,153.42,178.99,232.92};
        kvantomechanicIndexes index5 = new kvantomechanicIndexes("solventAccesibleSurfacesSAS", initialValues5);
        index5.setMetals(allMetalOxides);
        
        double[] initialValues6 = {-8.53,-9.43,-9.21,-8.25,-8.33,-10.62,-5.02,-7.78,-7.96,-7.9,-6.97,-7.08,-5.81,-6.84,-5.19,-11.36,-10.92,-10.91};
        kvantomechanicIndexes index6 = new kvantomechanicIndexes("HOMO", initialValues6);
        index6.setMetals(allMetalOxides);
        
        double[] initialValues7 = {1.66,-1.25,-5.67,-0.46,-0.09,-2.95,-4.98,-1.16,-0.96,0.28,-2.18,-2.73,-0.66,-6.61,-1.51,-5.3,1.03,-2};
        kvantomechanicIndexes index7 = new kvantomechanicIndexes("LUMO", initialValues7);
        index7.setMetals(allMetalOxides);
        
        double[] initialValues8 = {-5.09,-4.09,-1.77,-3.89,-4.12,-3.84,-0.02,-3.31,-3.5,-4.09,-2.4,-2.18,-2.58,-0.11,-1.84,-3.03,-5.97,-4.45};
        kvantomechanicIndexes index8 = new kvantomechanicIndexes("chemicalHardness", initialValues8);
        index8.setMetals(allMetalOxides);
        
        double[] initialValues9 = {-0.1,-0.12,-0.28,-0.13,-0.12,-0.13,-27.78,-0.15,-0.14,-0.12,-0.21,-0.23,-0.19,-4.41,-0.27,-0.16,-0.08,-0.11};
        kvantomechanicIndexes index9 = new kvantomechanicIndexes("totalSoftness", initialValues9);
        index9.setMetals(allMetalOxides);
                
        double[] initialValues10 = {-10.18,-8.18,-3.55,-7.79,-8.24,-7.68,-0.04,-6.62,-7,-8.18,-4.79,-4.36,-5.15,-0.23,-3.68,-6.07,-11.95,-8.9};
        kvantomechanicIndexes index10 = new kvantomechanicIndexes("energyGapEg", initialValues10);
        index10.setMetals(allMetalOxides);
        
        double[] initialValues11 = {-3.44,-5.34,-7.44,-4.36,-4.21,-6.78,-5,-4.47,-4.46,-3.81,-4.57,-4.91,-3.24,-6.73,-3.35,-8.33,-4.95,-6.45};
        kvantomechanicIndexes index11 = new kvantomechanicIndexes("electronicChemicalPotential", initialValues11);
        index11.setMetals(allMetalOxides);
        
        double[] initialValues12 = {1.66,-1.25,-5.67,-0.46,-0.09,-2.95,-4.98,-1.16,-0.96,0.28,-2.18,-2.73,-0.66,-6.61,-1.51,-5.3,1.03,-2};
        kvantomechanicIndexes index12 = new kvantomechanicIndexes("valanceBandEV", initialValues12);
        index12.setMetals(allMetalOxides);
        
        double[] initialValues13 = {-8.53,-9.43,-9.21,-8.25,-8.33,-10.62,-5.02,-7.78,-7.96,-7.9,-6.97,-7.08,-5.81,-6.84,-5.19,-11.36,-10.92,-10.91};
        kvantomechanicIndexes index13 = new kvantomechanicIndexes("conductionBandEC", initialValues13);
        index13.setMetals(allMetalOxides);
        
        double[] initialValues14 = {3.44,5.34,7.44,4.36,4.21,6.78,5,4.47,4.46,3.81,4.57,4.91,3.24,6.73,3.35,8.33,4.95,6.45};
        kvantomechanicIndexes index14 = new kvantomechanicIndexes("mullikenElectronegativity", initialValues14);
        index14.setMetals(allMetalOxides);
        
        double[] initialValues15 = {5.09,4.09,1.5,3.89,4.44,3.84,0.02,3.04,3.5,4.09,2.4,2.14,2.58,0.11,1.84,3.03,5.97,4.45};
        kvantomechanicIndexes index15 = new kvantomechanicIndexes("ParrAndPeopleAbsoluteHardnessHard", initialValues15);index1.addMetals(oxide1);
        index15.setMetals(allMetalOxides);
        
        double[] initialValues16 = {-3.44,-5.34,-8.25,-4.36,-4.57,-6.78,-5,-4.37,-4.46,-3.81,-4.57,-4.33,-3.24,-6.73,-3.35,-8.33,-4.95,-6.45};
        kvantomechanicIndexes index16 = new kvantomechanicIndexes("schuurmannAlphaShift", initialValues16);
        index16.setMetals(allMetalOxides);
        
        double[] initialValues17 = {17.83,19.92,45.5,16.36,12.33,12.44,734.03,21.35,23.21,31.58,34.22,49.54,26.36,40.16,107,9.09,10.74,4.95};
        kvantomechanicIndexes index17 = new kvantomechanicIndexes("polarizabilityOfFormationAhof", initialValues17);
        index17.setMetals(allMetalOxides);
        
        double[] initialValues18 = {17.79,19.84,45.5,16.02,12.32,12.43,40.97,21.23,23.12,31.54,34.14,24.94,26.22,39.79,106.98,9.7,10.71,4.95};
        kvantomechanicIndexes index18 = new kvantomechanicIndexes("polarizabilityFromDipoleMomentAd", initialValues18);
        index18.setMetals(allMetalOxides);
        
        double[] initialValues19 = {1.85,2.5,2.83,2.3,2.05,2.92,2.64,2.49,2.31,2.12,2.67,1.76,2.24,2.56,2.21,3.32,2.02,0};
        kvantomechanicIndexes index19 = new kvantomechanicIndexes("toxicityIndex", initialValues19);
        index19.setMetals(allMetalOxides);
        
        
        List<kvantomechanicIndexes> allKvantomechanicIndexes= new ArrayList<>();
        allKvantomechanicIndexes.add(index1);
        allKvantomechanicIndexes.add(index2);
        allKvantomechanicIndexes.add(index3);
        allKvantomechanicIndexes.add(index4);
        allKvantomechanicIndexes.add(index5);
        allKvantomechanicIndexes.add(index6);
        allKvantomechanicIndexes.add(index7);
        allKvantomechanicIndexes.add(index8);
        allKvantomechanicIndexes.add(index9);
        allKvantomechanicIndexes.add(index10);
        allKvantomechanicIndexes.add(index11);
        allKvantomechanicIndexes.add(index12);
        allKvantomechanicIndexes.add(index13);
        allKvantomechanicIndexes.add(index14);
        allKvantomechanicIndexes.add(index15);
        allKvantomechanicIndexes.add(index16);
        allKvantomechanicIndexes.add(index17);
        allKvantomechanicIndexes.add(index18);
        allKvantomechanicIndexes.add(index19);
        
        oxide1.setIndexes(allKvantomechanicIndexes);
        oxide2.setIndexes(allKvantomechanicIndexes);
        oxide3.setIndexes(allKvantomechanicIndexes);
        oxide4.setIndexes(allKvantomechanicIndexes);
        oxide5.setIndexes(allKvantomechanicIndexes);
        oxide6.setIndexes(allKvantomechanicIndexes);
        oxide7.setIndexes(allKvantomechanicIndexes);
        oxide8.setIndexes(allKvantomechanicIndexes);
        oxide9.setIndexes(allKvantomechanicIndexes);
        oxide10.setIndexes(allKvantomechanicIndexes);
        oxide11.setIndexes(allKvantomechanicIndexes);
        oxide12.setIndexes(allKvantomechanicIndexes);
        oxide13.setIndexes(allKvantomechanicIndexes);
        oxide14.setIndexes(allKvantomechanicIndexes);
        oxide15.setIndexes(allKvantomechanicIndexes);
        oxide16.setIndexes(allKvantomechanicIndexes);
        oxide17.setIndexes(allKvantomechanicIndexes);
        oxide18.setIndexes(allKvantomechanicIndexes);
     
        //abstract last item of metalOxide list, because it is writen again
        allMetalOxides.remove(allMetalOxides.size()-1);
        
        Calculations calculation = new Calculations("normalizationCalculation");
        
        
        
        //calculation of normalized values
        calculation.normalization(allMetalOxides, allKvantomechanicIndexes);
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Normalization Completed");
        System.out.println("-----------------------------------------------------------------------------");
        
        
        //Pearson correlation coeeficint calculation
        //Choose 2 variables as input for neural network
        List<String> variablesChosenForInput = new ArrayList<>();
        variablesChosenForInput = calculation.PearsonCoefficientCalculation(allMetalOxides, allKvantomechanicIndexes);
        System.out.println("\n\n-----------------------------------------------------------------------------");
        System.out.println("Pearson correlation coefficient calculation Completed");
        System.out.println("\nVariables selected as input variables:");
        for (String variablesChosenForInput1 : variablesChosenForInput) {
            System.out.println(variablesChosenForInput1);
        }
        System.out.println("-----------------------------------------------------------------------------");
        
        
        
        //Creation of new list with metalOxides, because no calculation must be done with last item of first list
        List<metalOxide> metalOxidesToDivideIntoSets = new ArrayList<>();
        metalOxidesToDivideIntoSets = allMetalOxides;
        metalOxidesToDivideIntoSets.remove(17);
        //Training Set
        List<metalOxide> metalsOfTrainingData = new ArrayList<>();
        metalsOfTrainingData = calculation.calculateTrainingSet(metalOxidesToDivideIntoSets, allKvantomechanicIndexes);
        
        //Test Set
        List<metalOxide> metalsOfTestData = new ArrayList<>();
        boolean metalFoundIntoTrainingData = false;
        for (metalOxide allMetalOxide : allMetalOxides) {
            metalFoundIntoTrainingData = false;
            for (metalOxide metalsOfTrainingData1 : metalsOfTrainingData) {
                if(allMetalOxide.equals(metalsOfTrainingData1))
                    metalFoundIntoTrainingData = true;
            }
            if(metalFoundIntoTrainingData==false)
                metalsOfTestData.add(allMetalOxide);
        }
        
        
        System.out.println("\n\n-----------------------------------------------------------------------------");
        System.out.println("Training set consists of metals:");
        for(metalOxide metal : metalsOfTrainingData){
            System.out.println(metal.getName());
        }
        System.out.println("-----------------------------------------------------------------------------");
        
        System.out.println("\n\n-----------------------------------------------------------------------------");
        System.out.println("Test set consists of metals:");
        for(metalOxide metal : metalsOfTestData){
            System.out.println(metal.getName());
        }
        System.out.println("-----------------------------------------------------------------------------");
        
    }
    
}
