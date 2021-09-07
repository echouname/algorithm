package com.nk.practice.leetcode.top100.easy;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * @author ningke
 * @date 2021/9/7
 */
public class ClimbStairs {

    /**
     * dp[i] = dp[i-1] + dp[i-2]
     * dp[2]=2  dp[1]=1
     * 这道题用数组提交无法通过
     */
    public static int climbStairs(int n) {
        if (n<2){
            return n;
        }
        int n1 = 1;
        int n2 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = n2;
            n2 = temp + n1;
            n1 = temp;
        }
        return n2;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(20));
    }
}
