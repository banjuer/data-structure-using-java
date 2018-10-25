package list;

import java.util.Arrays;

/**
 * @author : banjuer@outlook.com
 * @date :
 */
public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_SIZE = 10;

    private static final double SHRINK_FACTOR = 0.25;

    private E[] data;
    private int size;

    public ArrayList() {
        this(DEFAULT_SIZE);
    }

    public ArrayList(int capacity) {
        if (capacity < 0)
            throw new RuntimeException("illegal arg of capacity: " + capacity);
        data = (E[]) new Object[capacity];
    }

    @Override
    public void add(E e) {
        add(size, e);
    }

    @Override
    public void add(int index, E e) {
        check(index);
        if (size + 1 > data.length)
            resize(data.length << 1);
        for (int i = size - 1; i >= index ; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public void addFirst(E e) {
        add(0, e);
    }

    @Override
    public boolean remove(E e) {
        for (int i = 0; i < size; i++) {
            if (e == null && data[i] == null) {
                remove(i);
                return true;
            } else if (e != null && e.equals(data[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(E e) {
        int carry = 0;
        for (int i = 0; i < size; i++) {
            if (e == null && data[i] == null) {
                remove(i);
                carry++;
            } else if (e != null && e.equals(data[i])) {
                remove(i);
                carry++;
            }
        }
        return carry == 0;
    }

    @Override
    public E remove(int index) {
        check(index);
        E ret = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;

        /*
         * To avoid the complexity of the concussion
         */
        if (size <= data.length * SHRINK_FACTOR)
            resize(data.length >> 1);
        return ret;
    }

    @Override
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public boolean set(int index, E e) {
        check(index);
        data[index] = e;
        return false;
    }

    @Override
    public E get(int index) {
        check(index);
        return data[index];
    }

    private void check(int index) {
        if (index < 0 || index > size)
            throw new RuntimeException("illegal arg of index: " + index);
    }

    @Override
    public E getFirst() {
        return get(0);
    }

    @Override
    public E getLast() {
        return get(size - 1);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E e) {
        if (size == 0)
            throw new IllegalArgumentException("list is empty");
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i]))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "data=" + Arrays.toString(Arrays.copyOf(data, size)) +
                ", size=" + size +
                '}';
    }
}
