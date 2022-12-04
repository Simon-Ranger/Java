package instructors;

public class EarningsTesting {
    
    public static void main(String[] args) {
        // Initalises the other methods used in different classes
        FullTimeInstructor fullTimeInstructor = new FullTimeInstructor("sam", 
            "john", "1234", 100);
        PartTimeInstructor partTimeInstructor = new PartTimeInstructor("Jane", 
            "John", "5678", 20.5, 13.5, 20.5, 30);
        SessionalInstructor sessionalInstructor = new SessionalInstructor(
            "Dean", "James", "2654", 30, 40);

        // Prints out the information required 
        System.out.printf("Full Time Instructor: \n%s\n", 
            fullTimeInstructor + "\n");
        System.out.printf("Part Time Instructor: \n%s\n", 
            partTimeInstructor + "\n"); 
        System.out.printf("Sessional Instructor: \n%s\n", 
            sessionalInstructor);
    }
}

