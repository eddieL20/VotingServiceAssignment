package votingservice;
public class SingleChoiceQuestion extends Question {
    @Override
    public void displayQuestion() {
        System.out.println("=====================================");
        System.out.println("This is a single choice question: ");
        System.out.println("=====================================");
        System.out.println(getQuestion());
        for (int i = 0; i < choices.size(); i++){
            System.out.println((char) (CHAR_BIAS + i) + ") " + choices.get(i));
        }
    }

}
