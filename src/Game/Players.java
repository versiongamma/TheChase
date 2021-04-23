package Game;

import java.io.*;
import java.util.StringTokenizer;

public class Players {

    private String chaser;
    private String player;
    private int playerCash;
    private int chaserCash;

    /**
     * Constructor for Players
     *
     * @param chaser the name of the chaser
     * @param player the name of the player
     */
    public Players(String chaser, String player) {
        this.chaser = chaser;
        this.player = player;
        this.playerCash = 0;
        this.chaserCash = 0;
    }

    /**
     * Writes the player's name, how much they won/lost and the chaser's final
     * round score the the PlayersData file
     */
    public void write() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./data/players.data", true));
            writer.write(String.format("\n%s*%s*%s", getPlayer(), getPlayerCash(), getChaserCash()));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads out and displays the file containing player stats.
     *
     * @return the string to be printed on console
     */
    public static String read() {
        StringBuilder out = new StringBuilder();
        out.append("\n");
        try {
            FileReader reader = new FileReader("./data/players.data");
            StringBuilder file = new StringBuilder();
            int data;

            while ((data = reader.read()) != -1) {
                file.append((char) data);
            }

            StringTokenizer lines = new StringTokenizer(file.toString().replace("\r", ""), "\n");
            if (lines.countTokens() == 0) {
                out.append("No games have been played!");
            }
            while (lines.hasMoreTokens()) {

                StringTokenizer p = new StringTokenizer(lines.nextToken(), "*");
                String name = p.nextToken();
                int pCash = Integer.parseInt(p.nextToken());
                int cCash = Integer.parseInt(p.nextToken());
                out.append(String.format("%s %s with $%s cash!\n", name, (pCash > cCash) ? "won" : "lost", pCash));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.append("\n");
            return out.toString();
        }
    }

    //GETTERS AND SETTERS
    public String getChaser() {
        return chaser;
    }

    public void setChaser(String chaser) {
        this.chaser = chaser;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getPlayerCash() {
        return playerCash;
    }

    public int getChaserCash() {
        return chaserCash;
    }

    public void setChaserCash(int chaserCash) {
        this.chaserCash = chaserCash;
    }

    public void setPlayerCash(int playerCash) {
        this.playerCash = playerCash;
    }

}
