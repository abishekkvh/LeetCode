/*
Problem: Coin Change (LeetCode 322)
Category: Dynamic Programming / 1D Linear
Difficulty: Medium

Description:
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.

Approach:
1D Linear DP (Unbounded Knapsack / Bottom-Up Tabulation):
1. Let dp[i] be the minimum number of coins needed to make amount i.
2. Initialize dp array of size amount + 1 with (amount + 1) as a sentinel value (representing infinity).
3. Base case: dp[0] = 0 (0 coins required to form an amount of 0).
4. For each amount i from 1 to amount:
   - For each coin denomination:
     - If i - coin >= 0, dp[i] = min(dp[i], dp[i - coin] + 1).
5. If dp[amount] > amount, it is impossible to form the target -> return -1; otherwise, return dp[amount].

Time Complexity: O(amount * n) where n is the number of coins
Space Complexity: O(amount) for the 1D dp table
*/

import java.util.*;

class CoinChange 
{
    public static int coinChange(int[] coins, int amount) 
    {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) 
        {
            for (int coin : coins) 
            {
                if (i - coin >= 0) 
                {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) 
    {
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println("Output 1: " + coinChange(coins1, amount1)); // Expected: 3 (5 + 5 + 1)

        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("Output 2: " + coinChange(coins2, amount2)); // Expected: -1

        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println("Output 3: " + coinChange(coins3, amount3)); // Expected: 0
    }
}
