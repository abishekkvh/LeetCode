/*
Problem: First Missing Positive (LeetCode 41)
Category: Cyclic Sort / In-place Index Mapping
Difficulty: Hard

Approach:
1. Place each number x (1 ≤ x ≤ n) at index x-1.
2. Ignore numbers <= 0 or > n.
3. After placement, first index i where nums[i] != i+1
   gives missing positive.

Time Complexity: O(n)
Space Complexity: O(1)
*/

#include <vector>
using namespace std;

class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {

        int n = nums.size();

        for (int i = 0; i < n; i++) {

            // Place nums[i] at correct position if possible
            while (nums[i] > 0 && nums[i] <= n &&
                   nums[nums[i] - 1] != nums[i]) {

                swap(nums[i], nums[nums[i] - 1]);
            }
        }

        // Find first index where condition fails
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }

        return n + 1;
    }
};