package problems;

import org.junit.Test;

import java.util.HashMap;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-20 21:58
 */
public class RomanToInt {

    @Test
    public void test(){
        String[] romans = {
                "IV",
                "VI",
        };

        for (String roman : romans){
            System.out.println(romanToInt(roman));
        }

    }

    public int romanToInt(String roman){
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        int weight = 0;
        int postweight = 0;

        for (int i = roman.length() - 1; i >= 0; i --){
            weight = map.get(roman.charAt(i));
            if (postweight <= weight) result += weight; // 如果当前的罗马数字大于其后面的罗马数字，则加上当前的罗马数字
            else                    result -= weight;  // 如果当前的罗马数字小于其后面的罗马数字，则减去当前的罗马数字
            postweight = weight;
        }

        return result;
    }
}
