
public class Players {

    private String chaser;
    private String chaserWinLose;
    private String player;
    private String playerWinLose;
    private int playerScore;

    public Players(String chaser, String player) {
        this.chaser = chaser;
        this.player = player;
        this.chaserWinLose = ""; //Will be updated at end of game so we can print to file
        this.playerWinLose = ""; //Will be updated at end of game so we can print to file
        this.playerScore = 0; //Will be updated at end of game so we can print to file
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

    /**
     * @return the chaserWinLose
     */
    public String getChaserWinLose() {
        return chaserWinLose;
    }

    /**
     * @param chaserWinLose the chaserWinLose to set
     */
    public void setChaserWinLose(String chaserWinLose) {
        this.chaserWinLose = chaserWinLose;
    }

    /**
     * @return the playerWinLose
     */
    public String getPlayerWinLose() {
        return playerWinLose;
    }

    /**
     * @param playerWinLose the playerWinLose to set
     */
    public void setPlayerWinLose(String playerWinLose) {
        this.playerWinLose = playerWinLose;
    }

    /**
     * @return the playerScore
     */
    public int getPlayerScore() {
        return playerScore;
    }

    /**
     * @param playerScore the playerScore to set
     */
    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }
    
    public String playerToString(){
        return this.player+"*"+this.playerWinLose+"*"+this.playerScore; 
        //to print to file for the scoreboard, seperated by *
        //so we can use stringTokenizer to read file back in later
    }
    
    public String chaserToString(){
        return this.chaser+"*"+this.chaserWinLose; 
        //to print to file for the scoreboard, seperated by *
        //so we can use stringTokenizer to read file back in later
    }
}
