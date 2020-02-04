package offerV2;

/**
 * @No          v2-067,v1-049
 * @problem     把字符串转换成整数
 * @tag         字符串
 * @author      liyazhou
 * @date        2017-06-04
 *
 * <pre>
 *  把字符串转换成整数
 * </pre>
 */
public class _067_Cast_String_To_Int {


    /**
     * Note
     *
     * Thought
     *
     * Algorithm
     *      1.
     *      2.
     *      3.
     */
    private static class Solution {

        // 2017-8-18 10:18:20
        public int castStrToInt(String str){
            if (str == null || "".equals(str.trim())) return 0;

            boolean isNegative = str.charAt(0) == '-';

            int start = 0;
            char first = str.charAt(0);
            if (first == '-' || first == '+') {
                start = 1;
            }

            int ret = 0;
            for (int i = start; i < str.length(); i ++) {
                char ch = str.charAt(i);

                if (ch < '0' || ch > '9') {
                    return 0;
                }
                ret = ret * 10 + (ch - '0');
            }

            return isNegative ? -ret : ret;

        }
    }
}
