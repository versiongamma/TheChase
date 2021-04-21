package Game;

/**
 * This class sets all the variables used to store information re-guarding
 * the player and chaser, these variables are encapsulated so they are functional
 * throughout the other classes in the program. 
 * @authors Abby - 19071317 Julia - 19078503 Matt - 19076935
 */
public class Players {

    private String chaser;
    private String player;
    private int playerCash;
    private int chaserCash;
    private int playerScore;
    private int chaserScore;

    public Players(String chaser, String player) {
        this.chaser = chaser;
        this.player = player;
        this.playerCash = 0;
        this.chaserCash = 0;
        this.playerScore = 0;
        this.chaserScore = 0;
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

    public int getPlayerCash() {
        return playerCash;
    }

    public int getChaserCash() {
        return chaserCash;
    }

    public void setChaserCash(int chaserCash) {
        this.chaserCash = chaserCash;
    }

    public void setPlayerCash(int playerCash) {
        this.playerCash = playerCash;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getChaserScore() {
        return chaserScore;
    }

    public void setChaserScore(int chaserScore) {
        this.chaserScore = chaserScore;
    }

}
