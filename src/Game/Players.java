package Game;

public class Players {
	
	private String chaser;
	private String player;
	private int playerCash;
	private int chaserCash;



	public Players(String chaser, String player) {
		this.chaser = chaser;
		this.player = player;
		this.playerCash = 0;
		this.chaserCash = 0;
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
        
	public int getPlayerCash(){
		return playerCash;
	}

	public int getChaserCash() {
		return chaserCash;
	}

	public void setChaserCash(int chaserCash) {
		this.chaserCash = chaserCash;
	}

    public void setPlayerCash(int playerCash){
            this.playerCash = playerCash;
        }

}
