package Rounds;

import Game.Players;
import Questions.LongFormQuestion;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import static java.lang.Thread.sleep;

/**
 *
 * Round One of the Chase! 1 Minute timer is started - then the player will have
 * that amount of time to answer as many long answer question correctly they can
 * in that time period
 *
 * @authors Abby - 19071317 Julia - 19078503 Matt - 19076935
 */
public class RoundOne implements Round {

    private static String playerAnswer;
    private static Players players;
    private static ArrayList<Questions.LongFormQuestion> questions;
    private boolean inRound = true;

    /**
     * Default round constructor
     *
     * @param playerAnswer
     * @param players
     */
    public RoundOne(String playerAnswer, Players players) {
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

        System.out.println("Answer as many questions as you can in 1 minute!\n"
                + players.getPlayer() + ", are you ready? Press 'enter' to begin");
        String playerInput = scan.nextLine();

        System.out.println("\nGo!");

        Thread roundStop = new Thread(() -> {
            try {
                sleep(1000 * 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            inRound = false;
        });

        roundStop.start();

        //infinite method for printing questions, will end with the timer
        while (inRound) {
            System.out.println(questions.get(count));
            System.out.print("> ");

            playerAnswer = scan.nextLine();

            RoundOne.checkAnswer(playerAnswer, questions.get(count));
            count++;
        }
        return true;

    }
}
