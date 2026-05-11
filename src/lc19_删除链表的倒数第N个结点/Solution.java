package lc19_删除链表的倒数第N个结点;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode virtual = new ListNode(0);
        virtual.next = head;
        ListNode fast = virtual;
        ListNode slow = virtual;
        int count = 0;
        while (count < n) {
            fast = fast.next;
            count++;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return virtual.next;
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