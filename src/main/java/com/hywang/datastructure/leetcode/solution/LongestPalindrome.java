package com.hywang.datastructure.leetcode.solution;

/**
 * 5. 最长回文子串
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String babad = longestPalindrome("babad");
        System.out.println(babad);
    }

    public static String longestPalindrome(String s) {
        if(s == null || s.length() ==1){
            return s;
        }

        for (int i = 0, j = 2; i < s.length(); i++) {
            String substring = s.substring(i, j);
            String reverse = new StringBuilder(substring).reverse().toString();
            if (substring.equals(reverse)) {
                return substring;
            }
            j++;
        }

        return "null";
    }
}
