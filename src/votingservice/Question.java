package votingservice;

import java.util.ArrayList;
import java.util.List;

abstract class Question {
    static final int CHAR_BIAS = 65;
    private String question;
    protected List<String> choices = new ArrayList<>();

    // returns the question string
    public String getQuestion() {
        return question;
    }

    // set the question string
    public void setQuestion(String question) {
        this.question = question;
    }

    // used to display the question and the choices
    public abstract void displayQuestion();

    // returns the list of choices
    public List<String> getChoices() {
        return choices;
    }

    // set the list of choices, one at a time
    public void setChoices(String choice) {
        this.choices.add(choice);
    }

}
