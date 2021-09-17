package com.nk.practice.leetcode.top100.mid;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author ningke
 * @date 2021/9/15
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                //命中 开始向前后找
                int first = mid;
                int last = mid;
                while (first>0 && nums[first-1]== target) first--;
                while (last<nums.length && nums[last+1]== target) last++;
                return new int[]{first, last};
            }
        }
        return res;
    }

    public static void main(String[] args) {

        SearchRange searchRange = new SearchRange();
        int[] ints = searchRange.searchRange(new int[]{1, 3, 8, 10, 10,10,13, 14, 16, 18, 20}, 10);
        System.out.println(ints);
        //给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
        //
        //如果数组中不存在目标值 target，返回 [-1, -1]。
        //
        //进阶：
        //
        //你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
        // 
        //
        //示例 1：
        //
        //输入：nums = [5,7,7,8,8,10], target = 8
        //输出：[3,4]
        //示例 2：
        //
        //输入：nums = [5,7,7,8,8,10], target = 6
        //输出：[-1,-1]
        //示例 3：
        //
        //输入：nums = [], target = 0
        //输出：[-1,-1]
        // 
        //
        //提示：
        //
        //0 <= nums.length <= 105
        //-109 <= nums[i] <= 109
        //nums 是一个非递减数组
        //-109 <= target <= 109
    }
}
