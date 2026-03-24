/*
Problem: Best Time to Buy and Sell Stock I (LeetCode 121)
Category: Arrays / Greedy
Difficulty: Easy

Frequently Asked In: Amazon, Google, Microsoft, Meta

Approach:
1. Keep track of minimum price so far.
2. At each step, calculate profit = current price - min price.
3. Update maximum profit.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            // Update minimum price
            minPrice = Math.min(minPrice, prices[i]);

            // Calculate profit if sold today
            int profit = prices[i] - minPrice;

            // Update maximum profit
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}