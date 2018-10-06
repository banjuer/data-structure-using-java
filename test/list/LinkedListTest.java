package list;

import util.SysUtil;

/**
 * @author : guochengsen@outlook.com
 * @date :
 */
public class LinkedListTest {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        SysUtil.print(list);
        SysUtil.print(list.isEmpty());
        for (int i = 0; i < 100; i++) {
            list.remove(0);
        }
        SysUtil.print(list.toString());
        SysUtil.print(list.isEmpty());
    }

}
