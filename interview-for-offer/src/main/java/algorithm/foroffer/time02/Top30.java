package algorithm.foroffer.time02;

import org.junit.Test;

import java.util.LinkedList;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-07 11:05
 */
public class Top30 {

    /*----------------------------------------------------------------------------------------------------------------*/
    /**
     * 面试题21：包含min函数的栈，要求min、push、pop的时间复杂度均为O(1)
     */
    private class StackWithMin<T extends Comparable<T>>{
        private LinkedList<T> dataStack = new LinkedList<>();
        private LinkedList<T> minStack = new LinkedList<>();

        public T min(){
            return minStack.peek();
        }

        public void push(T t){
            dataStack.push(t);
            if (minStack.isEmpty()) minStack.push(t);
            else {
                T min = minStack.peek();
                if (min.compareTo(t) < 0) minStack.push(min);
                else                      minStack.push(t);
            }
        }

        public T pop(){
            if (dataStack.isEmpty()) return null;
            minStack.pop();
            return dataStack.pop();
        }
    }

    @Test
    public void test21_stackWithMinTest(){
        StackWithMin<Integer> stack = new StackWithMin<>();
        stack.push(5);
        System.out.println(stack.min());
        stack.push(6);
        System.out.println(stack.min());
        stack.push(3);
        System.out.println(stack.min());
    }


    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
}
