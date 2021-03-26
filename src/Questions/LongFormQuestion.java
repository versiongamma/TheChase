package Questions;

import java.util.StringTokenizer;

public class LongFormQuestion extends Question{

    public boolean checkAnswer(String answer) {
        return false;
    }

    public LongFormQuestion() {
        StringTokenizer line = getLines("long-form-questions.csv");
    }
}
