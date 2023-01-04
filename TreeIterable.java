import java.lang.Iterable;
import java.util.Iterator;

public class TreeIterable implements Iterable
{
    private final Iterable it;

    public TreeIterable(Iterable i) {
        it = i;
    }

    @Override
    public Iterator iterator() {
        return new TreeIterator(it);
    }
}
