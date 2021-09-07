package com.nk.practice.leetcode.top100.easy;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * @author ningke
 * @date 2021/9/7
 */
public class IsValid {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("["));
        // ([(]))
        //示例 1：
        //
        //输入：s = "()"
        //输出：true
        //示例 2：
        //
        //输入：s = "()[]{}"
        //输出：true
        //示例 3：
        //
        //输入：s = "(]"
        //输出：false
        //示例 4：
        //
        //输入：s = "([)]"
        //输出：false
        //示例 5：
        //
        //输入：s = "{[]}"
        //输出：true
    }

}
