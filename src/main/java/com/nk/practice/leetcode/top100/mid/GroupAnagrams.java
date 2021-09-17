package com.nk.practice.leetcode.top100.mid;


import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
 *
 * @author ningke
 * @date 2021/9/16
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ret = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            ret.putIfAbsent(key, new ArrayList<>());
            ret.get(key).add(str);
        }
        return new ArrayList<>(ret.values());
    }



    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        //示例 1:
        //
        //输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
        //输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
        //示例 2:
        //
        //输入: strs = [""]
        //输出: [[""]]
        //示例 3:
        //
        //输入: strs = ["a"]
        //输出: [["a"]]
        // 
        //
        //提示：
        //
        //1 <= strs.length <= 104
        //0 <= strs[i].length <= 100
        //strs[i] 仅包含小写字母
    }
}
