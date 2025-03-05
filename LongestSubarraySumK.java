
//Find the Longest Subarray with Sum K (Prex Sum / Two Pointers)
// Problem Statement:
// Given an array of integers nums and an integer k, nd the length of the longest subarray that sums up to k.
// Example:
// Input: nums = [1, 2, 3, 1, 1, 1, 5, -1], k = 5
// Output: 4
// Explanation: The longest subarray with sum 5 is [2, 3] or [1, 1, 1, 2].

import java.util.*;

public class LongestSubarraySumK {
    public static int longestSubarray(int[] nums, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int sum = 0, maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // If the sum is exactly k, update maxLength
            if (sum == k) {
                maxLength = i + 1;
            }

            // If (sum - k) exists in the map, it means a subarray with sum k exists
            if (prefixSumMap.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - prefixSumMap.get(sum - k));
            }

            // Store the first occurrence of sum in the map
            prefixSumMap.putIfAbsent(sum, i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 1, 5, -1};
        int k = 5;
        System.out.println(longestSubarray(nums, k)); // Output: 3
    }
}
