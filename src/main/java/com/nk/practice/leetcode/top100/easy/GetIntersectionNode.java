package com.nk.practice.leetcode.top100.easy;

import java.util.Stack;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * <p>
 * 图示两个链表在节点 c1 开始相交：
 *
 * @author ningke
 * @date 2021/9/9
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode0(ListNode headA, ListNode headB) {
        // 看两条链尾结点是否相等

        if (headA == null || headB == null) {
            return null;
        }
        int countA = 0;
        int countB = 0;
        // 计算长度
        ListNode currA = headA;
        ListNode currB = headB;
        while (currA != null) {
            currA = currA.next;
            countA++;
        }
        while (currB != null) {
            currB = currB.next;
            countB++;
        }
        // 裁剪
        if (countA > countB) {
            for (int i = countA - countB; i > 0; i--) {
                headA = headA.next;
            }
        } else if (countA < countB) {
            for (int i = countB - countA; i > 0; i--) {
                headB = headB.next;
            }
        }
        for (int i = Math.min(countA, countB); i >= 0; i--) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 看两条链尾结点是否相等
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }

    public static void main(String[] args) {
        //给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
        //图示两个链表在节点 c1 开始相交：
    }
}
