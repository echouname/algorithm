package com.nk.practice.leetcode.top100.easy;

/**
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 *
 * @author ningke
 * @date 2021/9/10
 */
public class HammingDistance {

    public static int hammingDistance(int x, int y) {
        int n = x ^ y;
        int count = 0;
        // 将问题变成统计某个数的1的个数
        while (n > 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {


        System.out.println(hammingDistance(1577962638, 1727613287));
        //示例 1：
        //
        //输入：x = 1, y = 4
        //输出：2
        //解释：
        //1   (0 0 0 1)
        //4   (0 1 0 0)
        //       ↑   ↑
        //上面的箭头指出了对应二进制位不同的位置。
        //示例 2：
        //
        //输入：x = 3, y = 1
        //输出：1
        // 
        //
        //提示：
        //
        //0 <= x, y <= 231 - 1
    }
}
