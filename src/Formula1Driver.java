
public class Formula1Driver extends Driver implements Comparable <Formula1Driver>{

    private int Num_Of_Races; // Number of races held
    private int Points; // Number of points
    private int first_pos;// Number of 1st places
    private int second_pos;// Number of 2nd places
    private int third_pos;// Number of 3rd places
    private int forth_pos;// Number of 4th places
    private int fifth_pos;// Number of 5th places
    private int sixth_pos;// Number of 6th places
    private int seventh_pos; // Number of 7th places
    private int eighth_pos; // Number of 8th places
    private int ninth_pos; // Number of 9th places
    private int tenth_pos; // Number of 10th places
    private int race_pos; //Total number of race positions



    // Main constructor to get the driver' details
    public Formula1Driver(String fullname,
                          String location,
                          String which_Team_They_Belong_To) {
        super(fullname, location, which_Team_They_Belong_To) ;

    }

    //Another constructor created for the race class to race details.
    public Formula1Driver(String fullname, int race_Position) {
        super(fullname);
        race_pos = race_Position;
    }

    public Formula1Driver() {
        super();
    }

    //getter and setters
    public int getNum_Of_Races() {
        return Num_Of_Races;
    }

    //getter and setters
    public void setNum_Of_Races(int num_Of_Races) {
        Num_Of_Races = num_Of_Races;
    }

    //getter and setters
    public int getPoints() {
        return Points;
    }

    //getter and setters
    public void setPoints(int points) {
        Points = points;
    }

    //getter and setters
    public int getFirst_pos() {
        return first_pos;
    }

    //getter and setters
    public void setFirst_pos(int first_Positions) {
        first_pos = first_Positions;
    }

    //getter and setters
    public int getSecond_pos() {
        return second_pos;
    }

    //getter and setters
    public void setSecond_pos(int second_Positions) {
        second_pos= second_Positions;
    }

    //getter and setters
    public int getThird_pos() {
        return third_pos;
    }

    //getter and setters
    public void setThird_pos(int third_Positions) {
        third_pos = third_Positions;
    }

    //getter and setters
    public int getForth_pos() {
        return forth_pos;
    }

    //getter and setters
    public void setForth_pos(int forth_pos) {
        this.forth_pos = forth_pos;
    }

    //getter and setters
    public int getFifth_pos() {
        return fifth_pos;
    }

    //getter and setters
    public void setFifth_pos(int fifth_pos) {
        this.fifth_pos = fifth_pos;
    }

    //getter and setters
    public int getSixth_pos() {
        return sixth_pos;
    }

    //getter and setters
    public void setSixth_pos(int sixth_pos) {
        this.sixth_pos = sixth_pos;
    }

    //getter and setters
    public int getSeventh_pos() {
        return seventh_pos;
    }

    //getter and setters
    public void setSeventh_pos(int seventh_pos) {
        this.seventh_pos = seventh_pos;
    }

    //getter and setters
    public int getEighth_pos() {
        return eighth_pos;
    }

    //getter and setters
    public void setEighth_pos(int eighth_pos) {
        this.eighth_pos = eighth_pos;
    }

    //getter and setters
    public int getNinth_pos() {
        return ninth_pos;
    }

    //getter and setters
    public void setNinth_pos(int ninth_pos) {
        this.ninth_pos = ninth_pos;
    }

    //getter and setters
    public int getTenth_pos() {
        return tenth_pos;
    }

    //getter and setters
    public void setTenth_pos(int tenth_pos) {
        this.tenth_pos = tenth_pos;
    }


    //method to sort the driver list in descending according to the points.
    @Override
    public int compareTo(Formula1Driver f) {
        int value = this.getPoints()-f.getPoints();
        if (value==0)
        {
            return this.first_pos-f.first_pos;
        }return value;
    }
}
