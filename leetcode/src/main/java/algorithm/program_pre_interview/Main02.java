package algorithm.program_pre_interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-13 20:42
 */
public class Main02 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        Map<String, HashSet<String>> map = new HashMap<>();
        for (int i = 0; i < 3 * m; i ++){ 
                String str1 = sc.next();
                String str2 = sc.next();
                String str3 = sc.next();
                HashSet<String> set = map.get(str1);
                if (set == null)  set = new HashSet<String>();
                if (!"*".equals(str2)) set.add(str2);
                if (!"*".equals(str3)) set.add(str2);
                map.put(str1, set);
                for (String key : map.keySet()){
                    HashSet<String> val = map.get(key);
                    if (val.contains(str1)){
                        if (!"*".equals(str2)) val.add(str2);
                        if (!"*".equals(str3)) val.add(str2);
                }
            }
        }
        for (String key : map.keySet()) {
            HashSet<String> val = map.get(key);
            if (val.size() >= n) {
                System.out.print(key + " ");
            }
        }
    }
}
