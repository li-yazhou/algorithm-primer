package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0448_DisappearedNumbers {
    
    /**
      充分使用数组长度和数组元素大小的关系，数组元素可以作为数组的下标使用
      
      The basic idea is that we iterate through the input array and mark elements as negative using nums[nums[i] -1] = -nums[nums[i]-1].
      In this way all the numbers that we have seen will be marked as negative.
      In the second iteration, if a value is not marked as negative, it implies we have never seen that index before, 
      so just add it to the return list.
    */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i ++){
            int index = Math.abs(nums[i]) - 1;  // 元素关联的下标
            if (nums[index] > 0)  nums[index] = -nums[index]; // 元素标记下标对应数字是否出现
        }
        for (int j = 0; j < nums.length; j ++){
            if (nums[j] > 0) list.add(j+1);
        }
        return list;
    }
    
}