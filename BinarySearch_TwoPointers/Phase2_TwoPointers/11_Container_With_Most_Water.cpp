/*
Problem: Container With Most Water (LeetCode 11)
Category: Two Pointers
Difficulty: Medium

Frequently Asked In: Amazon, Google, Microsoft, Meta, Apple

Approach:
1. Start with two pointers at both ends.
2. Calculate current area.
3. Move the pointer with smaller height.
4. Keep updating the maximum area.

Time Complexity: O(n)
Space Complexity: O(1)
*/

#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int maxArea(vector<int>& height) {

        int left = 0;
        int right = height.size() - 1;
        int maxWater = 0;

        while (left < right) {

            int width = right - left;
            int h = min(height[left], height[right]);

            maxWater = max(maxWater, width * h);

            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxWater;
    }
};