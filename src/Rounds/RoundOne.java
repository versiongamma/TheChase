package Rounds;

import Game.Players;
import Questions.LongFormQuestion;

import java.awt.Toolkit;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * Round One of the Chase! 1 Minute timer is started - then the player will have
 * that amount of time to answer as many long answer question correctly they can
 * in that time period
 */
public class RoundOne implements Round {

    private static String playerAnswer;
    private static Players players;
    Toolkit toolkit;
    Timer timer;

    /**
     * Default round constructor
     *
     * @param playerAnswer
     * @param players
     */
    public RoundOne(String playerAnswer, Players players) {
        RoundOne.playerAnswer = playerAnswer;
        RoundOne.players = players;
    }

    /**
     * Checks if a given answer is correct, and adds money to the player if so
     *
     * @param playerAnswer The players answer
     * @param question The question they are answering
     */
    public static void checkAnswer(String playerAnswer, LongFormQuestion question) {
        if (question.checkAnswer(playerAnswer)) {
            System.out.println("Correct!");
            players.setPlayerCash(players.getPlayerCash() + 1000);
        } else {
            System.out.println(String.format("Incorrect! The correct answer was: %s", question.getAnswer()));
        }
    }

    /**
     * Creates a new round
     *
     * @param seconds the amount of time the round should last
     */
    public RoundOne(int seconds) {
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                timer.cancel();
            }
        }, seconds * 1000);
    }

    /**
     * Sets and prints the timer and questions
     *
     * @return The outcome of the round's completion (true is successful)
     */
    public boolean startRound() {
        Scanner scan = new Scanner(System.in);
  
        System.out.println("Answer as many questions as you can in 1 minute! "
                + "When the timer finishes you will have time to answer the final question.\n");

        RoundOne roundOne = new RoundOne(60);
        System.out.println("Go!");

        
        //infinite method for printing questions, will end with the timer
        for (int i = 0; i < 10; i++) {
            LongFormQuestion question = new LongFormQuestion(1);
            System.out.println(question.getQuestion());
            playerAnswer = scan.nextLine();

            RoundOne.checkAnswer(playerAnswer, question);
        }
        return true;
    }
}
