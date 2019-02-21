package algorithm.foroffer;

import org.junit.Test;

/**
 * Created by liyazhou on 2017/5/25.
 * 面试题10：二进制 1 的个数
 * 题目：
 *      请实现一个函数，输入一个整数，输出该整数二进制表示中 1 的个数。
 *      例如把 9 表示成二进制是 1001， 有 2 位是 1。因此如果输入 9，该函数输出 2。
 */
public class Test10 {

    /**
     * 思路：
     *      1. 使用Integer.toBinaryString(int number)，将整数转换为二进制数组
     *      2. 统计字符串中 1 的个数
     * @param n 整数
     * @return 1 的个数
     */
    public static int numberOfOne(int n){
        String binString = Integer.toBinaryString(n);
        System.out.println(String.format("binString of %d, %s", n, binString));
        int counter = 0;
        for (int i = 0; i < binString.length(); i++)
            if (binString.charAt(i) == '1')
                counter ++;
        return counter;
    }

    /**
     * 思路：
     *      1. 将帧数转换为二进制字符串
     *      2. 统计字符串中 1 的个数
     * @param n 整数
     * @return 1 的个数
     */
    public static int numberOfOne2(int n){
        String binString = getBinString1(n);
        System.out.println(String.format("binString of %d, %s", n, binString));
        int counter = 0;
        for (int i = 0; i < binString.length(); i++)
            if (binString.charAt(i) == '1')
                counter ++;
        return counter;
    }

    /**
     * 将一个十进制整数转换为二进制字符串
     *
     * 在计算机中，为了方便计算（计算机中只有加法运算），所有数字都是用其补码表示的
     *
     * 原码、反码和补码详解：
     *  int类型的表示范围是 [-2^31, 2^31-1]
     *  1. 正整数，表示范围是 [1, 2^31-1]
     *      正整数的原码 = 反码 = 补码
     *
     *  2. 负整数（不能超出表示范围 [-2^31, -1]）
     *      负整数的原码，求负整数绝对值的原码，并将（最左边、最高位）符号位设置为 1
     *      负整数的反码，在原码的基础上，符号位不变，其余取反
     *      负整数的补码，在其原码的基础上，符号位不变，其余取反，最后加 1（或者表述为，在负整数的反码基础上，加 1）
     *
     *      负整数的补码转化为反码，负整数的补码减 1
     *      负整数的反码转化为原码，符号位不变，其余取反
     *
     *  3. 零，表示 0
     *      和正整数一样，其原码 = 反码 = 补码，为 [0000 0000 0000 0000]
     *
     * 注意：
     *      8 位二进制整数的取值范围是 [1111 1111, 0111 1111]，也即是 [-127, 127]，那么-128怎么表示呢？
     *      对于8位二进制，使用原码或反码表示的范围为[-127, +127]，而使用补码表示的范围是 [-128, 127]
     *      (-1) + (-127) = [1000 0001]原 + [1111 1111]原 = [1111 1111]补 + [1000 0001]补 = [1000 0000]补
     *      -1-127的结果应该是 -128，在用补码运算的结果中，[1000 0000]补就是 -128。
     *      但是注意因为实际上使用以前的-0的补码来表示-128，所以 -128 并没有原码和反码表示。
     *      （对 -128 的补码表示[1000 0000]补算出来的原码是[0000, 0000]原，这是不正确的）
     *
     * @param n 十进制整数
     * @return 二进制字符串
     */
    private static String getBinString1(int n) {
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n = -1 * n;
        }
        StringBuilder sBuilder = new StringBuilder();
        while(n != 0){
            int remainder = n % 2;
            n = n / 2;
            sBuilder.append(remainder);
        }

