/*
Problem: Find Minimum in Rotated Sorted Array (LeetCode 153)
Category: Modified Binary Search
Difficulty: Medium

Frequently Asked In: Amazon, Microsoft, Google, Meta

Approach:
1. Compare nums[mid] with nums[right].
2. If nums[mid] > nums[right],
   minimum lies in right half.
3. Otherwise, minimum lies in left half (including mid).

Time Complexity: O(log n)
Space Complexity: O(1)
*/

#include <vector>
using namespace std;

class Solution {
public:
    int findMin(vector<int>& nums) {

        int left = 0;
        int right = nums.size() - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
};