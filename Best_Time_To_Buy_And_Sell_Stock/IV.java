/*
Problem: Best Time to Buy and Sell Stock IV (LeetCode 188)
Category: Arrays / Dynamic Programming
Difficulty: Hard

Frequently Asked In: Amazon, Google, Microsoft, Meta

Approach:
1. If k >= n/2, it becomes unlimited transactions:
   - Use greedy approach (same as Stock II).
2. Otherwise, use Dynamic Programming:
   - dp[i][j] = max profit using at most i transactions up to day j.
   - Transition:
       dp[i][j] = max(
           dp[i][j-1],                  // no transaction today
           prices[j] + maxDiff         // sell today
       )
   - maxDiff tracks best value of (dp[i-1][j] - prices[j]).
3. Final answer = dp[k][n-1].

Time Complexity: O(k * n)
Space Complexity: O(k * n)
*/

class Solution {
    public int maxProfit(int k, int[] prices) 
    {
        int n = prices.length;
        if (n == 0) return 0;

        // Case 1: Unlimited transactions
        if (k >= n / 2) 
        {
            int profit = 0;
            for (int i = 1; i < n; i++) 
            {
                profit += Math.max(0, prices[i] - prices[i - 1]);
            }
            return profit;
        }

        // Case 2: DP for k transactions
        int[][] dp = new int[k + 1][n];

        for (int i = 1; i <= k; i++) 
        {
            int maxDiff = -prices[0];

            for (int j = 1; j < n; j++) 
            {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
            }
        }

        return dp[k][n - 1];
    }
}