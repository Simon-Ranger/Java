package testsimulator;

import java.util.ArrayList;

public interface QuestionFinder {
    // Concrete method
    public default boolean containsQuestion(String qID, ArrayList<Question> 
        questions) {
        
        boolean quest = false;
        
        // Returns true if questionID is found in questions
        for (Question question : questions) {
            if (question.getQuestionID().equals(qID)) {
                quest = true;
            }
        }
        
        return quest;
    }
}
