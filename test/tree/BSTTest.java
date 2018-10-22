package tree;

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
        for (int i = 0; i < 11; i++) {
            Thread.sleep(1);
            e = random.nextInt(100);
//            SysUtil.print(e);
            bst.add(e);
        }
        TreeUtil.print(bst.root());

    }

}
