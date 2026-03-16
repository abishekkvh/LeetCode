/*
Problem: Climbing Stairs (LeetCode 70)
Category: Dynamic Programming / Fibonacci Pattern
Difficulty: Easy

Problem Statement:
You are climbing a staircase. It takes n steps to reach the top.
Each time you can climb either 1 step or 2 steps.
Return the number of distinct ways to reach the top.

Approach:
1. Recognize that the problem follows the Fibonacci pattern.
2. To reach step i, you can come from:
      - step (i-1) by taking 1 step
      - step (i-2) by taking 2 steps
3. Define DP state:
      dp[i] = number of ways to reach step i
4. Recurrence relation:
      dp[i] = dp[i-1] + dp[i-2]
5. Base cases:
      dp[0] = 1 (one way to stay at ground)
      dp[1] = 1 (only one way to climb one step)
6. Fill the dp array iteratively up to n.

Time Complexity: O(n)
Space Complexity: O(n)

Optimization:
Space can be reduced to O(1) by storing only the last two values.
*/

#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int climbStairs(int n) 
    {
        if(n <= 2)
            return n;

        vector<int> dp(n + 1);

        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
};

int main()
{
    int n;

    cout << "Enter number of stairs: ";
    cin >> n;

    Solution obj;
    int result = obj.climbStairs(n);

    cout << "Number of ways to climb: " << result << endl;

    return 0;
}