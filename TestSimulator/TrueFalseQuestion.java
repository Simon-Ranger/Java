package testsimulator;

public class TrueFalseQuestion extends Question {
    // Instances
    private boolean correctAnswer;
    private boolean chosenAnswer;

    // Constructor
    public TrueFalseQuestion(String qID, int cNumber, String qText, 
        boolean cAnswer) {
        super(qID, cNumber, qText);
        correctAnswer = cAnswer;
        chosenAnswer = true;
    }
    
    /*returns true if “correctAnswer” and “chosenAnswer” are the same,
    otherwise false.*/
    @Override
    public boolean isAnswerCorrect() {
        return (correctAnswer == chosenAnswer);
    }
    
    // Accessor method correctAnswer
    public boolean getCorrectAnswer() {
        return correctAnswer;
    }
    
    // Accessor method chosenAnswer
    public boolean getChosenAnswer() {
        return chosenAnswer;
    }
    
    // Mutator method chosenAnswer
    public void setChosenAnswer(boolean chosenAnswer) {
        this.chosenAnswer = chosenAnswer;
    }
}
