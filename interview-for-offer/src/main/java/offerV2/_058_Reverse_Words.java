package offerV2;

/**
 * @No          v2-058,v1-042
 * @problem     翻转单词顺序
 * @tag         数组、字符串
 * @author      liyazhou
 * @date        2017-06-02
 *
 * <pre>
 *      输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 *      为简单起见，标点符号和普通字母一样处理。
 *      例如输入字符串"I am a student."，则输出"student. a am I"。
 * </pre>
 */
public class _058_Reverse_Words {


    /**
     * Note
     *
     * Thought
     *
     * Algorithm
     *      Solution 1：
     *          以空格为 separator(delimiter)将字符串切分为字符串数组，
     *          逆序遍历字符串数组
     *      Solution 2:
     *          两次翻转字符串。
     *          首先，翻转每个单词；
     *          然后，翻转整个字符串。
     */
    private static class Solution {

        /**
         * 解法一，翻转单词顺序
         * @param chars 字符数组
         */
        public String reverseSequence(char[] chars){
            if (chars == null) return null;

            String sequence = new String(chars);

            String[] words = sequence.split(" ");
            StringBuilder sBuilder = new StringBuilder();
            for (int i = words.length - 1; i >= 1; i--) {
                sBuilder.append(words[i]).append(" ");
            }
            sBuilder.append(words[0]);
            return sBuilder.toString();
        }


        /**
         * 解法二：翻转单词顺序
         * @param chars 字符数组
         */
        public String reverseSequence2(char[] chars){
            if (chars == null) return null;

            int i = 0;
            int j = 0;
            while (j <= chars.length) {
                if (j ==  chars.length || chars[j] == ' ') {
                    reverse(chars, i, j-1);
                    i = j + 1;
                }
                j ++;
            }

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
