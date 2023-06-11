import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import votingservice.SingleChoiceQuestion;
import votingservice.Student;
import votingservice.VotingService;

public class SimulationDriver {

    public static void main(String[] args) {

        // List of answers that can be chosen
        List<VotingService> VotingService = new ArrayList<>();

        // Add a single answer and a multiple answer question to VotingService Array
        VotingService.add(createSingleAnswerQuestion());
        VotingService.add(createMultipleAnswerQuestion());


        // Create random number of students
        Random random = new Random();
        int numOfStudents = random.nextInt(10) + 1;

        // Iterates through the objects of VotingService
        for (VotingService vService: VotingService) {
            // Checks if the current VotingService is a Single Choice Question
            if(vService.getQuestion() instanceof SingleChoiceQuestion){
                vService.displayQuestion();
                String studentID;

                for (int i = 0; i < numOfStudents; i++) {
                    int answerNum = random.nextInt(4);
                    char answerChar = (char) (answerNum + 65);
                    Student student = new Student();
                    student.setSingleAnswer(answerChar);

                    studentID = String.valueOf(i);
                    student.setStudentID(studentID);
                    vService.acceptStudentSubmission(student);
                }
                vService.displayStats();
            } else {
                vService.displayQuestion();

                for (int i = 0; i < numOfStudents; i++) {
                    Student student = new Student();
                    char[] answersArr = populateMultipleAnswers(vService.getNumOfCorrectChoices());
                    student.setMultipleAnswers(answersArr);
                    vService.acceptStudentSubmission(student);
                }
                vService.displayStats();
            }

    }

}
    public static char[] populateMultipleAnswers(int totalNum){
        char[] selected = new char[totalNum];
        Random random = new Random();

        for (int i = 0; i < totalNum; i++) {
            int randomNum;
            boolean isDuplicate;

            do {
                randomNum = random.nextInt(4);
                isDuplicate = false;

                // Check for Duplicate
                for (int j = 0; j < i; j++) {
                    if (selected[j] == randomNum){
                        isDuplicate = true;
                        break;
                    }
                }
            } while (isDuplicate);
            selected[i] = (char) (65 + randomNum);
        }
        return selected;
    }

    public static VotingService createSingleAnswerQuestion(){
        VotingService vService = new VotingService();

        vService.isSingleAnswer(true);

        vService.setQuestion("Who is the father of computers?");
        vService.setChoice("Charlie Babbage");
        vService.setChoice("Dennis Ritchie");
        vService.setChoice("Charles Babbage");
        vService.setChoice("Ken Thompson");

        vService.setCorrectAnswers('C');
        return vService;
    }

    public static VotingService createMultipleAnswerQuestion(){
        VotingService vService = new VotingService();

        vService.isSingleAnswer(false);
        vService.setQuestion("Which of these are data type: ");
        vService.setChoice("integer");
        vService.setChoice("character");
        vService.setChoice("integer");
        vService.setChoice("array");

        vService.setCorrectAnswers('A');
        vService.setCorrectAnswers('B');
        vService.setCorrectAnswers('C');

        return vService;
    }
}
