package com.nk.practice.leetcode.top100.easy;

/**
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 *
 * @author ningke
 * @date 2021/9/9
 */
public class CountBits {

    // 0 0个
    // 2次幂 1个
    // n表示2次幂
    // num[n-1] = num [n-2]+1
    // 1    3   4  5  6   7
    // 1    2   1  2  2    3
    public static int[] countBits(int n) {
        //   0 1 10  11 100 101 110 111 1000 1001 1010  1110  1111  10001
        //     容易发现 101 比10多一个1 如果能建立起两者的关系，易得所有的结果
        //     而   10 = 101 -当前最高有效位
        int high = 1;
        int[] bits = new int[n + 1];
        bits[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            if ((i & (i - 1)) == 0) {
                bits[i] = 1;
                high = i;
            }
            bits[i] = bits[i - high] + 1;
        }
        return bits;
    }

    public static void main(String[] args) {
        System.out.println(4 & 3);
        // 
        //
        //示例 1：
        //
        //输入：n = 2
        //输出：[0,1,1]
        //解释：
        //0 --> 0
        //1 --> 1
        //2 --> 10
        //示例 2：
        //
        //输入：n = 5
        //输出：[0,1,1,2,1,2]
        //解释：
        //0 --> 0
        //1 --> 1
        //2 --> 10
        //3 --> 11
        //4 --> 100
        //5 --> 101
        //提示：
        //
        //0 <= n <= 105
        // 
        //
        //进阶：
        //
        //很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？
        //你能不使用任何内置函数解决此问题吗？（如，C++ 中的 __builtin_popcount ）
    }
}
