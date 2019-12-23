package com.hywang.leetcode.chapter_1;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 *
 * 所以返回 [0, 1]
 */
public class Solution {

    /**
     *  暴力  时间复杂度 o(n²)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumOne(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new RuntimeException("No two sum solution");
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]),i};
            }
            map.put(target - nums[i], i);
        }
        throw new RuntimeException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9};
        int[] ints = twoSumOne(nums, 124);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
