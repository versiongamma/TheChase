import Messages.LoseMessage;
import Messages.WinMessage;
import Game.Players;
import Rounds.Round;
import Rounds.RoundOne;
import Rounds.RoundThree;
import Rounds.RoundTwo;

import java.io.IOException;
import java.util.Scanner;

/**
 * This is the main class of the program, all the rounds come together to create
 * the main game! Game instructions are also printed here.
 * 
 * @authors Abby - 19071317 Julia - 19078503 Matt - 19076935
 */
public class TheChase {

    /**
     * The program entry point
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println("|            Welcome to              |");
        System.out.println("|               the                  |");
        System.out.println("|              Chase!                |");
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n");

        int selection;
        Scanner scanner = new Scanner(System.in);
                
        
        do {
            System.out.println("Please Choose an Option: \n"
                    + "1. Play The Chase \n"
                    + "2. How to Play \n"
                    + "3. Exit");
            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    //game starts
                    
                    System.out.println("Player name?");
                    String player = scanner.next().trim();
                    System.out.println("Chaser name?");
                    String chaser = scanner.next().trim();
                    Players players = new Players(chaser, player);

                    System.out.println("\n");

                    //ROUND ONE
                    RoundOne round1 = new RoundOne(" ", players);
                    round1.startRound();
                    System.out.println("Time's up!");
                    
                    WinMessage wm = new WinMessage(players.getPlayerCash(), 1, players);
                    wm.printWinRoundMessage();
                    //END OF ROUND 1 GAMEPLAY
                    
                    //ROUND 2 GAMEPLAY
                    Round round2 = new RoundTwo(players);
                    boolean won = round2.startRound();

                    if (!won) {
                        LoseMessage lm = new LoseMessage(players);
                        lm.printLoseMessage();
                    } else {
                        wm = new WinMessage(players.getPlayerCash(), 2, players);
                        wm.printWinRoundMessage();
                    }
                    //END OF ROUND 2 GAMEPLAY

                    //ROUND 3 GAMEPLAY
                    if (new RoundThree(players).startRound()) {
                      new WinMessage(players.getPlayerCash(), 3, players).printWinRoundMessage();
                    } else {
                        new LoseMessage(players).printLoseMessage();
                    }
                    //END OF ROUND 3 GAMEPLAY
                    
                    System.out.println("Thanks for playing The Chase!");
                    break;
                case 2:
                    System.out.println("Game instructions: \n"
                            + "This game has been modled of the popular quiz game show 'The Chase'. \n"
                            + "To play: enter the name of the player and then the chaser - this is a two player\n"
                            + "game. Then follow the propmts and either try to out chase the chaser or catch the player!\n");
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    throw new IndexOutOfBoundsException();
            }

        } while (selection == 1 || selection == 2);
    }
}
