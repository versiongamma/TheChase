
import Questions.LongFormQuestion;
import java.io.IOException;
import java.util.Scanner;

/**
 * Abby - 19071317 Julia - 19078503 Matt - 19076935
 */
public class TheChase {

    /**
     * The program entry point
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // Make this prettier to match the output style
        // Also make sure to add in the main menu before this

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
                    String player = scanner.nextLine();
                    System.out.println("Chaser name?");
                    String chaser = scanner.nextLine();
                    Players players = new Players(chaser, player);

                    System.out.println("\n");

                    System.out.println(new LongFormQuestion());

                    //ROUND ONE
                    RoundOne round1 = new RoundOne(" ", players);

                    WinMessage wm = new WinMessage(players.getPlayerCash(), 1);
                    wm.printWinRoundMessage();

                    //END OF ROUND 1 GAMEPLAY
                    //ROUND 2 GAMEPLAY
                    Round2 round2 = new Round2(players.getPlayerCash());
                    round2.playerOfferChoice();
                    round2.makeQuestionsList();
                    int wonLost = round2.startRound();

                    switch (wonLost) {
                        case 0:
                            //LoseMessage lm = new LoseMessage(??);
                            //lm.printLoseMessage();
                            System.out.println("Lose Message Here");
                            break;
                        case 1:
                            wm = new WinMessage(players.getPlayerCash(), 2);
                            wm.printWinRoundMessage();
                            break;
                        default:
                            System.out.println("Error in Round 2 return.");
                            break;
                    }

                    players.setPlayerCash(round2.getMoneyRound2());
                    //END OF ROUND 2 GAMEPLAY

                    //ROUND 3 GAMEPLAY
                    //END OF ROUND 3 GAMEPLAY
                    break;
                case 2:
                    System.out.println("\n Game instructions: \n"
                            + " This game has been modled of the popular quiz game show 'The Chase'. \n"
                            + " To play: enter the name of the player and then the chaser - this is a two player\n"
                            + " game. Then follow the propmts and either try to out chase the chaser or catch the player!\n");
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
