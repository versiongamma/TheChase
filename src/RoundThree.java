import Exceptions.QuestionAlreadyUsedException;
import Questions.LongFormQuestion;
import Questions.Question;

import java.util.ArrayList;
import java.util.Scanner;

public class RoundThree {
    private Players players;

    public RoundThree(Players players) {
        this.players = players;
    }

    public synchronized void startRound() {
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
        try {
            wait(1000 * 120);
            timedRound.stop(); // Yes I know this is deprecated, but Thread.interrupt wasn't working

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        RoundThree r3 = new RoundThree(new Players("",""));
        r3.startRound();
    }
}
