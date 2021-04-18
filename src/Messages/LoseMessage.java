package Messages;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Rounds.Players;

/**
 *
 * @author julia
 */
public class LoseMessage {
   
    Players players;

    
    public void printLoseMessage(){
            System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
            System.out.println("  |         Well done Chaser!          |");
            System.out.println("  |     You caught the player and won! |");
            System.out.println(" =+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n");  
            
            System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
            System.out.println("  |Player money lost: "+players.getPlayerCash()+"|");
            System.out.println(" =+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n"); 
    }
    
}
