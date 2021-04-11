import java.util.Scanner;

public class RoundThree {
    private Players players;

    public RoundThree(Players players) {
        this.players = players;
    }

    public synchronized void startRound() {
        Thread timedRound = new Thread(() -> {
                Scanner scanner = new Scanner(System.in);
                while(true) {
                    System.out.println("x");
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

    }

    public static void main(String[] args) {
        RoundThree r3 = new RoundThree(new Players("",""));
        r3.startRound();
    }
}
