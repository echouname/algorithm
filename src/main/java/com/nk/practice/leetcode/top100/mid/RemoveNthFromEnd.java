package com.nk.practice.leetcode.top100.mid;

import com.nk.practice.leetcode.top100.struct.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * @author ningke
 * @date 2021/9/13
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode current = head;
        ListNode aux = head;
        for (int i = 0; i < n; i++) {
            aux = aux.next;
        }
        if (aux == null){
            return head.next;
        }
        while (aux.next != null) {
            current = current.next;
            aux = aux.next;
        }
        current.next = current.next.next;
        return head;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd test = new RemoveNthFromEnd();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        test.removeNthFromEnd(l1, 2);
        //示例 1：
        //
        //
        //输入：head = [1,2,3,4,5], n = 2
        //输出：[1,2,3,5]
        //示例 2：
        //
        //输入：head = [1], n = 1
        //输出：[]
        //示例 3：
        //
        //输入：head = [1,2], n = 1
        //输出：[1]
        //提示：
        //链表中结点的数目为 sz
        //1 <= sz <= 30
        //0 <= Node.val <= 100
        //1 <= n <= sz
    }
}
