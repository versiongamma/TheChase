package Rounds;

import java.util.Scanner;

import Exceptions.QuestionAlreadyUsedException;
import Game.Players;
import Questions.Question;
import Questions.LongFormQuestion;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

/**
 * @author Matt 19076935
 */
public class RoundThree implements Round {
    private Players players;
    private ArrayList<Question> questions = new ArrayList<Question>();
    private boolean inPlayerRound = true, inChaserRound = false;

    public RoundThree(Players players) {
        this.players = players;
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
                + players.getPlayer() + ", are you ready? Enter 'enter' to begin \n");
        scanner.nextLine();

        playerRound.start();

        while (inPlayerRound) {
            LongFormQuestion q = getQuestion();
            System.out.println(q);
            System.out.print("> ");

            if (q.checkAnswer(scanner.nextLine())) {
                System.out.println("Correct!");
                players.setPlayerCash(players.getPlayerCash() + 1000);
            } else {
                System.out.println(String.format("Incorrect! The correct answer was: %s", q.getAnswer()));
            }
        }

        System.out.println("Times Up!");

        /** Chaser's round */
        System.out.println("Answer as many questions as you can in 2 minutes!\n "
                + players.getChaser() + ", are you ready? Enter 'enter' to begin \n");
        scanner.nextLine();

        chaserRound.start();

        while (inChaserRound) {
            if (players.getPlayerCash() <= players.getChaserCash()) { return false; }

            LongFormQuestion q = getQuestion();
            System.out.println(q);
            System.out.print("> ");

            if (q.checkAnswer(scanner.nextLine())) {
                System.out.println("Correct!");
                players.setChaserCash(players.getChaserCash() + 1000);
            } else {
                System.out.println(String.format("Incorrect! Now, %s, try and guess!", players.getPlayer()));
                System.out.print(">");

                if (q.checkAnswer(scanner.nextLine())) {
                    players.setChaserCash(players.getChaserCash() > 0 ? players.getChaserCash() - 1000 : 0);
                    System.out.println("Correct!");
                } else {
                    System.out.println(String.format("Incorrect! The correct answer was: %s", q.getAnswer()));
                }
            }

            System.out.println(
                    String.format(
                            "\n%s's Cash: $%d\n%s's Cash: %d\n",
                            players.getPlayer(), players.getPlayerCash(),
                            players.getChaser(), players.getChaserCash()));
        }

        System.out.println("Times Up!");

        return players.getPlayerCash() > players.getChaserCash();
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

    public static void main(String[] args) {
        Players players = new Players("","");
        players.setPlayerCash(1000);
        RoundThree r3 = new RoundThree(players);
        r3.startRound();
    }
}
