package algorithm.foroffer;

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



//    @Test
//    public void test02(){
//        int result = add2(1,2);
//        System.out.println(result);
//    }
//
//    public int add2(int num1,int num2) {
//        int[] arr1 = numToArr(num1);
//        int[] arr2 = numToArr(num2);
//        int[] result = new int[32];
//
//        int num = 0;
//        int carry = 0;
//        int i = 31;
//        for (; i >= 0; i --){
//            num = arr1[i] ^ arr2[i] ^ carry;  // 不进位的相加当前位，再加上进位
//            //carry = (arr1[i] & arr2[i] & carry) == 0 ;  // 进位，高位相加时使用
//            if ((arr1[i] == 1 && arr2[i] != 0 && carry != 0) ||
//                    (arr1[i] == 0 && arr2[i] != 1 && carry != 0) ||
//                    (arr1[i] == 0 && arr2[i] != 0 && carry != 1)
//                    )
//                carry = 0;
//            else carry = 1;
//            result[i] = num;
//        }
//
//        if (carry == 1) result[i] = 1;
//
//        StringBuilder s = new StringBuilder();
//        for (i = 0; i < result.length; i ++)
//            s.append(result[i]);
//        int retval = Integer.valueOf(s.toString());
//
//        return retval;
//    }
//
//
//    private int[] numToArr(int num){
//        int[] arr = new int[32];
//        char[] chs = Integer.toBinaryString(num).toCharArray();
//
//        for (int i = chs.length-1; i >= 0; i --){
//            arr[i] = chs[i] - '0';
//        }
//
//        System.out.println(Arrays.toString(chs));
//        System.out.println(Arrays.toString(arr));
//        return arr;
//    }


}
