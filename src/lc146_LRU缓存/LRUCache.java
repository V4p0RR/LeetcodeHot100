package lc146_LRU缓存;

import java.util.*;


public class LRUCache {

    // 双向链表节点
    class Node {
        int key;
        int value;

        Node pre;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // 容量
    private int capacity;

    // key -> node
    private Map<Integer, Node> cache;

    // 虚拟头尾节点
    private Node dummyHead;
    private Node dummyTail;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        cache = new HashMap<>();

        dummyHead = new Node();
        dummyTail = new Node();

        // 初始化双向链表
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    // 获取
    public int get(int key) {

        Node node = cache.get(key);

        if (node == null) {
            return -1;
        }

        // 最近访问 -> 移到头部
        moveToHead(node);

        return node.value;
    }

    // 插入
    public void put(int key, int value) {

        Node node = cache.get(key);

        // 已存在
        if (node != null) {

            node.value = value;

            moveToHead(node);

            return;
        }

        // 不存在 -> 创建新节点
        Node newNode = new Node(key, value);

        // 加入map
        cache.put(key, newNode);

        // 插入头部
        addToHead(newNode);

        // 超容量
        if (cache.size() > capacity) {

            // 删除尾节点
            Node removed = removeTail();

            // map同步删除
            cache.remove(removed.key);
        }
    }

    // 删除节点
    private void removeNode(Node node) {

        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    // 插入到头部
    private void addToHead(Node node) {

        node.next = dummyHead.next;
        node.pre = dummyHead;

        dummyHead.next.pre = node;
        dummyHead.next = node;
    }

    // 移动到头部
    private void moveToHead(Node node) {

        removeNode(node);

        addToHead(node);
    }

    // 删除尾节点
    private Node removeTail() {

        Node node = dummyTail.pre;

        removeNode(node);

        return node;
    }
}

/*
  Your LRUCache object will be instantiated and called as such:
  LRUCache obj = new LRUCache(capacity);
  int param_1 = obj.get(key);
  obj.put(key,value);
 */