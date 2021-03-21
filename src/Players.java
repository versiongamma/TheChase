
import java.util.Scanner;


public class Players {
	
	private String chaser;
	private String player;
	
        public void askNames(){
            
            Scanner scan = new Scanner(System.in);
            
            System.out.println("Chaser's Name: ");
            chaser = scan.next();
            
            System.out.println("Player's Name: ");
            player = scan.next();
        }
	
	//GETTERS AND SETTERS
	
	public String getChaser() {
		return chaser;
	}

	public void setChaser(String chaser) {
		this.chaser = chaser;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

}
