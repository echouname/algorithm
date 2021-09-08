package com.nk.practice.leetcode.top100.easy;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * @author ningke
 * @date 2021/9/8
 */
public class MinStack {

    Node head;

    public MinStack() {

    }

    public void push(int val) {
        Node node = new Node(head == null ? val : Math.min(val, head.min), val, head);
        head = node;
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    public class Node {
        int min;
        int val;
        Node next;

        public Node(int min, int val, Node next) {
            this.min = min;
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        //设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
        //
        //push(x) —— 将元素 x 推入栈中。
        //pop() —— 删除栈顶的元素。
        //top() —— 获取栈顶元素。
        //getMin() —— 检索栈中的最小元素。
        // 
        //
        //提示：
        //
        //pop、top 和 getMin 操作总是在 非空栈 上调用。
    }
}
