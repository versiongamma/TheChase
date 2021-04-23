package Game;

/**
 * This class sets the board that is seen in the second round and responds
 * appropriately to the changes that occur in number size and colour as the
 * round progresses.
 *
 * @authors Abby - 19071317 Julia - 19078503 Matt - 19076935
 */
public class Board {

    public final String ANSI_RESET = "\u001B[0m";
    private final int HIGHOFFER;
    private final int LOWOFFER;
    private final int MIDDLEOFFER;
    private int playerPosition;
    private int chaserPosition;
    private int moneyChoice;

    /**
     * Constructor for Game.Board object. Assigns default values to
     * playerPosition, chaserPosition, and moneyChoice.
     *
     * @param high the high offer from the chaser
     * @param low the low offer from the chaser
     * @param middle the amount of money the player won in round 1
     */
    public Board(int high, int low, int middle) {
        this.HIGHOFFER = high;
        this.LOWOFFER = low;
        this.MIDDLEOFFER = middle;
        this.playerPosition = 0;
        this.chaserPosition = 0;
        this.moneyChoice = 0;
    }

    /**
     * Returns the high offer off of the board
     *
     * @return HIGHOFFER the high offer
     */
    public int getHIGHOFFER() {
        return HIGHOFFER;
    }

    /**
     * Returns the low offer off of the board
     *
     * @return LOWOFFER the low offer
     */
    public int getLOWOFFER() {
        return LOWOFFER;
    }

    /**
     * Returns the middle offer off of the board
     *
     * @return MIDDLEOFFER the middle offer
     */
    public int getMIDDLEOFFER() {
        return MIDDLEOFFER;
    }

    /**
     * Returns the integer of the block position where the player currently is
     *
     * @return playerPosition the block number of the player
     */
    public int getPlayerPosition() {
        return playerPosition;
    }

    /**
     * Returns the integer of the block position where the chaser currently is
     *
     * @return chaserPosition the block number of the chaser
     */
    public int getChaserPosition() {
        return chaserPosition;
    }

    /**
     * Specifies which offer the player has chosen and assigns it to the
     * variable moneyChoice
     *
     * @param moneyChoice the choice of which offer the player chose
     */
    public void setMoneyChoice(int moneyChoice) {
        this.moneyChoice = moneyChoice;
    }

    /**
     * Assigns the variable playerPosition to which block on the board they will
     * be sitting at the start of the game based on the offer they chose.
     *
     * @param choice the offer the player chose at the beginning of the round
     */
    public void setPlayerPosition(int choice) {
        if (choice == this.HIGHOFFER) {
            this.playerPosition = 2;
        } else if (choice == this.MIDDLEOFFER) {
            this.playerPosition = 3;
        } else if (choice == this.LOWOFFER) {
            this.playerPosition = 4;
        }
    }

    /**
     * Moves the player down one block on the board if they get a question
     * correct.
     */
    public void playerCorrect() {
        this.playerPosition++;
    }

    /**
     * Moves the chaser down one block on the board if they get a question
     * correct.
     */
    public void chaserCorrect() {
        this.chaserPosition++;
    }

    /**
     * Sets up and prints the initial board of the round, displaying the offers
     * to the player.
     */
    public void initialBoard() {
        String bg = "\u001B[44m"; //Blue
        String[] moneyStrArray = {"$" + String.valueOf(this.HIGHOFFER),
            "$" + String.valueOf(this.MIDDLEOFFER), "$" + String.valueOf(this.LOWOFFER)};
        int lineLength = 26;
        int leadingSpaces = 1;

        this.topOfBoard();
        this.printBlankBlock(26, 0, bg);

        for (String s : moneyStrArray) {
            int spaces = lineLength - 2 - s.length();
            int lSpaces = spaces / 2;
            int rSpaces = (spaces % 2) == 0 ? lSpaces : lSpaces + 1;
            this.printSymbolBlock(s, leadingSpaces, lSpaces, rSpaces, bg);
            lineLength -= 2;
            leadingSpaces++;
        }

        this.printBlankBlock(18, 4, bg);
        this.printBlankBlock(16, 5, bg);
        this.printBlankBlock(14, 6, bg);
        this.printBlankBlock(12, 7, bg);
    }

    /**
     * Calls the helper methods that will display the board as it changes
     * throughout the game.
     */
    public void printBoard() {
        this.topOfBoard();
        this.beforeChaserBlock();
        this.chaserBlock();
        this.afterChaserBlock();
        this.playerBlock();
        this.afterPlayerBlock();
    }

    /**
     * Prints out the top line of the board.
     */
    public void topOfBoard() {
        System.out.print("\n____________________________\n");
    }

    /**
     * Generates values to use for printing any red blank blocks needed before
     * the chaser block.
     */
    public void beforeChaserBlock() {
        if (this.chaserPosition > 1) {
            String bg = "\u001B[41m"; //Red
            int lineLength = 28;
            for (int i = 0; i < this.chaserPosition - 1; i++) {
                int leadingSpaces = i;
                lineLength -= 2;

                this.printBlankBlock(lineLength, leadingSpaces, bg);
            }
        }
    }

