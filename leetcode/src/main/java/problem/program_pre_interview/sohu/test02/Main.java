package problem.program_pre_interview.sohu.test02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-17 19:39
 */



/*
构造回文数组，而且使该回文数组的和最小。
 */
public class Main {

    @Test
    public void test(){
        Integer[][] arrs = {
                {1, 2, 3, 1, 2},
                {51, 23, 52, 97, 97, 76, 23, 51},
                {1, 2},
                {1, 2, 3},
                {1, 2, 3, 2},
        };

        for (Integer[] arr : arrs){
            List<Integer> list = new ArrayList<>();
            for (Integer ele : arr) list.add(ele);

            len = list.size();
            for (int i = 0; i < len; i ++)
                createSymmetryArray(list, i);

            int sum = 0;
            for (int element : list) sum += element;
            System.out.println(Arrays.toString(arr));
            System.out.println(list);
            System.out.println(sum);

        }

    }


    static int len = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        len = sc.nextInt();
        List<Integer> list = new ArrayList<>(len);
        for (int i = 0; i < len; i ++)
            list.add(sc.nextInt());

        for (int i = 0; i < len; i ++)
            createSymmetryArray(list, i);

        int sum = 0;
        for (int element : list) sum += element;
        // System.out.println(list);
        System.out.println(sum);
    }

    private static void createSymmetryArray(List<Integer> list, int index) {
        int first = list.get(index);
        int second = list.get(list.size()-1-index);
        if (first != second){
            if (first <= second) {
                list.add(list.size()-index, first);
            }
            else {
                list.add(index, second);
                len ++;
            }
        }

    }


}
