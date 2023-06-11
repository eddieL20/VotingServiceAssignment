package votingservice;

public interface IStudent {

    String getStudentID();

    void setStudentID(String studentID);

    char getSingleAnswer();

    void setSingleAnswer(char singleAnswer);

    char[] getMultipleAnswers();

    void setMultipleAnswers(char[] multipleAnswers);

}
