package offerV2;

/**
 * @No          v2-058,v1-042
 * @problem     左旋转字符串
 * @tag         数组、字符串
 * @author      liyazhou
 * @date        2017-06-02
 *
 * <pre>
 *      字符串的左悬殊操作是把字符串前面的若干个字符转移到字符串的尾部。
 *      请定义一个函数实现字符串左旋转操作的功能。
 *      比如输入字符串"abcdefg" 和数字 2，该函数将返回左旋转 2 位得到的结果"cdefgab"。
 * </pre>
 */
public class _058_Rotate_String {


    /**
     * Note
     *
     * Thought
     *
     *
     * Algorithm
     *      1. 左半部分翻转
     *      2. 有半部分翻转
     *      3. 整体翻转
     */
    private static class Solution {


        public String leftRotateString(char[] chars, int k){
            if (chars == null) return null;

            reverse(chars, 0, k-1);
            reverse(chars, k, chars.length-1);
            reverse(chars, 0, chars.length-1);

            return new String(chars);
        }


        private void reverse(char[] chars, int start, int end){
            for (; start < end; start ++, end --){
                swap(chars, start, end);
            }
        }


        private void swap(char[] chs, int i, int j) {
            char tmp = chs[i];
            chs[i] = chs[j];
            chs[j] = tmp;
        }

    }
}
