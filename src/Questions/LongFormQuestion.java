package Questions;

import java.util.Random;
import java.util.StringTokenizer;

public class LongFormQuestion extends Question {

    private String question;
    private String answer;
    
    @Override
    public boolean checkAnswer(String playerAnswer) {
        return false;
    }

    /**
     *
     */
    public LongFormQuestion() {
        StringTokenizer line;
        StringTokenizer lines = getLines("./data/long-form-questions.csv");
        int index = 0, i = 0;

        while (lines.hasMoreTokens()) {
            line = new StringTokenizer(lines.nextToken(), ",");
            if (line.countTokens() == 1) {
                index = new Random().nextInt(Integer.parseInt(line.nextToken().replace("\r", "")));
                continue;
            }

            if (index == i) {
                question = line.nextToken();
                answer = line.nextToken();
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
