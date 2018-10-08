package stack;

import list.LinkedList;

/**
 * @author : guochengsen@outlook.com
 * @date :
 */
public class LinkedStack<E> implements Stack<E> {

    private LinkedList<E> stack;

    public LinkedStack() {
        stack = new LinkedList<>();
    }

    @Override
    public void push(E e) {
        stack.add(e);
    }

    @Override
    public E pop() {
        return stack.removeLast();
    }

    @Override
    public E peek() {
        return stack.getLast();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    
    @Override
    public String toString() {
        int s = stack.size();
        StringBuilder sb = new StringBuilder(s);
        sb.append("LinkedStack {data = [");
        for (int i = 0; i < s; i++) {
            sb.append(stack.get(i));
            if (i != s - 1)
                sb.append(", ");
        }
        sb.append("], size = ").append(s).append('}');
        return sb.toString();
    }
    
}
