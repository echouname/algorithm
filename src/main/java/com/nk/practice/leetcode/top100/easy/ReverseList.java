package com.nk.practice.leetcode.top100.easy;

import com.nk.practice.leetcode.top100.struct.ListNode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * @author ningke
 * @date 2021/9/9
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode pre = null;
        // 3->4->5
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static ListNode reverseList0(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return reverse(head, head.next);
    }

    public static ListNode reverse(ListNode pre, ListNode next) {
        if (next == null) {
            return pre;
        }
        ListNode tail = reverse(next,next.next);
        next.next = pre;
        pre.next = null;
        return tail;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode node = reverseList0(n1);
        //提示：
        //
        //链表中节点的数目范围是 [0, 5000]
        //-5000 <= Node.val <= 5000
        // 
        //
        //进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
    }
}
