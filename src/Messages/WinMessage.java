package Messages;

import Game.Players;

/**
 * This class prints out the winning message for the player if they beat the
 * chaser for each round appropriately.
 *
 * @authors Abby - 19071317 Julia - 19078503 Matt - 19076935
 */
public class WinMessage {

    private final int CASHWON;
    private final int ROUNDNUMBER;
    private Players players;

    /**
     * Constructor for Messages.WinMessage object.
     *
     * @param cashWon the amount of cash the player won from the round
     * @param roundNumber the round they won
     */
    public WinMessage(int cashWon, int roundNumber, Players players) {
        this.CASHWON = cashWon;
        this.ROUNDNUMBER = roundNumber;
        this.players = players;
    }

    /**
     * Prints out the congratulation message for round 1 or round 2.
     */
    public void printWinRoundMessage() {
        if (this.ROUNDNUMBER < 3) {
            String moneyStr = "$" + String.valueOf(this.CASHWON) + "!";
            int lineLength = 38;
            int moneyspaces = lineLength - 2 - moneyStr.length();
            int moneylSpaces = moneyspaces / 2;
            int moneyrSpaces = (moneyspaces % 2) == 0 ? moneylSpaces : moneylSpaces + 1;

            String nameStr = "Well done " + players.getPlayer() + "!";
            int namespaces = lineLength - 2 - nameStr.length();
            int namelSpaces = namespaces / 2;
            int namerSpaces = (namespaces % 2) == 0 ? namelSpaces : namelSpaces + 1;

            System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");

            System.out.print("|");
            for (int i = 0; i < namelSpaces; i++) {
                System.out.print(" ");
            }
            System.out.print(nameStr);
            for (int i = 0; i < namerSpaces; i++) {
                System.out.print(" ");
            }
            System.out.println("|");

            System.out.println("|     From Round " + this.ROUNDNUMBER + " you have won      |");
            System.out.print("|");
            for (int i = 0; i < moneylSpaces; i++) {
                System.out.print(" ");
            }
            System.out.print(moneyStr);
            for (int i = 0; i < moneyrSpaces; i++) {
                System.out.print(" ");
            }
            System.out.println("|");
            System.out.println("|           Next, Round " + (this.ROUNDNUMBER + 1) + "!           |");
            System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n");
        } else {
            this.printFinalWinMessage();
        }
    }

    /**
     * Prints out the congratulation message for round 3.
     */
    public void printFinalWinMessage() {
        if (this.ROUNDNUMBER == 3) {
            String moneyStr = "$" + String.valueOf(this.CASHWON) + "!";
            int lineLength = 38;
            int spaces = lineLength - 2 - moneyStr.length();
            int lSpaces = spaces / 2;
            int rSpaces = (spaces % 2) == 0 ? lSpaces : lSpaces + 1;

            String nameStr = "Well done " + players.getPlayer() + "!";
            int namespaces = lineLength - 2 - nameStr.length();
            int namelSpaces = namespaces / 2;
            int namerSpaces = (namespaces % 2) == 0 ? namelSpaces : namelSpaces + 1;

            System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");

            System.out.print("|");
            for (int i = 0; i < namelSpaces; i++) {
                System.out.print(" ");
            }
            System.out.print(nameStr);
            for (int i = 0; i < namerSpaces; i++) {
                System.out.print(" ");
            }
            System.out.println("|");
            System.out.println("|     You bet the chaser and won     |");
            System.out.print("|");
            for (int i = 0; i < lSpaces; i++) {
                System.out.print(" ");
            }
            System.out.print(moneyStr);
            for (int i = 0; i < rSpaces; i++) {
                System.out.print(" ");
            }
            System.out.println("|");
            System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n");
        } else {
            this.printWinRoundMessage();
        }
    }
}
