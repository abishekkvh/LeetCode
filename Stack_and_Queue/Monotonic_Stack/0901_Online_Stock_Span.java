/*
Problem: Online Stock Span (LeetCode 901)
Category: Stack & Queue / Monotonic Stack
Difficulty: Medium

Description:
Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.
The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.

Approach:
Monotonic Decreasing Stack of [price, span]:
1. Maintain a stack where each element is a pair `[price, span]`.
2. For each incoming `price`:
   - Initialize `span = 1` (the day itself).
   - While the stack is non-empty and the top element's price is less than or equal to the current `price`:
     - Accumulate the top element's span: `span += st.peek()[1]`.
     - Pop the top element from the stack.
   - Push `[price, span]` onto the stack.
3. Return the computed `span`.

Time Complexity: Amortized O(1) per call to next(), since each price-span pair is pushed and popped at most once
Space Complexity: O(n) where n is the number of calls to next(), bounded by the monotonic stack
*/

import java.util.Stack;

class StockSpanner 
{
    private Stack<int[]> st;

    public StockSpanner() 
    {
        st = new Stack<>();
    }

    public int next(int price) 
    {
        int span = 1;

        while (!st.isEmpty() && st.peek()[0] <= price) 
        {
            span += st.peek()[1];
            st.pop();
        }

        st.push(new int[] { price, span });
        return span;
    }

    public static void main(String[] args) 
    {
        StockSpanner obj = new StockSpanner();
        System.out.println("Output: " + obj.next(100)); // Expected: 1
        System.out.println("Output: " + obj.next(80));  // Expected: 1
        System.out.println("Output: " + obj.next(60));  // Expected: 1
        System.out.println("Output: " + obj.next(70));  // Expected: 2
        System.out.println("Output: " + obj.next(60));  // Expected: 1
        System.out.println("Output: " + obj.next(75));  // Expected: 4
        System.out.println("Output: " + obj.next(85));  // Expected: 6
    }
}
