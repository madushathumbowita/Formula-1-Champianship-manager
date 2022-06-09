

abstract public class Driver {

    private String FullName;
    private String Location;
    private String team_name;

    //constructore built for the variables
    public Driver(String fullname, String location, String which_Team_They_Belong_To) {
        FullName = fullname;
        Location = location;
        team_name = which_Team_They_Belong_To;
    }

    public Driver(String fullname) {
        FullName = fullname;
    }

    public Driver() {

    }

    //getters and setters
    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String which_Team_They_Belong_To) {
        team_name = which_Team_They_Belong_To;
    }
}


