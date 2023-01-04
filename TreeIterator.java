import java.lang.Iterable;
import java.util.Iterator;
import java.util.Stack;

public class TreeIterator implements Iterator
{
    private final Stack<Iterator> its;
    private Object next;
    private boolean next_invalid = true;

    public TreeIterator(Iterable it) {
        its = new Stack<Iterator>();
        its.push(it.iterator());
    }

    @Override
    public boolean hasNext() {
        while (next_invalid) {
            if (its.empty())
                return false;
            if (its.peek().hasNext()) {
                next = its.peek().next();
                next_invalid = next instanceof Iterable;
                if (next_invalid)
                    its.push(((Iterable) next).iterator());
            }
            else
                its.pop();
        }
        return true;
    }

    @Override
    public Object next() {
        hasNext();
        next_invalid = true;
        return next;
    }
}
