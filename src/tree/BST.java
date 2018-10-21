package tree;

import queue.Queue;

/**
 * @author : guochengsen
 * @date :
 */
public class BST<E extends Comparable<E>> implements Tree<E> {

    private Node root;

    private int size;

    private class Node implements TreeNode {
        E e;
        Node left;
        Node right;
        public Node(E e) {
            this.e = e;
        }

        @Override
        public TreeNode leftChild() {
            return left;
        }

        @Override
        public TreeNode rightChild() {
            return right;
        }

        @Override
        public String toString() {
            return '[' + e.toString() + ']';
        }

    }

    @Override
    public TreeNode root() {
        return root;
    }

    @Override
    public void add(E e) {

    }

    @Override
    public void delete(E e) {

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
        return false;
    }

    @Override
    public E max() {
        return null;
    }

    @Override
    public E min() {
        return null;
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
    public void preorder(Queue queue) {

    }

    @Override
    public void inorder(Queue queue) {

    }

    @Override
    public void postorder(Queue queue) {

    }

    @Override
    public void level(Queue queue) {

    }

    @Override
    public void preorderStack(Queue queue) {

    }

}
