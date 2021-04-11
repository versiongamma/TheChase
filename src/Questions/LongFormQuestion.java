package Questions;

import java.util.Random;
import java.util.StringTokenizer;

public class LongFormQuestion extends Question {

    private String question;
    private String answer;

    @Override
    public boolean checkAnswer(String playerAnswer) {

        return playerAnswer.equalsIgnoreCase(answer);

    }

    /**
     *
     */
    public LongFormQuestion(int round) {
        StringTokenizer line;
        StringTokenizer lines = getLines(round == 2 ? "" : "./data/long-form-questions.csv");
        int index = new Random().nextInt(lines.countTokens()), i = 0;

        while (lines.hasMoreTokens()) {
            line = new StringTokenizer(lines.nextToken(), "*");

            if (index == i) {
                question = line.nextToken();
                answer = line.nextToken().replace("\r", "");
                break;
            }
            ++i;
        }
    }

    @Override
    public String toString() {
        return String.format("%s", getQuestion());
    }

    //GETTERS AND SETTER
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
