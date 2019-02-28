package algorithm.program_pre_interview.niuke;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-07 20:45
 */
public class BigNumber {
    public static void main(String... args){
        String str1 = "123";
        String str2 = "234";
        int[] num1 = strToNum(str1);
        int[] num2 = strToNum(str2);
        List<List<Integer>> lists = new ArrayList<>();

        int numOfZero = 0;
        for (int i = num2.length-1; i >= 0; i --){
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < numOfZero; j ++) list.add(0);
            numOfZero ++;
            int single = num2[i];
            int increment = 0;
            for (int j = num1.length-1; j >= 0; j --){
                int result = single * num1[j] + increment;
                list.add(result % 10);
                increment = result / 10;
            }
            if (increment == 1) list.add(1);
            System.out.println(list);
            // Collections.reverse(list);
            lists.add(list);
        }

        StringBuilder result = new StringBuilder();
        int maxsize = lists.get(lists.size()-1).size();
        int increment = 0;
        for (int i = 0; i < maxsize; i ++){ // 列
            int sum = 0;
            for (int j = 0; j < lists.size(); j ++){ // 行
                List<Integer> row = lists.get(j);
                if (i <= row.size()-1){
                    sum += row.get(i);
                }
            }
            sum += increment;
            result.append(sum % 10);
            increment = sum / 10;
        }

        result = result.reverse();
        if (increment > 0) result.append(increment);

        // if (flag == -1) System.out.print("-");
        System.out.println(result.toString());
    }

    private static int[] strToNum(String str){
        int[] num = new int[str.length()];
        int i = 0;
        for (char ch : str.toCharArray()){
            num[i ++] = ch - '0';
        }
        // System.out.println(Arrays.toString(num));
        return num;
    }
}
