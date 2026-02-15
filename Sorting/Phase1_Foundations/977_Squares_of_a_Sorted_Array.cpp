/*
Problem: Squares of a Sorted Array (LeetCode 977)
Category: Two Pointer Technique
Difficulty: Easy

Approach:
Since the array is sorted but contains negative numbers,
the largest square will come from either:
- The leftmost negative number
- The rightmost positive number

Use two pointers from both ends.
Compare absolute values and fill result from back.

Time Complexity: O(n)
Space Complexity: O(n)
*/

#include <vector>
using namespace std;

class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        int n = nums.size();
        vector<int> result(n);

        int left = 0;
        int right = n - 1;
        int index = n - 1;

        while (left <= right) {
            if (abs(nums[left]) > abs(nums[right])) {
                result[index--] = nums[left] * nums[left];
                left++;
            } else {
                result[index--] = nums[right] * nums[right];
                right--;
            }
        }

        return result;
    }
};