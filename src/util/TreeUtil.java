package util;

import tree.VisibleNode;

import java.util.*;

/**
 * @author : guochengsen
 * @date :
 */
public class TreeUtil {

    /**
     * Print a tree
     * make sure your console font is monospaced, `Dejavu Sans Mono` font suggested
     * @param root
     *            tree root node
     *                                                                           511
     *                                 ┌───────────────────────────────┴───────────────────────────────┐
     *                                281                                                             982
     *                                 └───────────────┐                               ┌───────────────┘
     *                                                291                             562
     *                                                 └───────┐               ┌───────┴───────┐
     *                                                        406             552             979
     *                                                     ┌───┘                           ┌───┘
     *                                                    372                             816
     */
    public static void print(VisibleNode root) {
        List<List<String>> lines = new ArrayList<>();

        List<VisibleNode> level = new ArrayList<>();
        List<VisibleNode> next = new ArrayList<>();

        level.add(root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<>();

            nn = 0;

            for (VisibleNode n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String aa = n.text();
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.left());
                    next.add(n.right());

                    if (n.left() != null) nn++;
                    if (n.right() != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<VisibleNode> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (String f : line) {

                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perpiece /= 2;
        }
    }

    /**
     *        511
     *       / \
     *     281 982
     *        \
     *       562
     *       / \
     *     552 979
     *         /
     *       816
     * @param root
     */
    public static void simplePrint(VisibleNode root) {
        int maxLeftOffset = findMaxOffset(root, 0, true);
        int maxRightOffset = findMaxOffset(root, 0, false);
        int offset = Math.max(maxLeftOffset, maxRightOffset);
        Map<Integer, PrintLine> lineMap = new HashMap();
        calculateLines(root, offset, lineMap, 0, true);
        Iterator<Integer> lineNumbers = lineMap.keySet().iterator();
        int maxLine = 0;
        while (lineNumbers.hasNext()) {
            int lineNumber = lineNumbers.next();
            if (lineNumber > maxLine) {
                maxLine = lineNumber;
            }
        }
        for (int i = 0; i <= maxLine; i++) {
            PrintLine line = lineMap.get(i);
            if (line != null) {
                System.out.println(line.getLineString());
            }
        }

    }

    private static void calculateLines(VisibleNode parent, int offset, Map<Integer, PrintLine> lineMap, int level,
                                       boolean right) {
        if (parent == null) {
            return;
        }
        int nameoffset = parent.toString().length() / 2;
        PrintLine line = lineMap.get(level);
        if (line == null) {
            line = new PrintLine();
            lineMap.put(level, line);
        }
        line.putString(right ? offset : (offset - nameoffset), parent.toString());
        if (parent.left() == null && parent.right() == null) {
            return;
        }
        PrintLine separateLine = lineMap.get(level + 1);
        if (separateLine == null) {
            separateLine = new PrintLine();
            lineMap.put(level + 1, separateLine);
        }
        if (parent.left() != null) {
            separateLine.putString(offset - 1, "/");
            calculateLines(parent.left(), offset - nameoffset - 1, lineMap, level + 2, false);
        }
        if (parent.right() != null) {
            separateLine.putString(offset + nameoffset + 1, "\\");
            calculateLines(parent.right(), offset + nameoffset + 1, lineMap, level + 2, true);
        }

    }

    private static class PrintLine {
        Map<Integer, String> printItemsMap = new HashMap<>();
        int maxOffset = 0;

        public void putString(int offset, String info) {
            printItemsMap.put(offset, info);
            if (offset > maxOffset) {
                maxOffset = offset;
            }
        }

        public String getLineString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= maxOffset; i++) {
                String info = printItemsMap.get(i);
                if (info == null) {
                    sb.append(" ");
                } else {
                    sb.append(info);
                    i += info.length();
                }
            }
            return sb.toString();
        }

    }

    private static int findMaxOffset(VisibleNode parent, int offset, boolean findLeft) {
        if (parent != null) {
            offset += parent.toString().length();
        }
        if (findLeft && parent.left() != null) {
            offset += 1;
            return findMaxOffset(parent.left(), offset, true);
        }
        if (!findLeft && parent.right() != null) {
            return findMaxOffset(parent.right(), offset, false);
        }
        return offset;
    }

}
