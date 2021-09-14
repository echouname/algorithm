package com.nk.practice.leetcode.top100.mid;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
 *
 * @author ningke
 * @date 2021/9/10
 */
public class LetterCombinations {

    Map<Character, String> map = new HashMap<>();

    String[][] characters;

    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }


    public List<String> letterCombinations0(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits.length() == 0) {
            return ret;
        }
        String[] s = new String[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            switch (digits.charAt(i)) {
                case '2':s[i]="abc";break;
                case '3':s[i]="def";break;
                case '4':s[i]="ghi";break;
                case '5':s[i]="jkl";break;
                case '6':s[i]="mno";break;
                case '7':s[i]="pqrs";break;
                case '8':s[i]="tuv";break;
                case '9':s[i]="wxyz";break;
            }
        }
        Queue<String> queue = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        for (int i = digits.length() - 1; i >= 0; i--) {
            String character = s[i];
            int count = queue.size();
            if (count == 0) {
                for (int j = 0; j < character.length(); j++) {
                    queue.offer(new String(new char[]{character.charAt(j)}));
                }
            } else {
                while (count > 0) {
                    String str = queue.poll();
                    for (int j = 0; j < character.length(); j++) {
                        String append = sb.append(character.charAt(j)).append(str).toString();
                        queue.offer(append);
                        sb.delete(0, append.length());
                    }
                    count--;
                }
            }
        }
        while (!queue.isEmpty()) {
            ret.add(queue.poll());
        }
        return ret;
    }

    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits.length() == 0) {
            return ret;
        }
        characters = new String[digits.length()][];
        recursiveAppend(digits, 0);
        for (int i = 0; i < characters[0].length; i++) {
            ret.add(characters[0][i]);
        }

        return ret;
    }

    public void recursiveAppend(String digits, int current) {
        String character = map.get(digits.charAt(current));

        if (current == digits.length() - 1) {
            characters[current] = new String[character.length()];
            for (int i = 0; i < character.length(); i++) {
                characters[current][i] = new String(new char[]{character.charAt(i)});
            }
            return;
        }
        recursiveAppend(digits, current + 1);
        String[] nextAppend = characters[current + 1];
        characters[current] = new String[nextAppend.length * character.length()];
        int count = 0;
        // append
        for (int i = 0; i < character.length(); i++) {
            for (int j = 0; j < nextAppend.length; j++) {
                characters[current][count] = character.charAt(i) + nextAppend[j];
                count++;
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> strings = letterCombinations.letterCombinations0("23");
        System.out.println(strings);


    }

}
