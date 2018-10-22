package tree;

import queue.Queue;

/**
 * @author : guochengsen
 * @date :
 */
public class BST<E extends Comparable<E>> implements Tree<E> {

    private Node root;

    private int size;

    private class Node implements VisibleNode {
        E e;
        Node left;
        Node right;
        public Node(E e) {
            this.e = e;
        }

        @Override
        public VisibleNode left() {
            return left;
        }

        @Override
        public VisibleNode right() {
            return right;
        }

        @Override
        public String text() {
            return toString();
        }

        @Override
        public String toString() {
            return e.toString();
        }

    }

    @Override
    public VisibleNode root() {
        return root;
    }

    @Override
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 向树中添加节点, 返回添加节点后的树
     * @param node
     * @param e
     * @return node
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);
        return node;
    }

    @Override
    public void delete(E e) {
        // TODO
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
        return contains(root, e);
    }

    /**
     * 检查树中是否包含元素
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {
        if (node == null)
            return false;
        if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else if (e.compareTo(node.e) > 0)
            return contains(node.right, e);
        else
            return true;
    }

    @Override
    public E max() {
        return max(root);
    }

    /**
     * 查找树中最大元素
     * @param node
     * @return
     */
    private E max(Node node) {
        return node.right == null ? node.e : max(node.right);
    }

    @Override
    public E min() {
        return min(root);
    }

    private E min(Node node) {
        return node.left == null ? node.e : min(node.left);
    }

    @Override
    public E floor(E e) {
        return null;
    }

    @Override
    public E ceil(E e) {
        return null;
    }

    @Override
    public E rank(E e) {
        return null;
    }

    @Override
    public E select(int rank) {
        return null;
    }

    @Override
    public void preorder(Queue<E> queue) {
        preorder(root, queue);
    }

    private void preorder(Node node, Queue<E> queue) {
        if (node == null) return;
        queue.enqueue(node.e);
        preorder(node.left, queue);
        preorder(node.right, queue);
    }

    @Override
    public void inorder(Queue<E> queue) {
        inorder(root, queue);
    }

    private void inorder(Node node, Queue<E> queue) {
        if (node == null) return;
        inorder(node.left, queue);
        queue.enqueue(node.e);
        inorder(node.right, queue);
    }

    @Override
    public void postorder(Queue<E> queue) {
        postorder(root, queue);
    }

    private void postorder(Node node, Queue<E> queue) {
        if (node == null) return;
        postorder(node.left, queue);
        postorder(node.right, queue);
        queue.enqueue(node.e);
    }

    @Override
    public void level(Queue queue) {

    }

    @Override
    public void preorderStack(Queue queue) {

    }

}
