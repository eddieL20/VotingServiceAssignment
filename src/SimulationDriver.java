import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import votingservice.SingleAnswerQuestion;
import votingservice.Student;
import votingservice.VotingService;

public class SimulationDriver {

    public static void main(String[] args) {

        // List of answers that can be chosen
        List<VotingService> VotingService = new ArrayList<>();

        String studentID;  // string variable for student ID

        // Add a single answer and a multiple answer question to VotingService Array
        VotingService.add(createSingleAnswerQuestion());
        VotingService.add(createMultipleAnswerQuestion());


        // Create random number of students
        Random random = new Random();
        int numOfStudents = random.nextInt(20) + 1;

        // Iterates through the objects of VotingService
        for (VotingService vService: VotingService) {

            // Checks if the current VotingService is a Single Answer Question, else it is a Multiple Answer Question
            if(vService.getQuestion() instanceof SingleAnswerQuestion){

                // Method used to display the question
                vService.displayQuestion();

                // for loop to generate a single answer and set it to a new student object
                // the Student object then gets submitted to the Voting Service Object
                for (int i = 0; i < numOfStudents; i++) {
                    int answerNum = random.nextInt(vService.getTotalNumOfChoices());
                    char answerChar = (char) (answerNum + 65);
                    Student student = new Student();
                    student.setSingleAnswer(answerChar);

                    // The student ID is the current i value in the loop which then gets converted to a string value
                    studentID = String.valueOf(i);
                    student.setStudentID(studentID);

                    // student object is submitted to Voting Service with answers and unique student ID
                    vService.acceptStudentSubmission(student);
                }

                // display Stats is the method used to display the correct and incorrect number of questions answered
                vService.displayStats();

            } else {
                // Method used to display the question
                vService.displayQuestion();

                // create Student new Student objects and create multiple answers for each student
                for (int i = 0; i < numOfStudents; i++) {
                    Student student = new Student();

                    // method used to create multiple answers for students without repeating solutions
                    char[] answersArr = populateMultipleAnswers(vService.getNumOfCorrectChoices(), vService.getTotalNumOfChoices());
                    student.setMultipleAnswers(answersArr);  // multiple answers are given to each student object

                    // create student ID
                    studentID = String.valueOf(i);
                    student.setStudentID(studentID);

                    // student object is submitted to Voting Service with multiple answers and unique student ID
                    vService.acceptStudentSubmission(student);
                }
                // display Stats is the method used to display the correct and incorrect number of questions answered
                vService.displayStats();
            }

    }

}

    // Function used to create and return multiple answers that do not repeat.
    // the first parameter sets the amount of answers made by student, and the second parameter
    // sets the amount of options, such as 'A, B, C, D,...'
    public static char[] populateMultipleAnswers(int totalNum, int totalNumOfChoices){
        char[] selected = new char[totalNum];
        Random random = new Random();
        final char CHAR_BIAS = 65;

        for (int i = 0; i < totalNum; i++) {
            int randomNum;
            boolean isDuplicate;

            do {
                // creates random number between 0 and 3
                randomNum = random.nextInt(totalNumOfChoices);
                isDuplicate = false;

                // Check for Duplicate
                for (int j = 0; j < i; j++) {
                    if (selected[j] == randomNum){
                        isDuplicate = true;
                        break;
                    }
                }
            } while (isDuplicate);
            // takes random num and adds 65 to make it a choice of A, B, C,... when converted from int to char
            selected[i] = (char) (CHAR_BIAS + randomNum);
        }
        // returns char array of answers
        return selected;
    }

    // This function creates an instance of a single answer question
    public static VotingService createSingleAnswerQuestion(){
        // new instance of VotingService object is created
        VotingService vService = new VotingService();

        // This decides if the question will be single Answer or multiple
        // True means single answer
        vService.isSingleAnswer(true);

        // This method sets the question for the Question object
        vService.setQuestion("Who is the father of computers?");

        // This method sets the choices for the question.
        vService.setChoice("Charlie Babbage");
        vService.setChoice("Dennis Ritchie");
        vService.setChoice("Charles Babbage");
        vService.setChoice("Ken Thompson");

        // Sets the correct answer...only one is needed because it is single choice
        vService.setCorrectAnswers('C');

        // returns the VotingService object
        return vService;
    }

    // creates and returns a
    public static VotingService createMultipleAnswerQuestion(){
        // new instance of VotingService object is created
        VotingService vService = new VotingService();

        // False set it to a multiple answer question
        vService.isSingleAnswer(false);

        // This method sets the question for the Question object
        vService.setQuestion("Which of these are data type: ");
        vService.setChoice("integer");
        vService.setChoice("character");
        vService.setChoice("integer");
        vService.setChoice("array");

        // Multiple answers are set for the multiple answer question
        vService.setCorrectAnswers('A');
        vService.setCorrectAnswers('B');
        vService.setCorrectAnswers('C');

        // returns the VotingService object
        return vService;
    }
}
