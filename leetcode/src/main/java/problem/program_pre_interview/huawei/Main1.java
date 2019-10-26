package problem.program_pre_interview.huawei;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-15 11:40
 */

/**
 * 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。
 * 小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”答案是5瓶，方法如下：
 * 先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，
 * 喝掉这瓶满的，这时候剩2个空瓶子。然后你让老板先借给你一瓶汽水，
 * 喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。
 * 如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
 */

import java.util.Scanner;

public class Main1{
    public static void main(String[] args){
        int[] results = new int[10];
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        while(sc.hasNextInt()){
            int num = sc.nextInt();
            results[counter ++] = calculateNum(num);
        }
        for(int i = 0; i < counter; i ++){
            System.out.println(results[i]);
        }
    }

    private static int calculateNum(int num){
        int times = 0;
        int result = num;
        int residual = 0;
        while (result != 0){
            int sum = result + residual;
            result = sum / 3;
            residual = sum % 3;
            times += result;
        }
        if (residual == 2) times += 1;
        return times;
    }


    /**
     * 更好的解法，
     * 能喝的汽水瓶水总是空瓶子的二分之一。
     */
}