
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author julia
 */
public class RoundThree {
    
    Toolkit toolkit;
    Timer timer;
    
      public RoundThree(int seconds) {
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up!");

                toolkit.beep();
                timer.cancel();
            }
        }, seconds * 1000);
    }
      
      public void startRound(){
          new RoundThree(120);
      }
    
}
