package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @No          146
 * @problem     LRU Cache
 * @level       Medium
 * @desc        最近最少使用缓存
 * @author      liyazhou1
 * @date        2017-10-14 10:36
 *
 * <pre>
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 * LRUCache cache = new LRUCache(2);
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * </pre>
 */

public class _0146_LRUCache {


    /**
     * Note
     *
     * Thought
     *      双向链表 + HashMap
     *
     * Challenge
     *      细节
     *
     * Algorithm
     *      1.
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private  static class LRUCache<K, V> {

        private int cap = 10;
        // value的类型是Node，因为在后面会根据结点获取key，所以不能简单地将value的类型定义为V
        private HashMap<K, Node> map;  // 保证访问结点的速度为O(1)
        private Node head;  // 最近插入或者访问的结点
        private Node tail;  // 最长时间没被访问的结点

        private class Node{
            K key;
            V val;
            Node next;
            Node prev;

            public Node(K key, V val) {
                this.key = key;
                this.val = val;
            }

            @Override
            public String toString() {
                return "Node{" + "key=" + key + ", val=" + val + '}';
            }
        }

        public LRUCache(int cap) {
            this.cap = cap;

            this.head = new Node(null, null);
            this.tail = new Node(null, null);
            head.next = tail;
            tail.prev = head;

            map = new HashMap<>();
        }

        /**
         * 访问一个结点，则将该结点移动到双向链表的头部
         */
        public V get(K key){
            V val = null;
            Node node = map.get(key);
            if (node != null){
                moveToHead(node);
                val = node.val;
            }
            return val;
        }

        /**
         * 插入或更新一个结点
         *      若缓存中存在该结点，则将其移动到头部
         *      若缓存中不存在该结点，则将其插入到头部，并判断链表的长度是否达到上限，若超过上限则删除最后一个结点
         * @param key 结点的key
         * @param val 结点的value
         */
        public void put(K key, V val){
            boolean exists = map.containsKey(key);
            if (exists){  // 当前key已存在，不需要删除考虑删除最后一个元素的情况
                Node node = map.get(key);
                node.val = val; // val 可能会更新
                moveToHead(node);
            } else {
                if (map.size() >= this.cap){  // 容量达到上限

                    // 删除最后一个元素
                    Node deleteNode = this.tail.prev;
                    deleteNode.prev.next = this.tail;
                    this.tail.prev = deleteNode.prev;

                    // 删除map中的索引
                    map.remove(deleteNode.key);
                }

                Node newNode = new Node(key, val);
                insertToHead(newNode);
                map.put(key, newNode);
            }
        }

        /**
         * 将当前结点移动到双向链表的第一个位置
         * @param node 当前结点
         */
        private void moveToHead(Node node) {
            //  删除元素
            node.prev.next = node.next;
            node.next.prev = node.prev;

            // 插入元素
            this.head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            this.head.next = node;
        }

        private void insertToHead(Node node) {
            this.head.next.prev = node;
            node.next = this.head.next;
            node.prev = this.head;
            this.head.next = node;
        }


        public static void main(String... args){
            LRUCache<Integer, Integer> cache = new LRUCache<>(2);
            cache.put(1, 1);
            cache.printLruCache();
            cache.testGet(cache);
            System.out.println("\n");

            cache.put(2, 2);
            cache.printLruCache();
            cache.testGet(cache);
            System.out.println("\n");

            cache.put(3, 3);
            cache.printLruCache();
            cache.testGet(cache);
            System.out.println("\n");

            cache.put(4, 4);
            cache.printLruCache();
            cache.testGet(cache);
            System.out.println("\n");

            cache.put(3, 333);
            cache.printLruCache();
            cache.testGet(cache);
            System.out.println("\n");

        }

        private void testGet(LRUCache<Integer, Integer> cache) {
            for (int i = 0; i < 5; i ++) {
                Integer val = cache.get(i);
                System.out.println("key = " + i + ", val = " + val);
            }
        }

