package problem.program_pre_interview.test20170919_xunlei.test01;

import org.junit.Test;

import java.util.Scanner;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-19 18:30
 */
public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String expr = sc.next();
        sc.close();
        String result = new Main().cal(expr);
        System.out.println(result);
    }


    @Test
    public void test(){
        String[] exprs = {
                "x+1=5+x+2",
                "x+7=5+x+2",
                "2x+5-3+x=6+x-2",
        };

        for (String expr : exprs){
            System.out.println(expr);
            System.out.println(cal(expr));
            System.out.println("-----------------");
        }
    }
    private  String cal(String expr) {
        StringBuilder s = new StringBuilder(expr);
        s.insert(0, "0+");
        int index = s.indexOf("=");
        s.insert(index+1, "0+");
        System.out.println(s);
        int leftx = 0, rightx = 0;
        int leftv = 0, rightv = 0;
        for (int i = 2; i < index; i ++){
            if (s.charAt(i) == 'x' && s.charAt(i-1) == '-')
                leftx --;

            if (s.charAt(i) == 'x' && s.charAt(i-1) == '+')
                leftx ++;

            if (s.charAt(i) == 'x' && s.charAt(i-2) == '-')
                leftx -= (s.charAt(i-1) - '0');

            if (s.charAt(i) == 'x' && s.charAt(i-2) == '+')
                leftx += (s.charAt(i-1) - '0');
        }


        for (int i = 2; i < index; i ++){
            if (s.charAt(i+1) != 'x' && s.charAt(i-1) == '-' && s.charAt(i) >= '0' && s.charAt(i) <= '9')
                leftv -= (s.charAt(i)-'0');

            if (s.charAt(i+1) != 'x' && s.charAt(i-1) == '+' && s.charAt(i) >= '0' && s.charAt(i) <= '9')
                leftv += (s.charAt(i)-'0');
        }

        for (int i = index+3; i < s.length(); i ++){
            if (s.charAt(i) == 'x' && s.charAt(i-1) == '-')
                rightx --;

            if (s.charAt(i) == 'x' && s.charAt(i-1) == '+')
                rightx ++;

            if (s.charAt(i) == 'x' && s.charAt(i-2) == '-')
                rightx -= (s.charAt(i-1) - '0');

            if (s.charAt(i) == 'x' && s.charAt(i-2) == '+')
                rightx += (s.charAt(i-1) - '0');
        }

        for (int i = index+3; i < s.length(); i ++){
            if (i+1 < s.length() && s.charAt(i+1) != 'x' && s.charAt(i-1) == '-' && s.charAt(i) >= '0' && s.charAt(i) <= '9')
                rightv -= (s.charAt(i)-'0');

            if (i+1 < s.length() && s.charAt(i+1) != 'x' && s.charAt(i-1) == '+' && s.charAt(i) >= '0' && s.charAt(i) <= '9')
                rightv += (s.charAt(i)-'0');

            if (i+1 == s.length() && s.charAt(i-1) == '-' && s.charAt(i) >= '0' && s.charAt(i) <= '9')
                rightv -= (s.charAt(i)-'0');

            if (i+1 == s.length() && s.charAt(i-1) == '+' && s.charAt(i) >= '0' && s.charAt(i) <= '9')
                rightv += (s.charAt(i)-'0');
        }

        // ax = b;
        int a = leftx - rightx;
        int b = rightv - leftv;

        System.out.println("leftx = " + leftx + ", leftv = " + leftv);
        System.out.println("rightx = " + rightx + ", rightv = " + rightv);
        if (a == 0 && b != 0) return "No solution";
        if (a == 0 && b == 0) return "Infinite solutions";

        return "x="+b/a;
    }
}
