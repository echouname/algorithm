package com.nk.practice.leetcode.top100.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个
 *
 * @author ningke
 * @date 2021/9/15
 */
public class CombinationSum {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList(combine));
            return;
        }
        dfs(candidates, target, ans, combine, idx + 1);
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum0(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        // 一边生成多路树一边遍历
        //对于数字n 可被计算的次数 0 <= count < target/n
        int[] aux = new int[candidates.length];
        recurseCalculate0(candidates, target, 0, 0, ret, aux);
        return ret;
    }

    private void recurseCalculate0(int[] candidates, int target, int index, int sum, List<List<Integer>> ret, int[] aux) {
        if (index == candidates.length) {
            return;
        }
        int max = target / candidates[index];
        for (int i = 0; i <= max; i++) {
            int n = i * candidates[index];
            if (n + sum > target) {
                return;
            }
            aux[index] = i;
            if (n + sum < target) {
                recurseCalculate0(candidates, target, index + 1, n + sum, ret, aux);
            }
            if (n + sum == target) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j <= index; j++) {
                    for (int k = 1; k <= aux[j]; k++) {
                        list.add(candidates[j]);
                    }
                }
                ret.add(list);
            }
        }
    }


    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> lists = combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists);

        //示例 1：
        //
        //输入: candidates = [2,3,6,7], target = 7
        //输出: [[7],[2,2,3]]
        //示例 2：
        //
        //输入: candidates = [2,3,5], target = 8
        //输出: [[2,2,2,2],[2,3,3],[3,5]]
        //示例 3：
        //
        //输入: candidates = [2], target = 1
        //输出: []
        //示例 4：
        //
        //输入: candidates = [1], target = 1
        //输出: [[1]]
        //示例 5：
        //
        //输入: candidates = [1], target = 2
        //输出: [[1,1]]
        // 
        //
        //提示：
        //
        //1 <= candidates.length <= 30
        //1 <= candidates[i] <= 200
        //candidate 中的每个元素都是独一无二的。
        //1 <= target <= 500
    }
}
