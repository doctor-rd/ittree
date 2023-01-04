import java.lang.Iterable;
import java.util.Iterator;
import java.util.Stack;

public class TreeIterator implements Iterator
{
    private final Stack<Iterator> its;

    public TreeIterator(Iterable it) {
        its = new Stack<Iterator>();
        its.push(it.iterator());
    }

    @Override
    public boolean hasNext() {
        for (Iterator it : its)
            if (it.hasNext())
                return true;
        return false;
    }

    @Override
    public Object next() {
        while (!its.peek().hasNext())
            its.pop();
        Object res;
        while ((res = its.peek().next()) instanceof Iterable)
            its.push(((Iterable) res).iterator());
        return res;
    }
}
