package stack;

import util.SysUtil;

/**
 * @author : guochengsen@outlook.com
 * @date :
 */
public class StackTest {

    public static void main(String[] args) {
//        Stack<Integer> stack = new LinkedStack<>();
        Stack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
            SysUtil.print(stack);
        }
        for (int i = 0, j = stack.size(); i < j; i++) {
            stack.pop();
            SysUtil.print(stack);
        }

    }

}
