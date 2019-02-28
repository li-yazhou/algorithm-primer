package algorithm.program_pre_interview.huawei;

import java.util.Scanner;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-30 18:03
 */

/**
 * 题目：
 *     将数字的中文拼音和英文单词相互转换，
 *     当有两个连续的数字时，比如“00”，可以输入"DoubleLing"或者"DoubleZero"，但是输出时不可含有"Double"。
 */
public class Main4 {

    public static void main(String[] args){
        String[] pin = {"Ling", "Yi", "Er", "San", "Si", "Wu", "Liu", "Qi", "Ba", "Jiu"};
        String[] digit = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i ++){
            if (input.charAt(i) <= 'Z' && input.charAt(i) >= 'A'){
                if (i != 0){
                    sb.append("_");
                }
                // sb.append("_");
            }
            sb.append(input.charAt(i));
        }
        String[] strs = sb.toString().split("_");
//        System.out.println(Arrays.toString(strs));
        String lastEle = strs[strs.length-1];
        boolean isDigit = false;
        for (int i = 0; i < digit.length; i ++){
            if (digit[i].equals(lastEle)){
                isDigit = true;
                break;
            }
        }

//        System.out.println(isDigit);

//        System.out.println(strs.length);
        for (int i = 0; i < strs.length-1; i ++){
            if (strs[i].equals("Double")){
                strs[i] = strs[i+1];
            }
        }

//        int[] indexs = new int[strs.length];
//        for (int i = 0; i < indexs.length; i ++)
//            indexs[i] = -1;

        if (isDigit){
            for (int i = 0; i < strs.length; i ++){
                boolean pass = false;
                for (int j = 0; j < digit.length; j ++){
                    if (strs[i].equals(digit[j])){
                        strs[i] = pin[j];
                        pass = true;
                        break;
                    }
                }
                if (!pass) {
                    System.out.println("ERROR");
                    return;
                }
            }

        }else{
            for (int i = 0; i < strs.length; i ++){
                boolean pass = false;
                for (int j = 0; j < pin.length; j ++){
                    if (strs[i].equals(pin[j])){
                        strs[i] = digit[j];
                        pass = true;
                        break;
                    }
                }
                if (!pass) {
                    System.out.println("ERROR");
                    return;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (String ele : strs){
            result.append(ele);
        }
        System.out.println(result);
    }

}
