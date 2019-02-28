package algorithm.base;

import org.junit.Test;

import java.util.Arrays;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-10-15 17:21
 */
public class Recursive {

    public int maxValue(int i, int[] arr){
        if(arr.length == 1) {
            return arr[0];
        }
        int j = i + 1;
        if(j == arr.length - 1) {
            return arr[j];
        }
        return Math.max(arr[i], maxValue(j, arr));
    }


    public int max(int[] arr, int i){
        if (i == arr.length-1)
            return arr[i];
        return Math.max(arr[i], max(arr, i+1));
    }


    int max = Integer.MIN_VALUE;
    public void getMax(int[] arr, int i){
        if (i < arr.length) max = Math.max(max, arr[i]);
        else                return;
        getMax(arr, i+1);
    }
    public int getMax(int[] arr){
        if (arr == null || arr.length == 0) throw new RuntimeException("参数异常");
        getMax(arr, 0);
        return max;
    }

    @Test
    public void test(){
        int[][] arrs = {
//                {1, 5, 6, 3, 2},
                {1, 0},
                {6, -1, 4},
//                {1},
        };
        for (int[] arr : arrs){
            System.out.print(Arrays.toString(arr) + "\t");
            System.out.println(max(arr, 0) + " :: " + getMax(arr));
        }
    }
}
