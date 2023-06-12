package votingservice;

public interface IStudent {
    // returns the student ID
    String getStudentID();

    // sets the student ID as a String
    void setStudentID(String studentID);

    // returns the answer to a single answer question
    char getSingleAnswer();

    // sets the answer to single choice
    void setSingleAnswer(char singleAnswer);

    // returns multiple answers in the form of a char array
    char[] getMultipleAnswers();

    // sets the multiple answers of the student
    void setMultipleAnswers(char[] multipleAnswers);

}
