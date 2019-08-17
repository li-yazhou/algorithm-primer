# 排序算法


## 排序算法分类
* **插入排序：** 直接插入、希尔排序
* **选择排序：** 简单选择、堆排序
* **交换排序：** 冒泡排序、快速排序
* **归并排序：** 归并排序


桶排序、基数排序、计数排序 


---


## 排序算法总结
 
### 简单的排序
* [冒泡排序 bubble sort 交换类配需](#冒泡排序)
* [选择排序 selection sort 选择类排序](#选择排序)
* [直接插入排序 straight insertion sort 插入类排序](#插入排序)
* 折半插入排序 binary insert sort


### 复杂的排序
* [希尔排序 shell sort 插入类排序](#希尔排序)
* [归并排序 merge sort](#希尔排序)
* [快速排序 quick sort 交换类排序](#快速排序)
* [堆排序 heap sort 选择类排序](#堆排序)

### 线性的排序
* 桶排序 bucket sort
* 计数排序 count sort
* 基数排序 radix sort


---


## 排序算法稳定性
**稳定性的排序：**
> 冒泡排序
> 插入排序（直接插入排序、折半插入排序）
> 归并排序
> 基数排序

**非稳定性的排序**
> 选择排序
> 堆排序
> 希尔排序
> 快速排序


----------


## 排序算法时间和空间复杂度对比

| 算法 | 平均时间复杂度 | 最坏时间复杂度 | 最好时间复杂度 | 空间复杂度 |
| :---- | :---- | :---- | :---- | :---- | 
|冒泡排序|||||
|快速排序|||||
|插入排序|||||
|希尔排序|||||
|选择排序|||||
|堆排序|||||
|归并排序|||||

![这里写图片描述](http://img.blog.csdn.net/20170905085957601?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGl5YXpob3UwMjE1/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


---


## 冒泡排序
### 描述
遍历数组array，下标 i 的范围是[0, length)；
     当遍历到下标为 i 的元素时，当前元素和 [i, length)中的最小元素交换位置。
     通俗的描述是，
         遍历数组，选择当前位置到末尾的所有元素中的最小者，与当前元素交换位置
         也即是，不断地选择剩余元素（包含当前元素）中的最小者，与当前元素交换位置


### 时间复杂度
expense: 时间复杂度 O(n^2)

### 稳定性
稳定


### 优缺点
缺点，运行时间与输入无关。
>为了找出剩余元素中的最小者而扫描一遍数组，但并不能为下一遍的扫描提供可以利用的信息。
     对于一个有序的数组（或者全部元素都相等的数组）和一个元素随机排列的数组所需要的排序时间是一样的。
     而其他算法更善于利用输入的初始状态。

优点，数据移动是最少的。
>选择排序用了 N 次交换 —— 交换次数和数组的大小是线性相关的。
     而其他排序算法的交换次数大多是线性对数或者平方级别的。
     
### 适用场景


```
package datastructure_algorithm.algorithm4.ch02_sort;

/**
 * algorithm: selection sort，选择排序
 * @author liyazhou
 * @create 2017-06-21 9:25
 */


import org.junit.Test;
import java.util.Arrays;
import java.util.Random;

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

    @Test
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
```


---


## 选择排序
### 描述
遍历数组array，下标 i 的范围是[0, length)；
当遍历到下标为 i 的元素时，当前元素和 [i, length)中的最小元素交换位置。

通俗的描述是，
    遍历数组，选择当前位置到末尾的所有元素中的最小者，与当前元素交换位置
    也即是，不断地选择剩余元素（包含当前元素）中的最小者，与当前元素交换位置

### 选择排序的优缺点
缺点，运行时间与输入无关。
>为了找出剩余元素中的最小者而扫描一遍数组，但并不能为下一遍的扫描提供可以利用的信息。
     对于一个有序的数组（或者全部元素都相等的数组）和一个元素随机排列的数组所需要的排序时间是一样的。
     而其他算法更善于利用输入的初始状态。
     
优点，数据移动是最少的。
>选择排序用了 N 次交换 —— 交换次数和数组的大小是线性相关的。
     而其他排序算法的交换次数大多是线性对数或者平方级别的。

### 时间复杂度
时间复杂度为O（n^2）

### 稳定性
不稳定

### 适用场景

### 简单选择排序的实现
```
package algorithm.algorithm4.ch02_sort;

/**
 * algorithm: selection sort，选择排序
 * @author liyazhou
 * @create 2017-06-20 10:05
 */

import org.junit.Test;
import java.util.Arrays;
import java.util.Random;
public class Selection {
    public static void sort(Comparable[] arr){
        for (int i = 0; i < arr.length; i ++){
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j ++){
                if (arr[j].compareTo(arr[minIdx]) < 0)
                    minIdx = j;
            }
            if (minIdx != i){
                Comparable tmp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = tmp;
            }
        }
    }

    @Test
    public void test(){
        int N = 15;
        Integer[] arr = new Integer[N];
        Random random = new Random();
        for (int i = 0; i < N; i ++) arr[i] = random.nextInt(100);
        System.out.println(Arrays.toString(arr));
        Selection.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
```


---


## 插入排序
### 描述
 一个形象生动的比喻：一张一张地整理扑克牌，将每一张牌插入到已经整理好的扑克中
 依次插入元素，每次插入新的元素后，保持已插入元素的顺序性。
 
 怎么保证已插入元素的顺序性呢？
     从右向左的方向和已排序数组比较，如果当前元素比它小，则交换两者，
     直到当前元素位于第一个位置或者是前面没有比其更大的元素。 
     
 优化，减少元素交换的次数
     在已排序的元素中从右向左找到第一个等于或者小于当前元素的位置，
     将位于它后面而且是已排序的元素依次往后移动一位，并将当前元素插入它的后面即可。

### 时间复杂度
expense: 时间复杂度 O(n^2)


### 适用场景
插入排序所需的时间取决于数组中元素的初始顺序。
适用场景，当数组是部分有序的时候，插入排序效率会有明显提升。


### 插入排序的实现
```
package algorithm.algorithm4.ch02_sort;
import org.junit.Test;
import java.util.Arrays;
import java.util.Random;
/**
 * algorithm: insertion sort，插入排序
 * @author liyazhou
 * @create 2017-06-20 10:49
 */
public class Insertion {
    public static void sort(Comparable[] arr){
        for (int i = 0; i < arr.length; i ++){
            for (int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j --){
                Comparable tmp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = tmp;
            }
        }
    }

    public static void sort2(Comparable[] arr){
        for (int i = 0; i < arr.length; i ++){
            Comparable newEle = arr[i];
            int j = i-1;
            // 从右向左找到第一个小于或者等于当前值的元素，找到返回其下标
            // 边界问题（如果已插入的所有元素均比当前值大，则 j = -1；如果已插入的所有元素均比当前值小，j = i-1）
            for (; j >= 0 && arr[j].compareTo(newEle) > 0; j --);
            for (int k = i; k > 0 && k > j; k --) arr[k] = arr[k-1];  // 将这些较大的元素依次向右移动
            arr[j+1] = newEle;  // 将新元素插入其从右边起第一个比其小的元素后面即可
        }
    }

    @Test
    public void test(){
        int N = 20;
        Integer[] arr = new Integer[N];
        Random random = new Random();
        for (int i = 0; i < N; i ++) arr[i] = random.nextInt(100);
        System.out.println(Arrays.toString(arr));
        Insertion.sort2(arr);
        System.out.println(Arrays.toString(arr));
    }
}

```


---


## 希尔排序

shell sort，希尔排序，也称为缩减增量排序算法，**递减增量排序**算法

### 描述
* 1、先取一个小于n的整数d1作为第一个增量，把文件的全部记录分成d1个组。
* 2、所有距离为d1的倍数的记录放在同一个组中，在各组内进行直接插入排序。
* 3、取第二个增量d2&lt;d1重复上述的分组和排序，
* 4、直至所取的增量dt=1(dt&lt;dt-l&lt;…&lt;d2&lt;d1)，即所有记录放在同一组中进行直接插入排序为止。

**更直白的描述**
将数组间隔为increment的元素分别划分到若干个小组，对每一个小组进行直接插入排序（每一小组的数据量较小，操作代价更小）；
不断地减小间隔，将数组划分为更多个小组，继续对每一个小组进行直接插入排序（可以使近邻的元素基本有序）；
最后，将数组划分为 N 个小组，也即是对全体元素进行一次直接插入排序。
（最后一步，数组已经基本有序，就对数组直接插入排序）


### 希尔排序算法的解释
在数组内的元素基本有序的情况下，直接插入排序是非常高效的。
而希尔排序就是创造基本有序的条件，之后进行直接插入排序的。

解释它的做法，

    希尔排序的思想是使数组中任意间隔为 increment 元素都是有序的。
    对间隔为increment的元素进行直接插入排序，可以使一个元素一次性地朝着最终位置前进一大步
    缩小间隔 increment，可以使任意一个局部的元素都是基本有序的。
    当数组基本有序时，对全体元素进行直接插入排序。


### 时间复杂度
expense: 
时间复杂度 O(n^(3/2))


### 希尔排序的实现
```
package algorithm.algorithm4.ch02_sort;
import org.junit.Test;
import java.util.Arrays;
import java.util.Random;
/**
 * algorithm: shell sort，希尔排序，也成为缩减增量排序算法，递减增量排序算法
 * @author liyazhou
 * @create 2017-06-20 12:55
 */
public class Shell {
    public static void sort(Comparable[] arr){
        int increment = arr.length;
        do{
            increment = increment/3 + 1;  // 当前的增量，保证最小增量是 1
            // 每次为一个分组添加一个的新的元素，直到把所有的元素添加到各个分组中
            for (int i = increment; i < arr.length; i ++){  
                Comparable newEle = arr[i];  // 待插入的新元素，下面的操作是找到合适的位置
                int j = i-increment;  // 组内的已排序的最后一个元素
                // 小组内新添加了一个元素，对其进行插入排序
                // 分组内所有比新元素大的元素依次向后移动increment位
                for (; j >= 0 && arr[j].compareTo(newEle) > 0; j -= increment) // 对每一个小组，组内插入排序
                    arr[j+increment] = arr[j];  // 组内右边的元素较当前元素大，则一次往后移动一位
                arr[j+increment] = newEle;  // 把新元素插入到合适的位置
            }
        } while (increment > 1);  // 增量increment = 1时，是对全体基本有序的数组进行插入排序，之后停止循环
    }

    @Test
    public void test(){
        int N = 30;
        Integer[] arr = new Integer[N];
        Random random = new Random();
        for (int i = 0; i < N; i ++) arr[i] = random.nextInt(100);
        System.out.println(Arrays.toString(arr));
        Shell.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

```

---


## 归并排序
 
### 归并排序思路
 归并排序的基本思想基于递归地拆分和合并，将两个或两个以上有序表合并成一个新的有序表。

将整个区间递归地拆分为小区间（最小的区间长度为1），然后递归地合并两个有序的区间。

### 时间复杂度
expense: 
> 平均时间复杂度 O(N*log(N))
> 最坏时间复杂度 O(N*log(N))
> 最好时间复杂度 O(N*log(N))

空间复杂度O(N)

### 应用场景

### 归并排序实现
```
package algorithm.algorithm4.ch02_sort;
import org.junit.Test;
import java.util.Arrays;
import java.util.Random;
/**
 * description:
 * algorithm: merge sort，归并排序
 * @author liyazhou
 * @create 2017-06-21 14:41
 */
public class Merge {
    public static void sort(Comparable[] arr){
        if (arr == null || arr.length < 2) return;
        Comparable[] aux = new Comparable[arr.length];  // 归并排序所需要的辅助空间
        sort(arr, 0, arr.length-1, aux);
    }

    private static void sort(Comparable[] arr, int low, int high, Comparable[] aux) {
        if (low >= high) return;
        int mid = low + (high - low)/2;
        sort(arr, low, mid, aux);           // 将左部区间排序
        sort(arr, mid+1, high, aux);        // 将右部区间排序
        merge(arr, low, mid, high, aux);    // 归并左右两部分区间的结果
    }

    /**
     * 合并位于 [low, mid] 和 [mid+1, high] 这两段闭区间内的元素
     * 每一个区间的内部都是有序的
     * @param arr 序列
     * @param low 开始索引
     * @param mid 中间索引
     * @param high 末尾索引
     * @param aux 辅助空间
     */
    private static void merge(Comparable[] arr, int low, int mid, int high, Comparable[] aux) {
        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k ++) aux[k] = arr[k];

        int k = low;
        while (i <= mid && j <= high){
            if (aux[i].compareTo(aux[j]) < 0) arr[k++] = aux[i++];
            else                              arr[k++] = aux[j++];
        }

        while (i <= mid) arr[k++] = aux[i++];
        while (j <= high) arr[k++] = aux[j++];
    }

    @Test
    public void test(){
        Random random = new Random();
        int N = 20;
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i ++) arr[i] = random.nextInt(100);
        System.out.println(Arrays.toString(arr));
        Merge.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
```

---


## 快速排序

在 [数据结构与算法动态可视化](https://visualgo.net/zh) 网站，可以观看排序时元素位置变化的过程。

### 快速排序的思想
从待排序的记录序列中选取一个记录（通常选取第一个记录，此处有优化空间）为枢轴，其关键字设置为 key1，然后将其余关键字小于 key1 的记录移到前面，而将关键字大于 key1 的记录移动到后面，结果将待排序记录序列分为两个子表，最后将关键字为 key1 的记录插到其分界线的位置处。将这个过程称为一趟快速排序。
     
通过一次划分后，就以关键字为 key1 的记录为界，将待排序序列分成了两个子表，且前面子表中所有记录的关键字均不大于key1，而后面子表中的所有记录的关键字均不小于 key1。

对分割后的子表继续按上述原则进行分割，直到所有子表的表长不超过 1 为止，此时待排序记录序列就变成了一个有序表。 


### 快速排序的步骤
假设待划分序列为 arr[left], arr[left+1], ... , arr[right]，具体实现上述划分过程时，可以设置两个指针 i 和 j，它们的初始值分别为 left 和 right。
    
首先将基准记录 arr[left] 赋值给 key，使 arr[left]，即arr[i]相当于空单元，然后反复进行如下两个扫描过程，直到 i 和 j 相遇。
> a. j 从右向左扫描，直到 arr[j] < key 时，将 arr[j] 移至空单元 arr[i]，此时 arr[j]相当于空单元。
   b. i 从左向右扫描，直到 arr[i] > key 时，将 arr[i] 移至空单元 arr[j]，此时 arr[i]相当于空单元。

当 i 和 j 相遇时，arr[i] （或 arr[j]）相当于空单元，且 arr[i] 左边所有记录均不大于基准记录（切分元素），而 arr[i] 右边所有记录均不小于基准记录（切分元素）。最后，将基准记录（切分元素）移至 arr[i] 中，就完成了一次划分过程。

对于 arr[i] 左边的子表和 arr[i] 右边的子表可采用同样的方法进行进一步划分。

### 通俗的描述

冒泡排序，在扫描过程中只对相邻的两个元素进行比较，因此在交换两个相邻元素时只能消除一个逆序。
如果能通过两个（不相邻的）元素的交换，消除待排序数组中的多个逆序，则会加快交换排序的速度。
快速排序方法中的一次交换可能消除多个逆序。

通俗地表述：

     1. 从待排序的数列中选择一个元素，作为基准元素（pivot），也成为切分元素，通常选择第一个元素或者最后一个元素
     2. 对数列排序，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆放在基准后面（相等的元素可以放到任意一边）。
        该基准就处于两部分的中间位置。这个称为分区（partition）操作。
     3. 然后，分别对基准元素左右两部分用同样的方法继续进行排序，直到整个序列有序（递归 recursive）。


### 时间复杂度
expense: 时间复杂度 O(n^2)，
平均时间复杂度是 O(n*log(n))

### 适用场景


### 快速排序实现
```
package algorithm.algorithm4.ch02_sort;
import org.junit.Test;
import java.util.Arrays;
import java.util.Random;
/**
 * algorithm: quick sort，快速排序
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
        // 为什么最后low一定是空位？
        // 因为当高位没有比key小的元素时，则低位产生了空位
        // 或者低位没有比key大的元素时，高位产生了空位，则while(low < high)一直执行到low == high
        return low;
    }

    @Test
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
```


---



## 堆排序

### 堆排序的过程

* 创建最大堆：
> 从最后一个非叶子结点到根结点（从下向上，这点非常关键）调整每一个子堆，使子堆有序化。
> 最开始的子堆的根结点是最后一个非叶子结点，它有一个或者两个孩子，它与较大者交换位置即可实现子堆有序化。
> 底部的子堆有序化，是其上面的堆进行调整的前提条件。
> 也即是，如果子堆是无序的，那么包含它的一个更大的堆就无法进行调整操作，
> 所以需要从最后一个非叶子结点到根结点（从下向上，这点非常关键）调整每一个子堆，使子堆有序化。。

* 调整最大堆（有序化堆）：
> （只有一个或者零个父结点相对孩子是无序）
> 如果当前结点有孩子结点，
> 如果当前结点的孩子结点的较大者比当前结点大，则交换两者位置，
> 否则调整结束，退出，
> 继续比较当前结点与其新的孩子结点


### 堆排序的步骤：
* 1. 初始化最大堆（使堆有序化，可能所有的子堆都是无序的，需要调整所有的子堆）
* 2. 将最大堆的第一个元素和最后一个元素交换位置；
    使堆的长度减 1；
    最大堆调整（使堆有序化，只有第一个元素相对于它的孩子是无序的，不断调整此元素和其后代的相对位置即可）；
    重复以上三步，直到堆的长度为 1。



### 索引关系
使用数组存储完全二叉树（堆），则结点下标关系是：
>父结点 i 的左子结点是 2 * i + 1；
父结点 i 的右子结点是 2 * i + 2；
子结点 i 的父结点是 floor((i-1)/2)
后一个非叶子结点是 floor(N/2)-1


### 时间复杂度
expense:
时间复杂度 O(N*log(N))

### 应用场景

### 堆排序实现

```
package algorithm.algorithm4.ch02_sort;
import org.junit.Test;
import java.util.Arrays;
import java.util.Random;
/**
 * algorithm: heap sort，堆排序
 */
public class Heap {
    public static void sort (Comparable[] arr){
        if (arr == null || arr.length < 2) return;

		// 1. 创建堆
        // 从下向上使每一个有孩子的结点都成为一个有序堆（宏观角度）
        // 多次堆化，从下到上不断新加元素，因为单次堆化要求最多只有根结点相对于孩子结点是无序的，所以需要从后往前添加元素
        // 具体的堆化操作是从上到下完成的，而且一次堆化要求最多只有根结点相对于孩子结点是无序的，此外所有的子堆都是有序的
        for (int i = arr.length/2-1; i >= 0; i --)  // 完全二叉树中最后一个有孩子的结点是 N/2-1
            maxHeapify(arr, i, arr.length);

		// 2. 堆排序
        for (int j = arr.length - 1; j > 0; j --) {
            swap(arr, 0, j);  // 堆首元素不断和堆尾元素交换位置，堆的大小减 1
            maxHeapify(arr, 0, j);  // 将去掉一个元素的新堆调整为最大堆（有序堆）
        }
    }

    /**
     * 从上到下有序化堆，使小于孩子的父结点下沉（sink）
     * @param arr 二叉堆
     * @param index 待调整的子堆的根结点
     * @param newSize 除了排序后的元素外，堆中剩余元素的个数
     */
    // 具体的堆化操作是从上到下完成的，而且一次堆化要求最多只有根结点相对于孩子结点是无序的，此外所有的子堆都是有序的
    private static void maxHeapify (Comparable[] arr, int index, int newSize){
        while (2 * index + 1 < newSize){  // 当前结点至少有左孩子
            int childIdx = 2 * index + 1;  // index 左孩子的下标
            // 存在右孩子，且右孩子比左孩子更大，则记录右孩子的下标
            if (childIdx + 1 < newSize && arr[childIdx].compareTo(arr[childIdx+1]) < 0) childIdx ++;
            if (arr[childIdx].compareTo(arr[index]) <= 0) break;  // 两个孩子均小于等于当前元素，则退出循环
            swap(arr, index, childIdx);
            index = childIdx;  // 当前不断跟新的孩子比较，跟其中一个较大的孩子交换位置
        }
    }

    private static void swap(Comparable[] arr, int i, int j){
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Test
    public void test(){
        Random random = new Random();
        int N = 20;
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i ++) arr[i] = random.nextInt(100);
        System.out.println(Arrays.toString(arr));
        Heap.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
```

---


## 参考
* [1] [算法-4](https://algs4.cs.princeton.edu/home/)
* [2] [数据结构与算法动态可视化](https://visualgo.net/zh/sorting)

