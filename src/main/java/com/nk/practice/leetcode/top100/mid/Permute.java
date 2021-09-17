package com.nk.practice.leetcode.top100.mid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ningke
 * @date 2021/9/15
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>(nums.length);
        for (int num : nums) {
            output.add(num);
        }
        backTrack(nums.length, res, output, 0);
        return res;
    }

    private void backTrack(int n, List<List<Integer>> res, List<Integer> output, int first) {
        if (first == n) {
            res.add(new ArrayList<>(output));
            return;
        }
        for (int i = first; i < n; i++) {
            Collections.swap(output, first, i);
            backTrack(n, res, output, first + 1);
            Collections.swap(output, first, i);
        }
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        List<List<Integer>> permute1 = permute.permute(new int[]{1, 2, 3});
        System.out.println(permute1);
        //给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
        //
        // 
        //
        //示例 1：
        //
        //输入：nums = [1,2,3]
        //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        //示例 2：
        //
        //输入：nums = [0,1]
        //输出：[[0,1],[1,0]]
        //示例 3：
        //
        //输入：nums = [1]
        //输出：[[1]]
        // 
        //
        //提示：
        //
        //1 <= nums.length <= 6
        //-10 <= nums[i] <= 10
        //nums 中的所有整数 互不相同
    }
}
