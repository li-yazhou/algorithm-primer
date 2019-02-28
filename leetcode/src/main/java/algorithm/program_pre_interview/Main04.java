package algorithm.program_pre_interview;

import java.util.*;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-10-18 20:00
 */
public class Main04 {
    public static void main(String... args){
        test();
    }

    private static void test(){
        int SIZE = (int)Math.pow(2, 23);
        // System.out.println(SIZE);
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[SIZE];
        for (int i = 0; i < N; i ++) {
            int id = Integer.valueOf(sc.next());
            arr[id] += 1;
        }

        int result = -1;
        int max = 0;
        for (int i =0; i < arr.length; i ++){
            if (arr[i] > max) {
                max = arr[i];
                result = i;
            }
        }
        System.out.println(result);
    }


    private static void test0(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i ++) {
            String id = sc.next();
            if(map.containsKey(id)) map.put(id, map.get(id)+1);
            else                    map.put(id, 1);
        }

        List<Map.Entry<String ,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int diff = o2.getValue() - o1.getValue();
                if (diff == 0) return o1.getKey().compareTo(o2.getKey());
                else return diff;
            }
        });

//        for (Map.Entry<String, Integer> entry : list){
//            System.out.println(entry.getKey());
//            break;
//        }
        System.out.println(list.get(0).getKey());
    }
}
