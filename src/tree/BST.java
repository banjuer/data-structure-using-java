package tree;

import queue.LinkedQueue;
import queue.Queue;

/**
 * @author : guochengsen
 * @date :
 */
public class BST<E extends Comparable<E>> implements Tree<E> {

    private Node root;

    private class Node implements VisibleNode {
        E e;
        Node left;
        Node right;

        /**
         * 通过节点数N来快速实现rank, select:
         * 1. 去掉size属性, size获取通过私有size(Node node)
         * 2. 添加元素时, 更新探测的节点 N = size(node.right) + size(node.left)
         */
        int N;
        public Node(E e) {
            this.N = 1;
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
            return e.toString() + ":" + N;
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
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);
        return resize(node);
    }

    @Override
    public void delete(E e) {
        root = delete(root, e);
    }

    private Node resize(Node node) {
        if (node == null) return null;
        node.N = size(node.right) + size(node.left) + 1;
        return node;
    }

    /**
     * 删除树中节点返回删除后的树
     * @param node
     * @param e
     * @return
     */
    public Node delete(Node node, E e) {
        if (node == null) return null;
        if (e.compareTo(node.e) < 0) {
            node.left = delete(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = delete(node.right, e);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node tmp = node;
            node = max(node.left);
            node.left = deleteMax(tmp.left);
            node.right = tmp.right;
        }
        return resize(node);
    }

    /**
     * 删除树中最大元素, 返回删除后的树
     * @param node
     */
    private  Node deleteMax(Node node) {
        if (node == null)
            return null;
        else if (node.right == null)
            return node.left;
        else {
            node.right = deleteMax(node.right);
            return resize(node);
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.N;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
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
        if (isEmpty())
            throw new IllegalArgumentException("bst is empty");
        return max(root).e;
    }

    /**
     * 查找树中关键字最大节点
     * @param node
     * @return
     */
    private Node max(Node node) {
        return node.right == null ? node : max(node.right);
    }

    @Override
    public E min() {
        if (isEmpty())
            throw new IllegalArgumentException("bst is empty");
        return min(root).e;
    }

    private Node min(Node node) {
        return node.left == null ? node : min(node.left);
    }

    @Override
    public E floor(E e) {
        E min = min();
        if (e.compareTo(min) < 0)
            return null;
        return floor(root, e).e;
    }

    /**
     * 查找树中e元素前驱返回树
     * @param node
     * @param e
     * @return
     */
    private Node floor(Node node, E e) {
        if (node == null)
            return null;
        else if (e.compareTo(node.e) == 0)
            return node;
        else if (e.compareTo(node.e) < 0) {
            return floor(node.left, e);
        } else {
            Node carry = floor(node.right, e);
            return carry == null ? node : carry;
        }
    }

    @Override
    public E ceil(E e) {
        if (e.compareTo(max()) > 0)
            return null;
        return ceil(root, e).e;
    }

    /**
     * 树中查找e元素后继
     * @param node
     * @param e
     * @return
     */
    private Node ceil(Node node, E e) {
        if (node == null)
            return null;
        else if (e.compareTo(node.e) == 0)
            return node;
        else if (e.compareTo(node.e) > 0)
            return ceil(node.right, e);
        else {
            Node carry = ceil(node.left, e);
            return carry == null ? node : carry;
        }
    }

    @Override
    public int rank(E e) {
        // TODO
        return rank(root, e);
    }

    private int rank(Node node, E e) {
        if (node == null)
            return 0;
        int carry = e.compareTo(node.e);
        if (carry < 0)
           return rank(node.left, e);
        else if (carry > 0)
            return size(node) + rank(node.right, e);
        else
            return size(node.left);
    }

    @Override
    public E select(int rank) {
        // TODO
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
    public void levelorder(Queue<E> queue) {
        Queue<Node> level = new LinkedQueue<>();
        Node cur;
        level.enqueue(root);
        while (!level.isEmpty()) {
            cur = level.dequeue();
            queue.enqueue(cur.e);
            if (cur.left != null)
                level.enqueue(cur.left);
            if (cur.right != null)
                level.enqueue(cur.right);
        }
    }

}
