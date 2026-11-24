/*
Problem: Min Stack (LeetCode 155)
Category: Stack & Queue / Monotonic Stack
Difficulty: Medium

Description:
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:
- MinStack() initializes the stack object.
- void push(int val) pushes the element val onto the stack.
- void pop() removes the element on the top of the stack.
- int top() gets the top element of the stack.
- int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

Approach:
Auxiliary Monotonic Stack for Minimum Tracking:
1. Maintain two stacks:
   - `st`: stores all pushed elements (primary stack).
   - `minSt`: stores running minimums in a monotonic non-increasing order (auxiliary stack).
2. When pushing `val`:
   - Always push `val` onto `st`.
   - If `minSt` is empty or `val <= minSt.peek()`, push `val` onto `minSt` as well (non-strict inequality handles duplicate minimums).
3. When popping:
   - Pop `popped` from `st`.
   - If `popped == minSt.peek()`, pop from `minSt` as well to maintain the current running minimum.
4. `top()` returns `st.peek()`, and `getMin()` returns `minSt.peek()` in constant time.

Time Complexity:
- push: O(1)
- pop: O(1)
- top: O(1)
- getMin: O(1)
Space Complexity: O(n) where n is the number of elements pushed into the stack
*/

import java.util.Stack;

class MinStack 
{
    private Stack<Integer> st;
    private Stack<Integer> minSt;

    public MinStack() 
    {
        st = new Stack<>();
        minSt = new Stack<>();
    }

    public void push(int value) 
    {
        st.push(value);

        if (minSt.isEmpty() || value <= minSt.peek()) 
        {
            minSt.push(value);
        }
    }

    public void pop() 
    {
        if (!st.isEmpty()) 
        {
            int popped = st.pop();
            if (!minSt.isEmpty() && popped == minSt.peek()) 
            {
                minSt.pop();
            }
        }
    }

    public int top() 
    {
        if (!st.isEmpty()) 
        {
            return st.peek();
        }
        return -1;
    }

    public int getMin() 
    {
        if (!minSt.isEmpty()) 
        {
            return minSt.peek();
        }
        return -1;
    }

    public static void main(String[] args) 
    {
        MinStack obj = new MinStack();

        // Standard LeetCode test case
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println("Current Min: " + obj.getMin()); // Expected: -3

        obj.pop();
        System.out.println("Current Top: " + obj.top()); // Expected: 0
        System.out.println("Current Min: " + obj.getMin()); // Expected: -2

        // Edge case: duplicate minimums
        obj.push(-2);
        obj.pop();
        System.out.println("Min after duplicate pop: " + obj.getMin()); // Expected: -2
    }
}
