

import Questions.Answer;
import Questions.MultiChoiceQuestion;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;

/**
 *
 * @author abbyl
 */
public class RoundTwo {

    private final int MONEYROUND1;
    private Board board;
    private ArrayList<Questions.MultiChoiceQuestion> questions;
    private int moneyRound2;

    /**
     * Constructor for a Round2 object.
     * 
     * @param moneyRound1 the money the player won from the first round
     */
    RoundTwo(int moneyRound1) {
        this.MONEYROUND1 = moneyRound1;
        this.board = new Board(this.highOffer(), this.lowOffer(), this.MONEYROUND1);
        this.questions = new ArrayList<Questions.MultiChoiceQuestion>();
        this.moneyRound2 = 0;
    }
    
    /**
     * Returns the integer of the money the player chose in round 2.
     * 
     * @return moneyRound2 the money value the player chose in round 2
     */
    public int getMoneyRound2() {
        return moneyRound2;
    }
    
    /**
     * Returns a high offer of the chaser's choice.
     * 
     * @return high the high offer
     */
    public int highOffer() {
        Scanner scanner = new Scanner(System.in);
        int high = 0;
        boolean correctInput = false;

        while (!correctInput) {
            System.out.println("Player's money value is $" + this.MONEYROUND1);
            System.out.println("Chaser, choose a high offer: ");
            String s = scanner.nextLine();
            try {
                high = Integer.parseInt(s.trim());
                if (high > this.MONEYROUND1) {
                    correctInput = true;
                } else {
                    System.out.println("The high offer must be more than the money won.");
                }

            } catch (NumberFormatException e) {
                System.out.println("The high offer must be an integer.");
            }
        }

        return high;
    }
    
    /**
     * Returns a low offer of the chaser's choice.
     * 
     * @return low the low offer
     */
    public int lowOffer() {
        Scanner scanner = new Scanner(System.in);
        int low = 0;
        boolean correctInput = false;

        while (!correctInput) {
            System.out.println("Chaser, choose a low offer: ");
            String s = scanner.nextLine();
            try {
                low = Integer.parseInt(s.trim());
                if (low < this.MONEYROUND1) {
                    correctInput = true;
                } else {
                    System.out.println("The low offer must be less than the money won.");
                }

            } catch (NumberFormatException e) {
                System.out.println("The low offer must be an integer.");
            }
        }

        return low;
    }

    /**
     * Displays the high and low offers to the player, and prompts them to make 
     * a choice. Also sets up the board for the start of game play.
     */
    public void playerOfferChoice() {
        Scanner scanner = new Scanner(System.in);
        this.board.initialBoard();
        boolean correctInput = false;

        while (!correctInput) {
            System.out.println("Player, which offer would you like to take? ");
            String s = scanner.nextLine();
            try {
                this.moneyRound2 = Integer.parseInt(s);
                if (this.getMoneyRound2() == board.getHIGHOFFER()) {
                    correctInput = true;
                } else if (this.getMoneyRound2() == board.getLOWOFFER()) {
                    correctInput = true;
                } else if (this.getMoneyRound2() == board.getMIDDLEOFFER()) {
                    correctInput = true;
                } else {
                    System.out.println("Please choose an offer from the board.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter your choice as an integer.");
            }
        }
        
        board.setMoneyChoice(this.getMoneyRound2());
        board.setPlayerPosition(this.getMoneyRound2());
    }

    /**
     * Generates a list of multi-choice questions from the provided text file.
     */
    public void makeQuestionsList() {
        try {
            BufferedReader inStream = new BufferedReader(new FileReader("./data/multi_choice_questions.csv"));
            String line = null;

            while ((line = inStream.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, "*");
                while (st.hasMoreTokens()) {
                    Questions.MultiChoiceQuestion temp = new Questions.MultiChoiceQuestion(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
                    this.questions.add(temp);
                }
            }

            inStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading from file");
        }
    }

    /**
     * Executes game play of round 2. Displays questions in a random order, prompts
     * player and chaser for answers and calls method to evaluate answers. At completion
     * of game play, returns 1 if player won and 0 if player lost.
     * 
     * @return returns 1 if player won, returns 0 if player lost
     */
    public int startRound() {
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        String playerAnswer;
        String chaserAnswer;
        boolean won = false;
        boolean lost = false;
        Answer result = null;
        Collections.shuffle(this.questions);

        while (!won && !lost) {
            while(result == null && count < this.questions.size()){
                System.out.println("\n" + this.questions.get(count).toString());
                System.out.println("Player answer: ");
                playerAnswer = scanner.nextLine().trim();
                System.out.println("Chaser answer: ");
                chaserAnswer = scanner.nextLine().trim();
                result = this.questions.get(count).checkAnswer(playerAnswer, chaserAnswer);

                switch (result) {
                    case BOTH:
                        this.board.playerCorrect();
                        this.board.chaserCorrect();
                        break;
                    case PLAYER:
                        this.board.playerCorrect();
                        break;
                    case CHASER:
                        this.board.chaserCorrect();
                        break;
                    default:
                        break;
                }
            }

            if (this.board.getPlayerPosition() == 9) {
                won = true;
            } else if (this.board.getChaserPosition() == this.board.getPlayerPosition()) {
                lost = true;
            }
            
            this.board.printBoard();
            result = null;
            count++;
        }
        
        if (won) {
            return 1;
        } else if (lost) {
            return 0;
        }
        else{
            return -1;
        }
    }
}