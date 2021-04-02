
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @authors
 * Abby - 
 * Julia - 19078503
 * Matt - 19076935
 */
public class TheChase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("__________________________");
        System.out.println("|  Welcome to The Chase! |");
        System.out.println("|________________________|");
        
=======
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
	System.out.println("|            Welcome to              |");
	System.out.println("|               the                  |");
	System.out.println("|              Chase!                |");
	System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n");
        
        Scanner scan = new Scanner(System.in);
        
        int selection;
        
        do{
            System.out.println("Please Choose an Option: \n"
                    + "1. Play The Chase \n"
                    + "2. How to Play \n"
                    + "3. Exit");
            selection = scan.nextInt();
            
            switch (selection) {
                case 1:
                    //game starts
                    break;
                case 2:
                    System.out.println("Game instructions: \n"
                            + "");
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    throw new IndexOutOfBoundsException();
            }
            
        }while(selection == 1);
    }
}
