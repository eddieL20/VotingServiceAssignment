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
    private final Set<Character> correctAnswers = new HashSet<>();

    // method that determines if it will be a single or multiple answer question
    @Override
    public void isSingleAnswer(boolean qType) {

        // if boolean is true, then questions is single answer question,
        // else the question is multiple answer question
        if(qType){
            this.question = new SingleAnswerQuestion();
        } else {
            this.question = new MultipleAnswerQuestion();
        }
    }

    // returns the question object
    public Question getQuestion() {
        return question;
    }

    // the parameter is a string that is then set as the actual question of the question object
    @Override
    public void setQuestion(String question) {
        this.question.setQuestion(question);
    }

    // sets the choices of the question object, one at a time
    public void setChoice(String choice){
        this.question.setChoices(choice);
    }

    // returns an integer of the total number of choices in the questions
    @Override
    public int getTotalNumOfChoices() {
        return question.choices.size();
    }

    // used to submit a Student object into the List of students
    @Override
    public void acceptStudentSubmission(Student student) {
        this.students.add(student);
    }

    // set the value of correct choices as an integer
    @Override
    public void setNumOfCorrectChoices(int num) {
        this.numOfCorrectChoices = num;
    }

    // returns an integer of the number of choices in the question
    @Override
    public int getNumOfCorrectChoices() {
        return numOfCorrectChoices;
    }

    // returns a set of characters of the correct answers
    @Override
    public Set<Character> getCorrectAnswers() {
       return correctAnswers;
    }

    // sets the correct answers for the question
    @Override
    public void setCorrectAnswers(char answer) {
        // sets the correct answer, one at time
        this.correctAnswers.add(answer);

        // gets the total number of correct answers
        int numCorrect = correctAnswers.size();

        // sets that number Correct value as a variable in the Voting Service
        setNumOfCorrectChoices(numCorrect);
    }

    // returns the tally of the answers that were correct from the students
    @Override
    public int getTotalCorrect() {
        return totalCorrect;
    }

    // returns the tally of the answers that were wrong from the students
    @Override
    public int getTotalWrong() {
        return totalWrong;
    }

    // displays the question and the choices
    @Override
    public void displayQuestion() {
        question.displayQuestion();
    }

    @Override
    public int[] stats() {
        // get number of choices in question
        int numOfChoices = question.getChoices().size();

        // create an array to get tally of all the student answers
        int[] totalAnswers = new int[numOfChoices];

        // checks if its single answer question
        if(question instanceof SingleAnswerQuestion){
            for (Student student : students) {
                char answer = student.getSingleAnswer();

                // if the answer is correct, increment total correct, else increment total wrong
                if( correctAnswers.contains(answer)){
                    totalCorrect += 1;
                } else {
                    totalWrong += 1;
                }

                // set the index for the array that tallies the student answers
                int index = ((int) answer) - CHAR_BIAS;

                // adds the current answer to the tally
                totalAnswers[index] += 1;
            }
        } else{
            for (Student student : students) {
                char[] answers = student.getMultipleAnswers();

                // iterates through the multiple answers of the students
                for (char answer : answers) {

                    // checks if the student answer is one of the correct answers
                    // if the answer is correct, increment total correct, else increment total wrong
                    if (correctAnswers.contains(answer)) {
                        totalCorrect += 1;
                    } else {
                        totalWrong += 1;
                    }

                    // set the index for the array that tallies the student answers
                    int index = ((int) answer) - CHAR_BIAS;

                    // adds the current answer to the tally
                    totalAnswers[index] += 1;
                }
            }
        }

        // returns the array of the tally of answer from the students
        return totalAnswers;
    }

    @Override
    public void displayStats() {
        // calls tht stats method to get the student answers
        int[] stats = stats();

        // used to display the count of the answer of all the students
        System.out.println("\nQuestion Stats:");
        for (int i = 0; i < stats.length; i++) {
            System.out.println((char) (CHAR_BIAS + i) + ") " + stats[i]);
        }

        // used to display the correct answers to the questions
        Set<Character> answers = getCorrectAnswers();
        System.out.print("\nCorrect Answer(s): ");
        for (char answer: answers) {
            System.out.print(answer + " ");
        }

        // used to display the total correct and total wrong answer of all the students
        System.out.println("\nTotal Correct: " + getTotalCorrect());
        System.out.println("Total Wrong: " + getTotalWrong() + "\n");
    }
}
