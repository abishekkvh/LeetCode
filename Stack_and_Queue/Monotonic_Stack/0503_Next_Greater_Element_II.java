/*
Problem: Next Greater Element II (LeetCode 503)
Category: Stack & Queue / Monotonic Stack
Difficulty: Medium

Approach:
Monotonic Stack with Circular Array Simulation:
1. Since the array is circular, simulate traversing the array twice by running a loop from 0 to 2 * n - 1 and indexing elements via `i % n`.
2. Maintain a monotonic decreasing stack of indices.
3. For each index `i % n`:
   - While the stack is non-empty and `nums[st.peek()] < nums[index]`, pop the index and record `nums[index]` as its next greater element in `result`.
4. Only push indices onto the stack during the first pass (`i < n`) because all potential next greater elements will be resolved within the circular sweep.
5. Initialize the `result` array filled with -1 to handle elements with no greater circular neighbor.

Time Complexity: O(n) where each index is pushed at most once and popped at most once
Space Complexity: O(n) for the monotonic stack and output array
*/

import java.util.*;

class NextGreaterElementII 
{
    public static int[] nextGreaterElements(int[] nums) 
    {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < 2 * n; i++) 
        {
            int index = i % n;

            while (!st.isEmpty() && nums[st.peek()] < nums[index]) 
            {
                int poppedIndex = st.pop();
                result[poppedIndex] = nums[index];
            }

            if (i < n) 
            {
                st.push(index);
            }
        }

        return result;
    }

    public static void main(String[] args) 
    {
        int[] nums1 = {1, 2, 1};
        System.out.println("Output 1: " + Arrays.toString(nextGreaterElements(nums1))); // Expected: [2, -1, 2]

        int[] nums2 = {1, 2, 3, 4, 3};
        System.out.println("Output 2: " + Arrays.toString(nextGreaterElements(nums2))); // Expected: [2, 3, 4, -1, 4]
    }
}
