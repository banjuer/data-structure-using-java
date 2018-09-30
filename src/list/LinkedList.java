package list;

import javax.xml.soap.Node;

/**
 * @author : guochengsen@outlook.com
 * @date :
 * @deprecated : Bidirectional loops
 */
public class LinkedList<E> implements List<E> {

    private int size;

    /**
     * using dumyHead to make the operation accordance
     */
    private Node dumyHead = new Node();

    private class Node<E> {

        Node next;

        Node prev;

        E data;

        public Node(Node prev, Node next, E data) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }

        public Node() {

        }

    }

    @Override
    public void add(E e) {

    }

    @Override
    public void add(int index, E e) {

    }

    @Override
    public void addFirst(E e) {

    }

    @Override
    public boolean remove(E e) {
        return false;
    }

    @Override
    public boolean removeAll(E e) {
        return false;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public boolean set(int index, E e) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
