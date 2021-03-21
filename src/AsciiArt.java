
public class AsciiArt {

    int highOffer;
    int lowOffer;
    int round1Cash;

    AsciiArt(int h, int l, int r) {
        this.highOffer = h;
        this.lowOffer = l;
        this.round1Cash = r;
    }

    public void questionBoard() {
        System.out.println("_______________________________");
        System.out.println("|                             |");
        System.out.println("|_____________________________|");
        System.out.println(" | $" + this.highOffer + "   |");
        System.out.println(" |___________________________|");
        System.out.println("  |$" + this.round1Cash + " |");
        System.out.println("  |_________________________|");
        System.out.println("   |$" + this.lowOffer + " |");
        System.out.println("   |_______________________|");
        System.out.println("    |                     |");
        System.out.println("    |_____________________|");
        System.out.println("     |                   |");
        System.out.println("     |___________________|");
        System.out.println("      |                 |");
        System.out.println("      |_________________|");
        System.out.println("       |               |");
        System.out.println("       |_______________|");

    }

}
