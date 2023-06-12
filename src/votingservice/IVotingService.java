package votingservice;

import java.util.Set;

public interface IVotingService {

    // Number used to convert integer to Capital Characters
    int CHAR_BIAS = 65;

    // parameter decides if it is a single or multiple answer question
    // e.g., true is a single answer question
    void isSingleAnswer(boolean questionType);

    // this sets the question  of the Question object
    void setQuestion(String question);

    // sets the choices of the question
    void setChoice(String choice);

    // returns the size of the List of choices
    int getTotalNumOfChoices();

    // the parameter is an instance of a Student object
    void acceptStudentSubmission(Student student);

    // returns the number of correct answers in the question
    void setNumOfCorrectChoices(int num);

    // returns the number of correct choices in the question
    int getNumOfCorrectChoices();

    // returns the correct answers
    Set<Character> getCorrectAnswers();

    // sets the correct answers for the question
    void setCorrectAnswers(char answer);

    // returns the count of answers that are correct
    int getTotalCorrect();

    // returns the count of answers that are incorrect
    int getTotalWrong();

    // Displays the question and the choices
    void displayQuestion();

    // returns an integer array of the tally for all the choices of the students
    int[] stats();

    // displays the tally of answers of all the students and displays the correct answers
    void displayStats();

}
