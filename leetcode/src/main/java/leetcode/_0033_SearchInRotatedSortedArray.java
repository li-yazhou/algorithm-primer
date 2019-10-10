package leetcode;

import org.junit.Test;

/**
 * @author liyazhou1
 * @desc 搜索旋转排序数组
 * @date 2019/9/21
 */
public class _0033_SearchInRotatedSortedArray {


//    public int search(int[] nums, int target) {
//        int maxIndex = searchMaxIndex(nums);
//        int index = -1;
//        if (target >= nums[0]) {
//            index =  Arrays.binarySearch(nums, 0, maxIndex+1, target);
//        } else {
//            index =  Arrays.binarySearch(nums, maxIndex+1, nums.length, target);
//        }
//        return Math.max(index, -1);
//    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int maxIndex = searchMaxIndex(nums);
        System.out.println("maxIndex = " + maxIndex);
        if (target >= nums[0]) {
            return binarySearch(nums, 0, maxIndex, target);
        } else {
            return binarySearch(nums, maxIndex+1, nums.length-1, target);
        }
    }


    private int binarySearch(int[] nums, int left, int right, int key) {
        int L = left, R = right;
        while (L <= R) {
            int M = (L + R) / 2;
            System.out.print("(L, R, M) = (" + L + ", " + R + ", " + M + ")");
            System.out.println("(L, R, M) = (" + nums[L] + ", " + nums[R] + ", " + nums[M] + ")");
            if (nums[M] == key) {
                return M;
            } else if (nums[M] > key) {
                R = M - 1;
            } else if (nums[M] < key) {
                L = M + 1;
            }
        }
        return -1;
    }


    private int searchMaxIndex(int[] nums) {
        int L = 0, R = nums.length - 1;
        while (L <= R) {
            int M = (L + R) / 2;
            if (M+1 < nums.length && nums[M] > nums[M+1]) {
                return M;
            } else {
                if (nums[M] > nums[L]) {
                    L = M + 1;
                } else if (nums[M] < nums[L]){
                    R = M - 1;
                } else {
                    return 0;
                }
            }
        }
        return 0;
    }

    @Test
    public void test() {

        int[][] inputs = {
                {4, 5, 6, 7, 8, 9, 0, 1, 2, 3},
                {4, 5, 6, 7, 8, 0, 1, 2, 3},
                {4, 5, 6, 7, 0, 1, 2, 3},
                {4, 5, 6, 7, 0, 1, 2},
                {1, 3},
                {0}
        };

//        for (int[] input: inputs) {
//            int maxIndex = searchMaxIndex(input);
//            System.out.println("maxIndex = " + maxIndex);
//            int index = search(input, 8);
//            System.out.println("index = " + index);
//        }

        int index = search(inputs[4], 3);
        System.out.println("index = " + index);
    }

}
