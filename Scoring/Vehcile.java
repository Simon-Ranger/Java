package part3;

public abstract class Vehcile {
    String owner;
    String regNum;
    
    enum Location {
        INNER_METRO,
        OUTTER_METRO,
        REGIONAL;
    }
    
    public abstract double calcRegFee();
    
    public Vehcile(String owner, String regNum, Location location) {
        this.owner = owner;
        this.regNum = regNum;
    }
    
    public String getOwner() {
        return this.owner;
    }
    
    public String getRegNum() {
        return this.regNum;
    }
    
    public Location getLocation() {
        return this.getLocation();
    }
    
    public String toString() {
        return this.owner;
    }
    
}
