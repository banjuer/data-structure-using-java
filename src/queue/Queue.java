package queue;

/**
 * @author : guochengsen@outlook.com
 * @date :
 */
public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E getFront();

    int size();

    boolean isEmpty();

}
