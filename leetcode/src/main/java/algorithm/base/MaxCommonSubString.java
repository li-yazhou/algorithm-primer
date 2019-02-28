package algorithm.base;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-10-15 16:29
 */


import org.junit.Test;

/**
题目：
     给定两个字符串 str1和str2，求它们的最长公共子串
     比如，str1 = "abc"， str2 = "bcabc"，则它们的最长公共子串是“abc”。

思路：
     使用二维数组保存字符串中对应字符的比较结果。
     字符的比较结果是，
     如果两个字符相等，而且其左上角没有元素，则比较结果为1；
     如果两个字符相等，而且其左上角有元素，则比较结果为左上角结果加1。

          a     b    c
     b    0     1    0
     c    0     0    2
     a    1     0    0
     b    0     2    0
     c    0     0    3

 最终，二维数组中的最大元素即为最长公共子串的长度，即为3。
 其实，可以使用两个一维数组即可以实现上述算法。
 第一个数组保存上一行的比较结果，第二个数组保存当前行的比较结果，使用第二个数组不断更新第一个数组。
 */
public class MaxCommonSubString {

    public String maxCommonSubstring(String s1, String s2){
        if (s1 == null || s2 == null) return "";

        int pos = 0;
        int maxLen = 0;

        int width = s1.length();
        int height = s2.length();

        int[] firstLine = new int[width];
        int[] currLine = new int[width];

        for (int i = 0; i < height; i ++){
            char ch = s2.charAt(i);
            for (int j = 0; j < width; j ++){
                if (ch == s1.charAt(j)){
                    if (j == 0) currLine[j] = 1;
                    else        currLine[j] = firstLine[j-1] + 1;
                    // maxLen = Math.max(currLine[j], maxLen);
                    if (currLine[j] > maxLen){
                        maxLen = currLine[j];
                        pos = j;
                    }
                }
            }

            // System.arraycopy();
            for (int k = 0; k < firstLine.length; k ++){
                firstLine[k] = currLine[k];
                currLine[k] = 0;
            }
        }

        // String maxCommonSubString = s1.substring(pos+1-maxLen, pos+1);
        return s1.substring(pos+1-maxLen, pos+1);
    }


    @Test
    public void test(){
        String[][] data = {
                {"abc", "bcabc"},
                {"abc", "bcab"},
                {"abc", "edf"},
        };

        for (String[] strs : data) {
            String result = maxCommonSubstring(strs[0], strs[1]);
            System.out.println(strs[0] + " :: " + strs[1] + " --> " + result);
        }
    }
}
