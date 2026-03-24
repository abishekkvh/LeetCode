/*
Problem: Best Time to Buy and Sell Stock III (LeetCode 123)
Category: Arrays / Dynamic Programming
Difficulty: Hard

Frequently Asked In: Amazon, Google, Microsoft, Meta

Approach:
1. Use two passes to simulate at most 2 transactions.
2. First pass (left → right):
   - Track minimum price so far.
   - Compute max profit up to each day → leftProfit[].
3. Second pass (right → left):
   - Track maximum price from right.
   - Compute max profit from each day to end → rightProfit[].
4. Combine both:
   - For each day, total profit = leftProfit[i] + rightProfit[i].
   - Take maximum of all.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int maxProfit(int[] prices) 
    {
        if (prices == null || prices.length < 2) 
        {
            return 0;
        }

        int n = prices.length;

        int[] leftProfit = new int[n];
        int[] rightProfit = new int[n];

        int minPrice = Integer.MAX_VALUE;
        int maxProfit1 = 0;

        for (int i = 0; i < n; i++)
        {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit1 = Math.max(maxProfit1, prices[i] - minPrice);
            leftProfit[i] = maxProfit1;
        }

        int maxPrice = Integer.MIN_VALUE;
        int maxProfit2 = 0;

        for (int i = n - 1; i >= 0; i--)
        {
            maxPrice = Math.max(maxPrice, prices[i]);
            maxProfit2 = Math.max(maxProfit2, maxPrice - prices[i]);
            rightProfit[i] = maxProfit2;
        }

        int result = 0;

        for (int i = 0; i < n; i++)
        {
            result = Math.max(result, leftProfit[i] + rightProfit[i]);
        }

        return result;
    }
}