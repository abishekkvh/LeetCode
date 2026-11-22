/*
Problem: Final Prices With a Special Discount in a Shop (LeetCode 1475)
Category: Stack & Queue / Monotonic Stack
Difficulty: Easy

Approach:
Monotonic Stack for Next Smaller or Equal Element:
1. Maintain a monotonic stack storing indices of items waiting for a discount.
2. Initialize `result` array as a copy of `prices`.
3. Iterate through `prices` with index `i`:
   - While the stack is not empty and `prices[st.peek()] >= prices[i]`:
     - Pop index from stack; the current `prices[i]` is the minimum-index discount (`j > index` where `prices[j] <= prices[index]`).
     - Update `result[index] = prices[index] - prices[i]`.
   - Push current index `i` onto the stack.
4. Any indices remaining in the stack have no applicable discount and retain their original prices.

Time Complexity: O(n) where each index is pushed and popped at most once
Space Complexity: O(n) for the monotonic stack and output array
*/

import java.util.*;

class FinalPricesWithSpecialDiscount 
{
    public static int[] finalPrices(int[] prices) 
    {
        int n = prices.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) 
        {
            result[i] = prices[i];

            while (!st.isEmpty() && prices[st.peek()] >= prices[i]) 
            {
                int index = st.pop();
                result[index] = prices[index] - prices[i];
            }

            st.push(i);
        }

        return result;
    }

    public static void main(String[] args) 
    {
        int[] prices1 = {8, 4, 6, 2, 3};
        System.out.println("Output 1: " + Arrays.toString(finalPrices(prices1))); // Expected: [4, 2, 4, 2, 3]

        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("Output 2: " + Arrays.toString(finalPrices(prices2))); // Expected: [1, 2, 3, 4, 5]

        int[] prices3 = {10, 1, 1, 6};
        System.out.println("Output 3: " + Arrays.toString(finalPrices(prices3))); // Expected: [9, 0, 1, 6]
    }
}
