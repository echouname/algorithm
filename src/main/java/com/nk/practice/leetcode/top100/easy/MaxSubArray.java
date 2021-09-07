package com.nk.practice.leetcode.top100.easy;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * @author ningke
 * @date 2021/9/7
 */
public class MaxSubArray {

    /**
     * 贪心
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0], sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    /**
     * dp  dp[i] = max(dp[i-1]+num,num)
     */
    public int maxSubArray0(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
            max = Math.max(nums[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int i, j = 0;
        //示例 1：
        //输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
        //输出：6
        //解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
        //示例 2：
        //
        //输入：nums = [1]
        //输出：1
        //示例 3：
        //
        //输入：nums = [0]
        //输出：0
        //示例 4：
        //
        //输入：nums = [-1]
        //输出：-1
        //示例 5：
        //
        //输入：nums = [-100000]
        //输出：-100000
        // 
        //
        //提示：
        //
        //1 <= nums.length <= 3 * 104
        //-105 <= nums[i] <= 10
        //
    }
}
