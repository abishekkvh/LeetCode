/*
Problem: Longest Consecutive Sequence (LeetCode 128)
Category: Arrays & Hashing
Difficulty: Medium

Approach:
1. Insert all array elements into a HashSet to allow O(1) containment checks.
2. Iterate through each number in the set:
   - Identify sequence starts: A number `num` starts a sequence only if `!set.contains(num - 1)`.
   - If it is a sequence start, count consecutive elements `num + 1, num + 2, ...` while present in set.
   - Track the maximum sequence length seen.
3. Each number is visited at most twice (once in loop, once in inner while-loop), guaranteeing linear time.

Time Complexity: O(N) where N is the number of elements in nums
Space Complexity: O(N) auxiliary space for the HashSet
*/

import java.util.*;

class LongestConsecutiveSequence {
    static int longestConsecutive(int[] nums) {
        int len = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int num : set) {
            int current_num = num;
            int consecutive = 1;
            
            if (!set.contains(num - 1)) {
                while (set.contains(current_num + 1)) {
                    current_num++;
                    consecutive++;
                }
            }

            if (consecutive > len) {
                len = consecutive;
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int nums[] = {0, 99, 100, 1, 2, 3};
        System.out.println(longestConsecutive(nums));
    }
}

