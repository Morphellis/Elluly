import java.util.Comparator;
public class NameComparator implements Comparator <AbstractTask>{
    public int compare(AbstractTask o1, AbstractTask o2) {
        return o1.getTitle().compareToIgnoreCase(o2.getTitle());
    }
}