        // 根据负数绝对值的原码，计算负数的补码
        if (isNegative){
            for (int i = sBuilder.length(); i < 31; i++)
                sBuilder.append(0);
            sBuilder.append(1);

            for (int j = 0; j < sBuilder.length()-1; j++){
                char ch = sBuilder.charAt(j)=='0' ? '1' : '0';
                sBuilder.setCharAt(j, ch);
            }

            StringBuilder tmpBuilder = new StringBuilder();
            int addition = 1;
            for (int k = 0; k < sBuilder.length(); k++){
                int emt = (sBuilder.charAt(k) == '0' ? 0 : 1) + addition;
                if (emt == 1) {
                    tmpBuilder.append(1);
                    break;
                }else{
                    tmpBuilder.append(0);
                    addition = 1;
                }
            }
            for(int i = tmpBuilder.length(); i < sBuilder.length(); i++)
                tmpBuilder.append(sBuilder.charAt(i));
            sBuilder = tmpBuilder;
        }
        return sBuilder.reverse().toString();
    }

    /**
     * 思路：
     *      1. 位操作：按位与操作，左移
     *      2. 2 的 n 次幂整数，与 number 按位与操作，
     *              如果结果大于0，则当前位数字为 1，
     *              否则，当前数字为 0
     * @param number 整数
     * @return 1 的个数
     */
    public static int numberOfOne3(int number){
        String binString = getBinString2(number);
        System.out.println(String.format("binString of %d, %s", number, binString));
        int counter = 0;
        int base = 1;
        while(base > 0){
            if((number & base) > 0) counter ++;
            base = base << 1;
        }
        if ((number & base) < 0) counter ++;   // number = 9, 0000 0000 0000 0000 0000 0000 0000 1001
        return counter;
    }

    private static String getBinString2(int number) {
        StringBuilder sBuilder = new StringBuilder();
        int base = 1;
        while(base > 0){
            int bitResult = (number & base) > 0 ? 1 : 0;  // 9 & 8 = 8
            sBuilder.append(bitResult);
            base = base << 1;
        }
        sBuilder.append((number & base) < 0 ? 1 : 0);  // number = 9, 0000 0000 0000 0000 0000 0000 0000 1001
        return sBuilder.reverse().toString();
    }

    /**
     * 思路：
     *      1. 位操作：按位与操作，无符号右移
     *      2. 2 的 n 次幂整数，与 number 按位与操作，
     *              如果结果大于0，则当前位数字为 1，
     *              否则，当前数字为 0
     * @param number 整数
     * @return 1 的个数
     */
    public static int numberOfOne4(int number){
        String binString = getBinString3(number);
        System.out.println(String.format("binString of %d, %s", number, binString));
        int counter = 0;
        // Java语言规范中，int整型类型占四个字节，总计32位
        // 对每一个位置与 1 进行按位与操作，再累加就可以求出当前数字的表示包含有多少位 1
        for (int i = 0; i < 32; i++){
            counter += (number & 1);
            number = number >>> 1;
        }
        return counter;
    }

    /**
     * 将整型数字转换为二进制字符串
     * @param number 整型数字
     * @return 二进制字符串
     */
    private static String getBinString3(int number) {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < 32; i++){
            sBuilder.append(number & 1);
            number = number >>> 1;
        }
        return sBuilder.reverse().toString();
    }

    public static void main(String[] args){
        int number = 0B1001;
        System.out.println(String.format("numberOfOne(%d) = %d", number, numberOfOne(number)));
        System.out.println(String.format("numberOfOne2(%d) = %d", number, numberOfOne2(number)));
        System.out.println(String.format("numberOfOne3(%d) = %d", number, numberOfOne3(number)));
        System.out.println(String.format("numberOfOne3(%d) = %d", number, numberOfOne4(number)));


        String strOf9 = Integer.toBinaryString(9);
        System.out.println(strOf9);
        int val = Integer.valueOf("000001001", 2);
        System.out.println("val = " + val);
    }

    @Test
    public void intToBinary(){
        int[] arr = {9, -9, 100, -100};
        for (int num : arr){
            System.out.println(num);
            System.out.println(get32BitBinString(num));
            System.out.println(getSimpleBinString(num));
            System.out.println("----------------------");
        }
    }

    /**
     * 将整型数字转换为二进制字符串，一共32位，不舍弃前面的0
     * @param number 整型数字
     * @return 二进制字符串
     */
    private  String get32BitBinString(int number) {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < 32; i++){
            sBuilder.append(number & 1);
            number = number >>> 1;
        }
        return sBuilder.reverse().toString();
    }

    /**
     * 将整型数字转换为二进制字符串，舍弃前面的0
     * @param number 整型数字
     * @return 二进制字符串
     */
    private  String getSimpleBinString(int number) {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < 32; i++){
            sBuilder.append(number & 1);
            number = number >>> 1;
        }
        int index = sBuilder.reverse().indexOf("1");
        return sBuilder.substring(index);
    }

    @Test
    public void intToBinaryUsingInteger(){

        int[] arr = {9, -9, 100, -100};
        for (int num : arr){
            System.out.println(num);
            System.out.println("binary \t\t\t\t" + Integer.toBinaryString(num)); // 进制转换的正规函数
            System.out.println("octal \t\t\t\t" + Integer.toOctalString(num)); // 进制转换的正规函数
            System.out.println("hex \t\t\t\t" + Integer.toHexString(num)); // 进制转换的正规函数
            System.out.println("toString(num, 2) \t" + Integer.toString(num, 2)); // 适合打印输出
            System.out.println("-----------------------------------");
        }

        // 将二进制字符串转换为整数
        String str = "000001001";
        int val = Integer.valueOf(str, 2);
        System.out.println(str + " = " + val);
        int n = 9;
        boolean isNegative = n < 0;
        n = - n;
    }

}
