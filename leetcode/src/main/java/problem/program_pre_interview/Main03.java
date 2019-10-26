package problem.program_pre_interview;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-08 15:35
 */

/*
圆周上两点间的距离
时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 30720KB；其他语言 555008KB
题目描述：
定义圆周上两点的距离s为这两点之间的劣弧对应的圆心角度数(0<=s<=180)，现输入圆周上的n个点（n>=2），
以角度a表示其位置(0<=a<360)，输入按a从小到大排序。求最远的一对点之间的距离。

输入
第一行为点个数n，后跟n行，每行一个双精度浮点数，表示点的角度（小数点后保留8位），例如输入样例中为4个点的输入：

输出
输出最远的一对点之间的距离（双精度浮点数，小数点后保留8位）和'\n'换行符。例如输入样例中，10.00000000与183.00000000两个点之间的距离为173.00000000，大于10.00000000与198.0000000之间的距离172.00000000，所以应输出：
173.00000000

样例输入
4
10.00000000
180.00000000
183.00000000
198.00000000

样例输出
173.00000000

Hint
注意事项：
1.程序性能要足够快，否则可能无法通过一些大型测试数据；
2.如果使用java语言，可以考虑使用BufferedReader从标准输入读取输入数据，Scanner读取一些比较大的输入数据会发生超时。

 */
public class Main03 {
    public static void main(String[] args) throws Exception{
        /*
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            double[] arr = new double[n];
            for (int i = 0; i < n; i ++) arr[i] = sc.nextDouble();
            double result = maxDis(arr);
            System.out.println(result);
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        double[] arr = new double[n];
        for (int i = 0; i < n; i ++) arr[i] = Double.valueOf(br.readLine());
        double result = maxDis(arr);
        System.out.printf(String.format("%.8f", result));
    }

    private static double maxDis0(double[] arr) {
        double maxDis = 0.0, dis = 0.0;
        for (int i = 0; i < arr.length; i ++){
            for (int j = i+1; j < arr.length; j ++){
                dis = arr[j] - arr[i];
                if (dis > 180) dis = 360 - dis;
                maxDis = Math.max(maxDis, dis);
            }
        }

        return maxDis;
    }


    private static double maxDis1(double[] arr) {
        double maxDis = 0.0, dis = 0.0;
        for (int i = 0; i < arr.length; i ++){
            for (int j = arr.length-1; j > 0; j --){
                dis = arr[j] - arr[i];
                if (dis > 180) dis = 360 - dis;
                maxDis = Math.max(maxDis, dis);
                if (arr[j] - arr[i] < 180) {
                    break;
                }
            }
        }
        return maxDis;
    }


    /**
     * 假如数组为0-365之间的整数
     *  与0构成最大劣弧的元素是180，
     *  与1构成最大劣弧的元素是181，
     *  与2构成最大劣弧的元素是182，
     * @param arr 数组
     * @return 最大的劣弧
     */
    private static double maxDis(double[] arr) {
        double maxDis = 0.0, dis = 0.0;
        int from = 1;
        int j = 1;
        for (int i = 0; i < arr.length; i ++){
            if (from > i + 1) j = from;
            for (; j < arr.length; j ++){
                dis = arr[j] - arr[i];
                if (dis > 180) {  // 找到第一个大于180的解，它和它前面的一个数跟当前数之差的最大值是一个候选解
                    maxDis = Math.max(maxDis, 360 - dis);
                    from = j;
                    break;
                }else{
                    maxDis = Math.max(maxDis, dis);
                }
            }
        }

        return maxDis;
    }


    @Test
    public void test(){
        double[][] arrs = {
                {10, 160, 183.111111111, 198},
                {10, 160, 183, 198, 338},
        };
        for (double[] arr : arrs){
            System.out.println(String.format("%.8f", maxDis(arr)));
        }
    }
}






















