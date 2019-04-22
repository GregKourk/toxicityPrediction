package toxicityprediction;

import java.util.*;

/**
 *
 * @author Γρηγόρης
 */
public class metalOxide {
    
    private String name;
    private List<kvantomechanicIndexes> indexes;
    private Calculations calculation;

    public metalOxide() {
    }

    public metalOxide(String name) {
        this.name = name;
        indexes = new ArrayList<>();
    }

    public metalOxide(String name, List<kvantomechanicIndexes> indexes) {
        this.name = name;
        this.indexes = indexes;
    }

    public String getName() {
        return name;
    }

    public List<kvantomechanicIndexes> getIndexes() {
        return indexes;
    }

    public Calculations getCalculation() {
        return calculation;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setIndexes(List<kvantomechanicIndexes> indexes) {
        this.indexes = indexes;
    }

    public void setCalculation(Calculations calculation) {
        this.calculation = calculation;
    }
        
    public void addKvantomechanicIndex(kvantomechanicIndexes k){
        indexes.add(k);
    }
    
    public void removeKvantomechanicIndex(kvantomechanicIndexes k){
        indexes.remove(k);
    }
}
