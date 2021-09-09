package com.nk.practice.leetcode.top100.easy;

import java.util.Stack;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * @author ningke
 * @date 2021/9/9
 */
public class IsPalindrome {

    private ListNode front;

    public boolean isPalindrome0(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            ListNode compare = stack.pop();
            if (compare.val != curr.val) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        front = head;
        return recurseCheck(head);
    }

    private boolean recurseCheck(ListNode curr) {
        if (curr == null) {
            return true;
        }
        if (!recurseCheck(curr.next)) {
            return false;
        }
        if (curr.val!=front.val) {
            return false;
        }
        front = front.next;
        return true;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(1);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(node));
        //提示：
        //
        //链表中节点数目在范围[1, 105] 内
        //0 <= Node.val <= 9
        // 
        //
        //进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
    }
}
