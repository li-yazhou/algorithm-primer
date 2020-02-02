package offerV2;

/**
 * @No          v2-05
 * @problem     替换字符串中的空格
 * @tag         字符串
 * @author      liyazhou1
 * @date        2017/5/23
 *
 * <pre>
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * </pre>
 */
public class _005_Replace_Blank_Space {


    /**
     * Note
     *
     * Thought
     *
     * Algorithm
     *      1. 扩容
     *      2. 从右往后移动元素
     */
    private static class Solution {


        public String replaceSpace(StringBuffer str) {
            // return str.toString().replace(" ", "%20");

            // 扩容
            int originLen = str.length();
            for (int i = 0; i < originLen; i ++) {
                if (str.charAt(i) == ' ') {
                    str.append("  ");
                }
            }

            // 从右往后移动元素
            int p1 = originLen-1;
            int p2 = str.length() - 1;

            // 没有空白字符则直接返回
            if (p2 == p1) {
                return str.toString();
            }

            while (p1 >= 0) {
                char ch = str.charAt(p1--);
                if (ch == ' ') {
                    str.setCharAt(p2--, '0');
                    str.setCharAt(p2--, '2');
                    str.setCharAt(p2--, '%');
                } else {
                    str.setCharAt(p2--, ch);
                }
            }
            return str.toString();
        }

        public static void main(String[] args) {
            String[] usecases = {
                    "We are  happy ."
            };

            for (String usecase : usecases) {
                System.out.println("usecase = " + usecase);
                String result = new Solution().replaceSpace(new StringBuffer(usecase));
                System.out.println("result = " + result);
            }
        }

    }
}
