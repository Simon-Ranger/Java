package instructors;

public class SessionalInstructor extends Employee {
    
    // Property
    private double hourlyRate;
    private double hoursWorked;
    
    // Constructor method
    public SessionalInstructor(String firstName, String lastName, String tfn, 
        double hR, double hW) {
        super(firstName, lastName, tfn);
        setHourlyRate(hR);
        setHoursWorked(hW);
    }

    // Over-rides the Earnings method to return the hourly rate & hours worked
    @Override
    public double Earnings() {
        return hourlyRate * hoursWorked;
    }
    
    // Over-rides the toString method to return first/last name, TFN & earnings
    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName() + "\n" 
            + this.getTaxFileNumber() + "\n" + Earnings();
    }
    
    // Accessor method for hourlyRate
    public double getHourlyRate() {
        return hourlyRate;
    }
    
    // Mutator method for hourlyRate
    public void setHourlyRate(double hourlyRate) {
        // exception handling
        try {
            if (hourlyRate >= 0.0) {
                this.hourlyRate = hourlyRate;
            } else {
                throw new IllegalArgumentException("The hourly rate must be > "
                    + "0!");
            }
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    
    // Accessor method for hoursWorked
    public double getHoursWorked() {
        return hoursWorked;
    }
    
    // Mutator method for hoursWorked
    public void setHoursWorked(double hoursWorked) {
        // exception handling
        try {
            if (hoursWorked >= 0.0) {
                this.hoursWorked = hoursWorked;
            } else {
                throw new IllegalArgumentException("The hours worked must be > "
                    + "0!");
            }
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    
}
