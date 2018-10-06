package list;

public interface List<E> {

    void add(E e);

    void add(int index, E e);

    void addFirst(E e);

    boolean remove(E e);

    boolean removeAll(E e);

    E remove(int index);

    E removeLast();

    E removeFirst();

    boolean set(int index, E e);

    E get(int index);

    E getFirst();

    E getLast();

    int size();

    boolean isEmpty();

}
