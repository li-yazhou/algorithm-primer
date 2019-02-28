package algorithm.program_pre_interview.niuke;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-06-25 17:32
 */

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] prices = null;
        if (sc.hasNextInt()){
            int len = sc.nextInt();
            prices = new int[len];
        }

        for (int i = 0; i < prices.length; ){
            if (sc.hasNextInt()){
                prices[i++] = sc.nextInt();
            }
        }

        java.util.Arrays.sort(prices);
        int price = prices[0];
        int rank = 1;
        for (int i = 1; i < prices.length; i ++){
            if (prices[i] != price){
                rank ++;
                price = prices[i];
                if (rank == 3) break;
            }
        }
        if (rank != 3) price = -1;
        System.out.println(price);
    }
}