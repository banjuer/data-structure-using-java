package queue;

/**
 * @author : guochengsen@outlook.com
 * @date :
 *
 * TODO this will implementing by using loop array
 */
public class ArrayQueue<E> implements Queue<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final int EXPANSION_FACTOR = 2;
    private static final double REDUCE_FACTOR = 0.25;

    private int tail; //  next head element index
    private int head; //  current tail element index
    private int size;
    private E[] data;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int capacity) {
        if (capacity < 0)
            throw new RuntimeException("illegal arg capacity: " + capacity);
        data = (E[]) new Object[capacity];
    }

    @Override
    public void enqueue(E e) {
        int next = (tail + 1) % data.length;
        if (next == head) {
            resize(data.length * EXPANSION_FACTOR);
            next = size + 1;
        }
        data[tail] = e;
        tail = next;
        size++;
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[ capacity];
        int next = head;
        int i = 0;
        while (next != tail) {
            newData[i++] = data[next];
            next = (next + 1 ) % data.length;
        }
        head = 0;
        tail = i;
        data = newData;
    }

    @Override
    public E dequeue() {
        if (size <= data.length * REDUCE_FACTOR) {
            resize(data.length / EXPANSION_FACTOR);
        }
        head = (head + 1) % data.length;
        size--;
        return data[head];
    }

    @Override
    public E getFront() {
        return data[head];
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
    public String toString() {
        StringBuilder sb = new StringBuilder(size);
        sb.append("ArrayQueue = {data = [");
        int next = head;
        while (next != tail) {
            sb.append(data[next]);
            next = (next + 1) % data.length;
            if (next != tail)
                sb.append(",");
        }
        sb.append("], size = ").append(size).append(']');
        return sb.toString();
    }

}
