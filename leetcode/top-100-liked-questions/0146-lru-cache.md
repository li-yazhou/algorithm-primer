# 146. LRU Cache

2017-08


## Level

Hard


---


## [LRU Cache](https://leetcode.com/problems/lru-cache/description/)
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4


---


## Thought

双向链表+HashMap


---


## Solution



```
class LRUCache {
    
    private int cap = 10;
    // value的类型是Node，因为在后面会根据结点获取key，所以不能简单地将value的类型定义为V
    private HashMap<K, Node> map;  // 保证访问结点的速度为O(1)
    private Node dummyNode;  // 双向循环链表的头结点

    
    private class Node{
        int key;
        int val;
        Node next;
        Node prev;
        
        public Node(){}
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.dummyHead = new Node();
        this.dummyHead.next = this.dummyHead;
        this.dummyHead.prev = this.dummyHead;
    }
    
    
    public int get(int key) {
        Node node = map.get(key);
        int result = -1;
        if (node != null){
            result = node.val;
            // 删除当前结点并将其插入到链表头部
            moveToHead(node);
        }
        return result;
    }
    
    
    private void moveToHead(Node node){
        deleteThisNode(node);
        insertIntoHead(node);
    }
    
    
    // 在双向循环量表中删除一个结点（结点个数大于等于2，也即不考虑只有一个dummyHead结点的情况）
    private void deleteThisNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        node.prev = null;
        node.next = null;   
    }
    
    
    private Node insertIntoHead(Node node){
        // 插入当前结点
        node.next = dummyHead.next;
        dummyHead.next.prev = node;
        dummyHead.next = node;
        node.prev = dummyHead;
        return node;
    }
    
    
    public void put(int key, int value) {
        boolean exists = map.containsKey(key);
        if (exists){
            Node node = map.get(key);
            node.val = value;
            moveToHead(node);
            // map.put(key, node);
        }else{
            if (map.size() >= this.cap){
                // 删除最后一个结点
                Node deleteNode = this.dummyHead.prev;                
                deleteThisNode(deleteNode);
                // lastNode.prev.next = this.dummyHead;
                // this.dummyHead.next = lastNode.prev;
                map.remove(deleteNode.key);
            }             
            Node node = new Node(key, value);
            node = insertIntoHead(node);
            map.put(key, node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```


----------

升级版本
2017-10-14 16:49:27

```
package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-10-14 10:36
 */

public class Test146_LRUCache<K, V> {
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

    public Test146_LRUCache(){
        init();
    }

    public Test146_LRUCache(int cap) {
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
        Test146_LRUCache<Integer, Integer> cache = new Test146_LRUCache<>(2);
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

    private void testGet(Test146_LRUCache<Integer, Integer> cache) {
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

```

测试结果

```
Node{key=1, val=1}
1 :: Node{key=1, val=1}
key = 0, val = null
key = 1, val = 1
key = 2, val = null
key = 3, val = null
key = 4, val = null



Node{key=2, val=2}
Node{key=1, val=1}
1 :: Node{key=1, val=1}
2 :: Node{key=2, val=2}
key = 0, val = null
key = 1, val = 1
key = 2, val = 2
key = 3, val = null
key = 4, val = null



remove node.key 1
Node{key=3, val=3}
Node{key=2, val=2}
2 :: Node{key=2, val=2}
3 :: Node{key=3, val=3}
key = 0, val = null
key = 1, val = null
key = 2, val = 2
key = 3, val = 3
key = 4, val = null



remove node.key 2
Node{key=4, val=4}
Node{key=3, val=3}
3 :: Node{key=3, val=3}
4 :: Node{key=4, val=4}
key = 0, val = null
key = 1, val = null
key = 2, val = null
key = 3, val = 3
key = 4, val = 4



Node{key=3, val=333}
Node{key=4, val=4}
3 :: Node{key=3, val=333}
4 :: Node{key=4, val=4}
key = 0, val = null
key = 1, val = null
key = 2, val = null
key = 3, val = 333
key = 4, val = 4
```

