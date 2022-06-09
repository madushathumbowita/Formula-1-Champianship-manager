import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Formula1ChampionshipManager implements ChampionshipManager {


    //Arraylist object created.
    private static ArrayList<Formula1Driver> driver_info = new ArrayList<>(); //array-list created for Formula1Driver class

    //getters and setters created
    public ArrayList<Formula1Driver> getdriver_info() {
        return driver_info;
    }

    //getters and setters created
    public void setdriver_details(ArrayList<Formula1Driver> driver_Details) {
        driver_info = driver_Details;
    }

    //Main menu structure created
    public void Menu() {
        System.out.println();
        System.out.println("...............................MENU..........................................\n");
        System.out.println(
                "  >  "+ "Enter 1 to Create new Driver Profile. \n" +
                "  >  "        + "Enter 2 to Delete Driver profile and a Team. \n" +
                "  >  "        + "Enter 3 to Change the Driver for an existing Constructor Team. \n" +
                "  >  "        + "Enter 4 to Display the statistics for the selected Driver. \n" +
                "  >  "        + "Enter 5 to Display Formula 1 Driver Table. \n" +
                "  >  "        + "Enter 6 to Add a Completed Race. \n" +
                "  >  "        + "Enter 7 to Save.  \n" +
                "  >  "        + "Enter 8 to open the GUI. \n" +
                "  >  "        + "Enter 9 to Exit. \n"
        );
        System.out.println("..............................................................................");
        System.out.println();
    }



    //method to add driver
    public void add_driver() {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Driver's Fullname:");
        String driver_full_name = input.nextLine();
        System.out.println("Enter the Location of the Race:");
        String location = input.nextLine();
        System.out.println("Enter the Team name:");
        String team = input.nextLine();

        driver_info.add(new Formula1Driver(driver_full_name, location, team)); //adding driver details for the driver details arraylist.
        System.out.println();
        System.out.println("DRIVER ADDED ");
    }


    //method to delete driver
    public void delete_driver() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Driver's Fullname:");
        String delete_fullname = input.nextLine();

        if (check_input_name(delete_fullname)) {
            for (int i = 0; i < driver_info.size(); i++) {
                if (driver_info.get(i).getFullName().equalsIgnoreCase(delete_fullname)) {
                    driver_info.remove(i);
                }
                driver_info.remove(input);
            }
            System.out.println("DRIVER DELETED");
        } else {
            System.out.println("NO DRIVER FOUND");
        }
    }


    // Check whether the input drivers name exist or not
    public boolean check_input_name(String name) {
        boolean n = false;
        for (int i = 0; i < driver_info.size(); i++) {
            if (driver_info.get(i).getFullName().equalsIgnoreCase(name)) {
                n = true;
                break;
            }
        }
        return n;
    }

    ////method to change a team of a driver
    public void change_driver() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Driver's fullname:");
        String DriverF = input.nextLine();
        System.out.println("Enter the new Team name:");
        String New_Team = input.nextLine();


        if (check_input_name(DriverF)) {
            for (int i = 0; i < driver_info.size(); i++) {
                if (driver_info.get(i).getFullName().equalsIgnoreCase(DriverF)) {
                    driver_info.get(i).setTeam_name(New_Team);
                    System.out.println("DRIVER ADDED TO THE TEAM");
                }
            }
        } else {
            System.out.println("NO DRIVER FOUND"); //output when not existing driver name entered.
        }
    }


    ////method to display driver statistics
    public void driver_stats() {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter driver's fullname:");
        String StatF = input.nextLine();

        if (check_input_name(StatF)) {

            //searching for the driver's first and last name and displaying his individual stats. This is done per driver.
            for (int z = 0; z < driver_info.size(); z++) {
                if (driver_info.get(z).getFullName().equalsIgnoreCase(StatF)) {
                    System.out.println("Driver's fullname: " + driver_info.get(z).getFullName());
                    System.out.println("Location of the race: " + driver_info.get(z).getLocation());
                    System.out.println("Team: " + driver_info.get(z).getTeam_name());

                    System.out.println("First Position: " + driver_info.get(z).getFirst_pos());
                    System.out.println("Second Position: " + driver_info.get(z).getSecond_pos());
                    System.out.println("Third Position: " + driver_info.get(z).getThird_pos());
                    System.out.println("Forth Position: " + driver_info.get(z).getForth_pos());
                    System.out.println("Fifth Position: " + driver_info.get(z).getFifth_pos());
                    System.out.println("Sixth Position: " + driver_info.get(z).getSixth_pos());
                    System.out.println("Seventh Position: " + driver_info.get(z).getSeventh_pos());
                    System.out.println("Eighth Position: " + driver_info.get(z).getEighth_pos());
                    System.out.println("Ninth Position: " + driver_info.get(z).getNinth_pos());
                    System.out.println("Tenth Position: " + driver_info.get(z).getTenth_pos());

                    System.out.println("Points: " + driver_info.get(z).getPoints());
                    System.out.println("The number of Races: " + driver_info.get(z).getNum_Of_Races());
                }
            }
        } else {
            System.out.println("NO STATUS FOUND");
        }
    }


    ////method to display all the drivers' details in a table
    public void driver_table() {
        Collections.sort(driver_info, Collections.reverseOrder());  //colletion sort used to display details in descending order.

        System.out.format("|%1$-20s|%2$-6s|%3$-10s|%4$-10s|%5$-10s|%6$-10s|%7$-10s|%8$-10s|%9$-10s|%10$-10s|%11$-13s|%12$-10s|%13$-15s|%14$-13s|\n",
                "FULLNAME", "POINTS", "1STPLACES", "2NDPLACES", "3RDPLACES", "4THPLACES", "5THPLACES", "6THPLACES", "7THPLACES"
                , "8THPLACES", "9THPLACES", "10THPLACES", "R_LOCATION", "TEAM");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (int y = 0; y < driver_info.size(); y++) {

            System.out.format("|%1$-20s|%2$-6s|%3$-10s|%4$-10s|%5$-10s|%6$-10s|%7$-10s|%8$-10s|%9$-10s|%10$-10s|%11$-13s|%12$-10s|%13$-15s|%14$-13s|\n", driver_info.get(y).getFullName(),
                    driver_info.get(y).getPoints(), driver_info.get(y).getFirst_pos(), driver_info.get(y).getSecond_pos(),
                    driver_info.get(y).getThird_pos(), driver_info.get(y).getForth_pos(), driver_info.get(y).getFifth_pos(),
                    driver_info.get(y).getSixth_pos(), driver_info.get(y).getSeventh_pos(), driver_info.get(y).getEighth_pos(),
                    driver_info.get(y).getNinth_pos(), driver_info.get(y).getTenth_pos(),
                    driver_info.get(y).getLocation(), driver_info.get(y).getTeam_name()
            );
        }
    }


    //method to add completed race
    public void add_completed_race() throws ParseException {
        LinkedList<Race> Race_Driver_Details1 = new LinkedList<>(); //creating a linked list for storing the race details.
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the Date of the Race (DD-MM-YYYY): ");
        String date = input.nextLine();

        Date race_date; // initialized the date variable
        race_date = new SimpleDateFormat("DD-MM-YYYY").parse(date); //convertion of string date to Date date

        //for-loop is used to get the position of a specific driver to calculate statistics and upgrade them to the arraylist.
        for (int s = 0; s < driver_info.size(); s++) {
            System.out.println("Enter Driver's Full name  " + driver_info.get(s).getFullName());
            Scanner inputa = new Scanner(System.in);
            System.out.println("Enter the Position driver got: ");
            int rank = inputa.nextInt();

            int score;
            // swich case to add drivers' positions to calucate points and other statistics
            switch (rank) {
                case 1:
                    score = 25;
                    int TotalScore = driver_info.get(s).getPoints() + score;
                    int FinalParticipation = driver_info.get(s).getNum_Of_Races() + 1;
                    int first_pos = driver_info.get(s).getFirst_pos() + 1;
                    driver_info.get(s).setPoints(TotalScore);
                    driver_info.get(s).setNum_Of_Races(FinalParticipation);
                    driver_info.get(s).setFirst_pos(first_pos);
                    break;
                case 2:
                    score = 18;
                    int TotalScore1 = driver_info.get(s).getPoints() + score;
                    int FinalParticipation1 = driver_info.get(s).getNum_Of_Races() + 1;
                    int second_pos = driver_info.get(s).getSecond_pos() + 1;
                    driver_info.get(s).setPoints(TotalScore1);
                    driver_info.get(s).setNum_Of_Races(FinalParticipation1);
                    driver_info.get(s).setSecond_pos(second_pos);
                    break;
                case 3:
                    score = 15;
                    int TotalScore2 = driver_info.get(s).getPoints() + score;
                    int FinalParticipation2 = driver_info.get(s).getNum_Of_Races() + 1;
                    int third_pos = driver_info.get(s).getThird_pos() + 1;
                    driver_info.get(s).setPoints(TotalScore2);
                    driver_info.get(s).setNum_Of_Races(FinalParticipation2);
                    driver_info.get(s).setThird_pos(third_pos);
                    break;
                case 4:
                    score = 12;
                    int TotalScore3 = driver_info.get(s).getPoints() + score;
                    int FinalParticipation3 = driver_info.get(s).getNum_Of_Races() + 1;
                    int forth_pos = driver_info.get(s).getForth_pos() + 1;
                    driver_info.get(s).setPoints(TotalScore3);
                    driver_info.get(s).setNum_Of_Races(FinalParticipation3);
                    driver_info.get(s).setForth_pos(forth_pos);
                    break;
                case 5:
                    score = 10;
                    int TotalScore4 = driver_info.get(s).getPoints() + score;
                    int FinalParticipation4 = driver_info.get(s).getNum_Of_Races() + 1;
                    int fifth_pos = driver_info.get(s).getFifth_pos() + 1;
                    driver_info.get(s).setPoints(TotalScore4);
                    driver_info.get(s).setNum_Of_Races(FinalParticipation4);
                    driver_info.get(s).setFifth_pos(fifth_pos);
                    break;
                case 6:
                    score = 8;
                    int TotalScore5 = driver_info.get(s).getPoints() + score;
                    int FinalParticipation5 = driver_info.get(s).getNum_Of_Races() + 1;
                    int sixth_pos = driver_info.get(s).getSixth_pos() + 1;
                    driver_info.get(s).setPoints(TotalScore5);
                    driver_info.get(s).setNum_Of_Races(FinalParticipation5);
                    driver_info.get(s).setSixth_pos(sixth_pos);
                    break;
                case 7:
                    score = 6;
                    int TotalScore6 = driver_info.get(s).getPoints() + score;
                    int FinalParticipation6 = driver_info.get(s).getNum_Of_Races() + 1;
                    int seventh_pos = driver_info.get(s).getSeventh_pos() + 1;
                    driver_info.get(s).setPoints(TotalScore6);
                    driver_info.get(s).setNum_Of_Races(FinalParticipation6);
                    driver_info.get(s).setSeventh_pos(seventh_pos);
                    break;
                case 8:
                    score = 4;
                    int TotalScore7 = driver_info.get(s).getPoints() + score;
                    int FinalParticipation7 = driver_info.get(s).getNum_Of_Races() + 1;
                    int eighth_pos = driver_info.get(s).getEighth_pos() + 1;
                    driver_info.get(s).setPoints(TotalScore7);
                    driver_info.get(s).setNum_Of_Races(FinalParticipation7);
                    driver_info.get(s).setEighth_pos(eighth_pos);
                    break;
                case 9:
                    score = 2;
                    int TotalScore8 = driver_info.get(s).getPoints() + score;
                    int FinalParticipation8 = driver_info.get(s).getNum_Of_Races() + 1;
                    int ninth_pos = driver_info.get(s).getNinth_pos() + 1;
                    driver_info.get(s).setPoints(TotalScore8);
                    driver_info.get(s).setNum_Of_Races(FinalParticipation8);
                    driver_info.get(s).setNinth_pos(ninth_pos);
                    break;
                case 10:
                    score = 1;
                    int TotalScore9 = driver_info.get(s).getPoints() + score;
                    int FinalParticipation9 = driver_info.get(s).getNum_Of_Races() + 1;
                    int tenth_pos = driver_info.get(s).getTenth_pos() + 1;
                    driver_info.get(s).setPoints(TotalScore9);
                    driver_info.get(s).setNum_Of_Races(FinalParticipation9);
                    driver_info.get(s).setTenth_pos(tenth_pos);
                    break;
            }
            LinkedList<Formula1Driver> FD1 = new LinkedList<>(); //Creating a linked list for driver details to be stored in race.
            String fn = driver_info.get(s).getFullName(); //Getting the first name to the driver linked list.

            FD1.add(new Formula1Driver(fn, rank)); //Adding the first, last and rank to the linked list.
            Race_Driver_Details1.add(new Race(race_date, FD1)); //Adding the date of the race and driver linked list to the main race linked list
        }
    }


    // store date into a file
    public void store_details(ArrayList<Formula1Driver> Get) throws IOException {
        FileWriter file = new FileWriter("details.txt");
        for (int c = 0; c < Get.size(); c++) { // for-loop is used.
            // first name, last name, credit card number and guests will be stored.
            file.write(Get.get(c).getFullName() + "\n");
            file.write(Get.get(c).getLocation() + "\n");
            file.write(Get.get(c).getTeam_name() + "\n");
            file.write(Get.get(c).getFirst_pos() + "\n");
            file.write(Get.get(c).getSecond_pos() + "\n");
            file.write(Get.get(c).getThird_pos() + "\n");
            file.write(Get.get(c).getForth_pos() + "\n");
            file.write(Get.get(c).getFifth_pos() + "\n");
            file.write(Get.get(c).getSixth_pos() + "\n");
            file.write(Get.get(c).getSeventh_pos() + "\n");
            file.write(Get.get(c).getEighth_pos() + "\n");
            file.write(Get.get(c).getNinth_pos() + "\n");
            file.write(Get.get(c).getTenth_pos() + "\n");
            file.write(Get.get(c).getPoints() + "\n");
            file.write(Get.get(c).getNum_Of_Races() + "\n");
        }
        System.out.println("DETAILS STORED"); //message displayed to know if it's done or not.
        file.close(); // close file.
    }


    // Loading stored data in the file
    public void load_details() throws FileNotFoundException {

        File file = new File("details.txt");
        Scanner input = new Scanner(file); //file is assigned to input.
        int index = 0;
        while (input.hasNextLine()) {
            driver_info.add(new Formula1Driver());
            driver_info.get(index).setFullName(input.nextLine());
            driver_info.get(index).setLocation(input.nextLine());
            driver_info.get(index).setTeam_name(input.nextLine());
            driver_info.get(index).setFirst_pos(Integer.parseInt(input.nextLine()));
            driver_info.get(index).setSecond_pos(Integer.parseInt(input.nextLine()));
            driver_info.get(index).setThird_pos(Integer.parseInt(input.nextLine()));
            driver_info.get(index).setForth_pos(Integer.parseInt(input.nextLine()));
            driver_info.get(index).setFifth_pos(Integer.parseInt(input.nextLine()));
            driver_info.get(index).setSixth_pos(Integer.parseInt(input.nextLine()));
            driver_info.get(index).setSeventh_pos(Integer.parseInt(input.nextLine()));
            driver_info.get(index).setEighth_pos(Integer.parseInt(input.nextLine()));
            driver_info.get(index).setNinth_pos(Integer.parseInt(input.nextLine()));
            driver_info.get(index).setTenth_pos(Integer.parseInt(input.nextLine()));
            driver_info.get(index).setPoints(Integer.parseInt(input.nextLine()));
            driver_info.get(index).setNum_Of_Races(Integer.parseInt(input.nextLine()));
            index++;
        }
    }
}



