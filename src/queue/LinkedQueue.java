package queue;

import list.LinkedList;

/**
 * @author : guochengsen@outlook.com
 * @date :
 */
public class LinkedQueue<E> implements Queue<E> {

    private LinkedList<E> queue;

    public LinkedQueue() {
        queue = new LinkedList<>();
    }

    @Override
    public void enqueue(E e) {
        queue.add(e);
    }

    @Override
    public E dequeue() {
        return queue.removeFirst();
    }

    @Override
    public E getFront() {
        return queue.getFirst();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        int s = queue.size();
        StringBuilder sb = new StringBuilder(s);
        sb.append("LinkedQueue = {data = [");
        for (int i = 0; i < s; i++) {
            sb.append(queue.get(i));
            if (i != s - 1)
                sb.append(", ");
        }
        sb.append("], size = ").append(s).append('}');
        return sb.toString();
    }
}
