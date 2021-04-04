package Questions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LongFormQuestion extends Question{

    private int id;
    private String question;
    private String[] answers;
    private String userAnswer;
    
    public boolean checkAnswer(String answer) {
        return false;
    }

    /**
     * 
     */
    public LongFormQuestion() throws FileNotFoundException, IOException {
     try{
        StringTokenizer st;
        FileReader fr = new FileReader("./data/long-form-questions.csv");
        BufferedReader br = new BufferedReader(fr);
        String line;
     
     while((line = br.readLine())!=null){
         st = new StringTokenizer(line, ",");
         System.out.println(st.nextToken());
     }
     }catch(FileNotFoundException e){
         System.out.println("File Not Found");
     }
    }
    

    
     @Override
    public String toString() {
        return String.format("%s\n\t1", question, userAnswer);
    }
}
