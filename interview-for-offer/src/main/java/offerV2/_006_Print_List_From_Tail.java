package offerV2;


import offerV2.common.ListNode;

import java.util.Stack;

/**
 * @No          v2-006,v1-005
 * @problem     从尾到头打印链表
 * @tag         链表
 * @author      liyazhou1
 * @date        2017/5/23
 *
 * <pre>
 * 输入一个链表的头结点，从尾到头反过来打印出每个结点的值（不能改变链表的结构，仅仅对链表进行只读操作）
 * </pre>
 */
public class _006_Print_List_From_Tail {


    /**
     * Note
     *
     * Thought
     *      栈
     *
     * Algorithm
     *      1. 遍历链表，将链表中的元素存入到栈中
     *      2. 访问栈中的元素
     */
    private static class Solution {

        public static void printList(ListNode headNode){
            if (headNode == null) return;

            Stack<ListNode> stack = new Stack<>();
            while(headNode != null){
                stack.push(headNode);
                headNode = headNode.nextNode();
            }

            while(!stack.isEmpty()){
                ListNode currNode = stack.pop();
                System.out.print(String.format("%s \t", currNode.getVal()));
            }
        }


        public static void main(String[] args){
            ListNode nextNode = new ListNode(1);
            ListNode headNode = new ListNode(0, nextNode);
            for(int i = 2; i < 10; i++){
                ListNode node = new ListNode(i);
                nextNode.setNext(node);
                nextNode = node;
            }

            new Solution2().printList(headNode);
        }
    }


    /**
     * Note
     *
     * Thought
     *      递归，递归的本质就是栈结构，代码更加简洁
     *
     * Algorithm
     *      1. 每访问到一个结点的时候，先递归输出它后面的结点，在输出该结点自身。
     */
    private static class Solution2 {

        public static void printList(ListNode headNode){
            if (headNode.nextNode() != null){
                printList(headNode.nextNode());
            }
            System.out.print(String.format("%s \t", headNode.getVal()));

        }

        public static void main(String[] args){
            ListNode nextNode = new ListNode(1);
            ListNode headNode = new ListNode(0, nextNode);
            for(int i = 2; i < 10; i++){
                ListNode node = new ListNode(i);
                nextNode.setNext(node);
                nextNode = node;
            }

            new Solution2().printList(headNode);
        }
    }

}
