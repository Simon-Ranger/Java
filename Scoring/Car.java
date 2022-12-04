package part3;

public class Car extends Vehcile{

    public Car(String owner, String regNum, Location location) {
        super(owner, regNum, location);
    }

    @Override
    public double calcRegFee() {
        return 800;
    }
    
}
