package testsimulator;

public abstract class Question {
    // Instances
    private String questionID;
    private int chapterNumber;
    private String questionText;
    
    // Abstract method
    public abstract boolean isAnswerCorrect();
    
    // Constructor 
    public Question(String qID, int cNumber, String qText) {
        this.questionID = qID;
        this.chapterNumber = cNumber;
        this.questionText = qText;
    }

    // Accessor method for questionID
    public String getQuestionID() {
        return questionID;
    }
    
    // Accessor method chapterNumber
    public int getChapterNumber() {
        return chapterNumber;
    }
    
    // Accessor method questionText
    public String getQuestionText() {
        return questionText;
    }
}
