package tree;

import queue.Queue;

/**
 * @author : guochengsen@dongao.com
 * @date :
 */
public class BST<E extends Comparable<E>> implements Tree {

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
    public void add(Comparable comparable) {

    }

    @Override
    public void delete(Comparable comparable) {

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
    public boolean contains(Comparable comparable) {
        return false;
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

    @Override
    public Comparable max() {
        return null;
    }

    @Override
    public Comparable min() {
        return null;
    }

    @Override
    public Comparable floor(Comparable comparable) {
        return null;
    }

    @Override
    public Comparable ceil(Comparable comparable) {
        return null;
    }

    @Override
    public Comparable rank(Comparable comparable) {
        return null;
    }

    @Override
    public Comparable select(int rank) {
        return null;
    }
}
