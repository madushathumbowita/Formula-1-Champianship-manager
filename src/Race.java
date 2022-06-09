import java.util.Date;
import java.util.LinkedList;
public class Race {


    Date race_date;
    LinkedList<Formula1Driver> Race_Driver_Details;


    //constructor for the race.
    public Race(Date race_date, LinkedList<Formula1Driver> race_Driver_Details) {
        this.race_date = race_date;
        Race_Driver_Details = race_Driver_Details;
    }

    public Race(String race_date, LinkedList<Formula1Driver> fd1) {
    }

    //getters and setters
    public Date getRace_date() {
        return race_date;
    }

    //getter and setters
    public void setRace_date(Date race_date) {
        this.race_date = race_date;
    }

    //getters and setters
    public LinkedList<Formula1Driver> getRace_Driver_Details() {
        return Race_Driver_Details;
    }

    //getters and setters
    public void setRace_Driver_Details(LinkedList<Formula1Driver> race_Driver_Details) {
        Race_Driver_Details = race_Driver_Details;
    }
}