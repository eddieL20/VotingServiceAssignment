package votingservice;

public class Student implements IStudent {
    private String studentID;
    private char singleAnswer;
    private char[] multipleAnswers;

    // returns the student ID
    @Override
    public String getStudentID() {
        return studentID;
    }

    // sets the student ID as a String
    @Override
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    // sets the answer to single choice
    public char getSingleAnswer() { return singleAnswer; }

    // sets a single answer as the answer
    public void setSingleAnswer(char singleAnswer) {
        this.singleAnswer = singleAnswer;
    }

    // returns multiple answers in the form of a char array
    public char[] getMultipleAnswers() { return multipleAnswers; }

    // sets multiple answers for a multiple answer question
    public void setMultipleAnswers(char[] multipleAnswers) {
        this.multipleAnswers = multipleAnswers;
    }
}
