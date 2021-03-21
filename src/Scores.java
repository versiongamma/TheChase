/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author julia
 */
public class Scores {

    /**
     * @return the chaserScore
     */
    public int getChaserScore() {
        return chaserScore;
    }

    /**
     * @param chaserScore the chaserScore to set
     */
    public void setChaserScore(int chaserScore) {
        this.chaserScore = chaserScore;
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
    private int chaserScore;
    private int playerScore;
    
    public int updateChaserScore(){
        return 0;
    }
    
    public int updatePlayerScore(){
        return 0;
    }
}