        public void printLruCache(){
            for (Node node = this.head.next; node != null; node = node.next){
                System.out.println(node);
            }

            for (Map.Entry<K,Node> entry : map.entrySet()){
                System.out.println(entry.getKey() + " :: " + entry.getValue());
            }
        }
    }


    /**
     * Note
     *
     * Thought
     *      双向链表 + HashMap
     *
     * Challenge
     *      细节
     *
     * Algorithm
     *      1.
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private  static class Solution {

        private static class LRUCache {

            private int cap;
            private HashMap<Integer, Node> map;  // 保证访问结点的速度为O(1)
            private Node head;  // 最近插入或者访问的结点
            private Node tail;  // 最长时间没被访问的结点

            private class Node {
                Integer key;
                Integer val;
                Node next;
                Node prev;

                public Node(Integer key, Integer val) {
                    this.key = key;
                    this.val = val;
                }

                @Override
                public String toString() {
                    return "Node{" + "key=" + key + ", val=" + val + '}';
                }
            }

            public LRUCache(int cap) {
                this.cap = cap;

                this.head = new Node(null, null);
                this.tail = new Node(null, null);
                head.next = tail;
                tail.prev = head;

                map = new HashMap<>();
            }

            /**
             * 访问一个结点，则将该结点移动到双向链表的头部
             */
            public int get(int key) {
                int val = -1;
                Node node = map.get(key);
                if (node != null) {
                    moveToHead(node);
                    val = node.val;
                }
                return val;
            }

            /**
             * 插入或更新一个结点
             * 若缓存中存在该结点，则将其移动到头部
             * 若缓存中不存在该结点，则将其插入到头部，并判断链表的长度是否达到上限，若超过上限则删除最后一个结点
             *
             * @param key 结点的key
             * @param val 结点的value
             */
            public void put(int key, int val) {
                boolean exists = map.containsKey(key);
                if (exists) {  // 当前key已存在，不需要删除考虑删除最后一个元素的情况
                    Node node = map.get(key);
                    node.val = val; // val 可能会更新
                    moveToHead(node);
                } else {
                    if (map.size() >= this.cap) {  // 容量达到上限

                        // 删除最后一个元素
                        Node deleteNode = this.tail.prev;
                        deleteNode.prev.next = this.tail;
                        this.tail.prev = deleteNode.prev;

                        // 删除map中的索引
                        map.remove(deleteNode.key);
                    }

                    Node newNode = new Node(key, val);
                    insertToHead(newNode);
                    map.put(key, newNode);
                }
            }

            /**
             * 将当前结点移动到双向链表的第一个位置
             *
             * @param node 当前结点
             */
            private void moveToHead(Node node) {
                //  删除元素
                node.prev.next = node.next;
                node.next.prev = node.prev;

                // 插入元素
                this.head.next.prev = node;
                node.next = head.next;
                node.prev = head;
                this.head.next = node;
            }

            private void insertToHead(Node node) {
                this.head.next.prev = node;
                node.next = this.head.next;
                node.prev = this.head;
                this.head.next = node;
            }


            public static void main(String... args) {
                LRUCache cache = new LRUCache(2);
                cache.put(1, 1);
                cache.printLruCache();
                cache.testGet(cache);
                System.out.println("\n");

                cache.put(2, 2);
                cache.printLruCache();
                cache.testGet(cache);
                System.out.println("\n");

                cache.put(3, 3);
                cache.printLruCache();
                cache.testGet(cache);
                System.out.println("\n");

                cache.put(4, 4);
                cache.printLruCache();
                cache.testGet(cache);
                System.out.println("\n");

                cache.put(3, 333);
                cache.printLruCache();
                cache.testGet(cache);
                System.out.println("\n");

            }

            private void testGet(LRUCache cache) {
                for (int i = 0; i < 5; i++) {
                    int val = cache.get(i);
                    System.out.println("key = " + i + ", val = " + val);
                }
            }

            public void printLruCache() {
                for (Node node = this.head.next; node != null; node = node.next) {
                    System.out.println(node);
                }

                for (Map.Entry<Integer, Node> entry : map.entrySet()) {
                    System.out.println(entry.getKey() + " :: " + entry.getValue());
                }
            }
        }
    }


    /**
     * Note
     *
     * Thought
     *      双向链表 + HashMap
     *
     * Challenge
     *      细节
     *
     * Algorithm
     *      1.
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution2 {

        private static class LRUCache {
            private int capacity;
            private LinkedHashMap<Integer, Integer> lrcCache;

            public LRUCache(int capacity) {
                this.capacity = capacity;
                lrcCache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
                    @Override
                    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                        return this.size() > capacity;
                    }
                };
            }

            public int get(int key) {
                if (lrcCache.containsKey(key)) {
                    return lrcCache.get(key);
                }
                return -1;
            }

            public void put(int key, int value) {
                this.lrcCache.put(key, value);
            }

            public void testGet(LRUCache cache) {
                for (int i = 0; i < 5; i ++) {
                    Integer val = cache.get(i);
                    System.out.println("key = " + i + ", val = " + val);
                }
            }

            @Override
            public String toString() {
                return lrcCache.toString();
            }
        }

        public static void main(String[] args) {
            LRUCache cache = new LRUCache(2);
            cache.put(1, 1);
            System.out.println("cache = " + cache);
            cache.testGet(cache);
            System.out.println();

            cache.put(2, 2);
            System.out.println("cache = " + cache);
            cache.testGet(cache);
            System.out.println();

            cache.put(3, 3);
            System.out.println("cache = " + cache);
            cache.testGet(cache);
            System.out.println();

            cache.put(4, 4);
            System.out.println("cache = " + cache);
            cache.testGet(cache);
            System.out.println();

            cache.put(3, 333);
            System.out.println("cache = " + cache);
            cache.testGet(cache);
            System.out.println();
        }
    }

}


