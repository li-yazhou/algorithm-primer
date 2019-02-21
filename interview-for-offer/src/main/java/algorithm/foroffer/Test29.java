package algorithm.foroffer;

/**
 * Created by liyazhou on 2017/5/29.
 * 面试题29：数组中出现次数超过一半的数字
 *
 * 题目：
 *      数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *      例如输入一个长度为 9 的数组 {1, 2, 3, 2, 2, 2, 5, 4, 2}。
 *      由于数字 2 在数组中出现了 5 次，超过数组长度的一半，因此输出 2。
 *      （牛客题目的额外要求，如果不存在次数过半的数字，则返回0）
 *
 * 问题：
 *      1. 对如此题目晕菜，第一感觉就是统计每一个数字出现的次数
 *
 * 思路：
 *      1. 遍历数组时，保存两个值，一个是数组中的一个数字，一个是次数。
 *         当遍历到下一个数字时候，如果其和之前保存的数字相同，则次数加 1，否则次数减 1。
 *         如果次数为零，则保存下一个数字，并把次数设为 1。
 *         最后一次把次数设置为 1 时，保存的数字即为出现次数超过数组长度一半的数字。
 */
public class Test29 {

    public static int findNum(int[] array){
        if (array == null) throw new RuntimeException("Invalid input, array is null.");

        int num = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i ++){
            if (times == 0){    // // 如果次数等于0，则保存当前数组，并将次数设置为1
                num = array[i];
                times = 1;
            }else{    // 如果次数不等于0，若当前值跟保存值相等则次数加1，否则减1
                if (array[i] == num) times ++;
                else				 times --;
            }
        }

        return num;
    }


    public static int findNum2(int[] array){
        if (array == null) throw new RuntimeException("Invalid input, array is null.");

        int num = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i ++){
            if (times == 0){    // // 如果次数等于0，则保存当前数组，并将次数设置为1
                num = array[i];
                times = 1;
            }else{    // 如果次数不等于0，若当前值跟保存值相等则次数加1，否则减1
                if (array[i] == num) times ++;
                else				 times --;
            }
        }

        // 验证是否过半
        int counter = 0;
        for (int i = 0; i < array.length; i ++){
            if (array[i] == num) counter ++;
        }
        // 如果不过半，则返回0
        if (counter <= array.length/2) num = 0;

        return num;
    }

    public static void main(String[] args){
        int[][] numbers = {
                {1, 2, 3, 2, 2, 2, 5, 4, 2},
                {1, 2, 3, 2, 2, 2, 5, 4, 2, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 1, 3, 1, 1},
        };

        for (int i = 0; i < numbers.length; i++)
            System.out.println(findNum(numbers[i]));
    }
}
