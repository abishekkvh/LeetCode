/*
Problem: Sort Colors (LeetCode 75)
Category: Sorting / Dutch National Flag Algorithm
Difficulty: Medium

Approach:
We use three pointers:
- low → boundary for 0s
- mid → current element
- high → boundary for 2s

If nums[mid] == 0 → swap with low
If nums[mid] == 1 → move mid
If nums[mid] == 2 → swap with high

Time Complexity: O(n)
Space Complexity: O(1)
*/

#include <vector>
using namespace std;

class Solution {
public:
    void sortColors(vector<int>& nums) 
    {
        int low = 0, mid = 0;
        int high = nums.size() - 1;

        while (mid <= high) {
            if (nums[mid] == 0) 
            {
                swap(nums[low], nums[mid]);
                low++;
                mid++;
            }
            else if (nums[mid] == 1) 
            {
                mid++;
            }
            else 
            { 
                
                // nums[mid] == 2
                swap(nums[mid], nums[high]);
                high--;
            }
        }
    }
};