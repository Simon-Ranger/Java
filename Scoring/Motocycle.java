package part3;

public class Motocycle extends Vehcile {
    int engCapacity;

    public Motocycle(String owner, String regNum, Location location, 
        int engCapacity) {
        super(owner, regNum, location);
    }

    @Override
    public double calcRegFee() {
        return 0;
    }
    
    @Override
    public String toString() {
        return this.regNum;
    }
    
    public int getEngCapacity() {
        return this.engCapacity;
    }
    

}
