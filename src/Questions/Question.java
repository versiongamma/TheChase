package Questions;

import java.io.FileReader;
import java.util.StringTokenizer;

public abstract class Question {

    /** Check if the answer is correct
     * @param playerAnswer The guess of the user
     * @return Boolean statement representing if the answer was correct or not
     */
    public abstract boolean checkAnswer(String playerAnswer);

    /** Gets the data from a given file
     * @param path The path of the file to get the data from
     * @return StringTokenizer of each line in the file
     */
    protected StringTokenizer getLines(String path) {
        try {
            FileReader reader = new FileReader(path);
            StringBuilder file = new StringBuilder(); // StringBuilder performs faster than += to a string
            int data;

            // Get and iterate over each line of file
            while ((data = reader.read()) != -1) {
                file.append((char) data);
            }

            return new StringTokenizer(file.toString(), "\n");
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    public abstract boolean equals(Question other);
}
