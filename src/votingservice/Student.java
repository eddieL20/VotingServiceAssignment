package votingservice;

public class Student implements IStudent {
    private int studentID;
    private char singleAnswer;
    private char[] multipleAnswers;

    @Override
    public int getStudentID() {
        return studentID;
    }

    @Override
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public char getSingleAnswer() {
        return singleAnswer;
    }

    public void setSingleAnswer(char singleAnswer) {
        this.singleAnswer = singleAnswer;
    }

    public char[] getMultipleAnswers() {
        return multipleAnswers;
    }

    public void setMultipleAnswers(char[] multipleAnswers) {
        this.multipleAnswers = multipleAnswers;
    }
}
