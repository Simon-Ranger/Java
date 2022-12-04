package instructors;

public class PartTimeInstructor extends Employee {
    
    // Property
    private double hourlyRateLecture;
    private double hoursLectured;
    private double hourlyRateMarking;
    private double hoursMarking;
    
    // Constructor method
    public PartTimeInstructor(String firstName, String lastName, String tfn, 
        double hrL, double hL, double hrM, double hM) {
        super(firstName, lastName, tfn);
        setHourlyRateLecture(hrL);
        setHoursLectured(hL);
        setHourlyRateMarking(hrM);
        setHoursMarking(hM);
    }

    // Over-rides the Earnings method to return the hourly rate & hours marked
    @Override
    public double Earnings() {
        return hourlyRateLecture * hoursLectured + 
            hourlyRateMarking * hoursMarking;
    }

    // Over-rides the toString method to return first/last name, TFN & earning
    @Override
    public String toString() {
       return this.getFirstName() + " " + this.getLastName() + "\n" 
            + this.getTaxFileNumber() + "\n" + Earnings();
    }
    
    // Accessor method for hourlyRateLecture
    public double getHourlyRateLecture() {
        return hourlyRateLecture;
    }
    
    // Mutator method for hourlyRateLecture
    public void setHourlyRateLecture(double hourlyRateLecture) {
        // exception handling
        try {
            if (hourlyRateLecture >= 0.0) {
                this.hourlyRateLecture = hourlyRateLecture;
            } else {
                throw new IllegalArgumentException("The hourly rate lecture "
                    + "must be > 0!");
            }  
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    
    // Accessor method for hoursLectured
    public double getHoursLectured() {
        return hourlyRateLecture;
    }
    
    // Mutator method for hoursLectured
    public void setHoursLectured(double hoursLectured) {
        // exception handling
        try {
            if (hoursLectured >= 0.0) {
                this.hoursLectured = hoursLectured;
            } else {
                throw new IllegalArgumentException("The hours lectured must be "
                    + "> 0!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    // Accessor method for hourlyRateMarking
    public double getHourlyRateMarking() {
        return hourlyRateMarking;
    }
    
    // Mutator method for hourlyRateMarking
    public void setHourlyRateMarking(double hourlyRateMarking) {
        // exception handling
        try {
            if (hourlyRateMarking >= 0.0) {
                this.hourlyRateMarking = hourlyRateMarking;
            } else {
                throw new IllegalArgumentException("The hourly rate marking "
                    + "must be > 0!");
            }  
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    
    // Accessor method for hoursMarking
    public double getHoursMarking() {
        return hoursMarking;
    }
    
    // Mutator method for hoursMarking
    public void setHoursMarking(double hoursMarking) {
        // exception handling
        try {
            if (hourlyRateLecture >= 0.0) {
                this.hoursMarking = hoursMarking;
            } else {
                throw new IllegalArgumentException("The hours marking must be "
                    + "> 0!");
            }
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
