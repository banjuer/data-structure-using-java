package list;

import util.SysUtil;

/**
 * @author : banjuer@outlook.com
 * @date :
 */
public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        SysUtil.print(list);
        SysUtil.print(list.isEmpty());
        for (int i = 0; i < 100; i++) {
            list.remove(0);
        }
        SysUtil.print(list);
        SysUtil.print(list.isEmpty());
    }

}
