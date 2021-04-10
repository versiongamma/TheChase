package Questions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.StringTokenizer;

public class LongFormQuestion extends Question {

    private int num;
    private String question;
    private String answer;
    
    @Override
    public boolean checkAnswer(String playerAnswer, String chaserAnswer) {
        return false;
    }

    /**
     *
     */
    public LongFormQuestion() throws FileNotFoundException, IOException {
        try {
            
            StringTokenizer st;
            BufferedReader readIn = new BufferedReader(new FileReader("./data/long-form-questions.csv"));
            String line;

            while ((line = readIn.readLine()) != null) {
                st = new StringTokenizer(line, ",");
                num = new Random().nextInt(st.countTokens() - 2);
                
                if (st.nextToken().contains(Integer.toString(num))){
                   question = st.nextToken();
                   answer = st.nextToken();
                }
                
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            System.out.println("Error reading file");
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
