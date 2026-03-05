/*
Problem: Trapping Rain Water (LeetCode 42)
Category: Two Pointers
Difficulty: Hard

Frequently Asked In: Amazon, Google, Microsoft, Meta, Adobe

Approach:
Use two pointers and track maximum heights from both sides.

If leftMax < rightMax:
    water depends on leftMax
Else:
    water depends on rightMax

Time Complexity: O(n)
Space Complexity: O(1)
*/

#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int trap(vector<int>& height) {

        int left = 0;
        int right = height.size() - 1;

        int leftMax = 0;
        int rightMax = 0;

        int water = 0;

        while (left < right) {

            if (height[left] < height[right]) {

                if (height[left] >= leftMax)
                    leftMax = height[left];
                else
                    water += leftMax - height[left];

                left++;
            }

            else {

                if (height[right] >= rightMax)
                    rightMax = height[right];
                else
                    water += rightMax - height[right];

                right--;
            }
        }

        return water;
    }
};