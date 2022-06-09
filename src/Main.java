
/** Madusha Thumbowita
 * w1790818
 * 20191207
 */


import org.w3c.dom.ls.LSOutput;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {

    static Formula1ChampionshipManager v = new Formula1ChampionshipManager();

    public static void main(String[] args) {
        //Created an object for GUI class
        GUI window = new GUI ();
        boolean T = true;


        try (Scanner input = new Scanner(System.in)) {
            v.load_details(); //load the stored details
            while (T) {
                v.Menu();

                System.out.println("Enter a Number : ");
                String L = input.nextLine();
                //System.out.println("...............................................................................");
                System.out.println();

                switch (L) {
                    case "1":
                        v.add_driver();
                        break;
                    case "2":
                        v.delete_driver();
                        break;
                    case "3":
                        v.change_driver();
                        break;
                    case "4":
                        v.driver_stats();
                        break;
                    case "5":
                        v.driver_table();
                        break;
                    case "6":
                        v.add_completed_race();
                        break;
                    case "7":
                        v.store_details(v.getdriver_info());
                        break;
                    case "8":
                        window.gui_frame();
                        break;
                    case "9": //Program will stop when user puts 9
                        T = false;
                        break;

                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
