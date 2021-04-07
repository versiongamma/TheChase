
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
    
    private String playerAnswer;
    
    public RoundOne(String playerAnswer){
        this.playerAnswer = playerAnswer;
    }
    
    public static void printQuestion() throws IOException{
        try{
         System.out.println(new LongFormQuestion());
        }catch(IOException e){
            System.out.println("Unable to read in question.");
        }
    }
    
    //checks the answer entered by the player
//    public void checkAnswer(String playerAnswer) throws IOException{
//      RoundOne r = new RoundOne(playerAnswer);
//      
//        //need to call in the answer string from the csv file
//        if(this.playerAnswer != r.getAnswer()){
//            System.out.println("Incorrect Answer!"
//                       + "The Answer was: ");
//            //next question
//           }
//        else if(this.playerAnswer == r.getAnswer()){
//           System.out.println("Correct!");
//           // getPlayerScore()++;
//           //next question
//           }
//    }
    
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
        new RoundOne(5);
        System.out.println("Go!");
        
        Scanner scan = new Scanner(System.in);
        String n = " ";
        //infinite method for printing questions, will end with the timer
        for(int i = 0; i < 10; i++){
            printQuestion();
            
            System.out.println("Question 1: ");
            n = scan.next();
            System.out.println("Question 2: ");
            n = scan.next();
            System.out.println("Question 3: ");
            n = scan.next();
            System.out.println("Question 4: ");
            n = scan.next();
            
            
//            playerAnswer = scan.next();
//            checkAnswer(this.playerAnswer);
        }
    }
    
}
   
