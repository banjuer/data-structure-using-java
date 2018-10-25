package set;

import list.LinkedList;

/**
 * @author : guochengsen
 * @date :
 */
public class LinkedSet<E> implements Set<E> {

    private LinkedList list;

    public LinkedSet() {
        list = new LinkedList();
    }

    @Override
    public void add(E e) {
        if (contains(e))
            return;
        list.add(e);
    }

    @Override
    public void remove(E e) {
        list.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
