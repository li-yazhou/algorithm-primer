package algorithm.program_pre_interview.niuke;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-28 20:41
 */

import org.junit.Test;

/**
 * 题目描述
         计算字符串最后一个单词的长度，单词以空格隔开。
         输入描述: 一行字符串，非空，长度小于5000。
         输出描述: 整数N，最后一个单词的长度。
    示例1
         输入 hello world
         输出 5
 */
public class Test001_lenOfLastWord {

    public int lenOfLastWord(String str){
        int len = 0;
        len = str.length() - str.lastIndexOf(" ") - 1;
        return len;
    }

    @Test
    public void test(){
        String[] strs = {"hello world", "thinking in java", "ABSIB T"};
        for (String str : strs){
            System.out.println("\""+ str + "\"" + " lenOfLastWord = " + lenOfLastWord(str));
        }
    }
}
