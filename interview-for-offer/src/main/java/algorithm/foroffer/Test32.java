package algorithm.foroffer;

/**
 * Created by liyazhou on 2017/5/29.
 * 面试题32：从 1 到 n 整数中 1 出现的次数
 *
 * 题目：
 *      输入一个整数 n，求从 1 到 n 这 n 个整数中的十进制表示中 1 出现的次数。
 *      例如输入 12， 从 1 到 12 这些整数中包含 1 的数字有 1，10，11 和 12，
 *      1 一共出现了 5 次。
 *
 * 考查点：
 *      1. 找规律
 *
 * 思路：
 *
 */
public class Test32 {

    public static int countNumOfOne(int n){
        int counter = 0;
        for (int i = 1; i <= n; i ++){
            for (int number = i; number != 0; number /= 10){
                if (number % 10 == 1)
                    counter ++;
            }
        }

        return counter;
    }

    public static void main(String[] args){
        int[] nums = {11, 12};

        for(int num: nums){
            for (int i = 1; i <= num; i ++) System.out.print(i + "\t");
            System.out.println("\n" + countNumOfOne(num) + "\n");
        }
    }
}
