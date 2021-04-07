
import Questions.LongFormQuestion;
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
    private static Players players;
    
    public RoundOne(String playerAnswer, Players players){
        RoundOne.playerAnswer = playerAnswer;
        players = players;
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
      LongFormQuestion round1 = new LongFormQuestion();
      
        //need to call in the answer string from the csv file
        if(RoundOne.playerAnswer != round1.getAnswer()){
            System.out.println("Incorrect Answer!"
                       + "The Answer was: ");
            //next question
           }
        else if(RoundOne.playerAnswer.equals(round1.getAnswer())){
           System.out.println("Correct!");
           players.setPlayerCash(players.getPlayerCash()+1);
           
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
            checkAnswer(RoundOne.playerAnswer);
        }
    }
    
}
   
