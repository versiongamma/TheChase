
import Questions.LongFormQuestion;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * Round One of the Chase! 1 Minute timer is started - then the player will have
 * that amount of time to answer as many long answer question correctly they can
 * in that time period
 */
public class RoundOne {

    private static String playerAnswer;
    private static Players players;
    Toolkit toolkit;
    Timer timer;

    /**
     * 
     * @param playerAnswer
     * @param players 
     */
    public RoundOne(String playerAnswer, Players players) {
        RoundOne.playerAnswer = playerAnswer;
        RoundOne.players = players;
    }

    /**
     * 
     * @throws IOException 
     */
    public static void printQuestion() throws IOException {
        System.out.println(new LongFormQuestion());
    }

    /**
     * 
     * @param playerAnswer
     * @throws IOException 
     */
    public static void checkAnswer(String playerAnswer) throws IOException {
        LongFormQuestion round1 = new LongFormQuestion();

        if (RoundOne.playerAnswer == null ? round1.getAnswer() != null : !RoundOne.playerAnswer.equals(round1.getAnswer())) {
            System.out.println("Incorrect Answer!"
                    + "The Answer was: " + round1.getAnswer());
            //next question
        } else if (RoundOne.playerAnswer.equals(round1.getAnswer())) {
            System.out.println("Correct!");
            players.setPlayerCash(players.getPlayerCash() + 1);
        }
        else{
            System.out.println("Something went wrong...");
        }
    }
   
/**
 * 
 * @param seconds 
 */
    public RoundOne(int seconds) {
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new timeOut(), seconds * 1000);
    }

    /**
     * 
     */
    class timeOut extends TimerTask {

        public void run() {
            System.out.println("Time's up!");

            toolkit.beep();
            timer.cancel();

        }
    }

  /**
   * 
   */
    public  void startRound() {
        System.out.println("Answer as many questions as you can in 1 minute! \n"
                + "Timer starting;");

        new RoundOne(60);
        System.out.println("Go!");

        Scanner scan = new Scanner(System.in);
        //infinite method for printing questions, will end with the timer
        for (int i = 0; i < 10; i++) {
            try {
                printQuestion();
                playerAnswer = scan.next();
                checkAnswer(RoundOne.playerAnswer);
            } catch (IOException ex) {
                System.out.println("Error");;
            }
        }
    }

}
