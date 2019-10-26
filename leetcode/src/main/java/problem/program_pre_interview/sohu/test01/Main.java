package problem.program_pre_interview.sohu.test01;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-17 19:19
 */

/*
简化路径，Leetcode 71
 */
public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String path = sc.next();
        LinkedList<String> stack = new LinkedList<String>();
        java.util.Set<String> set = new java.util.HashSet<String>(java.util.Arrays.asList("..", ".", ""));
        for (String str : path.split("/")){
            if (str.equals("..") && !stack.isEmpty()) stack.pop();
            if (!set.contains(str))    stack.push(str);
        }

        String result = "";
        for (String str : stack)  result =  "/" + str + result;
        result = result.isEmpty() ? "/" : result;
        System.out.println(result);
    }

}
