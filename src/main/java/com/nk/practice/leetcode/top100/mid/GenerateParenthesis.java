package com.nk.practice.leetcode.top100.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 有效括号组合需满足：左括号必须以正确的顺序闭合
 * <p>
 * 卡特兰数问题 即进栈出栈的序列 每次二选一 然后两个操作各有限制条件 双递归操作
 *
 * @author ningke
 * @date 2021/9/13
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        generateParenthesis(n, ret, new StringBuffer(), 0, 0);
        return ret;
    }

    private void generateParenthesis(int max, List<String> ret, StringBuffer appender, int left, int right) {
        if (left == max && right == max) {
            ret.add(appender.toString());
        }
        if (left < max) {
            appender.append("(");
            generateParenthesis(max, ret, appender, left + 1, right);
            appender.deleteCharAt(appender.length() - 1);
        }
        if (right < left) {
            appender.append(")");
            generateParenthesis(max, ret, appender, left, right + 1);
            appender.deleteCharAt(appender.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(3));
        //示例 1：
        //
        //输入：n = 3
        //输出：["((()))","(()())","(())()","()(())","()()()"]
        //示例 2：
        //
        //输入：n = 1
        //输出：["()"]
        // 
        //
        //提示：
        //
        //1 <= n <= 8
    }
}
