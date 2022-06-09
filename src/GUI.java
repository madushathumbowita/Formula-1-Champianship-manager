import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import static java.awt.BorderLayout.*;



public class GUI implements ActionListener {

    Formula1ChampionshipManager n = new Formula1ChampionshipManager();
    ArrayList<Formula1Driver> info = n.getdriver_info();
    String date;

    JFrame frame = new JFrame();  //Creating the frame object
    JPanel panel = new JPanel(); //Creating the pannel object

    //Create Button objects
    JButton button1 = new JButton("1. Display");
    JButton button2 = new JButton("2. SortByPoints");
    JButton button3 = new JButton("3. SortBy1st");
    JButton button4 = new JButton("4. Generate");


    //Table rows and column size
    String[][] rows = new String[10][7];
    String[] Column = {"Full_Name", "Team", "Location", "Points", "1stPlaces", "2ndPlaces", "3rdPlaces"};
    JTable Table = new JTable(rows, Column);
    JScrollPane Shell = new JScrollPane(Table); // table shell object created


    public void gui_frame() {

        frame.setTitle("Formula 1");
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(true); //The szie of the window is fixed.
        frame.setLayout(null);
        frame.setBounds(340,90,850,680); //Adujsting the GUI window

        //Creating the Table with the shell
        frame.getContentPane().add(Shell);
        Table.setRowHeight(25);
        Shell.setBounds(40, 160, 750, 270);

        //Adding buttons to the frame
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);

