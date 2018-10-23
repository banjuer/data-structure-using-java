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
        root = delete(root, e);
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
            // TODO
            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.left == null && node.right != null) {
                node = node.right;
            } else if (node.left != null && node.right == null) {
                node = node.left;
            } else {
                Node cur = new Node(max(node.left).e);
                deleteMax(node.left);
                cur.left = node.left;
                cur.right = node.right;
                node = cur;
            }
            size--;
        }
        return node;
    }

    /**
     * 删除树中最大元素, 此处不维护size值, 由调用方维护
     * @param node
     */
    private void deleteMax(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        node = null;
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
        return max(root).e;
    }

    /**
     * 查找树中最大元素
     * @param node
     * @return
     */
    private Node max(Node node) {
        return node.right == null ? node : max(node.right);
    }

    @Override
    public E min() {
        return min(root).e;
    }

    private Node min(Node node) {
        return node.left == null ? node : min(node.left);
    }

    @Override
    public E floor(E e) {
        // TODO
        return null;
    }

    @Override
    public E ceil(E e) {
        // TODO
        return null;
    }

    @Override
    public E rank(E e) {
        // TODO
        return null;
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
    public void level(Queue queue) {
        // TODO
    }

    @Override
    public void preorderStack(Queue queue) {
        // TODO
    }

}
