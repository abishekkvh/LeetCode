/*
Problem: Search in Rotated Sorted Array (LeetCode 33)
Category: Modified Binary Search
Difficulty: Medium

Frequently Asked In: Amazon, Microsoft, Google, Meta

Approach:
At least one half (left or right) will always be sorted.
1. Check which half is sorted.
2. Decide if target lies inside that half.
3. Adjust search space accordingly.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

#include <vector>
using namespace std;

class Solution {
public:
    int search(vector<int>& nums, int target) {

        int left = 0;
        int right = nums.size() - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return mid;

            // Left half sorted
            if (nums[left] <= nums[mid]) {

                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right half sorted
            else {

                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
};