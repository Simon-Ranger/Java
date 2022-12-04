package instructors;

// Abstract class
public abstract class Employee {
    
    // Instance Variables
    private String firstName;
    private String lastName;
    private String taxFileNumber;
    
    // Abstract method
    public abstract double Earnings();
    
    // Constructor method
    public Employee(String firstName, String lastName, String tfn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.taxFileNumber = tfn;
    }
    
    // Over-rides the toString method to return first/last name & the TFN
    @Override
    public String toString() {
        return this.getFirstName() + "" + this.getLastName() + "" 
            + this.getTaxFileNumber() + "" + this.Earnings();
    }
    
    // Accessor method for firstName
    public String getFirstName() {
        return firstName;
    }
    
    // Accessor method for lastName
    public String getLastName() {
        return lastName;
    }
    
    // Accessor method for taxFileNumber
    public String getTaxFileNumber() {
        return taxFileNumber;
    }
    
    // Mutator method for firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    // Mutator method for lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    // Mutator method for taxFileNumber
    public void setTaxFileNumber(String taxFileNumber) {
        this.taxFileNumber = taxFileNumber;
    } 
    
    
}