    /**
     * Generates values to use for printing the red chaser block.
     */
    public void chaserBlock() {
        if (this.chaserPosition >= 1) {
            String bg = "\u001B[41m"; //Red
            String chaserStr = "\\/";
            int lineLength = (-2) * (this.chaserPosition) + 30;
            int leadingSpaces = this.chaserPosition - 1;
            int spaces = lineLength - 4;
            int lSpaces = spaces / 2;
            int rSpaces = (spaces % 2) == 0 ? lSpaces : lSpaces + 1;

            this.printSymbolBlock(chaserStr, leadingSpaces, lSpaces, rSpaces, bg);
        }
    }

    /**
     * Generates values to use for printing any green blank blocks needed
     * between the chaser block and the player block.
     */
    public void afterChaserBlock() {
        if (this.chaserPosition != (this.playerPosition - 1)) {
            String bg = "\u001B[42m"; //Green
            int lineLength = (-2) * (this.chaserPosition + 1) + 30;
            for (int i = 0; i < (this.playerPosition - this.chaserPosition - 1); i++) {
                int leadingSpaces = i + this.chaserPosition;
                lineLength -= 2;

                this.printBlankBlock(lineLength, leadingSpaces, bg);
            }
        }
    }

    /**
     * Generates values to use for printing the blue player block.
     */
    public void playerBlock() {
        if (this.playerPosition < 9 && this.playerPosition != this.chaserPosition) {
            String bg = "\u001B[44m"; //Blue
            String playerMoneyStr = "$" + String.valueOf(this.moneyChoice);
            int lineLength = (-2) * (this.playerPosition) + 30;
            int leadingSpaces = this.playerPosition - 1;
            int spaces = lineLength - 2 - playerMoneyStr.length();
            int lSpaces = spaces / 2;
            int rSpaces = (spaces % 2) == 0 ? lSpaces : lSpaces + 1;

            this.printSymbolBlock(playerMoneyStr, leadingSpaces, lSpaces, rSpaces, bg);
        }
    }

    /**
     * Generates values to use for printing any blue blank blocks needed after
     * the player block.
     */
    public void afterPlayerBlock() {
        if (this.playerPosition < 8) {
            String bg = "\u001B[44m"; //Blue
            int lineLength = (-2) * (this.playerPosition + 1) + 30;
            for (int i = 0; i < (8 - this.playerPosition); i++) {
                int leadingSpaces = i + this.playerPosition;
                lineLength -= 2;

                this.printBlankBlock(lineLength, leadingSpaces, bg);
            }
        }
    }

    /**
     * Prints out any blank blocks on the board throughout the game with their
     * specified length, leading spaces, and background colour.
     *
     * @param lineLength the length of the text in each line of the block
     * @param leadingSpaces the number of spaces needed before each line of the
     * block to display the board in the correct shape
     * @param bg the background colour of the block
     */
    public void printBlankBlock(int lineLength, int leadingSpaces, String bg) {
        //leading spaces
        for (int k = 0; k < leadingSpaces; k++) {
            System.out.print(" ");
        }

        //top line
        System.out.print(bg + "|");
        for (int k = 0; k < lineLength; k++) {
            System.out.print(" ");
        }
        System.out.print("|\n" + this.ANSI_RESET);

        //leading spaces
        for (int k = 0; k < leadingSpaces; k++) {
            System.out.print(" ");
        }

        //bottom line
        System.out.print(bg + "|");
        for (int k = 0; k < lineLength; k++) {
            System.out.print("_");
        }
        System.out.print("|\n" + this.ANSI_RESET);
    }

    /**
     * Prints out any blocks that have text in them (money blocks, chaser block,
     * and player block) in their specified sizes and colours.
     *
     * @param str the string of text to go inside the block
     * @param leadingSpaces the number of spaces needed before each line of the
     * block to display the board in the correct shape
     * @param lSpaces the number of spaces need before the text within the block
     * to keep the text centered
     * @param rSpaces the number of spaces need after the text within the block
     * to keep the text centered
     * @param bg the background colour of the block
     */
    public void printSymbolBlock(String str, int leadingSpaces, int lSpaces, int rSpaces, String bg) {
        //leading spaces
        for (int i = 0; i < leadingSpaces; i++) {
            System.out.print(" ");
        }

        //top line
        System.out.print(bg + "|");
        for (int i = 0; i < lSpaces; i++) {
            System.out.print(" ");
        }
        System.out.print(str);
        for (int i = 0; i < rSpaces; i++) {
            System.out.print(" ");
        }
        System.out.print("|\n" + this.ANSI_RESET);

        //leading spaces
        for (int i = 0; i < leadingSpaces; i++) {
            System.out.print(" ");
        }

        //bottom line
        System.out.print(bg + "|");
        for (int i = 0; i < (lSpaces + rSpaces + str.length()); i++) {
            System.out.print("_");
        }
        System.out.print("|\n" + this.ANSI_RESET);
    }
}
