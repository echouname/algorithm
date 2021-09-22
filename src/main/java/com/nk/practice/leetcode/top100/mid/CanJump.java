package com.nk.practice.leetcode.top100.mid;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 *
 * @author ningke
 * @date 2021/9/17
 */
public class CanJump {

    /**
     * 贪心
     */
    public boolean canJump(int[] nums) {
        int max = nums[0];
        for (int i = 0; i <= max; i++) {
            max = Math.max(i + nums[i], max);
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return max >= nums.length - 1;
    }


    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        System.out.println(canJump.canJump(new int[]{1,2,1,0,0}));


        //示例 1：
        //
        //输入：nums = [2,3,1,1,4]
        //输出：true
        //解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
        //示例 2：
        //
        //输入：nums = [3,2,1,0,4]
        //输出：false
        //解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
        // 
        //
        //提示：
        //
        //1 <= nums.length <= 3 * 104
        //0 <= nums[i] <= 105
    }
}
