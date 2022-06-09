import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException;
public interface ChampionshipManager {

    void add_driver();
    void delete_driver();
    public boolean check_input_name(String name);
    void change_driver();
    void driver_stats();
    void driver_table();
    void add_completed_race() throws Exception;

    void store_details(ArrayList<Formula1Driver> Get) throws IOException;
    void load_details() throws Exception;

}


