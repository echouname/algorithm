package com.nk.practice.leetcode.top100.easy;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 *
 * @author ningke
 * @date 2021/9/7
 */
public class MergeTwoLists {


    public class ListNode {
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first = new ListNode();
        ListNode curr = first;
        while (l1 != null || l2 != null){
            int n1 = l1 == null ? 101 : l1.val;
            int n2 = l2 == null ? 101 : l2.val;
            ListNode node = new ListNode();
            if (n1 < n2) {
                node.val = n1;
                l1 = l1.next;
            } else {
                node.val = n2;
                l2 = l2.next;
            }
            curr.next = node;
            curr = node;
        }
        return first.next;
    }

    public ListNode best(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res = l1.val < l2.val ? l1 : l2;
        res.next = mergeTwoLists(res.next, l1.val >= l2.val ? l1 : l2);
        return res;
    }

}
