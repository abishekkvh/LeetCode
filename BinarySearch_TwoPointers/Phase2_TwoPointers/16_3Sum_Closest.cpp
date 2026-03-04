/*
Problem: 3Sum Closest (LeetCode 16)
Category: Two Pointers
Difficulty: Medium

Frequently Asked In: Amazon, Microsoft, Google, Meta

Approach:
1. Sort the array.
2. Fix one element.
3. Use two pointers (left and right) to search for best sum.
4. Update closest result whenever we find a smaller difference.

Time Complexity: O(n^2)
Space Complexity: O(1)
*/

#include <vector>
#include <algorithm>
#include <climits>
using namespace std;

class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {

        sort(nums.begin(), nums.end());
        int closest = INT_MAX;

        for (int i = 0; i < nums.size() - 2; i++) {

            int left = i + 1;
            int right = nums.size() - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (abs(target - sum) < abs(target - closest))
                    closest = sum;

                if (sum < target)
                    left++;
                else if (sum > target)
                    right--;
                else
                    return sum; // exact match
            }
        }

        return closest;
    }
};