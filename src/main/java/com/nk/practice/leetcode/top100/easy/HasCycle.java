package com.nk.practice.leetcode.top100.easy;

import com.nk.practice.leetcode.top100.struct.ListNode;

/**
 * 给定一个链表，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * @author ningke
 * @date 2021/9/8
 */
public class HasCycle {

    /**
     * 快慢指针
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode curr = head;
        ListNode next = curr.next;
        while (next != head) {
            if (next == null) {
                return false;
            }
            // 指向head
            curr.next = head;
            // 指针前进
            curr = next;
            next = next.next;
        }
        return true;
    }

}
