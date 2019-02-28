package algorithm.program_pre_interview.tuyayidong;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-05 13:53
 */
public class Main02 {
    public int maxLenOfUniqueSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int maxLen = 0;
        StringBuilder sub = new StringBuilder(s.length());
        int fromIndex = 0;  // 验证的起始位置

        for (int i = 0; i < s.length(); i ++){
            char ch = s.charAt(i);  // 取出当前待验证的字符
            int index = sub.indexOf(ch+"", fromIndex);  // 从起始位置开始验证
            if (index != -1) fromIndex = index+1;  // 如果存在该字符，则更新起始位置

            sub.append(ch);
            int len = sub.length() - fromIndex; // 当前字符到起始位置的长度（之前不存在和当前字符重复的字符）
            if (maxLen < len) maxLen = len;
        }

        return maxLen;
    }


    public String maxUniqueSubstring(String s) {
        if (s == null || s.length() == 0) return "";

        int maxLen = 0;
        int startIndex = 0;
        int endIndex = 1;
        StringBuilder sub = new StringBuilder(s.length());
        int fromIndex = 0;  // 验证的起始位置


        for (int i = 0; i < s.length(); i ++){
            char ch = s.charAt(i);  // 取出当前待验证的字符
            int index = sub.indexOf(ch+"", fromIndex);  // 从起始位置开始验证
            if (index != -1) fromIndex = index+1;  // 如果存在该字符，则更新起始位置

            sub.append(ch);
            int len = sub.length() - fromIndex; // 当前字符到起始位置的长度（之前不存在和当前字符重复的字符）
            if (maxLen < len) {  // 记录最长位置的起止下标
                maxLen = len;
                startIndex = fromIndex;
                endIndex = sub.length();
            }
        }

        return sub.substring(startIndex, endIndex);
    }

    @Test
    public void test(){
        String[] strs = {
                "",
                null,
                "aaaaaa",
                "abcabced",
                "aabbccdd",
                "abcdefghiab",
                "tuyayidong",
                "120135435"
        };

        for (String s : strs) {
            System.out.println(s + " -> " + maxUniqueSubstring(s));
        }
    }
}
