package lc206_反转链表;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = p.next;
        head.next = null;//断开原链 不然会形成环
        while (q != null) {
            ListNode next = q.next;
            q.next = p;
            p = q;
            q = next;
        }
        return p;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}