package com.nk.practice.leetcode.top100.mid;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 *
 * @author ningke
 * @date 2021/9/10
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        // TODO
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        //  -1 -1 -1 -1 -1 -1 -1 -1 -1  0  1
        // 情况1 a+b = -c
        // 情况2 a = -c
        //注意：答案中不可以包含重复的三元组。
        //示例 1：
        //  -4 -1 -1 0 1 2
        //输入：nums = [-1,0,1,2,-1,-4]
        //输出：[[-1,-1,2],[-1,0,1]]
        //示例 2：
        //
        //输入：nums = []
        //输出：[]
        //示例 3：
        //
        //输入：nums = [0]
        //输出：[]
        // 
        //
        //提示：
        //
        //0 <= nums.length <= 3000
        //-105 <= nums[i] <= 105
    }
}
