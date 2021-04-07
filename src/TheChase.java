
import Questions.LongFormQuestion;
import Questions.MultiChoiceQuestion;
import java.io.IOException;
import java.util.Scanner;

/**
 * Abby - 19071317
 * Julia - 19078503
 * Matt - 19076935
 */
public class TheChase {

    /** The program entry point
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // Make this prettier to match the output style
        // Also make sure to add in the main menu before this
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player name?");
        String player = scanner.nextLine();
        System.out.println("Chaser name?");
        String chaser = scanner.nextLine();
        Players players = new Players(chaser, player);
        
        System.out.println("\n");
        
        System.out.println(new LongFormQuestion());
        
        //This should be set to the value from Round 1
        players.setPlayerCash(1000);
        
        //ROUND 2 GAMEPLAY
        Round2 round2 = new Round2(players.getPlayerCash());
        round2.playerOfferChoice();
        round2.makeQuestionsList();
        int wonLost = round2.startRound();
        
        switch(wonLost){
            case 0:
                //LoseMessage lm = new LoseMessage(??);
                //lm.printLoseMessage();
                System.out.println("Lose Message Here");
                break;
            case 1:
                WinMessage wm = new WinMessage(round2.getMoneyRound2(), 2);
                wm.printWinRoundMessage();
                break;
            default:
                System.out.println("Error in Round 2 return.");
                break;
        }
        
        players.setPlayerCash(round2.getMoneyRound2());
        //END OF ROUND 2 GAMEPLAY
    }
    
    
    
}
