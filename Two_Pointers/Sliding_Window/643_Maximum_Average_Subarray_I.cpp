/*
Problem: Maximum Average Subarray I (LeetCode 643)
Category: Sliding Window
Difficulty: Easy

Approach:
1. Compute sum of first k elements.
2. Slide window by adding next element and removing previous.
3. Track maximum sum.

Time Complexity: O(n)
Space Complexity: O(1)
*/

#include <vector>
using namespace std;

class Solution 
{
public:
    double findMaxAverage(vector<int>& nums, int k) 
    {

        int n = nums.size();

        int windowSum = 0;

        // Step 1: first window
        for (int i = 0; i < k; i++) 
        {
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        // Step 2: slide window
        for (int i = k; i < n; i++) 
        {
            windowSum += nums[i];       // add new
            windowSum -= nums[i - k];   // remove old

            maxSum = max(maxSum, windowSum);
        }

        return (double)maxSum / k;
    }
};