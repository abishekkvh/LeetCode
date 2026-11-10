/*
Problem: Remove Duplicates from Sorted Array (LeetCode 26)
Category: Two Pointers / In-place
Difficulty: Easy

Approach:
1. Use slow pointer to track unique elements.
2. Compare current element with previous.
3. If different → place it at slow index.

Time Complexity: O(n)
Space Complexity: O(1)
*/

#include <vector>
using namespace std;

class Solution {
public:
    int removeDuplicates(vector<int>& nums) 
    {

        if (nums.empty()) return 0;

        int slow = 0;

        for (int fast = 1; fast < nums.size(); fast++) 
        {

            if (nums[fast] != nums[slow]) 
            {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1;
    }
};