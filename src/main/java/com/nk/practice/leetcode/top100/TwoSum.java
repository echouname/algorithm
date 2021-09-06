package com.nk.practice.leetcode.top100;

import java.util.*;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案
 *
 * @author ningke
 * @date 2021/9/6
 */
public class TwoSum {

    /**
     * BF
     */
    public static int[] bf(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        throw new RuntimeException("no results found");
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> existNum = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (existNum.containsKey(target - nums[i])){
                return new int[]{existNum.get(target - nums[i]), i};
            }
            existNum.put(nums[i], i);
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] res = twoSum(nums, 9);
        //输入：nums = [2,7,11,15], target = 9
        //输出：[0,1]
        //解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
    }
}
