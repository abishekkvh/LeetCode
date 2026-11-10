/*
Problem: House Robber (LeetCode 198)
Category: Dynamic Programming
Difficulty: Medium

Problem Statement:
You are a robber planning to rob houses along a street.
Each house has a certain amount of money stashed.
The only constraint stopping you from robbing each of them is:
👉 Adjacent houses cannot be robbed.

Given an integer array nums representing the amount of money in each house,
return the maximum amount of money you can rob without alerting the police.

Approach:
1. At each house, we have two choices:
      - Rob the current house → move to i+2
      - Skip the current house → move to i+1
2. Define DP state:
      dp[i] = maximum money that can be robbed starting from index i
3. Recurrence relation:
      dp[i] = max(nums[i] + dp[i+2], dp[i+1])
4. Base cases:
      dp[n] = 0
      dp[n+1] = 0
5. Instead of using extra space, we optimize using two variables.

Time Complexity: O(n)
Space Complexity: O(1)
*/

#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int rob(vector<int>& nums) 
    {
        int prev2 = 0; // dp[i+2]
        int prev1 = 0; // dp[i+1]

        for(int i = nums.size() - 1; i >= 0; i--)
        {
            int curr = max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
};

int main()
{
    int n;
    cout << "Enter number of houses: ";
    cin >> n;

    vector<int> nums(n);
    cout << "Enter money in each house: ";
    for(int i = 0; i < n; i++)
    {
        cin >> nums[i];
    }

    Solution obj;
    int result = obj.rob(nums);

    cout << "Maximum money that can be robbed: " << result << endl;

    return 0;
}