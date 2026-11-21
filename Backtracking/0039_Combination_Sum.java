/*
Problem: Combination Sum (LeetCode 39)
Category: Backtracking
Difficulty: Medium

Approach:
Backtracking with Reusable Elements:
1. Sort the candidate array to enable early termination (pruning when candidate exceeds remaining target).
2. Recursively build combinations:
   - Base Case: If remaining target == 0, a valid combination is found; add a snapshot to result.
   - Recursive Step: Iterate through candidates starting from `start` index (elements can be reused, so recursive call passes `i`).
   - If candidate > remaining, break early since all subsequent numbers in sorted array are also larger.
   - Choose candidate, recurse with remaining - candidate, and backtrack (un-choose).

Time Complexity: O(2^t) where t = target / min(candidates), bounded by the branching tree depth
Space Complexity: O(t) for the recursion stack and combination storage
*/

import java.util.*;

class CombinationSum 
{
    public static List<List<Integer>> combinationSum(int[] nums, int target) 
    {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remaining, int start) 
    {
        if (remaining < 0) 
        {
            return;
        } 
        else if (remaining == 0) 
        {
            list.add(new ArrayList<>(tempList));
        } 
        else 
        {
            for (int i = start; i < nums.length; i++) 
            {
                if (nums[i] > remaining) 
                {
                    break;
                }

                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remaining - nums[i], i); // Re-use allowed -> pass i
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) 
    {
        int[] nums1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println("Output 1: " + combinationSum(nums1, target1)); // Expected: [[2, 2, 3], [7]]

        int[] nums2 = {2, 3, 5};
        int target2 = 8;
        System.out.println("Output 2: " + combinationSum(nums2, target2)); // Expected: [[2, 2, 2, 2], [2, 3, 3], [3, 5]]
    }
}
