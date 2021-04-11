
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;


public class RoundThree {
    //2 minute timer 
    //the player starts by answering as many questions in 2 minutes
    //the chaser then gets to try and 'catch' the player, but if they get
    //a question wrong then the player has a chance to push them back by answering
    //the same question correctly.
    
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
