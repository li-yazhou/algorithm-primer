package algorithm.sort;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-21 9:25
 */



import java.util.Arrays;
import java.util.Random;

/**
 * algorithm: selection sort，选择排序
 *
 * description:
 *      遍历数组array，下标 i 的范围是[0, length)；
 *      当遍历到下标为 i 的元素时，当前元素和 [i, length)中的最小元素交换位置。
 *
 *      通俗的描述是，
 *          遍历数组，选择当前位置到末尾的所有元素中的最小者，与当前元素交换位置
 *          也即是，不断地选择剩余元素（包含当前元素）中的最小者，与当前元素交换位置
 *
 * expense: 时间复杂度 O(n^2)
 *
 * character:
 *      缺点，运行时间与输入无关。
 *           为了找出剩余元素中的最小者而扫描一遍数组，但并不能为下一遍的扫描提供可以利用的信息。
 *           对于一个有序的数组（或者全部元素都相等的数组）和一个元素随机排列的数组所需要的排序时间是一样的。
 *           而其他算法更善于利用输入的初始状态。
 *      优点，数据移动是最少的。
 *           选择排序用了 N 次交换 —— 交换次数和数组的大小是线性相关的。
 *           而其他排序算法的交换次数大多是线性对数或者平方级别的。
 */
public class Bubble {

    /**
     * 冒泡排序
     * 第二层循环，从后往前进行，注意边界
     * @param arr 数组
     */
    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length == 0) return;
        for (int i = 0; i < arr.length; i ++){
            for (int j = arr.length-1; j > i; j --){
                if (arr[j] < arr[j-1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
    }


    /**
     * 冒泡排序 —— “下沉排序”
     * 第二层循环，从前往后运行，注意边界
     * @param arr 数组
     */
    public static void bubbleSort2(int[] arr){
        if (arr == null || arr.length == 0) return;
        for (int i = 0; i < arr.length; i ++){
            for (int j = 1; j < arr.length-i; j ++){
                if (arr[j] < arr[j-1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
    }



    public void test(){
        Random random = new Random();
        int N = 20;
        int[] arr = new int[N];
        for (int i = 0; i < N; i ++) arr[i] = random.nextInt(100);
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(arr));
        Bubble.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        Bubble.bubbleSort2(arr2);
        System.out.println(Arrays.toString(arr2));
    }


}
