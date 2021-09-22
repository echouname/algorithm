package com.nk.practice.leetcode.top100.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * @author ningke
 * @date 2021/9/22
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(nums, ret, new ArrayList<>(),0);
        return ret;
    }

    private void dfs(int[] nums, List<List<Integer>> ret, List<Integer> subset, int i) {
        if (i == nums.length){
            ret.add(new ArrayList<>(subset));
            return;
        }
        // 选择i
        subset.add(nums[i]);
        dfs(nums,ret,subset,i+1);
        subset.remove(subset.size() - 1);
        // 不选择i
        dfs(nums,ret,subset,i+1);
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> subsets1 = subsets.subsets(new int[]{1, 2, 3});
        System.out.println(subsets1);
        //示例 1：
        //
        //输入：nums = [1,2,3]
        //输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        //示例 2：
        //
        //输入：nums = [0]
        //输出：[[],[0]]
        // 
        //
        //提示：
        //
        //1 <= nums.length <= 10
        //-10 <= nums[i] <= 10
        //nums 中的所有元素 互不相同
    }
}
