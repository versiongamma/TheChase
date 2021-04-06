
import Questions.LongFormQuestion;
import Questions.MultiChoiceQuestion;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * Round One of the Chase!
 * 1 Minute timer is started - then the player will have that amount of time to
 * answer as many long answer question correctly they can in that time period
 */

public class RoundOne {
    
    private static String playerAnswer;
    
    public RoundOne(String playerAnswer){
        RoundOne.playerAnswer = playerAnswer;
    }
    
    public static void printQuestion() throws IOException{
        try{
         System.out.println(new LongFormQuestion());
        }catch(IOException e){
            System.out.println("Unable to read in question.");
        }
    }
    
    //checks the answer entered by the player
    public static void checkAnswer(String playerAnswer) throws IOException{
       
        //need to call in the answer string from the csv file
        if(playerAnswer == m){
            System.out.println("Incorrect Answer!"
                       + "The Answer was: ");
            //next question
           }
        else if(playerAnswer == m){
           System.out.println("Correct!");
           // getPlayerScore()++;
           //next question
           }
    }
    
    //interal timer stuff
    Toolkit toolkit;

    Timer timer;

    public RoundOne(int seconds) {
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new timeOut(), seconds * 1000);
    }

    //calls the timer to end
    class timeOut extends TimerTask {

        public void run() {
            System.out.println("Time's up!");
            toolkit.beep();
            timer.cancel();
        }
    }

    //sets and prints the timer and questions
    public static void main(String args[]) throws IOException {
        System.out.println("Answer as many questions as you can in 1 minute! \n"
                + "Timer starting;");
        new RoundOne(60);
        System.out.println("Go!");
        
        Scanner scan = new Scanner(System.in);
        //infinite method for printing questions, will end with the timer
        for(int i = 0; i < 10; i++){
            printQuestion();
            playerAnswer = scan.next();
            checkAnswer(playerAnswer);
        }
    }
    
}
   
