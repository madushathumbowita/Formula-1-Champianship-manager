import java.util.Comparator;


public class PositionCompare implements Comparator<Formula1Driver> {
    
    @Override
    public int compare(Formula1Driver o1, Formula1Driver o2) {


        if (o1.getFirst_pos() == o2.getFirst_pos()) {
           return 0;

        } else if (o1.getFirst_pos() > o2.getFirst_pos()) {
            return -1;
        }
        else {
            return 1;
        }
    }
}

