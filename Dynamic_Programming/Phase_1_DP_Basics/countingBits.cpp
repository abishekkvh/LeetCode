/*
Problem: Counting Bits (LeetCode 338)
Category: Dynamic Programming / Bit Manipulation
Difficulty: Easy

Problem Statement:
Given an integer n, return an array ans of length n + 1 such that
for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

Approach:
1. Use DP to avoid recalculating bits for every number.
2. Observe the pattern:
      dp[i] = dp[i / 2] + (i % 2)
   Explanation:
      - i / 2 → right shift (removes last bit)
      - (i % 2) → tells whether last bit is 1 or 0
3. Base case:
      dp[0] = 0
4. Build the dp array from 1 to n.

Time Complexity: O(n)
Space Complexity: O(n)
*/

#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> countBits(int n) 
    {
        vector<int> dp(n + 1, 0);

        for(int i = 1; i <= n; i++)
        {
            dp[i] = dp[i / 2] + (i % 2);
        }

        return dp;
    }
};

int main()
{
    int n;
    cout << "Enter n: ";
    cin >> n;

    Solution obj;
    vector<int> result = obj.countBits(n);

    cout << "Number of 1's in binary from 0 to n:\n";

    for(int i = 0; i <= n; i++)
    {
        cout << i << " -> " << result[i] << endl;
    }

    return 0;
}