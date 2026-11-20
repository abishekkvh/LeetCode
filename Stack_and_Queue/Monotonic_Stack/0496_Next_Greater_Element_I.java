/*
Problem: Next Greater Element I (LeetCode 496)
Category: Stack & Queue / Monotonic Stack
Difficulty: Easy

Approach:
Monotonic Stack + Hash Map:
1. Traverse `nums2` maintaining a monotonically decreasing stack of elements.
2. For each number in `nums2`, while the stack is non-empty and the current number is greater than the stack top:
   - Pop the top element and record in the map that the current number is its next greater element (`map.put(popped, num)`).
3. Push the current number onto the stack.
4. Any elements remaining in the stack have no greater element to their right; map them to -1.
5. For each element in `nums1`, retrieve its next greater element from the map (or default to -1).

Time Complexity: O(n1 + n2) where n1 = nums1.length and n2 = nums2.length (each element is pushed and popped at most once)
Space Complexity: O(n2) for the monotonic stack and hash map
*/

import java.util.*;

class NextGreaterElementI 
{
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int[] result = new int[nums1.length];

        for (int num : nums2) 
        {
            while (!st.isEmpty() && st.peek() < num) 
            {
                int popped = st.pop();
                map.put(popped, num);
            }

            st.push(num);
        }

        while (!st.isEmpty()) 
        {
            map.put(st.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++) 
        {
            result[i] = map.getOrDefault(nums1[i], -1);
        }

        return result;
    }

    public static void main(String[] args) 
    {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println("Output 1: " + Arrays.toString(nextGreaterElement(nums1, nums2))); // Expected: [-1, 3, -1]

        int[] nums1_2 = {2, 4};
        int[] nums2_2 = {1, 2, 3, 4};
        System.out.println("Output 2: " + Arrays.toString(nextGreaterElement(nums1_2, nums2_2))); // Expected: [3, -1]
    }
}
