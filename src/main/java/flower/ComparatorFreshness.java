package flower;

import java.util.Comparator;

public class ComparatorFreshness implements Comparator<Flower> {

    public int compare(Flower o1, Flower o2) {
        if (o1.getFreshnessOrdinal()>o2.getFreshnessOrdinal()) return 1;
        else if (o1.getFreshnessOrdinal()<o2.getFreshnessOrdinal()) return -1;
        else return 0;
    }
    
}
