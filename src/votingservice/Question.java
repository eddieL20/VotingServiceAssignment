package votingservice;

import java.util.ArrayList;
import java.util.List;

abstract class Question {
    static final int CHAR_BIAS = 65;
    private String question;
    protected List<String> choices = new ArrayList<>();

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public abstract void displayQuestion();

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(String choice) {
        this.choices.add(choice);
    }

}
