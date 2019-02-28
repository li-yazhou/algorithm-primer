package algorithm.leetcode.top300;

public class T283_Easy_MoveZeroes {
    // public void moveZeroes(int[] nums) {
    //     int numOfZero = 0;
    //     for (int i = 0; i < nums.length; i ++){
    //         if (nums[i] != 0) continue;
    //         for (int j = i+1; j < nums.length; j ++){
    //             if (nums[j] != 0) {
    //                 nums[i] = nums[j];
    //                 nums[j] = 0;
    //                 break;
    //             }
    //         }
    //     }
    // }
    
    
    public void moveZeroes(int[] nums) {
        int pos = 0;
        for (int num : nums){
            if (num != 0) nums[pos++] = num;
        }
        
        while (pos < nums.length){
            nums[pos++] = 0;
        }
    }
}