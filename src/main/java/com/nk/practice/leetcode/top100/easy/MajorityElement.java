package com.nk.practice.leetcode.top100.easy;

import java.util.Arrays;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * @author ningke
 * @date 2021/9/9
 */
public class MajorityElement {

    public static int majorityElement0(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 摩尔投票法
     * 内耗 拼完了总是选出下一个候选者 众数自然会最终胜出
     */
    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += candidate == num ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement0(new int[]{3, 3, 4}));
        //示例 1：
        //
        //输入：[3,2,3]
        //输出：3
        //示例 2：
        //
        //输入：[2,2,1,1,1,2,2]
        //输出：2
        //尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
    }
}
