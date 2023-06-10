package votingservice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VotingService implements IVotingService {
    private Question question;
    private int numOfCorrectChoices;
    private int totalCorrect = 0;
    private int totalWrong = 0;
    private final List<Student> students = new ArrayList<>();
    private Set<Character> correctAnswers = new HashSet<>();

    @Override
    public void isSingleAnswer(boolean qType) {
       if(qType){
           this.question = new SingleChoiceQuestion();
       }
       else {
           this.question = new MultipleChoiceQuestion();
       }
    }

    public Question getQuestion() {
        return question;
    }

    @Override
    public void setQuestion(String question) {
        this.question.setQuestion(question);
    }

    public void setChoice(String choice){
        this.question.setChoices(choice);
    }
    @Override
    public void acceptStudentSubmission(Student student) {
        this.students.add(student);
    }

    @Override
    public void setNumOfCorrectChoices(int num) {
        this.numOfCorrectChoices = num;
    }

    @Override
    public int getNumOfCorrectChoices() {
        return numOfCorrectChoices;
    }

    @Override
    public Set<Character> getAnswers() {
       return correctAnswers;
    }

    @Override
    public void setCorrectAnswers(char answer) {
        this.correctAnswers.add(answer);
        int numCorrect = correctAnswers.size();
        setNumOfCorrectChoices(numCorrect);
    }

    @Override
    public int getTotalCorrect() {
        return totalCorrect;
    }

    @Override
    public int getTotalWrong() {
        return totalWrong;
    }

    @Override
    public void displayQuestion() {
        question.displayQuestion();
    }

    @Override
    public int[] stats() {
        int numOfChoices = question.getChoices().size();
        int[] totalAnswers = new int[numOfChoices];

        if(question instanceof SingleChoiceQuestion){
            for (Student student : students) {
                char answer = student.getSingleAnswer();
                if( correctAnswers.contains(answer)){
                    totalCorrect += 1;
                } else {
                    totalWrong += 1;
                }
                int index = ((int) answer) - CHAR_BIAS;
                totalAnswers[index] += 1;
            }
        } else{
            for (Student student : students) {
                char[] answers = student.getMultipleAnswers();
                for (char answer : answers) {
                    if (correctAnswers.contains(answer)) {
                        totalCorrect += 1;
                    } else {
                        totalWrong += 1;
                    }
                    int index = ((int) answer) - CHAR_BIAS;
                    totalAnswers[index] += 1;
                }
            }
        }
        return totalAnswers;
    }

    @Override
    public void displayStats() {
        int[] stats = stats();
        System.out.println("\nQuestion Stats:");
        for (int i = 0; i < stats.length; i++) {
            System.out.println((char) (CHAR_BIAS + i) + ") " + stats[i]);
        }
        Set<Character> answers = getAnswers();
        System.out.print("\nCorrect Answer(s): ");
        for (char answer: answers) {
            System.out.print(answer + " ");
        }
        System.out.println("");
        System.out.println("Total Correct: " + getTotalCorrect());
        System.out.println("Total Wrong: " + getTotalWrong() + "\n");
    }
}
