package com.nk.practice.leetcode.top100.easy;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * @author ningke
 * @date 2021/9/8
 */
public class MaxProfit {

    public static int maxProfit(int[] prices) {
        // 想象成趋势图，其实就是求最大上升的线段长，关键是找到每次趋势转折的拐点
        if (prices.length <=1) {
            return 0;
        }
        int max = 0;
        for (int i = 1, j = 0; i < prices.length; i++) {
            if (prices[i] > prices[j]) max = Math.max(prices[i] - prices[j], max);
            else j = i;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2, 1, 2, 1, 0, 1, 2, 4}));
        System.out.println(maxProfit(new int[]{2, 1, 4}));
        System.out.println(maxProfit(new int[]{2, 4, 1, 3, 4}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{1, 1, 1, 1, 1, 1}));
        //示例 1：
        //
        //输入：[7,1,5,3,6,4]
        //输出：5
        //解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
        //     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
        //示例 2：
        //
        //输入：prices = [7,6,4,3,1]
        //输出：0
        //解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
        // 
        //
        //提示：
        //
        //1 <= prices.length <= 105
        //0 <= prices[i] <= 104
        //
    }
}
