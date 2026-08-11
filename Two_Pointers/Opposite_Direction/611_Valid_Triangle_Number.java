/*
Problem: Valid Triangle Number (LeetCode 611)
Category: Two Pointers
Difficulty: Medium

Approach:
1. Sort the array of side lengths in ascending order.
2. Iterate from the end of the array (largest element as the longest side `nums[i]`).
3. For each `nums[i]`, use two pointers (`left` and `right`) to find pairs that satisfy the triangle inequality: `nums[left] + nums[right] > nums[i]`.
   - If the condition is met, it means all elements from index `left` to `right - 1` can also form a valid triangle with `nums[right]` and `nums[i]`. Add `right - left` to the count and decrement `right`.
   - Otherwise, increment `left` to increase the sum.

Time Complexity: O(n^2)
Space Complexity: O(log n) (due to sorting)
*/

import java.util.Arrays;

class Valid_Triangle_Number {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            int left = 0;
            int right = i - 1;

            while (left <= right) {
                if (nums[left] + nums[right] > nums[i]) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Valid_Triangle_Number solver = new Valid_Triangle_Number();

        System.out.println("Running LeetCode 611: Valid Triangle Number");
        System.out.println("=============================================");

        // Test Case 1
        int[] nums1 = {2, 2, 3, 4};
        System.out.println("Test Case 1:");
        System.out.println("Nums: " + Arrays.toString(nums1));
        System.out.println("Expected output: 3");
        System.out.println("Actual output:   " + solver.triangleNumber(nums1));
        System.out.println();

        // Test Case 2
        int[] nums2 = {4, 2, 3, 4};
        System.out.println("Test Case 2:");
        System.out.println("Nums: " + Arrays.toString(nums2));
        System.out.println("Expected output: 4");
        System.out.println("Actual output:   " + solver.triangleNumber(nums2));
        System.out.println();
    }
}
