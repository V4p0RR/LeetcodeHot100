package lc234_回文链表;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        boolean isOdd = false;
        ListNode fast = head;
        ListNode slow = head;
        //快慢指针找中点 分别奇偶
        while (true) {
            if (fast.next != null) {
                if (fast.next.next != null) {
                    fast = fast.next.next;
                    slow = slow.next;
                } else {
                    fast = fast.next;
                    isOdd = false;
                    break;
                }
            } else {
                isOdd = true;
                break;
            }
        }
        if (isOdd) {
            //奇数
            ListNode pre = null;
            ListNode next = null;
            ListNode cur = slow.next;
            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            ListNode left = head;
            ListNode right = pre;
            while (right != null) {
                if (left.val != right.val) {
                    return false;
                }
                left = left.next;
                right = right.next;
            }
        } else {
            //偶数
            ListNode pre = null;
            ListNode next = null;
            ListNode cur = slow.next;
            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            ListNode left = head;
            ListNode right = pre;
            while (right != null) {
                if (left.val != right.val) {
                    return false;
                }
                left = left.next;
                right = right.next;
            }
        }
        return true;
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