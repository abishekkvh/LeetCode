/*
Problem: Binary Search (LeetCode 704)
Category: Core Binary Search
Difficulty: Easy

Frequently Asked In: Amazon, Microsoft, Google, Adobe

Approach:
1. Maintain left and right pointers.
2. Compute mid carefully.
3. If target found → return index.
4. Adjust search space accordingly.

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
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }
};