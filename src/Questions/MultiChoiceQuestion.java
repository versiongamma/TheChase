package Questions;


import java.util.Locale;

/**
 *
 * @author abbyl
 */
public class MultiChoiceQuestion{
    private final String QUESTION;
    private final String A;
    private final String B;
    private final String C;
    private final String ANSWER;
    
    /**
     * Constructor for MultiChoiceQuestion object.
     * 
     * @param question the questions itself
     * @param a        answer a
     * @param b        answer b
     * @param c        answer c
     * @param answer   the letter of the correct answer (a, b, or c)
     */
    public MultiChoiceQuestion(String question, String a, String b, String c, String answer){
        this.QUESTION = question;
        this.A = a;
        this.B = b;
        this.C = c;
        this.ANSWER = answer;
    }
    
    /**
     * Returns if the chaser's and/or player's answer is correct or not for
     * each question. Returns a different number depending for both correct, just 
     * player correct, just chaser correct, neither correct, and incorrect input.
     * 
     * @param playerAnswer the answer the player entered
     * @param chaserAnswer the answer the player entered
     * @return The state of the answer as a Answer type,
     */
    public Answer checkAnswer(String playerAnswer, String chaserAnswer){
        if((!playerAnswer.equalsIgnoreCase("A") && !playerAnswer.equalsIgnoreCase("B") 
                && !playerAnswer.equalsIgnoreCase("C")) || (!chaserAnswer.equalsIgnoreCase("A") 
                && !chaserAnswer.equalsIgnoreCase("B") && !chaserAnswer.equalsIgnoreCase("C"))){
            
            System.out.println("Please enter A, B, or C as your answer.");
            return Answer.NEITHER;
        }
        else if(playerAnswer.equalsIgnoreCase(ANSWER) && chaserAnswer.equalsIgnoreCase(ANSWER)){
            return Answer.BOTH;
        }
        else if(playerAnswer.equalsIgnoreCase(ANSWER) && !chaserAnswer.equalsIgnoreCase(ANSWER)){
            return Answer.PLAYER;
        }
        else if(!playerAnswer.equalsIgnoreCase(ANSWER) && chaserAnswer.equalsIgnoreCase(ANSWER)){
            return Answer.CHASER;
        }
        else{
            return Answer.NEITHER;
        }
    }
    
    /**
     * Overrides the toString method to return the question as a string that is 
     * readable for the user.
     * 
     * @return the readable string
     */
    @Override
    public String toString(){
        return this.QUESTION +"\n"+this.A+"\n"+this.B+"\n"+this.C;
    }
}
