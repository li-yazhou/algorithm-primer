package problem.program_pre_interview.qunaer.test01;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-14 8:51
 */
import java.util.Scanner;



/*
4 13
1 2 4 7


部分和问题
时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB
题目描述：
部分和问题：
给定整数{a1,a2…an}，判断是否可以从中挑选出若干数，使他们的和恰好为k
输入
首先，n和k，n表示数的个数，k表示数的和。 接着一行n个数。 （1<=n<=20,保证不超int范围）
输出
如果和恰好可以为k，输出“YES”，并按从小到大输入顺序依次输出是由哪几个数的和组成，否则“NO”

样例输入
4 13
1 2 4 7

样例输出
YES
2 4 7
*/

public class Main {

    public static boolean dfs(int[] arr, int[] list, int i, int sum, int k) {
        if(sum > k) {
            return false;
        }
        if(i == arr.length) {
            return sum == k;
        }
        if(dfs(arr, list, i + 1, sum, k)) {
            list[i] = 0;
            return true;
        }
        if(dfs(arr, list, i + 1, sum + arr[i], k)) {
            list[i] = 1;
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int[] list = new int[n];

            if(dfs(arr, list, 0, 0, k)) {
                System.out.println("YES");
                for(int i = 0; i < n; i++) {
                    if(list[i] == 1) {
                        System.out.print(arr[i] + " ");
                    }
                }
                System.out.println();
            }else {
                System.out.println("NO");
            }
        // }
        sc.close();
    }
}
