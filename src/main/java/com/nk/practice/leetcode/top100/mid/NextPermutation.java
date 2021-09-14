package com.nk.practice.leetcode.top100.mid;

/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * @author ningke
 * @date 2021/9/14
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                // 寻找仅大于 i 的元素并与i交换位置
                int j = nums.length - 1;
                for (; j >= i + 1; j--) {
                    if (nums[j] > nums[i]) {
                        break;
                    }
                }
                swap(nums, i, j);
                if (i == nums.length - 2) {
                    return;
                }
                // reverse i + 1 到 nums.length -1
                reverse(nums, i + 1, nums.length - 1);
                return;
            }
        }
        // 如果还能走到这里 说明是降序 直接reverse
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        for (int i = left, j = right; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] -= nums[j];
    }

    public static void main(String[] args) {
        // 2 3 1    3 1 2
        // 2 4 3 1  3 1 2 4
        NextPermutation nextPermutation = new NextPermutation();
        int[] n1 = {1, 2, 3};
        int[] n2 = {4, 7, 6, 5};
        int[] n3 = {9, 1, 2, 3, 4};
        int[] n4 = {8, 9, 7, 6};
        nextPermutation.nextPermutation(n1);
        nextPermutation.nextPermutation(n2);
        nextPermutation.nextPermutation(n3);
        nextPermutation.nextPermutation(n4);

        //   System.out.println(n1);
        //  System.out.println(n2);
        System.out.println(n3);
        // 5 4 3 2 1
        // 4 7 6 5 -> 5 7 6 4  ->5 4 6 7
        // 只有升序不满足 直接reverse
        // 问题1：判断是否升序
        // 问题2：如何找下一个大的序列
        // 91234 -> 91243
        // 8976 ->9678 这个例子 是跟次大交换位置 然后剩下的元素升序排列
        //示例 1：
        //
        //输入：nums = [1,2,3]
        //输出：[1,3,2]
        //示例 2：
        //
        //输入：nums = [3,2,1]
        //输出：[1,2,3]
        //示例 3：
        //
        //输入：nums = [1,1,5]
        //输出：[1,5,1]
        //示例 4：
        //
        //输入：nums = [1]
        //输出：[1]
        // 
        //
        //提示：
        //
        //1 <= nums.length <= 100
        //0 <= nums[i] <= 100
    }
}
