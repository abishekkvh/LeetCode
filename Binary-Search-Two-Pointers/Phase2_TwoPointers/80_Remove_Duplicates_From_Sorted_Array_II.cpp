/*
Problem: Remove Duplicates from Sorted Array II (LeetCode 80)
Category: Two Pointers
Difficulty: Medium

Frequently Asked In: Amazon, Google, Microsoft, Meta

Approach:
1. Use a slow pointer to place valid elements.
2. Allow at most two occurrences of each number.
3. Compare current element with nums[slow-2].

Time Complexity: O(n)
Space Complexity: O(1)
*/

#include <vector>
using namespace std;

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {

        int n = nums.size();
        if (n <= 2) return n;

        int slow = 2;

        for (int fast = 2; fast < n; fast++) {

            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        return slow;
    }
};