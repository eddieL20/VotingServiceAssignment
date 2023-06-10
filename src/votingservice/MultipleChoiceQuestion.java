package votingservice;

public class MultipleChoiceQuestion extends Question {
    @Override
    public void displayQuestion() {
        System.out.println("==============================");
        System.out.println("Select all that apply: ");
        System.out.println("==============================");
        System.out.println(getQuestion());
        for (int i = 0; i < choices.size(); i++){
            System.out.println((char)(Question.CHAR_BIAS + i) + ") " + choices.get(i));
        }
    }

}
