/*
Problem: Length of Longest Subarray With at Most K Frequency (LeetCode 2958)
Category: Two Pointers / Sliding Window
Difficulty: Medium

Approach:
1. Use a sliding window approach with two pointers: left and right.
2. Use a HashMap to store the frequency of each element in the current window.
3. Iterate right pointer from 0 to nums.length - 1:
   - Add nums[right] to the frequency map.
   - If the frequency of nums[right] exceeds k, shrink the window from the left by decrementing the frequency of nums[left] and incrementing left, until the frequency of nums[right] is at most k.
   - Update the maxLen with the current window size (right - left + 1).

Time Complexity: O(n)
Space Complexity: O(n) (for the frequency map)
*/

package Two_Pointers.Sliding_Window;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Length_Of_Longest_Subarray_With_At_Most_K_Frequency {
    public static int maxSubarrayLength(int[] nums, int k) {
        int left = 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.get(nums[right]) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println("Running LeetCode 2958: Length of Longest Subarray With at Most K Frequency");
        System.out.println("=========================================================================");

        // Test Case 1
        int[] nums1 = { 1, 2, 1, 2, 1, 2, 1, 2, 1, 2 };
        int k1 = 1;
        System.out.println("Test Case 1:");
        System.out.println("Nums: " + Arrays.toString(nums1) + ", k: " + k1);
        System.out.println("Expected output: 2");
        System.out.println("Actual output:   " + maxSubarrayLength(nums1, k1));
        System.out.println();

        // Test Case 2
        int[] nums2 = { 1, 2, 3, 1, 2, 3, 1, 2 };
        int k2 = 2;
        System.out.println("Test Case 2:");
        System.out.println("Nums: " + Arrays.toString(nums2) + ", k: " + k2);
        System.out.println("Expected output: 6");
        System.out.println("Actual output:   " + maxSubarrayLength(nums2, k2));
        System.out.println();

        // Test Case 3
        int[] nums3 = { 5, 5, 5, 5, 5, 5, 5 };
        int k3 = 4;
        System.out.println("Test Case 3:");
        System.out.println("Nums: " + Arrays.toString(nums3) + ", k: " + k3);
        System.out.println("Expected output: 4");
        System.out.println("Actual output:   " + maxSubarrayLength(nums3, k3));
        System.out.println();

        // Test Case 4 (Edge case)
        int[] nums4 = { 1, 2, 2, 2, 3 };
        int k4 = 1;
        System.out.println("Test Case 4 (Edge case):");
        System.out.println("Nums: " + Arrays.toString(nums4) + ", k: " + k4);
        System.out.println("Expected output: 2");
        System.out.println("Actual output:   " + maxSubarrayLength(nums4, k4));
        System.out.println();
    }
}
