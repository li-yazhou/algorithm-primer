package problem.program_pre_interview.test20170919_xunlei.test02;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-19 18:30
 */
import java.util.Scanner;


public class Main {

    public static boolean solution(int[] array, int index,
                                   int sum, int k, int[] visit) {

        if(sum > k) { // 如果sum 大于k，就不用搜索了
            return false;
        }

        if(index == array.length) { // 如果搜索的深度刚好是数组的长度，那么需要判断sum是否等于k
            return sum == k;
        }

        // 第一种情况，选它
        if(solution(array, index + 1, sum, k, visit)) {
            visit[index] = 0;  // 0 表示不选
            return true;
        }

        // 第二种情况，不选它
        if(solution(array, index + 1, sum + array[index], k, visit)) {
            visit[index] = 1; // 1 表示选
            return true;
        }

        return false;
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] array = new int[n];
        int[] visit = new int[n];

        for(int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }


        if(solution(array, 0, 0, k, visit)) {
            System.out.println("YES");
            for(int i = 0; i < n; i++) {
                if(visit[i] == 1) {
                    System.out.print(array[i] + " ");
                }
            }
            System.out.println();
        }else {
            System.out.println("NO");
        }
    }
}
