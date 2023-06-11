package votingservice;

import java.util.Set;

public interface IVotingService {
    int CHAR_BIAS = 65;
    void isSingleAnswer(boolean questionType);

    void setQuestion(String question);

    void setChoice(String choice);

    void acceptStudentSubmission(Student student);

    void setNumOfCorrectChoices(int num);

    int getNumOfCorrectChoices();

    Set<Character> getAnswers();

    void setCorrectAnswers(char answers);

    int getTotalCorrect();

    int getTotalWrong();

    void displayQuestion();

    int[] stats();

    void displayStats();

}
