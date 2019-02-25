## 剑指offer合辑之面试41-67

>
> [《剑指offer》面试题 Java 代码的 Github 地址](https://github.com/li-yazhou/algorithm-primer/tree/master/interview-for-offer/src/main/java/algorithm/foroffer)
> 
> [《剑指offer》面试题 Markdown 版本，包含题目、分析及代码的 Github 地址](https://github.com/li-yazhou/algorithm-primer/tree/master/interview-for-offer/md)
>


## 面试题41 和为 s 的两个数字 VS 和为 s 的连续正数序列


>题目一：
     输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得他们的和正好是 s。
     如果有多对数字的和等于 s， 输出任意一对即可。
     例如，输入数组 {1, 2, 4, 7, 11, 15}和数字15，输出 4,7。
>
>题目二：
     输入一个正数 s，打印出所有和为 s 的连续正数序列（至少含有两个数）。
     例如输入 15，由于 1+2+3+4+5 = 4+5+6 = 7+8 = 15，
     所以结果打印出3个连续序列 1~5、4~6 和 7~8。

```
package algorithm.foroffer.top50;

import org.junit.Test;

import java.util.Arrays;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-01 21:19
 *
 * 面试题41：和为 s 的两个数字 VS 和为 s 的连续正数序列
 *
 * 题目一：
 *      输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得他们的和正好是 s。
 *      如果有多对数字的和等于 s， 输出任意一对即可。
 *      例如，输入数组 {1, 2, 4, 7, 11, 15}和数字15，输出 4,7。
 *
 * 考查点：
 *      1. 二叉查找的思想（对于排序数组，首先要想到二分查找，使用两个指针不断缩小范围）
 *
 * 思路：
 *      1. 使用两个指针，分别指向查找范围的最小值 min 和最大值 max
 *      2. 如果 min + max < sum，则 min 向后移动一位
 *         如果 min + max > sum，则 max 向前移动一位
 *         如果 min + max == sum，则输出 min, max，停止循环
 *
 *
 * 题目二：
 *      输入一个正数 s，打印出所有和为 s 的连续正数序列（至少含有两个数）。
 *      例如输入 15，由于 1+2+3+4+5 = 4+5+6 = 7+8 = 15，
 *      所以结果打印出3个连续序列 1~5、4~6 和 7~8。
 *
 * 考查点：
 *      1. 找规律
 *
 * 思路：
 *      1. 连续的数字序列之和正好，则返回该序列
 *         连续的数字序列之和较小，则从后面添加数字
 *         连续的数字序列之和较大，则从前面删除数字，
 *         （每添加一个较大的数字，可以能会删除若干个较小的数字，需要使用循环）
 *         循环条件是，最小值的下标minIdx小于 (sum+1)/2
 *
 */
public class Test41 {

    /**
     * 在数组 array 中查找一对和为 sum 的数字
     * @param array 数组
     * @param sum 两个数字之和
     * @return 如果存在，返回这对数字；不存在，返回 null
     */
    public int[] findTwoNum(int[] array, int sum){
        if (array == null || array.length < 2)  return null;

        int minIdx = 0;
        int maxIdx = array.length-1;

        while (minIdx < maxIdx){
            if (array[minIdx] + array[maxIdx] == sum)       return new int[]{array[minIdx], array[maxIdx]};
            else if (array[minIdx] + array[maxIdx] < sum)   minIdx ++;
            else                                            maxIdx --;
        }
        return null; // 违背单一出口原则，但是这种写法简洁，是适合刷题的写法
    }

    @Test
    public void test11(){
        int[][] arrs = {
                {1, 2, 4, 7, 11, 15},
        };

        int[] result = findTwoNum(arrs[0], 109);
        System.out.println(Arrays.toString(result));
    }


    public void findContinuousSequence(int sum){
        if (sum < 3) return;

        int small = 1;
        int big = 2;
        int middle = (sum + 1) / 2;
        int currSum = small + big;
        while (small < middle){
            if (currSum == sum) printSequence(small, big+1);

            // 每添加一个较大的数字，可以能会删除若干个较小的数字
            while (currSum > sum && small < middle){
                currSum -= small;
                small ++;
                if (currSum == sum) printSequence(small, big+1);
            }

            big ++;
            currSum += big;
        }
    }

    private void printSequence(int start, int end) {
        for (int i = start; i < end; i ++)
            System.out.print(i + "\t");
        System.out.println();
    }

    @Test
    public void test21(){
        findContinuousSequence(4);
    }

}

```



## 面试题42 翻转单词顺序 VS 左旋转字符串

> 题目一：
      输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
      为简单起见，标点符号和普通字母一样处理。
      例如输入字符串"I am a student."，则输出"student. a am I"。
>      
> 题目二：
     字符串的左悬殊操作是把字符串前面的若干个字符转移到字符串的尾部。
     请定义一个函数实现字符串左旋转操作的功能。
     比如输入字符串"abcdefg" 和数字 2，该函数将返回左旋转 2 位得到的结果"cdefgab"。

```
package algorithm.foroffer.top50;

import org.junit.Test;

import java.util.Arrays;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-02 14:57
 *
 * 面试题42：翻转单词顺序 VS 左旋转字符串
 *
 * 题目一：
 *      输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 *      为简单起见，标点符号和普通字母一样处理。
 *      例如输入字符串"I am a student."，则输出"student. a am I"。
 *
 * 考查点：
 *      1. 字符数组的操作
 *
 * 思路：
 *      Solution 1：
 *          以空格为 separator(delimiter)将字符串切分为字符串数组，
 *          逆序遍历字符串数组
 *      Solution 2:
 *          两次翻转字符串。
 *          首先，翻转整个字符串；
 *          然后，翻转每个单词。
 *
 * 题目二：
 *      字符串的左悬殊操作是把字符串前面的若干个字符转移到字符串的尾部。
 *      请定义一个函数实现字符串左旋转操作的功能。
 *      比如输入字符串"abcdefg" 和数字 2，该函数将返回左旋转 2 位得到的结果"cdefgab"。
 *
 * 考查点：
 *
 * 思路：
 *
 *
 */
public class Test42 {

    /**
     * 解法一，翻转单词顺序
     * @param chars 字符数组
     */
    public String reverseSequence(char[] chars){
        if (chars == null) return null;
        String sequence = new String(chars);
        String[] words = sequence.split(" ");
        StringBuilder sBuilder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sBuilder.append(words[i]).append(" ");
        }
        if (sBuilder.length() > 0) sBuilder.deleteCharAt(sBuilder.length()-1);
        return sBuilder.toString();
    }


    /**
     * 解法二：翻转单词顺序
     * @param chars 字符数组
     */
    public String reverseSequence2(char[] chars){
        if (chars == null) return null;

        // for (int i = 0; i < chars.length/2; i++) chars[i] = chars[chars.length-1-i];
        reverseString(chars, 0, chars.length);
        // System.out.println(new String(chars));

        int wordStartIdx = 0;
        int wordEndIdx = 0;
        for (int i = 0; i < chars.length; i++){
            if (chars[wordEndIdx] == ' '){
                reverseString(chars, wordStartIdx, wordEndIdx);
                // System.out.println(new String(chars));
                wordStartIdx = wordEndIdx + 1;
            }
            wordEndIdx ++;
        }
        return new String(chars);
    }

    private char[] reverseString(char[] chars, int startIdx, int endIdx){
        // System.out.printf("startIdx, endIdx = %d, %d\n", startIdx, endIdx);
        for (endIdx --; startIdx < endIdx; startIdx ++, endIdx --){
            char tmp = chars[startIdx];
            chars[startIdx] = chars[endIdx];
            chars[endIdx] = tmp;
        }
        return chars;
    }


    @Test
    public void test11(){
        String[] lines = {
                "I am a student.",
                "I",
                " ",
                "",
        };

        for(String line : lines){
            System.out.println("method 1: " + reverseSequence(line.toCharArray()));
            System.out.println("method 2: " + reverseSequence2(line.toCharArray()));
        }
    }


    /**
     * 方法一：字符数组中的前 k 个字符平移到末尾（辅助空间较大）
     * @param chars 字符数组
     * @param k 移动字符的数目
     * @return 移动之后的数组
     */
    public char[] mvHeadToTail(char[] chars, int k){
        if (chars == null || k >= chars.length-1 || k < 0) return chars;
        char[] tmpChars = new char[k];
        for (int i = 0; i < k; i ++) tmpChars[i] = chars[i];
        // 一步到位，但是需要长度的k的字符数组作为辅助空间
        // 当然，当 k 较大且空间复杂度限制时，可以考虑一次移动 m 个字符。
        for(int j = k; j < chars.length; j ++) chars[j-k] = chars[j];
        for(int i = 0; i < k; i ++) chars[chars.length - k + i] = tmpChars[i];
        return chars;
    }

    /**
     * 方法二：字符数组中的前 k 个字符平移到末尾（时间复杂较大）
     * @param chars 字符数组
     * @param k 移动字符的数目
     * @return 移动之后的数组
     */
    public char[] mvHeadToTail2(char[] chars, int k){
        if (chars == null || k >= chars.length-1 || k < 0) return chars;
        char tmp;
        for (int i = 0; i < k; i ++) {
            tmp = chars[0];
            for (int j = 1; j < chars.length; j++) chars[j-1] = chars[j];
            chars[chars.length-1] = tmp;
        }
        return chars;
    }

    @Test
    public void test21(){
        String[] lines = {
                "abcdefg",
                "string",
        };

        for (String line : lines){
            System.out.println(mvHeadToTail(line.toCharArray(), 2));
            System.out.println(mvHeadToTail2(line.toCharArray(), 2));
        }
    }
}

```


----------

左旋转字符串
2017-8-17 17:03:59

```
public String LeftRotateString(String str,int n) {
    if (str == null || str.length() == 0) return str;
    
    n = n % str.length();
    
    StringBuilder s = new StringBuilder(str);
    
    String substring = s.substring(0, n);
    
    s.delete(0, n).append(substring);
    
    return s.toString();
}
```


----------


反转单词顺序
2017-8-17 19:32:27

```
public String ReverseSentence(String str) {
    if (str == null || str.length() == 0) return str;
    
    if (str.trim().equals("")) return str;
    
    String[] words = str.split(" ");
    // if (words.length == 0) return str;  // "               " 的返回结果
    
    StringBuilder result = new StringBuilder();
    
    for (int i = words.length-1; i >= 0; i --)
        result.append(words[i]).append(" ");
        
    if (result.length() > 0)
        result.deleteCharAt(result.length()-1);
    
    return result.toString();
}
```






## 面试题43 n个骰子的点数 - null

> **题目：**
     把 n 个骰子仍在地上，所有骰子朝上一面的点数之和为 s。
     输入 n，打印出 s 的所有可能的值出现的次数。
     

```
package algorithm.foroffer.top50;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-02 19:35
 *
 * 面试题43：n个骰子的点数
 *
 * 题目：
 *      把 n 个骰子仍在地上，所有骰子朝上一面的点数之和为 s。
 *      输入 n，打印出 s 的所有可能的值出现的次数。
 *
 * 考查点：
 *      1. 数学建模能力
 *
 * 思路：
 *
 *
 */
public class Test43 {
}

```





## 面试题44 扑克牌的顺子

>**题目：**
>
>从扑克牌中随机抽 5 张牌，判断是不是顺子，即这 5 张牌是不是连续的。
2~10为数字本身， A 为 1，J 为 11，Q 为 12，K 为13，而大、小王可以看成任意数字。

```
package algorithm.foroffer.top50;

import org.junit.Test;

import java.util.*;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-02 20:12
 *
 * 面试题44：扑克牌的顺子
 *
 * 题目：
 *      从扑克牌中随机抽 5 张牌，判断是不是顺子，即这 5 张牌是不是连续的。
 *      2~10为数字本身， A 为 1，J 为 11，Q 为 12，K 为13，而大、小王可以看成任意数字。
 *
 * 考查点：
 *      1. 抽象建模能力
 *
 * 思路：
 *      1. 对非大小王的数字排序
 *             如果有相同的数字，则返回 false
 *             统计大、小王的数目(大小王初始化为0，区分其他的牌)
 *             计算相邻数字之间的差，相差为1，表示连续，相差大于 1，则不连续，统计相邻的牌空缺总数（大于大小王数目，返回 false）
 *
 *
 */
public class Test44 {

    public boolean isContinuous(int[] numbers){
        if (numbers == null || numbers.length != 5) return false;

        // 冒泡排序
        for (int i = 0; i < numbers.length; i ++){
            for (int j = i; j < numbers.length; j ++){
                // if (numbers[i] == numbers[j]) return false; // 存在相同的数字，不是顺子
                if (numbers[i] > numbers[j]){
                    int tmp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }

        // 统计大小王的个数
        int counter = 0;
        for (int i = 0; i < 2; i ++){
            if (numbers[i] == 0) counter ++;
        }

        int totalDiff = 0;
        for (int i = 1; i < numbers.length; i ++){
            if (numbers[i-1] == 0) continue; // 前一个数字是0，也即是小大王则跳过
            int diff = numbers[i] - numbers[i-1];
            if (diff == 0) return false;
            totalDiff += (diff - 1);
            if (totalDiff > counter) return false;
        }

        return totalDiff <= counter;
    }

    @Test
    public void test(){
        List<Integer> pokers = new ArrayList<>();
        for (int i = 0; i < 4; i ++){
            for (int j = 1; j < 14; j ++)
                pokers.add(j);
        }
        pokers.add(0);
        pokers.add(0);
        Collections.shuffle(pokers);

        for (int times = 0; times < 10; times ++) {
            int[] selectedPokers = new int[5];
            Random random = new Random();
            for (int i = 0; i < 5; i++)
                 selectedPokers[i] = pokers.get(random.nextInt(pokers.size()));

            boolean isContinuous = isContinuous(selectedPokers);
            System.out.println(Arrays.toString(selectedPokers) + ":\t" + isContinuous);
        }
    }


}

```


----------

逻辑更加清晰的代码

2017-8-17 20:15:19

```
public boolean isContinuous(int [] numbers) {
    if (numbers == null || numbers.length == 0) return false;
    
    // Arrays.sort(numbers， Comparator.reverseOrder());
    // Arrays.sort(numbers);
    
    for (int i = 0; i < numbers.length; i ++){
        int idx = i;
        for (int j = i+1; j < numbers.length; j ++){
            if (numbers[j] < numbers[idx])
                idx = j;
        }
        if (idx != i){
            int tmp = numbers[i];
            numbers[i] = numbers[idx];
            numbers[idx] = tmp;
        }
    }
    
    
    int timesOfZero = 0;
    for (int num : numbers){
        if (num == 0) timesOfZero ++;
        else		  break;
    }
    
    int diff = 0;
    for (int i = 1; i < numbers.length; i ++){
        if (numbers[i] == numbers[i-1] && numbers[i] != 0) return false;
        if (numbers[i-1] == 0 || numbers[i] == 0) continue;
        diff += numbers[i] - numbers[i-1] - 1;
    }
    
    boolean isContinuous = false;
    if (timesOfZero >= diff) isContinuous = true; 
    
    return isContinuous;
}
```





## 面试题45 圆圈中最后剩下的数字

>**题目：**
>
> 0, 1, 2, ..., n-1 这 n 个数字排成一个圆圈，从数字 0 开始每次从这个圆圈里删除第 m 个数字。
 求出这个圆圈里剩下的最后一个数字。

```
package algorithm.foroffer.top50;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-03 20:41
 * 面试题 46：圆圈中最后剩下的数字
 *
 * 题目：
 *      0, 1, 2, ..., n-1 这 n 个数字排成一个圆圈，从数字 0 开始每次从这个圆圈里删除第 m 个数字。
 *      求出这个圆圈里剩下的最后一个数字。
 *
 * 考查点：
 *      1. 约瑟夫环问题
 *
 * 思路：
 *      1. 圆形链表
 *
 *
 */
public class Test45 {

    public int lastRemainElement(int n, int m){
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i ++) list.add(i);

        int idx = 0;
        for (int i = 0; i < n-1; i ++){
            // for (int j = 0; j < m-1; j ++) idx ++;
            idx = idx + (m-1);
            idx = idx % list.size();
            list.remove(idx);
        }
        return list.get(0);
    }

    @Test
    public void test(){
        System.out.println(lastRemainElement(5, 3));
    }


}

```

使用数组求解
2017-8-17 21:30:30

```
 public int LastRemaining_Solution0(int n, int m) {
     if (n == 0 || m == 0) return -1;
     
     int[] arr = new int[n];  // 下标表示id
     int num = 0;  // 当前报数
     int idx = 0;  // 当前报数的id
     int counter = 0;  // 已经被删除的个数
     
     for (int i = 0; ; i ++){
         num = i % m;
         // idx = idx % n;
         if (num == m-1) {
             arr[idx] = -1;
             counter ++;
             if (counter == n-1) break;
         }
         
         
         // 查找下一个报数的id
         idx ++;
         if (idx == n) idx = 0;
         while (arr[idx] == -1){
             idx ++;
             if (idx == n) idx = 0;
         }

     }
     
     
     for (int j = 0; j < arr.length; j ++){
         if (arr[j] == 0) return j;
     }
     
     return -1;
 }
```






## 面试题46 求 1+2+3+...+n（不使用乘除以及条件判断语句求前 n 项正整数的和）

>**题目：**
>
>求 1+2+...+n。要求不能使用乘除法、for、while、if、else、switch、case等关键字
及条件判断语句。

```
package algorithm.foroffer.top50;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-03 21:36
 *
 * 面试题46：求 1+2+...+n
 *
 * 题目：
 *      求 1+2+...+n。要求不能使用乘除法、for、while、if、else、switch、case等关键字
 *      及条件判断语句。
 *
 * 考查点：
 *      1. 发散思维，使用对象数组初始化实现求和功能
 *
 * 思路：
 *      1. 不能使用公式法(*,/)，不能使用循环(for/while)、不能使用递归(if)
 *
 */

class Add{
    static int sum = 0;
    static int n = 0;
    public Add(){
        n ++;
        sum += n;
    }

    public static int sum(int n){
        // n = 0;
        // sum = 0;
        // 创建对象数组，仅仅是分配内存空间，不调用构造函数
        Add[] adds = new Add[n];
        return sum;
    }
}
public class Test46 {

    @Test
    public void test(){
        // int sum = Add.sum(5);
        // System.out.println(sum);
    }

    /**
     * 不用 if 判断递归终止条件的递归
     * @param n 参数
     * @return 和
     */
    public int sum(int n){
        int sum = n;
        boolean bool = (n > 0) && ((sum +=sum(n-1)) > 0);
        return sum;
    }

    @Test
    public void test2(){
        System.out.println(sum(5));
    }

}

```






## 面试题47 不用加减乘除做加法

>**题目：**
>
>写一个函数，求两个整数之和，要求在函数体内不得使用加减乘除四则运算。

```
package algorithm.foroffer.top50;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-03 22:01
 *
 * 面试题 47：不用加减乘除做加法
 *
 * 题目：
 *      写一个函数，求两个整数之和，要求在函数体内不得使用加减乘除四则运算。
 *
 * 考查点：
 *      1. 位运算
 *
 * 思路：
 *      比如计算 5 + 97，
 *      第一步，两个整数的各个对应为相加，每位相加产生的结果不进位。个位是 5 + 7 = 2，十位是 0 + 9 = 9，结果是 92
 *      第二步，只取各位相加产生的进位。个位相加 5 + 7，进位是 10，十位相加 0 + 9，进位是 0
 *      第三步，把第一步产生的不进位结果与第二步产生的所有的进位累加，结果即为所求。92 + 10 + 0 = 102
 *
 *      同理，使用这种方法对二进制数字计算也是成立的。
 *
 */
public class Test47 {

    public int add(int num1, int num2){
        int sum, carry;
        do{  // 从低位到高位循环做进位运算
            sum = num1 ^ num2;  // 不进位相加
            carry = (num1 & num2) << 1; // 进位产生的数字

            num1 = sum; // 加上一次进位数字的结果
            num2 = carry;  // 进的位数，在下一轮循环中，做不进位运算
        }while (num2 != 0);

        return num1;
    }

    @Test
    public void test(){
        System.out.println(add(12, 5));
        System.out.println(add(-12, 5));
        System.out.println(add(-12, -5));
        System.out.println(add(12, 0));
    }

}

```





## 剑指offer 面试题48 不能被继承的类

>**题目：**
>
>用 C++设计一个不能被继承的类。

```
package algorithm.foroffer.top50;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-04 19:49
 * 面试题 48：不能被继承的类
 *
 * 题目：
 *      用 C++设计一个不能被继承的类。
 *
 * 考查点：
 *      1. 类的继承性
 *
 * 思路：
 *      1. Java语言中，被 final 修饰的类不能被继承，如 String 等
 */

final class FinalClass{

}


public class Test48 /**extends FinalClass*/{
}

```





## 面试题49 把字符串转换成整数

> **题目：**
>
> 把字符串转换成整数

```
package algorithm.foroffer.top50;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-04 19:54
 *
 * 面试题 49：把字符串转换成整数
 *
 * 考查点：
 *      1. 细节。空字符串，空指针，正负号，前几个数字是0（没啥影响），超出表示范围
 *
 * 思路：
 *      1. 从低位往高位（从右往左）计算
 *
 *
 */
public class Test49 {

    public int strToInt(char[] chars){
        String str = String.valueOf(chars);
        return Integer.valueOf(str); // Integer.parseInt(str);
    }

    public int strToInt2(char[] chars){
        if (chars == null || chars.length == 0) throw new RuntimeException("Invalid input. chars can be null or length is 0.");

        int sign = 1;
        int start = 0;
        if (chars[0] == '-') {
            start = 1;
            sign = -1;
        }
        else if (chars[0] == '+') start = 1;

        return strToIntCore(chars, start, sign);
    }

    private int strToIntCore(char[] chars, int start, int sign) {
        // int value = (int)Math.pow(2, 31); 2147483647,已经强转，表示int型最大值

        long value = sign;
        int base = 1;
        for (int i = chars.length - 1; i >= start; i --){
            if (chars[i] < '0' || chars[i] > '9')
                throw new NumberFormatException(String.valueOf(chars, start, chars.length-start) + ", Invalid input. Element of chars should range from '0' to '9' ");
            // try {  intValue += (chars[i] - '0') * base;  }
            // catch(Exception except){  throw new RuntimeException("beyond the range of int");  }
            value += (chars[i] - '0') * base;
            if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE)
                throw new NumberFormatException(String.valueOf(chars, start, chars.length-start) + ", beyond the range of int");
            base *= 10;
        }
        return (int)value;
    }


    @Test
    public void test(){
        String[] strs = {
                "123",
                "-123",
                "-0",
                "+123",
                "+12345671111111110",
                "-12345611111111170",
        };
        for (String str : strs){
            System.out.println(strToInt2(str.toCharArray()));
            System.out.println(strToInt(str.toCharArray()));
        }
        // char[] chars = new char[0]; System.out.println(chars.length == 0);
    }
}
```


----------

2017-8-18 10:22:42


```
public int StrToInt(String str){
    if (str == null || "".equals(str.trim())) return 0;
    
    int flag = 1;
    int i = 0;
    if (str.charAt(0) == '-') {
        flag = -1;
        i = 1;
    } else if (str.charAt(0) == '+')
        i = 1;
    
    for (; i < str.length(); i ++){
        if (str.charAt(i) != '0') break;
    }
    
    int num = 0;
    int base = 1;
    char ch;
    for (int j = str.length()-1; j >= i; j --){
        ch = str.charAt(j);
        if (ch < '0' || ch > '9') return 0;
        num += (str.charAt(j)-'0') * base;
        base *= 10;
    }
     
    return num * flag;
    
}



public int StrToInt0(String str) {
    if (str == null || "".equals(str.trim())) return 0;
    int result = 0;
    try{
        result = Integer.valueOf(str);
    }catch (Exception e){
    }
    return result;
}
```






## 面试题50 树中两个结点的最低公共祖先

>**题目：**
>
> 给出一棵树的根结点和树中的两个结点，找到这两个结点的最低公共祖先结点。
> 如下面的树中，给出根结点0以及5和7两个结点，找到5、7的最低公共祖先，结果是1。
<pre>
            0
           / \
         1    2
       /  \
      3    4
    / \   / | \
   5  6  7  8  9
</pre>



```
package algorithm.foroffer.top50;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-04 21:26
 * 面试题 50：树中两个结点的最低公共祖先
 *
 * 考查点：
 *      1. 树的遍历
 *      2. 知识迁移能力，将问题转化为已有解决方法的问题
 *
 * 思路：
 *      1. 遍历树，找到根结点到指定结点的路径，是单向链表
 *      2. 从头到尾找到两条单向链表的最后一个公共结点
 *
 *
 *               0
 *              / \
 *            1    2
 *          /  \
 *         3    4
 *       / \   / | \
 *      5  6  7  8  9
 *
 */

class TreeNode{
    int             value;
    List<TreeNode> children = new ArrayList<>();
    public TreeNode(int _value){ value = _value; }
    public void addChild(TreeNode child){ children.add(child); }
    public void addChildren(TreeNode... children){
        for (TreeNode child : children) this.children.add(child);
    }

}

public class Test50 {

    /**
     * 找根结点到目标结点的路径
     * @param root 树的根结点
     * @param target 树中的一个结点
     * @param path 从根结点到目标结点的路径
     * @return 如果存在从根结点到目标结点的路径，则返回；否则返回 null
     *
     *
    private void getNodePath(TreeNode root, TreeNode target, List<TreeNode> path){
        if (root == null) return ;

        // 添加当前结点
        path.add(root);

        // 处理孩子结点
        for (TreeNode child : root.children){
            // System.out.println(child.value);  // 0	1	3	5	4	7	8	9	2
            if (child == target){
                System.out.println(child.value);
                path.add(child);
                return ;
            }else{
                System.out.println("---- " + child.value);
                getNodePath(child, target, path);
            }
        }

        // 恢复现场
        path.remove(path.size()-1);
        // 0	1	3	5	4	7	8	9	2
        // 0	1	3	5	6	4	7	2
    }

    */

    /**
     * 找根结点到目标结点的路径
     * @param root 树的根结点
     * @param target 树中的一个结点
     * @param path 从根结点到目标结点的路径
     * @return 如果存在从根结点到目标结点的路径，则返回；否则返回 null
     */
    private boolean getNodePath2(TreeNode root, TreeNode target, List<TreeNode> path){
        // 添加当前结点
        path.add(root);
        System.out.print(root.value + "\t");  //0	1	3	5	6	4	7

        if (root == target) return true;

        boolean found = false;

        // 处理孩子结点
        for (TreeNode child : root.children){
            found = getNodePath2(child, target, path);
            if (found) break;
        }
        
        // 以当前结点为根结点的子树中，不存在目标结点，则从路径中删除该结点
        if (!found) path.remove(path.size()-1);

        return found;
    }

    /**
     * 找两个链表的最后一个相同的结点
     * @param head1 链表一的头结点
     * @param head2 链表二的头结点
     * @return 两个链表的最后一个相同的结点
     */
    private TreeNode getLastCommonNode(List<TreeNode> head1, List<TreeNode> head2){
        for (int i = 1; i < head1.size() && i < head2.size(); i ++){
            if (head1.get(i).value != head2.get(i).value &&
                    head1.get(i-1).value == head2.get(i-1).value)
                return head1.get(i-1);
        }
        return null;
    }


    /**
     * 根据树的根结点和树中的两个结点，找到这两个结点的最低公共祖先结点
     * @param root 树的根结点
     * @param target1 树中结点1
     * @param target2 树中的结点2
     * @return 两个结点的最低公共祖先结点
     */
    public TreeNode getLastCommonParent(TreeNode root, TreeNode target1, TreeNode target2){
        if (root == null || target1 == null || target2 == null) return null;

        List<TreeNode> path1 = new ArrayList<>();
        getNodePath2(root, target1, path1);
        System.out.println();
        for(TreeNode node : path1) System.out.print(node.value + "\t");
        System.out.println();

        List<TreeNode> path2 = new ArrayList<>();
        getNodePath2(root, target2, path2);
        System.out.println();
        for(TreeNode node : path2) System.out.print(node.value + "\t");
        System.out.println();

        return getLastCommonNode(path1, path2);
    }


    @Test
    public void test(){
        TreeNode[] nodes = generateTree();
        TreeNode root = nodes[0];
        TreeNode target1 = nodes[1];
        TreeNode target2 = nodes[2];

        TreeNode lastCommonNode = getLastCommonParent(root, target1, target2);
        System.out.println("lastCommonNode.value = " + lastCommonNode.value);

    }


    /**
     *               0
     *              / \
     *            1    2
     *          /  \
     *         3    4
     *       / \   / | \
     *      5  6  7  8  9
     *
     */
    private TreeNode[] generateTree() {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        node0.addChildren(node1, node2);
        node1.addChildren(node3, node4);
        node3.addChildren(node5, node6);
        node4.addChildren(node7, node8, node9);

        return new TreeNode[]{node0, node5, node7};
    }


}

```






## 面试题51 数组中重复的数字

>**题目：**
> 
>在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
数组中某些数字是重复的，但不知道有几个数字重复了，也不知道
每个数字重复了几次。请找出数组中任意一个重复的数字。例如，
如果输入长度为 7 的数组 {2, 3, 1, 0, 2, 5, 3}，那么对应
的输出是重复的数字 2 或者 3。

```
package algorithm.foroffer.top60;

import org.junit.Test;

import java.util.Arrays;


/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-05 21:43
 * 面试题 51：数组中重复的数字
 *
 * 题目：
 *      在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 *      数组中某些数字是重复的，但不知道有几个数字重复了，也不知道
 *      每个数字重复了几次。请找出数组中任意一个重复的数字。例如，
 *      如果输入长度为 7 的数组 {2, 3, 1, 0, 2, 5, 3}，那么对应
 *      的输出是重复的数字 2 或者 3。
 *
 * 考查点：
 *
 * 思路：
 *      1. 方法一：
 *          时间复杂度小，需要辅助空间
 *          需要一个保存数字以及其出现次数的 map
 *      2. 方法二：
 *           时间复杂度高，空间复杂度是 O(1)
 *           两层循环遍历所有的数字
 *
 */
public class Test51 {

    public int findOneDuplicateDigit(int[] array){
        if (array == null || array.length == 0) throw new RuntimeException("Invalid input.");
        // Map<Integer, Integer> map = new HashMap<>();
        int[] entrys = new int[array.length];
        int result = -1;
        for (int i = 0; i < array.length; i++){
            entrys[array[i]] += 1;
            if (entrys[array[i]] > 1) {
                result = array[i];
                break;
            }
        }
        System.out.println(Arrays.toString(entrys));
        return result;
    }

    public int findOneDuplicateDigit2(int[] array){
        if (array == null || array.length == 0) throw new RuntimeException("Invalid input.");
        int result = -1;
        for (int i = 0; i < array.length; i ++){
            for (int j = i+1; j < array.length; j ++){
                if (array[i] == array[j]) return array[i];
            }
        }
        return result;
    }

    @Test
    public void test(){
        int[] array = {1, 2, 3, 5, 7, 2, 1, 3};
        System.out.println(findOneDuplicateDigit(array));
        System.out.println(findOneDuplicateDigit2(array));
    }
}

```


----------


更加高效的解法。
思路如下：
从头到尾遍历每一个数字，将以当前数字为下标的元素加 length，
当再次有跟这个下标一样的数字出现时，发现该下标处的元素大于 n-1，则这个数字出现了两次。

一个疑问，当被遍历到的数字大于length呢？
说明它的下标跟之前的数字相等，因此它的值被加 length。这是一个编码过程。
现在需要它的真实值，只需要 减去 length就可以得到它的原始值。

```
// Parameters:
//    numbers:     an array of integers
//    length:      the length of array numbers
//    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
//                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
//    这里要特别注意~返回任意重复的一个，赋值duplication[0]
// Return value:       true if the input is valid, and there are some duplications in the array number
//                     otherwise false

public boolean duplicate(int numbers[],int length,int [] duplication) {
    duplication[0] = -1;
    boolean valid = false;
     
    if (numbers == null) return valid;
    
    for (int i = 0; i < length; i ++){
        int index = numbers[i];

        if (index >= length)    // index 要表示原来数组中i位置处的元素
            index -= length;

        if (numbers[index] > length){    // numbers[index]已经被一个同样的值为index的元素修改过
            valid = true;
            duplication[0] = index;
            break;
        }

        numbers[index] += length;
    }
    
    return valid;
}
```






## 面试题52 构建乘积数组

>**题目：**
>
> 给定一个数组 A[0, 1, ..., n-1]，请构建一个数组 B[0, 1, ..., n-1]，
 其中 B 中的元素 B[i] = A[0] * A[1] * A[2] * ... * A[i+1] * A[i+2]。
 不能使用除法运算。

```
package algorithm.foroffer.top60;

import org.junit.Test;

import java.util.Arrays;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-06 17:36
 * 面试题52：构建乘积数组
 *
 * 题目：
 *      给定一个数组 A[0, 1, ..., n-1]，请构建一个数组 B[0, 1, ..., n-1]，
 *      其中 B 中的元素 B[i] = A[0] * A[1] * A[2] * ... * A[i+1] * A[i+2]。
 *      不能使用除法运算。
 *
 * 考查点：
 *      1. 找规律，提高计算速度
 *      2. 把计算过的，且以后会用到的数据保存起来，减少计算次数，提升执行效率
 *
 * 思路：
 *      1. B[i] = A[0] * A[1] * A[2] * ... * A[i+1] * A[i+2] * ... * A[n-1]
 *         可以定义，B[i] = C[i] + D[i]
 *         其中，C[i] = A[0] * A[1] * A[2] * ... * A[i-1],
 *         D[i] = A[i+1] * A[i+2] * ... * A[n-1]
 *              = A[n-1] * A[n-2] * ... * A[i+1]
 *
 *         则 B[i+1] = C[i+1] * D[i+1]，
 *         其中，C[i+1] = C[i] * A[i], D[i+1] = A[n-1] * A[n-2] * ... * A[i+2]
 *
 */
public class Test52 {

    public int[] multiply(int[] array){
        if (array == null || array.length == 0) return null;

        int[] multiArr = new int[array.length];
        multiArr[0] = 1;
        for (int i = 1; i < array.length; i ++)
            multiArr[i] = multiArr[i-1] * array[i-1];

        int tmp = 1;
        for (int i = array.length-2; i >= 0; i --){
            tmp *= array[i + 1];
            multiArr[i] *= tmp;
        }

        return multiArr;
    }

    @Test
    public void test(){
        int[] array = {1, 2, 3, 4, 5};
        int[] multiArr = multiply(array);
        System.out.println(Arrays.toString(multiArr));
    }
}

```






## 面试题55 字符流中第一个不重复的字符

> **题目：**
>
>请实现一个函数用来找出字符流中第一个只出现一次的字符。
例如，当从字符流中只读出前两个字符 "goo" 时，第一个只出现一次的字符是 "g"，
当从该字符串中读出前六个字符 "google" 时，第一个只出现一次的字符是 "l"。
```
package algorithm.foroffer.top60;

import org.junit.Test;


/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-18 10:51
 *
 * 题目：
 *      请实现一个函数用来找出字符流中第一个只出现一次的字符。
 *      例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"，
 *      当从该字符串中读出前六个字符 "google" 时，第一个只出现一次的字符是 "l"。
 *
 * 考查点：
 *      1. 字符串
 *
 * 思路：
 *      0。要做到：
 *          一、统计字符出现的次数；
 *          二、标记只出现一次的字符的先后位置
 *      1. 使用长度为 256 的整型数组，数组元素的值是字符出现的"先后顺序"，如果出现多次标记为-1，否则标记为 order
 *         (order初始值为 1，随输入的字符流个数增长)
 *      2. 查找最小 order 出现的位置，也即是数组中不为0或-1的所有元素中的最小值。即是最小的order，
 *         对应下标就是字符流中第一个只出现一次的字符。
 *
 */
public class Test55 {

    public char firstCharAppearingOnce(char[] chars){
        // if (chars == null || chars.length == 0) throw new IllegalArgumentException("Argument is illegal.");
        if (chars == null) throw new IllegalArgumentException("Argument is illegal.");

        int order = 1;
        int[] occurence = new int[256];
        for (int idx : chars)  {
            if (idx < 0 || idx > 255) throw new IllegalArgumentException();

            if (occurence[idx] == 0)  occurence[idx] = order;
            else                      occurence[idx] = -1;
            order ++;
        }

        char ch = '\0';
        int minFlag = chars.length + 1;
        for (int i = 0; i < occurence.length; i ++){
            if (occurence[i] >= 1 && occurence[i] < minFlag){
                ch = (char)i;
                minFlag = occurence[i];
            }
        }
        return ch;
    }


    @Test
    public void test(){
        String[] strings = {
                "",
                "g",
                "go",
                "goo",
                "goog",
                "googl",
                "google",
        };

        for (String string : strings){
            char[] chars = string.toCharArray();
            String line = String.format("%s :: %s", string, firstCharAppearingOnce(chars));
            System.out.println(line);
        }
    }
}

```





## 面试题56 链表中环的入口结点

> **题目：**
>
> 一个链表中包含环，如何找出环的入口结点？
 例如，在链表 1 -> 2 -> 3 -> 4 -> 5 -> 6，其中 6 指向3，
 则该链表中环的入口结点是 3。
 
 
```
package algorithm.foroffer.top60;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-18 14:17
 *
 * 面试题56：链表环的入口结点
 *
 * 题目：
 *      一个链表中包含环，如何找出环的入口结点？
 *      例如，在链表 1 -> 2 -> 3 -> 4 -> 5 -> 6，其中 6 指向3，
 *      则该链表中环的入口结点是 3。
 *
 * 考查点：
 *      1. 链表
 *
 * 思路：
 *      1. 转换问题，
 *              如果已知环中的结点总数，（需要先获得环中的一个结点）
 *              则可将问题转换为链表中倒数第 k 个结点。
 *      2. 首先找到环中的一个结点（重点），然后统计环中结点的个数，最后找到环的入口。
 *         a. 找到环中的一个结点，使用两个指针，它们均指向头结点，移动速度分别为 1 和 2，
 *            直到两个结点相遇，相遇处的结点就是环中的一个结点
 *            （使用慢指针和快指针找到环中的一个结点，快与慢指针）
 *         b. 移动其中的一个结点，直到该指针再次回到出发点，移动过程中统计出环中的结点的个数 k
 *         c. 使这个两个结点同时指向头结点，先移动其中的一个结点 k 步，然后以同样的速度移动两者，
 *            直到它们相遇，相遇处即是环的入口结点
 */

class Node{
    int value;
    Node next;
    public Node(int _value){ value = _value; }
    public void setNext(Node _next){ next = _next; }
    public Node next(){ return next; }
}
public class Test56 {

    public Node entranceNode(Node head){
        Node pointer1, pointer2;

        // a. 找到环中的一个结点
        // for (pointer1 = pointer2 = head;)
        for (pointer1 = head, pointer2 = head.next();
             pointer1 != pointer2;
             pointer1 = pointer1.next(), pointer2 = pointer2.next().next());

        // b. 统计环中结点的个数
        int counter = 1;
        for (pointer1 = pointer1.next(); pointer1 != pointer2; pointer1 = pointer1.next())
            counter ++;

        // c. 找到环中的入口结点，也即是求解链表中的倒数第 k 个结点
        pointer1 = pointer2 = head;
        for (int i = 0; i < counter; i++) pointer2 = pointer2.next();
        for (; pointer1 != pointer2; pointer1 = pointer1.next(), pointer2 = pointer2.next());

        return pointer1;
    }


    @Test
    public void test(){
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node0.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node2);

        Node entranceNode = entranceNode(node0);
        System.out.println(entranceNode.value);
    }
}

```





## 面试题57 删除链表中重复的结点

> **题目：**
>
> 在一个排序的链表中，如何删除重复的结点？
例如，链表 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5，
删除重复结点后为 1 -> 2 - > 3 -> 4 -> 5

```
package algorithm.foroffer.top60;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-18 15:12
 * 面试题57：删除链表中重复的结点
 *
 * 题目：
 *      在一个排序的链表中，如何删除重复的结点？
 *      例如，链表 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5，
 *      删除重复结点后为 1 -> 2 - > 3 -> 4 -> 5
 *
 * 考查点：
 *      1. 链表
 *
 * 思路：
 *      1. 如果当前结点跟后继结点相等，则将当前结点指向其后继结点的后继结点
 */

class Node57 {
    int value;
    Node57 next;
    public Node57 (int _value){ value = _value; }
    @Override
    public String toString(){
        return String.format("value = %s, next = %s", value, next == null ? null : next.value );
    }
}
public class Test57 {

    public Node57 deleteDuplication(Node57 head){
        for (Node57 currNode = head; currNode.next != null; currNode = currNode.next){
            if (currNode.value == currNode.next.value)
                currNode.next = currNode.next.next;
        }

        return head;
    }

    @Test
    public void test(){
        Node57 node0 = new Node57(0);
        Node57 node1 = new Node57(1);
        Node57 node2 = new Node57(2);
        Node57 node3 = new Node57(3);
        Node57 node4 = new Node57(3);
        Node57 node5 = new Node57(4);
        Node57 node6 = new Node57(4);
        Node57 node7 = new Node57(5);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        Node57 newHead = deleteDuplication(node0);
        for (; newHead != null; newHead = newHead.next)
            System.out.println(newHead.value);
    }
}

```


----------


面试题57：删除链表中重复的结点
题目：
     在一个排序的链表中，如何删除重复的结点？
     例如，链表 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5，
     删除重复结点后为 1 -> 2 -> 5

2017-8-19 20:49:45

```
 private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 双指针
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode dummyHead = new ListNode(-1);  // small trick，哑结点（头指针）
        dummyHead.next = pHead;

        ListNode first = dummyHead;  
        ListNode second = pHead;
        int currVal;

        while(second != null){
            currVal = second.val;
            // 情况一：当前结点跟后面的结点相等，则删除这些结点
            if (second.next != null && second.next.val == currVal){ 
                while (second != null && second.val == currVal){
                    second = second.next;
                }
                first.next = second;  // 此时只需要删除重复的元素，first不需要移动
            } else{  // 情况二：当前结点跟后面的结点不相等，则向后移动这两个指针
                // first.next = second;
                first = second;
                second = second.next;
            }
        }
        return dummyHead.next;
    }
```





## 面试题58 二叉树的下一个结点

> **题目：**
>
> 给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
> 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
> 例如，下图的中序遍历序列为 3, 1, 7, 4, 8, 0, 5, 2, 6。
<pre>
             0
           /   \
          1     2
         / \   / \
        3  4  5   6
          / \
         7   8
     </pre>

```
package algorithm.foroffer.top60;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-18 15:32
 *
 * 面试题58：二叉树的下一个结点
 *
 * 题目：
 *      给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 *      树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
 *      例如，下图的中序遍历序列为 3, 1, 7, 4, 8, 0, 5, 2, 6。
 *                  0
 *                /   \
 *               1     2
 *              / \   / \
 *             3  4  5   6
 *               / \
 *              7   8
 *
 *
 * 考查点：
 *      1. 二叉树的遍历
 *
 * 思路：
 *      1. 中序遍历序列，
 *         当前结点有右孩子，则其右子树的最左子结点即是下一个结点
 *         当前结点没有右孩子，而且是其父结点的左孩子，则其父结点即是下一个结点
 *         当前结点没有左孩子，而且是其父结点的右孩子，则其从下往上的祖先结点中是左孩子的结点即是下一个结点，可能不存在
 *
 */

class Node58{
    int value;
    Node58 parent;
    Node58 left;
    Node58 right;

    public Node58(int _value){ value = _value; }
    public void setParentAndChildren(Node58 _parent, Node58 _left, Node58 _right){
        parent = _parent;
        left = _left;
        right = _right;
    }
    @Override
    public String toString(){
        return String.format("value = %s", value);
    }
}
public class Test58 {

    public Node58 nextNode(Node58 node){
        if (node == null) return null;
        Node58 next = null;

        if (node.right != null){   // 当前结点有右孩子，则下一个结点是其右子树的最左子结点
            Node58 currNode = node.right;
            for (; currNode.left != null; currNode = currNode.left);
            next = currNode;
        } else if (node.parent != null){ // 当前结点没有右孩子，但存在父结点
            Node58 parentNode = node.parent;   // 初始默认当前结点是其父结点的左孩子，则下一个结点就是其父结点
            Node58 currNode = node;
            // 若当前结点是父结点的右孩子，则一直向上遍历，直到遇到其祖先结点是一个左孩子的情况
            // 该祖先结点的父结点的左子树已被遍历完成，则中序遍历的下一个结点就是其父结点
            while (parentNode != null && currNode == parentNode.right){
                currNode = parentNode;
                parentNode = parentNode.parent;
            }
            next = parentNode;
        }

        return next;
    }


    @Test
    /**
     *                  0
     *                /   \
     *               1     2
     *              / \   / \
     *             3  4  5   6
     *               / \
     *              7   8
     *
     * 其中序遍历序列为 3, 1, 7, 4, 8, 0, 5, 2, 6。
     */
    public void test(){
        Node58 node0 = new Node58(0);
        Node58 node1 = new Node58(1);
        Node58 node2 = new Node58(2);
        Node58 node3 = new Node58(3);
        Node58 node4 = new Node58(4);
        Node58 node5 = new Node58(5);
        Node58 node6 = new Node58(6);
        Node58 node7 = new Node58(7);
        Node58 node8 = new Node58(8);

        node0.setParentAndChildren(null, node1, node2);
        node1.setParentAndChildren(node0, node3, node4);
        node2.setParentAndChildren(node0, node5, node6);
        node3.setParentAndChildren(node1, null, null);
        node4.setParentAndChildren(node1, node7, node8);
        node5.setParentAndChildren(node2, null, null);
        node6.setParentAndChildren(node2, null, null);
        node7.setParentAndChildren(node4, null, null);
        node8.setParentAndChildren(node4, null, null);

        System.out.println(0 + " -> " + nextNode(node0));
        System.out.println(1 + " -> " + nextNode(node1));
        System.out.println(2 + " -> " + nextNode(node2));
        System.out.println(3 + " -> " + nextNode(node3));
        System.out.println(4 + " -> " + nextNode(node4));
        System.out.println(5 + " -> " + nextNode(node5));
        System.out.println(6 + " -> " + nextNode(node6));
        System.out.println(7 + " -> " + nextNode(node7));
        System.out.println(8 + " -> " + nextNode(node8));

        /**
         0 -> value = 5
         1 -> value = 7
         2 -> value = 6
         3 -> value = 1
         4 -> value = 8
         5 -> value = 2
         6 -> null
         7 -> value = 4
         8 -> value = 0
         */
    }
}

```





## 面试题59 对称的二叉树

<pre>题目：
请实现一个函数，用来判断一颗二叉树是不是对称的。
如果一棵二叉树和它的镜像一样，那么它是对称的。
例如，下图中第一棵二叉树是对称的，另外两棵不是。
       8                  8                 7
     /   \              /   \             /   \
    6     6            6     9           7     7
   / \   / \          / \   / \         / \   /
  5  7  7   5        5  7  7   5       7  7  7
</pre>

```
package algorithm.ac.foroffer.top60;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-18 19:48
 *
 * 面试题59：对称的二叉树
 *
 * 题目：
 *      请实现一个函数，用来判断一颗二叉树是不是对称的。
 *      如果一棵二叉树和它的镜像一样，那么它是对称的。
 *      例如，下图中第一棵二叉树是对称的，另外两棵不是。
 *             8                  8                 7
 *           /   \              /   \             /   \
 *          6     6            6     9           7     7
 *         / \   / \          / \   / \         / \   /
 *        5  7  7   5        5  7  7   5       7  7  7
 *
 * 考查点：
 *      1. 二叉树前序遍历的应用，先遍历左子树的前序遍历和先遍历右子树的前序遍历
 *      2. 对于像第三棵树这样的特殊情况，需要考虑叶子结点的孩子 null 才能，这一点至关重要
 *
 * 思路：
 *      1.二叉树的前序遍历和对称前序遍历
 *
 */

class BinTreeNode59{
    int value;
    BinTreeNode59 left;
    BinTreeNode59 right;

    public BinTreeNode59 (int _value){ value = _value; }
    public void setChildren (BinTreeNode59 _left, BinTreeNode59 _right){
        left = _left;
        right = _right;
    }
}
public class Test59 {

    public boolean isSymmetrical (BinTreeNode59 root){
        return isSymmetrical (root, root);
    }

    public boolean isSymmetrical (BinTreeNode59 root1, BinTreeNode59 root2){
        if (root1 == null && root2 == null) return true;  // 唯一正确的出口

        // 一般情况下，不这么表示两者只有一个为空，但有上一句的限制，则可以使用
        if (root1 == null || root2 == null) return false;

        if (root1.value != root2.value) return false;

        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }


    @Test
    /**
     *             8          
     *           /   \        
     *          6     6       
     *         / \   / \      
     *        5  7  7   5     
     */
    public void test(){
        BinTreeNode59 node0 = new BinTreeNode59(8);
        BinTreeNode59 node1 = new BinTreeNode59(6);
        BinTreeNode59 node2 = new BinTreeNode59(6);
        BinTreeNode59 node3 = new BinTreeNode59(5);
        BinTreeNode59 node4 = new BinTreeNode59(7);
        BinTreeNode59 node5 = new BinTreeNode59(7);
        BinTreeNode59 node6 = new BinTreeNode59(5);

        node0.setChildren(node1, node2);
        node1.setChildren(node3, node4);
        node2.setChildren(node5, node6);

        System.out.println(isSymmetrical(node0));
    }

    @Test
    /**
     *          8
     *        /   \
     *       6     9
     *      / \   / \
     *     5  7  7   5
     */
    public void test1(){
        BinTreeNode59 node0 = new BinTreeNode59(8);
        BinTreeNode59 node1 = new BinTreeNode59(6);
        BinTreeNode59 node2 = new BinTreeNode59(9);
        BinTreeNode59 node3 = new BinTreeNode59(5);
        BinTreeNode59 node4 = new BinTreeNode59(7);
        BinTreeNode59 node5 = new BinTreeNode59(7);
        BinTreeNode59 node6 = new BinTreeNode59(5);

        node0.setChildren(node1, node2);
        node1.setChildren(node3, node4);
        node2.setChildren(node5, node6);

        System.out.println(isSymmetrical(node0));
    }

    @Test
    /**
     *          7
     *        /   \
     *       7     7
     *      / \   /
     *     7  7  7
     */
    public void test2(){
        BinTreeNode59 node0 = new BinTreeNode59(7);
        BinTreeNode59 node1 = new BinTreeNode59(7);
        BinTreeNode59 node2 = new BinTreeNode59(7);
        BinTreeNode59 node3 = new BinTreeNode59(7);
        BinTreeNode59 node4 = new BinTreeNode59(7);
        BinTreeNode59 node5 = new BinTreeNode59(7);

        node0.setChildren(node1, node2);
        node1.setChildren(node3, node4);
        node2.setChildren(node5, null);

        System.out.println(isSymmetrical(node0));
    }


}

```





## 面试题60 把二叉树打印成多行

> **题目：**
>    从上到下按层打印二叉树，同一层的结点按从左到右顺序打印，
>    每一层打印到一行。例如下面的二叉树的结果为：
<pre> 
                8
               / \
              6  10
            / \  / \
           5  7 9  11
           
     结果为：
     8
     6 10
     5 7 9 11
</pre>

```
package algorithm.foroffer.top60;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-08 17:24
 *
 * 面试题60：把二叉树打印为多行
 *
 * 题目：
 *      从上到下按层打印二叉树，同一层的结点按从左到右顺序打印，
 *      每一层打印到一行。例如下面的二叉树的结果为：
 *                  8
 *                 / \
 *                6  10
 *              / \  / \
 *             5  7 9  11
 *
 *       结果为：
 *       8
 *       6 10
 *       5 7 9 11
 *
 * 考查点：
 *      1. 树的层次遍历，属于广度优先遍历，使用的数据结构是队列
 *
 * 思路：
 *      1. 队列，
 *      2. 两个辅助变量，一个变量保存当前层还没有打印的结点数，
 *         另一个变量保存下一层结点的数目
 *
 */

class BinTreeNode{
    int value;
    BinTreeNode left;
    BinTreeNode right;
    public BinTreeNode(int _value){ value = _value; }
    public void setChildren(BinTreeNode _left, BinTreeNode _right){
        left = _left;
        right = _right;
    }
}
public class Test60 {

    public void printBinTree(BinTreeNode root){
        if (root == null) return;

        Queue<BinTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int nextLevel = 0;
        int thisLevel = 1;

        while (!queue.isEmpty()){
            BinTreeNode currNode = queue.poll();

            if (currNode.left != null){
                queue.offer(currNode.left);
                nextLevel ++;
            }

            if (currNode.right != null){
                queue.offer(currNode.right);
                nextLevel ++;
            }


            System.out.print(currNode.value + "\t");
            thisLevel --;

            if (thisLevel == 0){
                System.out.println();
                thisLevel = nextLevel;
                nextLevel = 0;
            }
        }
    }

    @Test
    public void test(){
        BinTreeNode node8 = new BinTreeNode(8);
        BinTreeNode node6 = new BinTreeNode(6);
        BinTreeNode node10 = new BinTreeNode(10);
        BinTreeNode node5 = new BinTreeNode(5);
        BinTreeNode node7 = new BinTreeNode(7);
        BinTreeNode node9 = new BinTreeNode(9);
        BinTreeNode node11 = new BinTreeNode(11);

        node8.setChildren(node6, node10);
        node6.setChildren(node5, node7);
        node10.setChildren(node9, node11);

        printBinTree(node8);
    }
}

```





## 面试题61 按之字形顺序打印二叉树

<pre>题目：
请实现一个函数按照之字型顺序打印二叉树，即第一行按照从左到右的顺序打印，
第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
例如：按之字形顺序打印下面的二叉树的结果为：
1
3  2
4  5  6 7
15 14 13 12 11 10 9 8

             1
         /       \
       2          3
     /  \        /   \
    4    5      6     7
  / \   / \    / \   / \
 8  9  10 11  12 13 14 15
</pre>
```
package algorithm.ac.foroffer.top70;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;


/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-19 8:37
 *
 * 题目：
 *      请实现一个函数按照之字型顺序打印二叉树，即第一行按照从左到右的顺序打印，
 *      第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *      例如：按之字形顺序打印下面的二叉树的结果为：
 *      1
 *      3  2
 *      4  5  6 7
 *      15 14 13 12 11 10 9 8
 *
 *               1
 *           /       \
 *         2          3
 *       /  \        /   \
 *      4    5      6     7
 *    / \   / \    / \   / \
 *   8  9  10 11  12 13 14 15
 *
 * 考查点：
 *      1. 层次遍历（广度优先遍历）不使用递归
 *      2. 栈的应用
 *
 * 思路：
 *      1. 使用两个栈协同工作
 *      2. 当遍历到奇数层时，先保存其右孩子到栈中，再保存其左孩子
 *         当遍历到偶数层时，先保存其左孩子到栈中，再保存其右孩子
 *         （打印后的元素立刻出栈，则刚进入到一个新的层时，其中的一个栈是空的，将新层中的元素的孩子保存到这个空栈中）
 *
 *
 */

class BinTreeNode61{
    int value;
    BinTreeNode61 left;
    BinTreeNode61 right;
    public BinTreeNode61 (int _value){ value = _value; }
    public void setChildren(BinTreeNode61 _left, BinTreeNode61 _right){
        left = _left;
        right = _right;
    }

}

public class Test61 {

    public void snakePrint(BinTreeNode61 root){
        if (root == null) return;

        LinkedList<BinTreeNode61> stack1 = new LinkedList<>();  // 保存奇数层的元素
        LinkedList<BinTreeNode61> stack2 = new LinkedList<>();  // 保存偶数层的元素
        // LinkedList[] stacks = new LinkedList[2]; 分析结合使用泛型和数组可能会带来的问题，为什么不能？
        int current = 1;  // 1 表示奇数层，0 表示偶数层
        // int next = 2;

        stack1.push(root);
        LinkedList<BinTreeNode61> currStack;
        LinkedList<BinTreeNode61> nextStack;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            currStack = current == 1 ? stack1 : stack2;  // 选取奇数层或者偶数层为当前层，以访问该层的元素
            nextStack = current == 1 ? stack2 : stack1;  // 选取奇数层或者偶数层为下一层，以存放当前层元素的孩子

            BinTreeNode61 node = currStack.pop();  // 访问当前层的元素，栈顶元素
            System.out.print(node.value + "\t");   // System.out.print(node.value + '\t');

            if (current == 1){  // 若当前层是奇数层，则先保存左孩子，再保存右孩子
                if (node.left != null) nextStack.push(node.left);
                if (node.right != null) nextStack.push(node.right);
            }
            else{  // 若当前层是偶数层，则先保存右孩子，再保存左孩子
                if (node.right != null) nextStack.push(node.right);
                if (node.left != null) nextStack.push(node.left);
            }

            // 当前层的元素被打印完毕，则换行，
            // 并将当前行设置为下一行，也即是若当前行是奇数层，则设置为偶层数，反之，设置为奇数层。
            if (currStack.isEmpty()){
                System.out.println();
                // int tmp = current;  current = next;  next = tmp;
                current = current == 0 ? 1 : 0;
            }
        }
    }


    @Test
    public void test(){
        BinTreeNode61 node1 = new BinTreeNode61(1);
        BinTreeNode61 node2 = new BinTreeNode61(2);
        BinTreeNode61 node3 = new BinTreeNode61(3);
        BinTreeNode61 node4 = new BinTreeNode61(4);
        BinTreeNode61 node5 = new BinTreeNode61(5);
        BinTreeNode61 node6 = new BinTreeNode61(6);
        BinTreeNode61 node7 = new BinTreeNode61(7);
        BinTreeNode61 node8 = new BinTreeNode61(8);
        BinTreeNode61 node9 = new BinTreeNode61(9);
        BinTreeNode61 node10 = new BinTreeNode61(10);
        BinTreeNode61 node11 = new BinTreeNode61(11);
        BinTreeNode61 node12 = new BinTreeNode61(12);
        BinTreeNode61 node13 = new BinTreeNode61(13);
        BinTreeNode61 node14 = new BinTreeNode61(14);
        BinTreeNode61 node15 = new BinTreeNode61(15);

        node1.setChildren(node2, node3);
        node2.setChildren(node4, node5);
        node3.setChildren(node6, node7);
        node4.setChildren(node8, node9);
        node5.setChildren(node10, node11);
        node6.setChildren(node12, node13);
        node7.setChildren(node14, node15);

        snakePrint(node1);
    }
}

```


----------

类比面试题60 把二叉树打印成多行，可以得到一个更加直观更加简单的方法

2017-8-20 08:46:16

```
import java.util.ArrayList;
import java.util.*;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

}
*/
public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lines = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) return lines;
        
        ArrayList<Integer> line = new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        
        TreeNode currNode;
        int thisLevel = 1;
        int nextLevel = 0;
        
        int level = 1;
        
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while(!queue.isEmpty()){
            currNode = queue.poll();
            if (currNode.left != null) {
                queue.offer(currNode.left);
                nextLevel ++;
            }
            if (currNode.right != null) {
                queue.offer(currNode.right);
                nextLevel ++;
            }
            
            if (level % 2 == 1) line.add(currNode.val);
            else			    stack.push(currNode.val);
            
            thisLevel --;
            if (thisLevel == 0){
                if (level % 2 == 0){
                    while (!stack.isEmpty()){
                        line.add(stack.pop());
                    }
                    
                }
                lines.add(line);
                line = new ArrayList<Integer>();
                thisLevel = nextLevel;
                nextLevel = 0;
                level ++;
            }
        }
        return lines;
    }
}
```





## 面试题62 序列化和反序列化二叉树

>**题目：**
>
>请实现两个函数，分别用来序列化和反序列化二叉树。


```
package algorithm.ac.foroffer.top70;

import org.junit.Test;

import java.util.LinkedList;


/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-19 11:08
 *
 * 面试题62：序列化二叉树
 *
 * 题目：
 *      请实现两个函数，分别用来序列化和反序列化二叉树。
 *                    1
 *                  /  \
 *                2     3
 *               /     / \
 *              4     5  6
 *
 * 考查点：
 *      1. 二叉树
 *
 * 思路：
 *      1. 序列化二叉树，采用前序遍历的方式
 *            而且要保证任何结点均有两个孩子，若没有孩子或者只有一个孩子，则将缺失的孩子设置为 null
 *      2. 反序列化二叉树，
 *
 */

class BinTreeNode62{
    int value;
    BinTreeNode62 left;
    BinTreeNode62 right;
    public BinTreeNode62(){}
    public BinTreeNode62 (int _value){ value = _value; }
    public void setChildren(BinTreeNode62 _left, BinTreeNode62 _right){
        left = _left;
        right = _right;
    }

}

public class Test62 {

    /**
     * 序列化二叉树
     * @param root 二叉树的根结点
     * @return 序列化后的字符串
     */
    public String serializeToString(BinTreeNode62 root){
        if (root == null) return null;
        String[] sequence = new String[]{""};
        serializeToString(root, sequence);
        return sequence[0].substring(1);
    }

    private void serializeToString(BinTreeNode62 root, String[] sequence){
        if (root == null) {
            sequence[0] += ",#";
            return;
        }
        else sequence[0] += ("," + root.value);

        serializeToString(root.left, sequence);
        serializeToString(root.right, sequence);
    }


    /**
     * 反序列化二叉树
     * @param sequence 序列化后的二叉树
     * @return 二叉树的根结点
     */
    public BinTreeNode62 deserializeToBinTree(String sequence){
        if (sequence == null || sequence.length() == 0) return null;
        String[] values = sequence.split(",");
        return deserializeToBinTree(values, new int[]{0});
    }

    private BinTreeNode62 deserializeToBinTree(String[] values, int[] index) {
        String value = values[index[0]++];
        BinTreeNode62 root = null;
        if (value.matches("[0-9]+")){
            root = new BinTreeNode62();
            root.value = Integer.valueOf(value);

            // System.out.println(root.value);

            root.left = deserializeToBinTree(values, index);
            root.right = deserializeToBinTree(values, index);
        }
        return root;
    }


    @Test
    public void test(){
        BinTreeNode62 node1 = new BinTreeNode62(1);
        BinTreeNode62 node2 = new BinTreeNode62(2);
        BinTreeNode62 node3 = new BinTreeNode62(3);
        BinTreeNode62 node4 = new BinTreeNode62(4);
        BinTreeNode62 node5 = new BinTreeNode62(5);
        BinTreeNode62 node6 = new BinTreeNode62(6);

        node1.setChildren(node2, node3);
        node2.setChildren(node4, null);
        node3.setChildren(node5, node6);

        String sequence = serializeToString(node1);
        System.out.println(sequence);  // 1,2,4,#,#,#,3,5,#,#,6,#,#

        BinTreeNode62 root = deserializeToBinTree(sequence);
        System.out.println("-------------------");
        System.out.println(root.value);
        System.out.println(root.left.value);
        System.out.println(root.left.left.value);
        System.out.println(root.right.value);
        System.out.println(root.right.left.value);
        System.out.println(root.right.right.value);

        LinkedList<BinTreeNode62> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            BinTreeNode62 node = queue.poll();
            System.out.print(node.value + "\t");
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

    }

}

```




## 面试题63 二叉搜索树的第 k 个结点

<pre>题目：
    给定一棵二叉搜索树，请找出其中的第 k 大的结点。
    例如下面的二叉树中，按结点数值大小升序顺序，第三个结点的值是 7。
                 8
                / \
               6  10
             / \  / \
            5  7 9  11
</pre>

```
package foroffer.top70;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-08 19:42
 * 面试题63：二叉搜索树的第 k 个结点
 *
 * 题目：
 *      给定一棵二叉搜索树，请找出其中的第 k 大的结点。
 *      例如下面的二叉树中，按结点数值大小升序顺序，第三个结点的值是 7。
 *                  8
 *                 / \
 *                6  10
 *              / \  / \
 *             5  7 9  11
 *
 * 考查点：
 *      1. 二叉搜索树
 *      2. 二叉树的中序遍历
 *      3. 递归，递归中状态变量的设置
 */


class BinTreeNode{
    int value;
    BinTreeNode left;
    BinTreeNode right;
    public BinTreeNode(int _value){ value = _value; }
    public void setChildren(BinTreeNode _left, BinTreeNode _right){
        left = _left;
        right = _right;
    }
}


public class Test63 {

    public BinTreeNode kthNode(BinTreeNode root, int[] k){
        BinTreeNode kthNode = null;
        if (root.left != null) kthNode = kthNode(root.left, k);  // 左子树的遍历
        // System.out.println("--------" + k[0]);
        if (kthNode == null){  // 中序遍历的操作
            k[0] --;
            if (k[0] == 0) kthNode = root;
        }
        if (kthNode == null && root.right != null)  // 右子树的遍历
            kthNode = kthNode(root.right, k);
        return kthNode;
    }


    @Test
    public void test(){
        BinTreeNode node8 = new BinTreeNode(8);
        BinTreeNode node6 = new BinTreeNode(6);
        BinTreeNode node10 = new BinTreeNode(10);
        BinTreeNode node5 = new BinTreeNode(5);
        BinTreeNode node7 = new BinTreeNode(7);
        BinTreeNode node9 = new BinTreeNode(9);
        BinTreeNode node11 = new BinTreeNode(11);

        node8.setChildren(node6, node10);
        node6.setChildren(node5, node7);
        node10.setChildren(node9, node11);

        BinTreeNode node = kthNode(node8, new int[]{3});
        System.out.println(node.value);
    }
}

```




## 面试题64 数据流中的中位数

> **题目：**
>
> 如何得到一个数据流中的中位数？
 如果从数据流中读出期数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

```
package algorithm.ac.foroffer.top70;

import org.junit.Test;

import java.util.*;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-19 16:26
 *
 * 面试题64：数据流中的中位数
 *
 * 题目：
 *      如何得到一个数据流中的中位数？
 *      如果从数据流中读出期数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 *      如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 考查点：
 *      1. 查找
 *      2. 最大堆和最小堆
 *
 * 思路：
 *      1. 将数据流中的数据保存到两个容器中，这两个容器需要满足以下的条件：
 *            a. 保证一个容器中的最大值不大于另一个容器中的最小值
 *            b. 保证两个容器中的元素个数相差 0 或者 1
 *            c. 存放较小值的容器能够快读获取到最大值，存放较大值的容器能够快速获取到最小值
 *      2. 这个数据结构就是最大堆和最小堆
 *      3. 步骤：
 *            当新输入一个数据时，
 *            若两个容器中元素的总数目是偶数，
 *              则将最大堆中的最大值和当前值中较大值保存到最小堆中，较小者保存到最大堆中。
 *              （为了保证一个容器中的最大值不大于另一个容器中的最小值）
 *            若两个容器中元素的总数目是奇数，
 *              则将最小堆中的最小值和当前值中的较小者保存到最大堆中，较大者保存到最小堆中。
 *              （为了保证一个容器中的最大值不大于另一个容器中的最小值）
 *            通过对两个容器中总元素个数的判断，控制新的数据保存到哪一个堆中，实现了两个容器中元素个数相差为 0 或者 1。
 *            此时，已然满足了 1 中的 a、b 和 c 三个条件。
 *
 *
 *
 */
public class Test64 {
    private Queue<Integer> minHeap = new PriorityQueue<>();
    // Comparator<Integer> reverse = new Comparator<Integer>(){
    //    @Override public int compare(Integer obj1, Integer obj2){ return obj2 - obj1; }
    // };
    private Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public void insert(int num){
        if (((minHeap.size() + maxHeap.size()) & 1) == 0){ // 数字的总数为偶数，将新的数据插入到最小堆中（最小堆中保存的都是较大的数字）
            // 若当前值最大堆中的最大值小，则将当前数字和最大数字交换（为了保证最大堆的最大值始终不大于最小堆中的最小值）
            // 即，将当前数字保存到最大堆中，将最大堆中的最大数字弹出并保存到最小堆中
            if (maxHeap.size() > 0 && num < maxHeap.peek()){
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        }
        else{  // 数字的总数为奇数，将新的数据插入到最大堆中（最大堆中保存的都是较小的数字）
            // 若当前值比最小堆中的最小值大，则将当前数字和最小值交换（为了保证最大堆中的最大值始终不大于最小堆中的最小值）
            // 即，将当前数字存放到最小堆中，将最小堆中的最小数字弹出并保存到最大堆中
            if (minHeap.size() > 0 && num > minHeap.peek()){
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }


    public double getMedain(){
        int size = minHeap.size() + maxHeap.size();
        if (size == 0) throw new IllegalArgumentException("Argument is illegal.");
        double medain = -1;
        if ((size & 1) == 1) medain = minHeap.peek();
        else                 medain = (minHeap.peek() + maxHeap.peek()) / 2.0;
        return medain;
    }

    @Test
    public void test(){
        Random random = new Random();
        int N = 10;
        for (int i = 0; i < N; i ++)  insert(random.nextInt(100));

        for (int i = 0; i < 5; i ++) {
            insert(random.nextInt(100));
            System.out.println("maxHeap : " + maxHeap);
            System.out.println("minHeap : " + minHeap);
            System.out.println(getMedain());
            System.out.println();
        }
    }
}

```

测试结果：
```
maxHeap : [53, 33, 42, 4, 28]
minHeap : [55, 76, 64, 99, 91, 92]
55.0

maxHeap : [53, 33, 42, 4, 28, 2]
minHeap : [55, 76, 64, 99, 91, 92]
54.0

maxHeap : [42, 33, 16, 4, 28, 2]
minHeap : [53, 76, 55, 99, 91, 92, 64]
53.0

maxHeap : [42, 33, 16, 4, 28, 2, 16]
minHeap : [53, 76, 55, 99, 91, 92, 64]
47.5

maxHeap : [42, 33, 16, 4, 28, 2, 16]
minHeap : [53, 70, 55, 76, 91, 92, 64, 99]
53.0
```





# 面试题65 滑动窗口的最大值

> **题目：**
>
>   给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
     例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小 3，
     那么移动存在 6 个滑动窗口，它们的最大值分别为 {4, 4, 6, 6, 6, 5}。

```
package foroffer.top70;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-19 20:53 // 2017-8-21 10:46:30
 *
 * 面试题65：滑动窗口的最大值
 *
 * 题目：
 *      给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
 *      例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小 3，
 *      那么移动存在 6 个滑动窗口，它们的最大值分别为 {4, 4, 6, 6, 6, 5}。
 *
 * 考查点：
 *      1. 双端队列的应用
 *
 * 思路：
 *      1. 新的元素比队列中的任何元素都大，则清空队列，并将其添加到队尾
 *      2. 新的元素比队尾中的元素小，则将其添加到队尾
 *      3. 新的元素比队尾元素大，但是比队首元素小，则将比其小的元素移出队列，然后将其添加到队尾。（从队尾删除元素）
 *
 *      怎么控制窗口的大小呢？
 *          队列里面存放的是下标，
 *          插入元素之前，先判断尾首下标之差是否等于 n-1，如果是，则将队首元素移出队列
 *
 *
 * Deque的12种方法总结如下：
 * 	                   First Element (Head)	                      Last Element (Tail)
 *              Throws exception	Special value	        Throws exception	Special value
 *  Insert	      addFirst(e)	     offerFirst(e)	            addLast(e)	     offerLast(e)
 *  Remove	      removeFirst()      pollFirst()     	        removeLast()	 pollLast()
 *  Examine	      getFirst()	     peekFirst()	            getLast()	     peekLast()
 *
 */
public class Test65 {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length == 0 || size < 1) return result;

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length; i ++){
            // 保证添加新的元素之前，窗口中首尾元素下标之差最大是size
            if (i > 0 && !deque.isEmpty()){
                int firstIdx = deque.peekFirst();
                int diff = i - firstIdx;
                if (diff == size)
                    deque.pollFirst();
            }
            /*
            if (!deque.isEmpty() && num[i] > deque.peekFirst()){
                deque.clear();
            }else{
                while(!deque.isEmpty() && num[i] >= deque.peekLast())
                    deque.pollLast();
            }
            */

            // 同一个窗口中的元素如果小于新元素，则被删除
            // 由于前面的元素总是大于后面的元素，所以从后面开始删除
            while(!deque.isEmpty() && num[i] >= num[deque.peekLast()])
                deque.pollLast();

            // 新元素总是会被添加到双端队列的末尾
            deque.offerLast(i);

            // 双端队列的队头存放的是一个窗口的最大值
            if (i >= size-1)
                result.add(num[deque.peekFirst()]);
        }
        return result;
    }
}
```



>
> [《剑指offer》面试题 Java 代码的 Github 地址](https://github.com/li-yazhou/algorithm-primer/tree/master/interview-for-offer/src/main/java/algorithm/foroffer)
> 
> [《剑指offer》面试题 Markdown 版本，包含题目、分析及代码的 Github 地址](https://github.com/li-yazhou/algorithm-primer/tree/master/interview-for-offer/md)
>
