/*
Problem: Combination Sum II (LeetCode 40)
Category: Backtracking
Difficulty: Medium

Approach:
Backtracking with Unique Combinations & Duplicate Elements:
1. Sort candidate array so identical elements are adjacent and to enable early pruning.
2. In the backtracking loop starting from `start`:
   - If candidate > remaining, break early (pruning).
   - If i > start and nums[i] == nums[i - 1], skip candidate (`continue`) to prevent generating duplicate combination subsets at the same tree depth.
   - Choose candidate, recurse with remaining - nums[i] and index `i + 1` (each element can be used only once).
   - Backtrack (un-choose).
3. If remaining == 0, record the valid combination.

Time Complexity: O(2^n) in the worst case where n is the number of candidates
Space Complexity: O(n) recursion call stack depth
*/

import java.util.*;

class CombinationSumII 
{
    public static List<List<Integer>> combinationSum2(int[] nums, int target) 
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
                if (i > start && nums[i] == nums[i - 1]) 
                {
                    continue; // Skip duplicate elements at the same decision level
                }

                if (nums[i] > remaining) 
                {
                    break; // Prune branch when candidate exceeds remaining target
                }

                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remaining - nums[i], i + 1); // Single use -> pass i + 1
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) 
    {
        int[] nums1 = {10, 1, 2, 7, 6, 1, 5};
        int target1 = 8;
        System.out.println("Output 1: " + combinationSum2(nums1, target1)); // Expected: [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]

        int[] nums2 = {2, 5, 2, 1, 2};
        int target2 = 5;
        System.out.println("Output 2: " + combinationSum2(nums2, target2)); // Expected: [[1, 2, 2], [5]]
    }
}
