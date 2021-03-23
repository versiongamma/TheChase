package Questions;

public interface Question {

    /** Check if the answer is correct
     * @param answer The guess of the user
     * @return Boolean statement representing if the answer was correct or not
     */
    boolean checkAnswer(String answer);
}
