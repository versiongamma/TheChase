package Questions;

import netscape.javascript.JSObject;

import java.io.FileReader;
import java.util.Random;
import java.util.StringTokenizer;

/** Object for a single multi choice question, containing its list of answers
 */
public class MultiChoiceQuestion implements Question {
    private String question, answer;
    private String[] answers;
    private int id;

    public boolean checkAnswer(String answer) {
        return false;
    }

    /** Constructor which generates a random question from the available list of questions
     */
    public MultiChoiceQuestion() {
        try {
            FileReader reader = new FileReader("./data/multi-choice-questions.csv");
            StringBuilder file = new StringBuilder(); // StringBuilder performs faster than += to a string
            int data;

            // Get and iterate over each line of multi-choice-questions.csv
            while ((data = reader.read()) != -1) { file.append((char)data); }
            StringTokenizer line = new StringTokenizer(file.toString(), "\n");
            id = new Random().nextInt(line.countTokens() - 2);
            while (line.hasMoreTokens()) {

                // Get each value on the current line
                StringTokenizer dbQuestion = new StringTokenizer(line.nextToken(), ",");

                // Update the object's values if the id value on the current line matches the object's id
                if (dbQuestion.nextToken().contains(Integer.toString(id))) {
                    question = dbQuestion.nextToken();
                    answers = new String[]{dbQuestion.nextToken(), dbQuestion.nextToken(), dbQuestion.nextToken()};
                    answer = answers[Integer.parseInt(dbQuestion.nextToken().replace("\r", ""))];
                    // Final token will contain a return carriage character that needs to be stripped to parse it as an int
                }
            }
        } catch (Exception e) {e.printStackTrace();}
    }

    @Override
    public String toString() {
        return String.format("%s\n\t1. %s\n\t2. %s\n\t3. %s", question, answers[0], answers[1], answers[2]);
    }

}