        //Adding a content pane to the frame
        frame.getContentPane().add(panel);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY); //changing the panel color

        //Customizing the panel
        panel.setBounds(50,50,730,55);
        panel.setBackground(Color.LIGHT_GRAY);

        //Adding a text object
        JLabel textin = new JLabel("FORMULA 1 RACING STATUS");
        textin.setFont(new Font("Serif", Font.BOLD, 35)); //Customizing the text
        panel.add(textin);

        //Customizing the 1st button
        button1.setFocusPainted(false); //there is no outline on the text
        button1.setBorder(new LineBorder(Color.WHITE)); //changing the button border color
        button1.setBounds(100, 490, 120, 40);
        button1.addActionListener(this); //listens to the button's action

        //Customizing the 2nd button
        button2.setFocusPainted(false);
        button2.setBorder(new LineBorder(Color.WHITE));
        button2.setBounds(260, 490, 120, 40);
        button2.addActionListener(this); //listens to the button's action

        //Customizing the 3rd button
        button3.setFocusPainted(false);
        button3.setBorder(new LineBorder(Color.WHITE));
        button3.setBounds(420, 490, 120, 40);
        button3.addActionListener(this); //listens to the button's

        //Customizing the 4th button
        button4.setFocusPainted(false);
        button4.setBorder(new LineBorder(Color.WHITE));
        button4.setBounds(580, 490, 120, 40);
        button4.addActionListener(this); //listens to the button.

    }

    // Method to display the table of all the drivers' statistics in decending oder of points
    public void table_info() {

        //Collection sort used to sort in decending order
        Collections.sort(info, Collections.reverseOrder());
        for (int i = 0; i<info.size(); i++ )
        {
            rows[i][0] = info.get(i).getFullName();
            rows[i][1] = info.get(i).getTeam_name();
            rows[i][2] = info.get(i).getLocation();
            rows[i][3] = String.valueOf(info.get(i).getPoints());
            rows[i][4] = String.valueOf(info.get(i).getFirst_pos());
            rows[i][5] = String.valueOf(info.get(i).getSecond_pos());
            rows[i][6] = String.valueOf(info.get(i).getThird_pos());
        } Table.repaint(); //refreshing the table
    }


    //method to sort drivers' statistics in asecending oder of points
    public void sort_points (){

        //comparing points , created an object of PointsCompare class
        PointsCompare pointsCompare = new PointsCompare();
        info.sort(pointsCompare);
        for (int i = 0; i<info.size(); i++ )
        {
            rows[i][0] = info.get(i).getFullName();
            rows[i][1] = info.get(i).getTeam_name();
            rows[i][2] = info.get(i).getLocation();
            rows[i][3] = String.valueOf(info.get(i).getPoints());
            rows[i][4] = String.valueOf(info.get(i).getFirst_pos());
            rows[i][5] = String.valueOf(info.get(i).getSecond_pos());
            rows[i][6] = String.valueOf(info.get(i).getThird_pos());
        } Table.repaint();
    }

    //method to sort drivers' statistics according to the largest number of first positions won in races
    public void sort_pos (){
        // comparing positions , created object of PositionCompare class.
        PositionCompare positionCompare = new PositionCompare();
        info.sort(positionCompare);

        for (int i = 0; i<info.size(); i++ )
        {
            rows[i][0] = info.get(i).getFullName();
            rows[i][1] = info.get(i).getTeam_name();
            rows[i][2] = info.get(i).getLocation();
            rows[i][3] = String.valueOf(info.get(i).getPoints());
            rows[i][4] = String.valueOf(info.get(i).getFirst_pos());
            rows[i][5] = String.valueOf(info.get(i).getSecond_pos());
            rows[i][6] = String.valueOf(info.get(i).getThird_pos());

        } Table.repaint();
    }

    //Adding a completed a race using the Add_Complete_Race method.
    public void add_completed_race() throws ParseException {
        LinkedList<Race> Race_Driver_Details1 = new LinkedList<>(); //creating a linked list for storing the race details.

        String date;
        String race_date = null;

        Random random = new Random();
        int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);

        LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
        System.out.println(randomBirthDate);


        for (int s = 0; s < info.size(); s++) {
            Random rand = new Random();
            int value = rand.nextInt(10)+1;
            int rank = value;
            int score;


            switch (rank) {
                case 1:
                    score = 25;
                    int TotalScore = info.get(s).getPoints() + score;
                    int FinalParticipation = info.get(s).getNum_Of_Races() + 1;
                    int first_pos = info.get(s).getFirst_pos() + 1;
                    info.get(s).setPoints(TotalScore);
                    info.get(s).setNum_Of_Races(FinalParticipation);
                    info.get(s).setFirst_pos(first_pos);
                    break;
                case 2:
                    score = 18;
                    int TotalScore1 = info.get(s).getPoints() + score;
                    int FinalParticipation1 = info.get(s).getNum_Of_Races() + 1;
                    int second_pos = info.get(s).getSecond_pos() + 1;
                    info.get(s).setPoints(TotalScore1);
                    info.get(s).setNum_Of_Races(FinalParticipation1);
                    info.get(s).setSecond_pos(second_pos);
                    break;
                case 3:
                    score = 15;
                    int TotalScore2 = info.get(s).getPoints() + score;
                    int FinalParticipation2 = info.get(s).getNum_Of_Races() + 1;
                    int third_pos = info.get(s).getThird_pos() + 1;
                    info.get(s).setPoints(TotalScore2);
                    info.get(s).setNum_Of_Races(FinalParticipation2);
                    info.get(s).setThird_pos(third_pos);
                    break;
                case 4:
                    score = 12;
                    int TotalScore3 = info.get(s).getPoints() + score;
                    int FinalParticipation3 = info.get(s).getNum_Of_Races() + 1;
                    int forth_pos = info.get(s).getForth_pos() + 1;
                    info.get(s).setPoints(TotalScore3);
                    info.get(s).setNum_Of_Races(FinalParticipation3);
                    info.get(s).setForth_pos(forth_pos);
                    break;
                case 5:
                    score = 10;
                    int TotalScore4 = info.get(s).getPoints() + score;
                    int FinalParticipation4 = info.get(s).getNum_Of_Races() + 1;
                    int fifth_pos = info.get(s).getFifth_pos() + 1;
                    info.get(s).setPoints(TotalScore4);
                    info.get(s).setNum_Of_Races(FinalParticipation4);
                    info.get(s).setFifth_pos(fifth_pos);
                    break;
                case 6:
                    score = 8;
                    int TotalScore5 = info.get(s).getPoints() + score;
                    int FinalParticipation5 = info.get(s).getNum_Of_Races() + 1;
                    int sixth_pos = info.get(s).getSixth_pos() + 1;
                    info.get(s).setPoints(TotalScore5);
                    info.get(s).setNum_Of_Races(FinalParticipation5);
                    info.get(s).setSixth_pos(sixth_pos);
                    break;
                case 7:
                    score = 6;
                    int TotalScore6 = info.get(s).getPoints() + score;
                    int FinalParticipation6 = info.get(s).getNum_Of_Races() + 1;
                    int seventh_pos = info.get(s).getSeventh_pos() + 1;
                    info.get(s).setPoints(TotalScore6);
                    info.get(s).setNum_Of_Races(FinalParticipation6);
                    info.get(s).setSeventh_pos(seventh_pos);
                    break;
                case 8:
                    score = 4;
                    int TotalScore7 = info.get(s).getPoints() + score;
                    int FinalParticipation7 = info.get(s).getNum_Of_Races() + 1;
                    int eighth_pos = info.get(s).getEighth_pos() + 1;
                    info.get(s).setPoints(TotalScore7);
                    info.get(s).setNum_Of_Races(FinalParticipation7);
                    info.get(s).setEighth_pos(eighth_pos);
                    break;
                case 9:
                    score = 2;
                    int TotalScore8 = info.get(s).getPoints() + score;
                    int FinalParticipation8 = info.get(s).getNum_Of_Races() + 1;
                    int ninth_pos = info.get(s).getNinth_pos() + 1;
                    info.get(s).setPoints(TotalScore8);
                    info.get(s).setNum_Of_Races(FinalParticipation8);
                    info.get(s).setNinth_pos(ninth_pos);
                    break;
                case 10:
                    score = 1;
                    int TotalScore9 = info.get(s).getPoints() + score;
                    int FinalParticipation9 = info.get(s).getNum_Of_Races() + 1;
                    int tenth_pos = info.get(s).getTenth_pos() + 1;
                    info.get(s).setPoints(TotalScore9);
                    info.get(s).setNum_Of_Races(FinalParticipation9);
                    info.get(s).setTenth_pos(tenth_pos);
                    break;

            }
            LinkedList<Formula1Driver> FD1 = new LinkedList<>(); //created a linkdlist to store driver details to the race
            String fn = info.get(s).getFullName(); //Getting the fullname to the driver linked list.

            FD1.add(new Formula1Driver(fn, rank)); //Added the first, last and position to the linked list.
            Race_Driver_Details1.add(new Race(race_date, FD1));//Added the date of the race and driver linkedlist to the main race linkedlist
            System.out.println();
            System.out.println("The full name of the driver is "+fn+"\n"+
                    "The position is "+"- "+ rank);

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {  //activating the buttons

        if (e.getSource().equals(button1))
        {
            button1.setBounds(100, 490, 120, 40);
            table_info();
        }
        else if (e.getSource().equals(button2))
        {
            button2.setBounds(260, 490, 120, 40);
            sort_points();
        }
        else if (e.getSource().equals(button3))
        {
            button3.setBounds(420, 490, 120, 40);
            sort_pos();
        }
        else if (e.getSource().equals(button4))
        {
            button4.setBounds(580, 490, 120, 40);
            try {
                add_completed_race();
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }

        }
    }

}

