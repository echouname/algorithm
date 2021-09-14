package com.nk.practice.leetcode.top100.mid;

import com.nk.practice.leetcode.top100.struct.ListNode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * @author ningke
 * @date 2021/9/6
 */
public class AddTwoSum {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = new ListNode();
        ListNode curr = first;
        int up = 0;
        while (l1 != null || l2 != null || up != 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += up;
            up = sum / 10;
            ListNode listNode = new ListNode(sum % 10);
            curr.next = listNode;
            curr = listNode;
        }
        return first.next;
    }

    // 7->0->8
    // 1
    public static void main(String[] args) {
        //输入：l1 = [2,4,3], l2 = [5,6,4]
        //输出：[7,0,8]
        //解释：342 + 465 = 807.
    }
}
