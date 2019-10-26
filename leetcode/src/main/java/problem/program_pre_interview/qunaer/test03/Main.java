package problem.program_pre_interview.qunaer.test03;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-14 8:51
 */

/*
期末考试
时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB
题目描述：
为了防止期末考试有同学作弊，已知在一个M行N列(1<=N,M<=10)的教室中，坐在(x,y)位置的学生可以偷窥到(x-1,y),（x+1,y）(x-1,y-1),(x+1,y-1)四个位置的同学的答卷。
另外，教室中有一些座位是不能坐的(好的座椅用.表示，坏的座椅用x表示)，要求给出在给定的教室中能够安排多少学生参加考试。
第一行输入两个数，分别代表行数和列数（以空格隔开），第2~1+M行为座椅。输出的唯一一行为最大能容纳的同学人数
输入
第一行输入两个数，分别代表行数和列数（以空格隔开），第2~1+M行为座椅
输出
输出的唯一一行为最大能容纳的同学人数

样例输入
2 3
…
…
样例输出
4




 */

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();

        char[][] arrs = new char[m][n];
        for(int i = 0; i < m; i++) {
            char[] chars = sc.nextLine().toCharArray();
            for(int j = 0; j < n; j++)
                arrs[i][j] = chars[j];
        }

        int[][] dpval = new int[m+2][n+2];
        int counter = 0;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(arrs[i-1][j-1] == 'x')  continue;
                if(dpval[i-1][j-1] == 0 && dpval[i-1][j+1] == 0 && dpval[i][j-1] == 0 && dpval[i][j+1] == 0) {
                    dpval[i][j] = 1;
                    counter++;
                }
            }
        }
        System.out.println(counter);
        sc.close();
    }

}
