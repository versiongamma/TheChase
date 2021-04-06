package Questions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.StringTokenizer;

public class LongFormQuestion extends Question {

    private int id;
    private String question;
    private String answer;
    
    @Override
    public boolean checkAnswer(String answer) {
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
                id = new Random().nextInt(st.countTokens() - 2);
                
               // StringTokenizer longFormQuestion = new StringTokenizer(readIn.nextToken(), ",")
                if (st.nextToken().contains(Integer.toString(id))){
                    question = st.nextToken();
                    //answer = 
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
        return String.format("%s", question);
    }
}
