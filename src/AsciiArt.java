
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
        System.out.println("____________________________");
        System.out.println("|                          |");
        System.out.println("|__________________________|");
        System.out.println(" |       $" + this.highOffer + "       |");
        System.out.println(" |________________________|");
        System.out.println("  |      $" + this.round1Cash + "      |");
        System.out.println("  |______________________|");
        System.out.println("   |      $" + this.lowOffer + "     |");
        System.out.println("   |____________________|");
        System.out.println("    |                  |");
        System.out.println("    |__________________|");
        System.out.println("     |                |");
        System.out.println("     |________________|");
        System.out.println("      |              |");
        System.out.println("      |______________|");
        System.out.println("       |            |");
        System.out.println("       |____________|");

    }

}
