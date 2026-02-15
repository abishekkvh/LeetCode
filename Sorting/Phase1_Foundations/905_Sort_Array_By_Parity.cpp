/*
Problem: Sort Array By Parity (LeetCode 905)
Category: Sorting / Two Pointer Technique
Difficulty: Easy

Approach:
Use two pointers:
- left starts from beginning
- right starts from end

If left is even → move forward
If right is odd → move backward
If left is odd and right is even → swap

Time Complexity: O(n)
Space Complexity: O(1)
*/

#include <vector>
using namespace std;

class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& nums) {
        int left = 0;
        int right = nums.size() - 1;

        while (left < right) {
            if (nums[left] % 2 > nums[right] % 2) {
                swap(nums[left], nums[right]);
            }

            if (nums[left] % 2 == 0) left++;
            if (nums[right] % 2 == 1) right--;
        }

        return nums;
    }
};