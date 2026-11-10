/*
Problem: N-th Tribonacci Number (LeetCode 1137)
Category: Dynamic Programming
Difficulty: Easy

Problem Statement:
The Tribonacci sequence is defined as follows:
T0 = 0, T1 = 1, T2 = 1

For n >= 3:
Tn = T(n-1) + T(n-2) + T(n-3)

Given an integer n, return the value of Tn.

Approach:
1. This is similar to Fibonacci but with 3 previous values.
2. Define DP array:
      dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
3. Base cases:
      dp[0] = 0
      dp[1] = 1
      dp[2] = 1
4. Build the dp array iteratively up to n.

Time Complexity: O(n)
Space Complexity: O(n)

Optimization:
Space can be reduced to O(1) by storing only last three values.
*/

#include <iostream>
using namespace std;

class Solution {
public:
    int tribonacci(int n) 
    {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;

        int dp[n+1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for(int i = 3; i <= n; i++)
        {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[n];
    }
};

int main()
{
    int n;
    cout << "Enter n: ";
    cin >> n;

    Solution obj;
    int result = obj.tribonacci(n);

    cout << "Tribonacci number T(" << n << ") = " << result << endl;

    return 0;
}