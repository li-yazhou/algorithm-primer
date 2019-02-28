package algorithm.program_pre_interview.huawei;

import java.util.ArrayList;
import java.util.Scanner;

/*

[编程|200分] 报数游戏
时间限制：3秒
空间限制：32768K
题目描述
100个人围成一圈，每个人有一个编码，编号从1开始到100。他们从1开始依次报数，报到为M的人自动退出圈圈，然后下一个人接着从1开始报数，
直到剩余的人数小于M。请问最后剩余的人在原先的编号为多少？ 例如输入M=3时，输出为： “58,91” ，输入M=4时，输出为： “34,45,97”。

输入描述:
函数原型：
void  NumberOffGame(int m, char * output);
输入的m，m为大于1且小于100的整数。

输出描述:
输出output，其中output已经分配足够的内存空间，无需单独分配；

如果m输入小于等于1，则输出“ERROR!”；
如果m输入大于等于100，则输出“ERROR!”；
否则按照编号从小到大的顺序，以“,”分割输出编号字符串，输出的字符串中标点符号均为半角字符。

示例1
输入
3
输出
58,91

 */

public class Main08 {

    static final int n = 100;

    /*
     * 求圆圈中剩余的人的编号
     * 方法，用boolean模拟一下
     */
    /*
    public static void NumberOffGame(int m) {
        if(m <= 1 || m >= 100) {
            System.out.println("ERROR!");
            return ;
        }
        boolean[] array = new boolean[n];
        int left = n;
        int count = 0; // 用于计数的
        int i = 0;
        while(left >= m) {
            count++;
            if(count == m) {
                array[i] = true; // 退出
                left--;
            }
            i = (i + 1) % n; // 下一个人的位置
            while(array[i]) {
                i = (i + 1) % n;
            }
        }
        //LinkedList<String> list = new LinkedList();
        for(int j = 0; j < array.length; j++) {
            if(!array[j]) {
                list.add(String.valueOf(j+1));
                list.add(",");
            }
        }
        int len = list.size();
        for(int j = 0; j < len - 1; j++) {
            System.out.print(list.removeFirst());
        }
        System.out.println();
    }*/

    public static void NumberOffGame(int m) {
        if(m <= 1 || m >= 100) {
            System.out.println("ERROR!");
            return ;
        }

        ArrayList<Integer> list = new ArrayList(n);
        for(int i = 1;i <= n;i++){
            list.add(i);
        }

        int count = 1;
        int index;

        for(index = 0; list.size() >= m ; index++){
            if(index == list.size()){
                index = 0;
            }
            if(count % m == 0){
                list.remove(index);
                index--;
            }
            count++;
        }

        int len = list.size();
        for(int j = 0; j < len - 1; j++) {
            System.out.print(list.get(j) +",");
        }
        System.out.println(list.get(len-1));

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        NumberOffGame(m);
        sc.close();
    }
}
