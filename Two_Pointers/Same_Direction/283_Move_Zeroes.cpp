/*
Problem: Move Zeroes (LeetCode 283)
Category: Two Pointers / In-place
Difficulty: Easy

Approach:
1. Move all non-zero elements to the front.
2. Fill remaining positions with zero.

Time Complexity: O(n)
Space Complexity: O(1)
*/

#include <vector>
using namespace std;

class Solution {
public:
    void moveZeroes(vector<int>& nums) 
    {

        int slow = 0;

        // Move non-zero elements forward
        for (int fast = 0; fast < nums.size(); fast++) 
        {
            if (nums[fast] != 0) 
            {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        // Fill remaining with zeros
        while (slow < nums.size()) 
        {
            nums[slow] = 0;
            slow++;
        }
    }
};