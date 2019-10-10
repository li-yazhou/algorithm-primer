package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author liyazhou1
 * @desc 最接近的三数之和
 * @date 2019/9/21
 */
public class _0016_3SumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i ++) {
            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail) {
                int sum = nums[i] + nums[head] + nums[tail];
                if (Math.abs(result - target) > Math.abs(sum - target)) {
                    result = sum;
                }

                int diff = sum - target;
                if (diff < 0) {
                    head ++;
                } else if (diff > 0){
                    tail --;
                } else if (diff == 0) {
                    return target;
                }
            }
        }

        return result;
    }


    @Test
    public void solution() {
        int sumCloset = threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println("sumCloset = " + sumCloset);
    }

}
