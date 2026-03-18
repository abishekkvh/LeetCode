/*
Problem: Coin Change (LeetCode 322)
Category: Dynamic Programming
Difficulty: Medium

Problem Statement:
You are given an array of coins of different denominations and an integer amount.
Return the minimum number of coins needed to make up that amount.
If that amount cannot be made, return -1.

Approach:
1. Define DP state:
      dp[i] = minimum number of coins needed to make amount i
2. Initialize:
      dp[0] = 0 (0 coins needed to make amount 0)
      All other dp[i] = INT_MAX (representing impossible initially)
3. For every amount i from 1 to amount:
      Try every coin:
          if (i - coin >= 0 and dp[i - coin] != INT_MAX)
              dp[i] = min(dp[i], dp[i - coin] + 1)
4. Final answer:
      If dp[amount] == INT_MAX → return -1
      else return dp[amount]

Time Complexity: O(amount * number of coins)
Space Complexity: O(amount)
*/

#include <iostream>
#include <vector>
#include <climits>
using namespace std;

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) 
    {
        vector<int> dp(amount + 1, INT_MAX);

        dp[0] = 0;

        for(int i = 1; i <= amount; i++)
        {
            for(int coin : coins)
            {
                if(i - coin >= 0 && dp[i - coin] != INT_MAX)
                {
                    dp[i] = min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return (dp[amount] == INT_MAX) ? -1 : dp[amount];
    }
};

int main()
{
    int n;
    cout << "Enter number of coins: ";
    cin >> n;

    vector<int> coins(n);
    cout << "Enter coin denominations: ";
    for(int i = 0; i < n; i++)
    {
        cin >> coins[i];
    }

    int amount;
    cout << "Enter target amount: ";
    cin >> amount;

    Solution obj;
    int result = obj.coinChange(coins, amount);

    cout << "Minimum coins needed: " << result << endl;

    return 0;
}