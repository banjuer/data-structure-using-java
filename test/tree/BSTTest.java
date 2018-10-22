package tree;

import queue.LinkedQueue;
import queue.Queue;
import util.SysUtil;
import util.TreeUtil;

import java.util.Random;

/**
 * @author : guochengsen
 * @date :
 */
public class BSTTest {



    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        BST<Integer> bst = new BST<>();
        int e;
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1);
            e = random.nextInt(1000);
//            SysUtil.print(e);
            bst.add(e);
        }
        TreeUtil.print(bst.root());
        Queue<Integer> queue = new LinkedQueue<>();
//        bst.preorder(queue);
        bst.inorder(queue);
//        bst.postorder(queue);

        System.out.println(queue);
        System.out.println("max:" + bst.max());
        System.out.println("min:" + bst.min());
    }

}
