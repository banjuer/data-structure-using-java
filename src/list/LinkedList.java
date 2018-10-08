package list;

/**
 * @author : guochengsen@outlook.com
 * @date :
 */
public class LinkedList<E> implements List<E> {

    private int size;

    /**
     * using dumyHead to make the operation accordance
     */
    private Node dumyHead;

    private Node dumyTail;

    public LinkedList() {
        this.dumyHead = new Node();
        this.dumyTail = new Node();
        dumyHead.next = dumyTail;
        dumyTail.prev = dumyHead;
    }

    private class Node {

        Node next;

        Node prev;

        E data;

        Node() {

        }

        Node(Node next, Node prev, E data) {
            this.next = next;
            this.prev = prev;
            this.data = data;
        }

        @Override
        public String toString(){
            return data.toString();
        }
    }

    @Override
    public void add(E e) {
        addBefore(dumyTail, e);
    }

    /**
     * add node before the target node
     * @param target node
     * @param e data
     */
    private void addBefore(Node target, E e) {
        Node add = new Node(target, target.prev, e);
        target.prev.next = add;
        target.prev = add;
        size ++;
    }

    @Override
    public void add(int index, E e) {
        Node target = getNode(index);
        addBefore(target, e);
    }

    @Override
    public void addFirst(E e) {
        addBefore(dumyHead.next, e);
    }

    @Override
    public boolean remove(E e) {
        Node cur = dumyHead;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
            if (e == null && cur.data == null) {
                delNode(cur);
                return true;
            } else if (e != null && e.equals(cur.data)) {
                delNode(cur);
                return true;
            }
        }
        return false;
    }

    private void delNode(Node target) {
        target.prev.next = target.next;
        target.next.prev = target.prev;
        target.next = null;
        target.prev = null;
        size --;
    }

    @Override
    public boolean removeAll(E e) {
        Node cur = dumyHead;
        int carry = 0;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
            if (e == null && cur.data == null) {
                delNode(cur);
                carry ++;
            } else if (e != null && e.equals(cur.data)) {
                delNode(cur);
                carry ++;
            }
        }
        return carry == 0;
    }

    @Override
    public E remove(int index) {
        Node target = getNode(index);
        delNode(target);
        return target.data;
    }

    @Override
    public E removeLast() {
        Node last = dumyTail.prev;
        delNode(last);
        return last.data;
    }

    @Override
    public E removeFirst() {
        Node first = dumyHead.next;
        delNode(first);
        return first.data;
    }

    @Override
    public boolean set(int index, E e) {
        Node target = getNode(index);
        if (target == null) {
            return false;
        }
        target.data = e;
        return true;
    }

    /**
     * search node by index
     * @param index
     * @return
     */
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("illegal arg index: " + index);
        }
        int middle = (size - 1) / 2;
        Node carry;
        if (index > middle) {
            carry = dumyTail;
            for (int i = size - 1; i >= index; i--) {
                carry = carry.prev;
            }
        } else {
            carry = dumyHead;
            for (int i = 0; i <= index; i++) {
                carry = carry.next;
            }
        }
        return carry;
    }

    @Override
    public E get(int index) {
        Node carry = getNode(index);
        return carry == null ? null : carry.data;
    }

    @Override
    public E getFirst() {
        return dumyHead.next.data;
    }

    @Override
    public E getLast() {
        return dumyTail.prev.data;
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
        sb.append("LinkedList {data = [");
        Node cur = dumyHead;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
            sb.append(cur.data);
            if (i != size - 1)
                sb.append(", ");
        }
        sb.append("], size = ");
        sb.append(size);
        sb.append('}');
        return sb.toString();
    }

}
