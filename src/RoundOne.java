
import Questions.LongFormQuestion;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * Round One of the Chase!
 * 1 Minute timer is started - then the player will have that amount of time to
 * answer as many long answer question correctly they can in that time period
 */

public class RoundOne {

    //code goes in here
    //I have found a way to make the timer work as well
    
    public void showQuestions(){
        RoundOne r = new RoundOne();
       
       for(int i = 0; i <10; i++){
           print questions here
           System.out.println(new LongFormQuestion());
           
           //print writer then buffer reader
           
           if(LongFormQuestion == false){
               System.out.println("Incorrect Answer!"
                       + "The Answer was: ");
               
           }
           else if(LongFormQuestion == true){
               System.out.println("Correct!");
               r.getPlayerScore()++;
           }
           
           i--;
       }
    }
}
   
