

/**
 *
 * @author abbyl
 */
public class WinMessage {
    private final int CASHWON;
    private final int ROUNDNUMBER;
    
    /**
     * Constructor for WinMessage object.
     * 
     * @param cashWon     the amount of cash the player won from the round
     * @param roundNumber the round they won
     */
    WinMessage(int cashWon, int roundNumber){
        this.CASHWON = cashWon;
        this.ROUNDNUMBER = roundNumber;
    }
    
    /**
     * Prints out the congratulation message for round 1 or round 2.
     */
    public void printWinRoundMessage(){
        if(this.ROUNDNUMBER < 3){
            String moneyStr = "$"+String.valueOf(this.CASHWON)+"!";
            int lineLength = 38;
            int spaces = lineLength-2-moneyStr.length();
            int lSpaces = spaces/2;
            int rSpaces = (spaces%2) == 0? lSpaces : lSpaces+1;

            System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
            System.out.println("|         Well done Player!          |");
            System.out.println("|     From Round "+this.ROUNDNUMBER+" you have won      |");
            System.out.print("|");
            for(int i = 0; i < lSpaces; i++){
                System.out.print(" ");
            }
            System.out.print(moneyStr);
            for(int i = 0; i < rSpaces; i++){
                System.out.print(" ");
            }
            System.out.println("|");
            System.out.println("|           Next, Round " + (this.ROUNDNUMBER+1) + "!           |");
            System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n");
        }
        else{
            this.printFinalWinMessage();
        }
    }
    
    /**
     * Prints out the congratulation message for round 3.
     */
    public void printFinalWinMessage(){
        if(this.ROUNDNUMBER == 3){
            String moneyStr = "$"+String.valueOf(this.CASHWON)+"!";
            int lineLength = 38;
            int spaces = lineLength-2-moneyStr.length();
            int lSpaces = spaces/2;
            int rSpaces = (spaces%2) == 0? lSpaces : lSpaces+1;

            System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
            System.out.println("|         Well done Player!          |");
            System.out.println("|     You bet the chaser and won     |");
            System.out.print("|");
            for(int i = 0; i < lSpaces; i++){
                System.out.print(" ");
            }
            System.out.print(moneyStr);
            for(int i = 0; i < rSpaces; i++){
                System.out.print(" ");
            }
            System.out.println("|");
            System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n");    
        }
        else{
            this.printWinRoundMessage();
        }
    }
    
    //adds the player's stats to the stats file
    //public void addStats(Players players){
        
    //}
}
