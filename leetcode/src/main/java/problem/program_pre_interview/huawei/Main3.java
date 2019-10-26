package problem.program_pre_interview.huawei;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-30 19:57
 */
public class Main3 {

    @Test
    public void test(){
       String[] strs = {"a",
                        "aa",
                        "aaa",
                        "ab",
                        "az",
               "z",
               "i",
               "exam201708/test20170830_huawei",
               "26",
               "27",
               "27",
               "27",
               "104680767",
       };
       for (String str: strs){
           String result = convertTo26(str);
           System.out.println(str + " :: " + result);

       }
    }



//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
//        String result = new Main2().convertTo26(s);
//        System.out.println(result);
//    }

    public String convertTo26(String str){
        char[] chars = str.toCharArray();
        String result = "";
        if (chars[0] >= '0' && chars[0] <= '9'){
            result = numToStr(chars);
        }else{
            result = strToNum(chars) + "";
        }

        return result;
    }

    private String numToStr(char[] chars){
        StringBuilder result = new StringBuilder();
        int num = Integer.valueOf(new String(chars));
        while (num != 0){
            int re = num % 26;
            if (re > 0){
                char r = (char)(re + ('a' - 1));
                result.append(r);
            }
            num  /= 26;
        }
        return result.reverse().toString();
    }

    private int strToNum(char[] chars){
        int num = 0;
        int counter = 0;
        int base = 1;
        for (int i = chars.length-1; i >= 0; i --){
            base = 1;
            for (int j = 0; j < counter; j ++){
                base *= 26;
            }
            num += (chars[i] - 'a' + 1) * base;
            counter ++;
        }
        return num;
    }
}
