package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-10-14 10:36
 */

public class _0146_LRUCache<K, V> {
    private int cap = 10;
    // value的类型是Node，因为在后面会根据结点获取key，所以不能简单地将value的类型定义为V
    private HashMap<K, Node> map;  // 保证访问结点的速度为O(1)
    private Node dummyNode;  // 双向循环链表的头结点

    private class Node{
        K key;
        V val;
        Node next;
        Node prev;

        public Node() {
        }

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", val=" + val +
                    '}';
        }
    }

    public _0146_LRUCache(){
        init();
    }

    public _0146_LRUCache(int cap) {
        this.cap = cap;
        init();
    }

    private void init() {
        dummyNode = new Node();
        dummyNode.next = dummyNode;
        dummyNode.prev = dummyNode;

        map = new HashMap<>();
    }

    public V get(K key){
        V val = null;
        Node node = map.get(key);
        if (node != null){
            moveToHead(node);
            val = node.val;
        }
        return val;
    }

    public void put(K key, V val){
        boolean exists = map.containsKey(key);
        if (exists){  // 当前key已存在，不需要删除考虑删除最后一个元素的情况
            Node node = map.get(key);
            node.val = val; // val 可能会更新
            moveToHead(node);
            // map.put(key, node);
        } else {
            if (map.size() >= this.cap){  // 达到最高容量，且插入的是新元素，需要删除最后一个元素
                Node deleteNode = this.dummyNode.prev;
                deleteThisNode(deleteNode);  // 删除最后一个元素
                map.remove(deleteNode.key);  // 因此，Map中的value类型为Node，需要包含key和value
                System.out.println("remove node.key " + deleteNode.key);
            }
            Node newNode = new Node(key, val);
            insertIntoHead(newNode);
            map.put(key, newNode);
        }
    }

    /**
     * 将当前结点移动到双向链表的第一个位置
     * @param node 当前结点
     */
    private void moveToHead(Node node) {
        deleteThisNode(node);
        insertIntoHead(node);
    }

    /**
     * 删除双向链表中的一个结点
     * @param node 要删除的结点
     */
    private void deleteThisNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        node.next = null;
        node.prev = null;
    }

    /**
     * 将一个结点插入到双向链表的头结点后面，作为双向链表的第一个元素
     * @param node 带插入的结点
     */
    private void insertIntoHead(Node node) {
        Node secNode = this.dummyNode.next;
        this.dummyNode.next = node;
        node.prev = this.dummyNode;
        node.next = secNode;
        secNode.prev = node;
    }



    public static void main(String... args){
        _0146_LRUCache<Integer, Integer> cache = new _0146_LRUCache<>(2);
        cache.put(1, 1);
        cache.printLruCache();
        cache.testGet(cache);
        System.out.println("\n\n");

        cache.put(2, 2);
        cache.printLruCache();
        cache.testGet(cache);
        System.out.println("\n\n");

        cache.put(3, 3);
        cache.printLruCache();
        cache.testGet(cache);
        System.out.println("\n\n");

        cache.put(4, 4);
        cache.printLruCache();
        cache.testGet(cache);
        System.out.println("\n\n");

        cache.put(3, 333);
        cache.printLruCache();
        cache.testGet(cache);
        System.out.println("\n\n");

    }

    private void testGet(_0146_LRUCache<Integer, Integer> cache) {
        for (int i = 0; i < 5; i ++) {
            Integer val = cache.get(i);
            System.out.println("key = " + i + ", val = " + val);
        }
    }

    public void printLruCache(){
        for (Node node = this.dummyNode.next; node != this.dummyNode; node = node.next){
            System.out.println(node);
        }

        for (Map.Entry<K,Node> entry : map.entrySet()){
            System.out.println(entry.getKey() + " :: " + entry.getValue());
        }
    }
}
