package lc25_K个一组翻转链表;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (true) {
            // 1. 找到一组的结尾
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;

            // 2. 定位区间
            ListNode start = pre.next;
            ListNode next = end.next;

            // 3. 断开
            end.next = null;

            // 4. 反转
            pre.next = reverse(start);

            // 5. 接回去
            start.next = next;

            // 6. 移动指针
            pre = start;
            end = pre;
        }

        return dummy.next;
    }

    // 普通反转链表
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
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
