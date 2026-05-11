package lc138_随机链表的复制;

public class Solution {
    public Node copyRandomList(Node head) {
        Node cur = head;
        while (cur != null) {
            Node n = new Node(cur.val);
            n.next = cur.next;
            cur.next = n;
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        Node virtual = new Node(0);
        virtual.next = head;
        Node pre = virtual;
        cur = head;
        while (pre.next != null) {
            Node n = cur.next;
            pre.next = n;
            pre = n;
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return virtual.next;
    }
}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}