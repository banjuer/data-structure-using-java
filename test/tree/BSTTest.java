package tree;

import queue.LinkedQueue;
import queue.Queue;
import util.TreeUtil;


/**
 * @author : guochengsen
 * @date :
 */
public class BSTTest {

    private static void mock(Queue<Integer> queue) {
        queue.enqueue(428);
        queue.enqueue(364);
        queue.enqueue(565);
        queue.enqueue(3);
        queue.enqueue(420);
        queue.enqueue(550);
        queue.enqueue(629);
        queue.enqueue(202);
        queue.enqueue(811);
        queue.enqueue(800);
    }

    public static void main(String[] args) {
        Queue<Integer> mockQueue = new LinkedQueue<>();
        mock(mockQueue);
        Tree<Integer> bst = new BST<>();
        while (!mockQueue.isEmpty()) {
            bst.add(mockQueue.dequeue());
        }
        TreeUtil.print(bst.root());

        Queue<Integer> orderQueue = new LinkedQueue<>();
//        bst.preorder(orderQueue);
        bst.inorder(orderQueue);
//        bst.postorder(orderQueue);
//        bst.levelorder(orderQueue);
        System.out.println(orderQueue);

//        int t = 550;
//        System.out.println(t + "'s floor:" + bst.floor(t));
//        System.out.println(t + "'s ceil:" + bst.ceil(t));
//        System.out.println(bst.rank(t));
//        bst.delete(629);
//        TreeUtil.print(bst.root());
        System.out.println(bst.select(7));

    }

}
