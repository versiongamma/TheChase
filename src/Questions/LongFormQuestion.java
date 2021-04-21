package Questions;

import java.util.Random;
import java.util.StringTokenizer;

/**
 * This class creates long form questions from the files of questions. It randomizes
 * the order of the questions so its different each time it is played and also checks
 * the answer to see if it is correct or not.
 * 
 * @authors Abby - 19071317 Julia - 19078503 Matt - 19076935
 */
public class LongFormQuestion extends Question {

    private String question;
    private String answer;

    public LongFormQuestion(String q, String a){
        this.question = q;
        this.answer = a;
    }
    
    /**
     * Checks if an answer to a question is correct
     * @param playerAnswer The answer to check with
     * @return If the answer is correct
     */
    @Override
    public boolean checkAnswer(String playerAnswer) {

        return playerAnswer.equalsIgnoreCase(answer);

    }

    @Override
    public boolean equals(Question other) {
        if (!(other instanceof LongFormQuestion)) { return false; }
        LongFormQuestion converted = (LongFormQuestion) other;
        return this.question.equalsIgnoreCase(converted.question);
    }

    /**
     * Constructs a new long question based on the stored set of questions
     */
    public LongFormQuestion() {
        StringTokenizer lines = getLines("./data/long-form-questions2.csv");
        int index = new Random().nextInt(lines.countTokens()), i = 0;

        while (lines.hasMoreTokens()) {
            StringTokenizer line = new StringTokenizer(lines.nextToken(), "*");

            if (index == i) {
                question = line.nextToken();
                answer = line.nextToken().replace("\r", "");
                break;
            }
            ++i;
        }
    }

    /**
     * 
     * @return 
     */
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
