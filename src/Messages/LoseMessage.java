package Messages;

import Game.Players;

/**
 *This class prints out the loosing message for player if the chaser
 * beats them in rounds two or three. 
 * 
 * @authors Abby - 19071317 Julia - 19078503 Matt - 19076935
 */
public class LoseMessage {

    Players players;

    public LoseMessage(Players players) {
        this.players = players;
    }

    public void printLoseMessage() {
        String chaserStr = "Well done " + players.getChaser() + "!";
        int lineLength = 38;
        int namespaces = lineLength - 2 - chaserStr.length();
        int namelSpaces = namespaces / 2;
        int namerSpaces = (namespaces % 2) == 0 ? namelSpaces : namelSpaces + 1;

        System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");

        System.out.print("|");
        for (int i = 0; i < namelSpaces; i++) {
            System.out.print(" ");
        }
        System.out.print(chaserStr);
        for (int i = 0; i < namerSpaces; i++) {
            System.out.print(" ");
        }
        System.out.println("|");

        System.out.println("|    You caught the player and won!  |");
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n");
        
        String playerStr = players.getPlayer()+"'s money lost: $" + players.getPlayerCash();
        int playerspaces = lineLength - 2 - playerStr.length();
        int playerlSpaces = playerspaces / 2;
        int playerSpaces = (playerspaces % 2) == 0 ? playerlSpaces : playerlSpaces + 1;

        System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");

        System.out.print("|");
        for (int i = 0; i < playerlSpaces; i++) {
            System.out.print(" ");
        }
        System.out.print(playerStr);
        for (int i = 0; i < playerSpaces; i++) {
            System.out.print(" ");
        }
        System.out.println("|");
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n");
    }

}
