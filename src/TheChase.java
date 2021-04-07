
import Questions.LongFormQuestion;
import Questions.MultiChoiceQuestion;
import java.io.IOException;

/**
 * Abby - 
 * Julia - 19078503
 * Matt - 19076935
 */
public class TheChase {

    /** The program entry point
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        System.out.println(new MultiChoiceQuestion());
        
        System.out.println("\n");
        
        System.out.println(new LongFormQuestion());
        
        //ROUND 2 GAMEPLAY
        int cash = 1000; //Will be set from the previous round
        
        Round2 round2 = new Round2(cash);
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
        //END OF ROUND 2 GAMEPLAY
    }
    
    
    
}
