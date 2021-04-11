
import Questions.LongFormQuestion;
import Questions.Question;

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
    private LongFormQuestion question;
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
     * @param playerAnswer
     * @param question
     */

    public static void checkAnswer(String playerAnswer, Question question) throws IOException {
        if (question.checkAnswer(playerAnswer)) {

        }

    //
   
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

    //sets and prints the timer and questions
    /**
     *
     * @throws IOException
     */


    public void startRound() throws IOException {

        System.out.println("Answer as many questions as you can in 1 minute! \n"
                + "Timer starting;");

        new RoundOne(60);
        System.out.println("Go!");

        Scanner scan = new Scanner(System.in);
        //infinite method for printing questions, will end with the timer
        for (int i = 0; i < 10; i++) {
            LongFormQuestion question = new LongFormQuestion();
            playerAnswer = scan.next();

            System.out.println(question.getQuestion());
            playerAnswer = scan.nextLine();

            this.checkAnswer(playerAnswer, question);
        }
    }

}
