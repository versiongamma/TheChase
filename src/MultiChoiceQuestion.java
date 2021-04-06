

/**
 *
 * @author abbyl
 */
public class MultiChoiceQuestion {
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
    MultiChoiceQuestion(String question, String a, String b, String c, String answer){
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
     * @return             returns 1 for both correct, 2 for just player, 3 for 
     *                     just chaser, 0 for neither, and 4 for an incorrect input
     */
    public int checkAnswer(String playerAnswer, String chaserAnswer){
        if((!playerAnswer.equalsIgnoreCase("A") && !playerAnswer.equalsIgnoreCase("B") 
                && !playerAnswer.equalsIgnoreCase("C")) || (!chaserAnswer.equalsIgnoreCase("A") 
                && !chaserAnswer.equalsIgnoreCase("B") && !chaserAnswer.equalsIgnoreCase("C"))){
            
            System.out.println("Please enter A, B, or C as your answer.");
            return 4;
        }
        else if(playerAnswer.equalsIgnoreCase(ANSWER) && chaserAnswer.equalsIgnoreCase(ANSWER)){
            return 1;
        }
        else if(playerAnswer.equalsIgnoreCase(ANSWER) && !chaserAnswer.equalsIgnoreCase(ANSWER)){
            return 2;
        }
        else if(!playerAnswer.equalsIgnoreCase(ANSWER) && chaserAnswer.equalsIgnoreCase(ANSWER)){
            return 3;
        }
        else{
            return 0;
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
