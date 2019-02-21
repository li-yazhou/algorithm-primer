package algorithm.foroffer;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-02 14:57
 *
 * 面试题42：翻转单词顺序 VS 左旋转字符串
 *
 * 题目一：
 *      输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 *      为简单起见，标点符号和普通字母一样处理。
 *      例如输入字符串"I am a student."，则输出"student. a am I"。
 *
 * 考查点：
 *      1. 字符数组的操作
 *
 * 思路：
 *      Solution 1：
 *          以空格为 separator(delimiter)将字符串切分为字符串数组，
 *          逆序遍历字符串数组
 *      Solution 2:
 *          两次翻转字符串。
 *          首先，翻转整个字符串；
 *          然后，翻转每个单词。
 *
 * 题目二：
 *      字符串的左悬殊操作是把字符串前面的若干个字符转移到字符串的尾部。
 *      请定义一个函数实现字符串左旋转操作的功能。
 *      比如输入字符串"abcdefg" 和数字 2，该函数将返回左旋转 2 位得到的结果"cdefgab"。
 *
 * 考查点：
 *
 * 思路：
 *
 *
 */
public class Test42 {

    /**
     * 解法一，翻转单词顺序
     * @param chars 字符数组
     */
    public String reverseSequence(char[] chars){
        if (chars == null) return null;

        String sequence = new String(chars);
        if (sequence.trim().equals("")) return sequence;

        String[] words = sequence.split(" ");
        StringBuilder sBuilder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sBuilder.append(words[i]).append(" ");
        }
        if (sBuilder.length() > 0) sBuilder.deleteCharAt(sBuilder.length()-1);
        return sBuilder.toString();
    }


    /**
     * 解法二：翻转单词顺序
     * @param chars 字符数组
     */
    public String reverseSequence2(char[] chars){
        if (chars == null) return null;

        // for (int i = 0; i < chars.length/2; i++) chars[i] = chars[chars.length-1-i];
        reverseString(chars, 0, chars.length);
        // System.out.println(new String(chars));

        int wordStartIdx = 0;
        int wordEndIdx = 0;
        for (int i = 0; i < chars.length; i++){
            if (chars[wordEndIdx] == ' '){
                reverseString(chars, wordStartIdx, wordEndIdx);
                // System.out.println(new String(chars));
                wordStartIdx = wordEndIdx + 1;
            }
            wordEndIdx ++;
        }
        return new String(chars);
    }

    private char[] reverseString(char[] chars, int startIdx, int endIdx){
        // System.out.printf("startIdx, endIdx = %d, %d\n", startIdx, endIdx);
        for (endIdx --; startIdx < endIdx; startIdx ++, endIdx --){
            char tmp = chars[startIdx];
            chars[startIdx] = chars[endIdx];
            chars[endIdx] = tmp;
        }
        return chars;
    }


    @Test
    public void test11(){
        String[] lines = {
                "I am a student.",
                "I",
                " ",
                "",
        };

        for(String line : lines){
            System.out.println("method 1: " + reverseSequence(line.toCharArray()));
            System.out.println("method 2: " + reverseSequence2(line.toCharArray()));
        }
    }


    /**
     * 方法一：字符数组中的前 k 个字符平移到末尾（辅助空间较大）
     * @param chars 字符数组
     * @param k 移动字符的数目
     * @return 移动之后的数组
     */
    public char[] mvHeadToTail(char[] chars, int k){
        if (chars == null || k >= chars.length-1 || k < 0) return chars;
        char[] tmpChars = new char[k];
        for (int i = 0; i < k; i ++) tmpChars[i] = chars[i];
        // 一步到位，但是需要长度的k的字符数组作为辅助空间
        // 当然，当 k 较大且空间复杂度限制时，可以考虑一次移动 m 个字符。
        for(int j = k; j < chars.length; j ++) chars[j-k] = chars[j];
        for(int i = 0; i < k; i ++) chars[chars.length - k + i] = tmpChars[i];
        return chars;
    }

    /**
     * 方法二：字符数组中的前 k 个字符平移到末尾（时间复杂较大）
     * @param chars 字符数组
     * @param k 移动字符的数目
     * @return 移动之后的数组
     */
    public char[] mvHeadToTail2(char[] chars, int k){
        if (chars == null || k >= chars.length-1 || k < 0) return chars;
        char tmp;
        for (int i = 0; i < k; i ++) {
            tmp = chars[0];
            for (int j = 1; j < chars.length; j++) chars[j-1] = chars[j];
            chars[chars.length-1] = tmp;
        }
        return chars;
    }

    @Test
    public void test21(){
        String[] lines = {
                "abcdefg",
                "string",
        };

        for (String line : lines){
            System.out.println(mvHeadToTail(line.toCharArray(), 2));
            System.out.println(mvHeadToTail2(line.toCharArray(), 2));
        }
    }
}
