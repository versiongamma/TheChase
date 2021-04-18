package Rounds;

import java.util.Scanner;

import Exceptions.QuestionAlreadyUsedException;
import Game.Players;
import Questions.Question;
import Questions.LongFormQuestion;
import java.util.ArrayList;

/**
 * @author Matt 19076935
 */
public class RoundThree implements Round {
    private Players players;

    public RoundThree(Players players) {
        this.players = players;
    }

    /**
     * Starts the round
     * @return The outcome of the round
     */
    public synchronized boolean startRound() {
        Thread timedRound = new Thread(() -> {
            ArrayList<Question> questions = new ArrayList<Question>();
            Scanner scanner = new Scanner(System.in);
            while(true) {
                LongFormQuestion q = new LongFormQuestion(2);
                try {
                    for (Question done : questions) {
                        System.out.println(done);
                        if (q.equals(done)) {
                            System.out.println("skipping");
                            throw new QuestionAlreadyUsedException();
                        }
                    }
                } catch (QuestionAlreadyUsedException e) {
                    continue;
                }
                questions.add(q);
                System.out.println(q);
                scanner.nextLine();
            }
        });

        timedRound.start();
        System.out.println("Thread Started");
        try {
            wait(1000);
            timedRound.stop(); // Yes I know this is deprecated, but Thread.interrupt wasn't working


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        RoundThree r3 = new RoundThree(new Players("",""));
        r3.startRound();
    }
}
