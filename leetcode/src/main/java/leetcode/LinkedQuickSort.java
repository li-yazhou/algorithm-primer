package leetcode;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-10-16 10:45
 */


public class LinkedQuickSort {

    private static class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
        public Node() {};
    }


    private static class Solution1 {


        private Node[] partition(Node head, Node end) {

            if (head == null) {
                return null;
            }

            Node nextList = null;
            if (end != null) {
                nextList = end.next;
            }

            Node lHead = new Node();
            Node mHead = new Node();
            Node rHead = new Node();

            Node lNode = lHead;
            Node mNode = mHead;
            Node rNode = rHead;

            Node pivot = end; // 末尾节点作为枢轴节点
            mNode.next = end;
            mNode = mNode.next;

            Node curr = head;
            while (curr != end) {  // 末尾节点不参与循环中比较，末尾节点作为枢轴节点
                Node nextNode = curr.next;
                curr.next = null;

                if (curr.val < pivot.val) {
                    lNode.next = curr;
                    lNode = lNode.next;
                } else if (curr.val == pivot.val) {
                    mNode.next = curr;
                    mNode = mNode.next;
                } else {
                    rNode.next = curr;
                    rNode = rNode.next;
                }
                curr = nextNode;
            }

            Node newHead = new Node();
            newHead.next = lHead.next;
            lNode.next = mHead.next;
            mNode.next = rHead.next;



            return new Node[]{newHead.next, mHead.next, rHead.next};  // pivot end

        }


        public void quickSort(Node start, Node end) {
            if (start != end) {
                Node[] heads = partition(start, end);
                quickSort(heads[0], heads[1]);
                quickSort(heads[1], heads[2]);
            }
        }


        private static void printLinkedList(Node start) {
            for (Node node = start; node.next != null; node = node.next) {
                System.out.print(node.val + " -> ");
            }
            System.out.println();
        }


        private static Node[] generateLinkedList() {
            int[] arr = {2, 1, 5, 3, 4};
            Node node01 = new Node(arr[0]);
            Node node02 = new Node(arr[1]);
            Node node03 = new Node(arr[2]);
            Node node04 = new Node(arr[3]);
            Node node05 = new Node(arr[4]);

            node01.next = node02;
            node02.next = node03;
            node03.next = node04;
            node04.next = node05;

            return new Node[]{node01, node05};
        }


        public static void main(String[] args) {
            Node[] endpoints = generateLinkedList();
            Node start = endpoints[0];
            Node end = endpoints[1];
            printLinkedList(start);

            new Solution1().quickSort(start, end);

            printLinkedList(start);
        }



    }


    private class Solution {

        /**
         * 一次快排操作，链表分为两部分，前一部分小于枢轴结点，后一部分大于等于枢轴结点
         *
         * @param start 起始结点
         * @param end   终止结点
         * @return 切分结点
         */
        private Node partition(Node start, Node end) {
            int key = start.val;
            Node first = start;
            Node second = start.next;

            // 将较小的数字移动到前面
            while (second != end) {
                // 从后面找到一个较小的结点，和前面一个较大的结点交换
                if (second.val < key) {  // 有条件的移动第一个指针
                    // 第一个指针向后移动一位，first指向结点的值是大于或等于second指向结点的值
                    first = first.next;

                    // 第一个指针和第二个指针指向的结点的值交换
                    int temp = first.val;
                    first.val = second.val;
                    second.val = temp;
                }
                // 第二个指针向后移动一位
                second = second.next;
            }

            // 找到切分位置，并将该结点的值和枢轴结点的值交换
            int temp = first.val;
            first.val = start.val;
            start.val = temp;

            return first;  // 返回切分位置（枢轴结点的新位置）
        }

        public void quickSort(Node start, Node end) {
            if (start != end) {
                Node partition = partition(start, end);
                quickSort(start, partition);
                quickSort(partition.next, end);
            }
        }


        private void printLinkedList(Node start) {
            for (Node node = start; node.next != null; node = node.next) {
                System.out.print(node.val + " -> ");
            }
            System.out.println();
        }


        private Node[] generateLinkedList() {
            int[] arr = {2, 1, 5, 3, 4};
            Node node01 = new Node(arr[0]);
            Node node02 = new Node(arr[1]);
            Node node03 = new Node(arr[2]);
            Node node04 = new Node(arr[3]);
            Node node05 = new Node(arr[4]);

            node01.next = node02;
            node02.next = node03;
            node03.next = node04;
            node04.next = node05;

            return new Node[]{node01, node05};
        }

        @Test
        public void test() {
            Node[] endpoints = generateLinkedList();
            Node start = endpoints[0];
            Node end = endpoints[1];
            printLinkedList(start);

            quickSort(start, end);

            printLinkedList(start);
        }
    }


}
