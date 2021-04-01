
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * Round One of the Chase!
 * 1 Minute timer is started - then the player will have that amount of time to
 * answer as many long answer question correctly they can in that time period
 */
public class RoundOne {
    //code goes in here
    //I have found a way to make the timer work as well
    
    public void showQuestions(){
        RoundOne r = new RoundOne();
        BufferedReader br = null;
        PrintWriter pw = null;
        
       for(int i = 0; i <10; i++){
           //print questions here
           br = new BufferedReader(new FileReader(./LongFormQuestions.txt));
           pw = new PrintWriter("./Longformquestions.txt");
           //print writer then buffer reader
           
           if(question == false){
               System.out.println("Incorrect Answer!"
                       + "The Answer was: ");
               
           }
           else if(question == true){
               System.out.println("Correct!");
               r.getPlayerScore()++;
           }
           
           i--;
       }
    }
}
   
