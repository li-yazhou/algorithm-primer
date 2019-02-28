package algorithm.leetcode.top500;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-10-12 10:57
 */
public class T461_HammingDistance {

    public int hammingDistance(int x, int y) {
        int counter = 0;
        for (int i = 0; i < 32; i ++){
            if ((x & 1) != (y & 1)) counter ++;
            x = x >> 1;
            y = y >> 1;
        }
        return counter;
    }


    @Test
    public void test(){
        int result = hammingDistance(1, 4);
        System.out.println(result);
    }

}
