package Rounds;

import Game.Players;
import Questions.LongFormQuestion;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
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
    private static ArrayList<Questions.LongFormQuestion> questions;
    private Random randomNumber;
    Toolkit toolkit;
    Timer timer;

    /**
     * Default round constructor
     *
     * @param playerAnswer
     * @param players
     */
    public RoundOne(String playerAnswer, Players players) {
        this.randomNumber = new Random();
        RoundOne.playerAnswer = playerAnswer;
        RoundOne.players = players;
        RoundOne.questions = new ArrayList<Questions.LongFormQuestion>();
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
     * Generates a list of multi-choice questions from the provided text file.
     */
    public void makeQuestionsList() {
        try {
            BufferedReader inStream = new BufferedReader(new FileReader("./data/long-form-questions.csv"));
            String line = null;

            while ((line = inStream.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, "*");
                while (st.hasMoreTokens()) {
                    LongFormQuestion temp = new LongFormQuestion(st.nextToken(), st.nextToken());
                    this.questions.add(temp);
                }
            }

            inStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Error reading from file");
            System.exit(0);
        }
    }
    
    /**
     * Sets and prints the timer and questions
     *
     * @return The outcome of the round's completion (true is successful)
     */
    @Override
    public boolean startRound() {
        Scanner scan = new Scanner(System.in);
        
        makeQuestionsList();
        Collections.shuffle(this.questions);
        int count = 0;
        
        System.out.println("Answer as many questions as you can in 1 minute!\n "
                + players.getPlayer() + ", are you ready? Enter 'y' to begin: \n");
        String playerInput = scan.next();

        do {
            RoundOne roundOne = new RoundOne(60);
            System.out.println("\nGo!");

            //infinite method for printing questions, will end with the timer
            for (int i = 0; i < 10; i++) {
                System.out.println(questions.get(count));
                System.out.print("> ");
                if (i == 0) {
                    String temp = scan.nextLine();
                }
                playerAnswer = scan.nextLine();

                RoundOne.checkAnswer(playerAnswer, questions.get(count));
                count++;
            }
            return true;

        } while (playerInput.equals("y") || playerInput.equals("Y"));
    }
}
