package queue;

import util.SysUtil;

/**
 * @author : guochengsen@outlook.com
 * @date :
 */
public class QueueTest {

    public static void main(String[] args) {
//        Queue<Integer> queue = new LinkedQueue<>();
        Queue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            SysUtil.print(queue);
        }
        while (!queue.isEmpty()) {
            queue.dequeue();
            SysUtil.print(queue);
        }
    }

}
