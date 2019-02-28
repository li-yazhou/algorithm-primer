package algorithm.program_pre_interview;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-25 9:34
 */
public class Main01 {

    /**
     * 题目：
     *      给出一个 -100000 ~ 100000 之间的整数，找出由这个整数中的数字组成的最小整数。
     * @param intkey 数字
     */
    @Test
    public void findUnlockKey(int intkey){
        boolean isNegative = intkey < 0;
        if (isNegative) intkey = - intkey;
        String key = intkey + "";
        char[] chars = key.toCharArray();
        int result = 0;
        if (isNegative) {
            Arrays.sort(chars);
            for(int i = 0; i < chars.length/2; i ++){
                char temp = chars[i];
                chars[i] = chars[chars.length-1-i];
                chars[chars.length-1-i] = temp;
            }
            result = - Integer.valueOf(new String(chars));
        }else {
            Arrays.sort(chars);
            int i = 0;
            char first = chars[0];
            for (i = 0; i < chars.length; i++) {
                if (chars[i] != '0') {
                    first = chars[i];
                    break;
                }
            }
            if (i != 0) {
                chars[i] = '0';
                chars[0] = first;
            }
            result = Integer.valueOf(new String(chars));
        }
        System.out.println(result);
    }


    /**
     * 题目：
     *      有 n*m 块蛋糕编号为 1-n*m，k个同学，每个同学写上自己想要得到的蛋糕编号列表，
     *      最终每个同学得到一个块蛋糕，如果该蛋糕编号属于自己写的列表，那么这个同学就会很开心，
     *      那么，最多可以让多少位同学开心呢？
     *
     *      int findMaxHappyFriend(int n, int m, int k, List<List<Integer>> choiceList)
     */
    public int findMaxHappyFriend(int n, int m, int k, List<List<Integer>> choiceList){

        return k;
    }
    @Test
    public void test02(){

    }


    @Test
    public void test01(){

    }
}
