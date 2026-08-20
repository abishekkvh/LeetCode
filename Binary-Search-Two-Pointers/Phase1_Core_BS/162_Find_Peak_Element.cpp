/*
Problem: Find Peak Element (LeetCode 162)
Category: Structural Binary Search
Difficulty: Medium

Frequently Asked In: Amazon, Google, Microsoft

Approach:
If nums[mid] < nums[mid+1],
peak must exist on the right side.
Otherwise, peak exists on the left side (including mid).

Time Complexity: O(log n)
Space Complexity: O(1)
*/

#include <vector>
using namespace std;

class Solution {
public:
    int findPeakElement(vector<int>& nums) {

        int left = 0;
        int right = nums.size() - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;  // or right (both equal)
    }
};