package offerV2;

/**
 * @No          v2-065,v1-052
 * @problem     构建乘积数组
 * @tag         数组
 * @author      liyazhou
 * @date        2017-06-06
 *
 * <pre>
 *      给定一个数组 A[0, 1, ..., n-1]，请构建一个数组 B[0, 1, ..., n-1]，
 *      其中 B 中的元素 B[i] = A[0] * A[1] * A[2] * ... *A[i-1] * A[i+1] * A[i+2] * ... A[n-1]。
 *      不能使用除法运算。
 * </pre>
 */
public class _066_Multiply_Array {


    /**
     * Note
     *
     * Thought
     *      1. 找规律，提高计算速度
     *      2. 把计算过的，且以后会用到的数据保存起来，减少计算次数，提升执行效率
     * Algorithm
     *      1. B[i] = A[0] * A[1] * A[2] * ... * A[i+1] * A[i+2] * ... * A[n-1]
     *         可以定义，B[i] = C[i] * D[i]
     *         其中，C[i] = A[0] * A[1] * A[2] * ... * A[i-1],
     *         D[i] = A[i+1] * A[i+2] * ... * A[n-1]
     *              = A[n-1] * A[n-2] * ... * A[i+1]
     *
     *         则 B[i+1] = C[i+1] * D[i+1]，
     *         其中，C[i+1] = C[i] * A[i], D[i+1] = A[n-1] * A[n-2] * ... * A[i+2]
     */
    private static class Solution {

        public int[] multiply(int[] array){
            if (array == null || array.length == 0) return null;

            int[] multiArr = new int[array.length];
            multiArr[0] = 1;
            for (int i = 1; i < array.length; i ++)
                multiArr[i] = multiArr[i-1] * array[i-1];

            int tmp = 1;
            for (int i = array.length-2; i >= 0; i --){
                tmp *= array[i + 1];
                multiArr[i] *= tmp;
            }

            return multiArr;
        }

    }
}
