package testsimulator;

public class MultipleChoiceQuestion extends Question{
    // Instances
    private String answers[];
    private char correctAnswer;
    private char chosenAnswer;

    // Constructor 
    public MultipleChoiceQuestion(String questionID, int chapterNumber, 
        String questionText, String a1, String a2, String a3, String a4, 
        char cAnswer) {
        super(questionID, chapterNumber, questionText);
        this.answers = new String[] {a1, a2, a3, a4};
        chosenAnswer = 'a';
        correctAnswer = cAnswer;
    }
    
    /*returns true if “correctAnswer” and “chosenAnswer” are the same,
    otherwise false.*/
    @Override
    public boolean isAnswerCorrect() {
        return (correctAnswer == chosenAnswer);  
    }
    
    // Accessor method for answers
    public String[] getAnswers() {
        return new String[] {answers[0], answers[1], answers[2], answers[3]};
    }
    
    // Accessor method correctAnswer
    public char getCorrectAnswer() {
       return correctAnswer;
    }
    
    // Accessor method chosenAnswer
    public char getChosenAnswer() {
         return chosenAnswer;
    }
    
    // Mutator method chosenAnswer
    public void setChosenAnswer(char chosenAnswer) {
        this.chosenAnswer = chosenAnswer;
    }
}
