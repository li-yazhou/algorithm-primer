package algorithm.sort;


import java.util.Arrays;
import java.util.Random;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-20 14:50
 */

/**
 * algorithm: quick sort，快速排序
 *
 * algorithm thought:
 *      从待排序的记录序列中选取一个记录（通常选取第一个记录，此处有优化空间）为枢轴pivot，其关键字设置为 key1，
 *      然后将其余关键字小于 key1 的记录移到前面，而将关键字大于 key1 的记录移动到后面，结果将待排序记录序列
 *      分为两个子表，最后将关键字为 key1 的记录插到其分界线的位置处。将这个过程称为一趟快速排序。
 *      通过一次划分后，就以关键字为 key1 的记录为界，将待排序序列分成了两个子表，且前面子表中所有记录的关键字
 *      均不大于key1，而后面子表中的所有记录的关键字均不小于 key1。
 *      对分割后的子表继续按上述原则进行分割，直到所有子表的表长不超过 1 为止，此时待排序记录序列就变成了一个有序表。
 *
 *
 * algorithm description:
 *      假设待划分序列为 arr[left], arr[left+1], ... , arr[right]，具体实现上述划分过程时，可以设置两个指针 i 和 j，
 *      它们的初始值分别为 left 和 right。
 *      首先将基准记录 arr[left] 赋值给 key，使 arr[left]，即arr[i]相当于空单元，然后反复进行如下两个扫描过程，直到 i 和 j 相遇。
 *          a. j 从右向左扫描，直到 arr[j] < key 时，将 arr[j] 移至空单元 arr[i]，此时 arr[j]相当于空单元。
 *          b. i 从左向右扫描，直到 arr[i] > key 时，将 arr[i] 移至空单元 arr[j]，此时 arr[i]相当于空单元。
 *      当 i 和 j 相遇时，arr[i] （或 arr[j]）相当于空单元，且 arr[i] 左边所有记录均不大于基准记录（切分元素），而 arr[i] 右边所有
 *      记录均不小于基准记录（切分元素）。最后，将基准记录（切分元素）移至 arr[i] 中，就完成了一次划分过程。
 *      对于 arr[i] 左边的子表和 arr[i] 右边的子表可采用同样的方法进行进一步划分。
 *
 *
 * description:
 *      冒泡排序，在扫描过程中只对相邻的两个元素进行比较，因此在交换两个相邻元素时只能消除一个逆序。
 *      如果能通过两个（不相邻的）元素的交换，消除待排序数组中的多个逆序，则会加快交换排序的速度。
 *      快速排序方法中的一次交换可能消除多个逆序。
 *      通俗地表述：
 *      1. 从待排序的数列中选择一个元素，作为基准元素（pivot），也称为切分元素，通常选择第一个元素或者最后一个元素
 *      2. 对数列排序，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆放在基准后面（相等的元素可以放到任意一边）。
 *         该基准就处于两部分的中间位置。这个称为分区（partition）操作。
 *      3. 然后，分别对基准元素左右两部分用同样的方法继续进行排序，直到整个序列有序（递归 recursive）。
 *
 * expense: 时间复杂度 O(n^2)，平均时间复杂度是 O(n*log(n))
 *
 * character:
 */
public class Quick {

    public static void sort(Comparable[] arr, int low, int high){
        if (low < high){
            // 调用一趟快速排序，以切分元素（枢轴元素 pivot）为界划分两个子表
            int pos = partition(arr, low, high);
            sort(arr, low, pos-1);  // 对左部子表快速排序
            sort(arr, pos+1, high);  // 对右部子表快速排序
        }
    }

    private static int partition(Comparable[] arr, int low, int high) {
        Comparable key = arr[low];
        while (low < high){
            // 从右到左找一个比切分元素key小的元素
            for (; low < high && arr[high].compareTo(key) >= 0; high --);
            // 若找到一个比切分元素小的元素，则将它放置在低位，此时高位出生产一个空位
            // 低位处的初始值是切分元素，之后低位处是一个空位
            if (low < high) {
                arr[low] = arr[high];
                low ++;
            }

            // 从左到右找一个比切分元素大的元素
            for (; low < high && arr[low].compareTo(key) <= 0; low ++);
            // 若找到一个比切分元素大的元素，则将它放置在高位，此时低位产生一个空位
            if (low < high){
                arr[high] = arr[low];
                high --;
            }
        }
        arr[low] = key;  // 将切分元素放置在空位
        return low;
    }


    public void test(){
        Random random = new Random();
        int N = 20;
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) arr[i] = random.nextInt(100);
        System.out.println(Arrays.toString(arr));
        Quick.sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
