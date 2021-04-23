package Rounds;

import java.util.Scanner;

import Exceptions.QuestionAlreadyUsedException;
import Game.Players;
import Questions.Question;
import Questions.LongFormQuestion;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

/**
 * @authors Abby - 19071317 Julia - 19078503 Matt - 19076935
 */
public class RoundThree implements Round {
    private Players players;
    private ArrayList<Question> questions = new ArrayList<Question>();
    private boolean inPlayerRound = true, inChaserRound = false;
    private int playerPosition;
    private int chaserPosition;

    public RoundThree(Players players) {
        this.players = players;
        this.playerPosition = 0;
        this.chaserPosition = 0;
    }

    /**
     * Starts the round
     * @return The outcome of the round
     */
    public boolean startRound() {

        Thread playerRound = new Thread(() -> {
            try { sleep(1000 * 120); }
            catch (InterruptedException e) { e.printStackTrace(); }

            inPlayerRound = false;
            inChaserRound = true;
        });

        Thread chaserRound = new Thread(() -> {
            try { sleep(1000 * 120); }
            catch (InterruptedException e) { e.printStackTrace(); }

            inChaserRound = false;
        });

        Scanner scanner = new Scanner(System.in);

        /** Player's round */
        System.out.println("Answer as many questions as you can in 2 minutes!\n "
                + players.getPlayer() + ", are you ready? Press 'enter' to begin \n");
        scanner.nextLine();

        playerRound.start();

        while (inPlayerRound) {
            LongFormQuestion q = getQuestion();
            System.out.println(q);
            System.out.print("> ");

            if (q.checkAnswer(scanner.nextLine())) {
                System.out.println("Correct!");
                playerPosition++;
                //players.setPlayerCash(players.getPlayerCash() + 1000);
            } else {
                System.out.println(String.format("Incorrect! The correct answer was: %s", q.getAnswer()));
            }
        }

        System.out.println("Times Up!");

        /** Chaser's round */
        System.out.println("Answer as many questions as you can in 2 minutes!\n "
                + players.getChaser() + ", are you ready? Press 'enter' to begin \n");
        scanner.nextLine();

        chaserRound.start();

        while (inChaserRound) {
            if (players.getPlayerCash() <= players.getChaserCash()) { return false; }

            LongFormQuestion q = getQuestion();
            System.out.println(q);
            System.out.print("> ");

            if (q.checkAnswer(scanner.nextLine())) {
                System.out.println("Correct!");
                chaserPosition++;
            } else {
                System.out.println(String.format("Incorrect! Now, %s, try and guess!", players.getPlayer()));
                System.out.print(">");

                if (q.checkAnswer(scanner.nextLine())) {
                    players.setChaserCash(players.getChaserCash() > 0 ? chaserPosition-- : 0);
                    System.out.println("Correct!");
                } else {
                    System.out.println(String.format("Incorrect! The correct answer was: %s", q.getAnswer()));
                }
            }

            System.out.println(
                    String.format(
                            "\n%s's Position: %d\n%s's Position: %d\n",
                            players.getPlayer(), playerPosition,
                            players.getChaser(), chaserPosition));
        }

        System.out.println("Times Up!");

        players.setChaserCash(1000*chaserPosition);
        return playerPosition > chaserPosition;
    }

    /**
     * Get a question which has not been asked before in this game
     * @return A question not already indexed into this.questions
     */
    public LongFormQuestion getQuestion() {
        int i = 0;
        while(true) {
            if (i > 1000) { break; }
            LongFormQuestion q = new LongFormQuestion();
            try {
                for (Question done : questions) {
                    if (q.equals(done)) {
                        throw new QuestionAlreadyUsedException();
                    }
                }
            } catch (QuestionAlreadyUsedException e) {
                ++i;
                continue;
            }
            questions.add(q);
            return q;
        }
        return null;
    }
}
