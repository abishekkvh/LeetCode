/*
Problem: Search Insert Position (LeetCode 35)
Category: Core Binary Search / Lower Bound
Difficulty: Easy

Frequently Asked In: Amazon, Microsoft, Google

Approach:
If target exists → return its index.
If not → return the position where it should be inserted.

This is equivalent to finding the first position
where nums[index] >= target.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

#include <vector>
using namespace std;

class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {

        int left = 0;
        int right = nums.size() - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        // If not found, left is correct insert position
        return left;
    }
};