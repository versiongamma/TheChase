/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author julia
 */
public class LoseMessage {
    
    private int moneyLost;
   
    LoseMessage(int moneyLost){
        this.moneyLost = moneyLost;
    }
    
    public void printLoseMessage(){
            System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
            System.out.println(" |          Well done Chaser!           |");
            System.out.println(" |  You have caught the player and won! |");
            System.out.println(" =+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n");   
            
            System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
            System.out.println(" |          The player cash lost:       |");
            System.out.println(" =+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n");  
    }
    
}
