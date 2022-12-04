package instructors;

// Inherited class from the Superclass "Employee"
public class FullTimeInstructor extends Employee{
    
    // Property
    private double weeklySalary;
    
    // Constructor method
    public FullTimeInstructor(String firstName, String lastName, String tfn, 
        double ws) {
        super(firstName, lastName, tfn);
        setWeeklySalary(ws);
    }

    // Over-rides the Earning method to return the salary
    @Override
    public double Earnings() {
        return weeklySalary;
    }
    
    // Over-rides the toString method to return first/last name, TFN & earnings
    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName() + "\n" 
            + this.getTaxFileNumber() + "\n" + Earnings();
    }

    // Accessor method for weeklySalary
    public double getWeeklySalary() {
        return weeklySalary;
    }
    
    // Mutator method for weeklySalary
    public void setWeeklySalary(double weeklySalary) {
        // exception handling
        try {
            if (weeklySalary >= 0.0) {
                this.weeklySalary = weeklySalary;
            } else {
                throw new IllegalArgumentException("The salary must be > 0!");
            }  
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    
}

