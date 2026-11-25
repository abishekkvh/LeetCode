/*
Problem: Design a Stack With Increment Operation (LeetCode 1381)
Category: Stack & Queue / Queue & Structure Adapters
Difficulty: Medium

Description:
Design a stack that supports increment operations on its elements.

Implement the CustomStack class:
- CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of elements in the stack.
- void push(int x) Adds x to the top of the stack if the stack has not reached the maxSize.
- int pop() Deletes and returns the top of the stack or -1 if the stack is empty.
- void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, increment all the elements in the stack.

Approach:
1. Direct / Simulation Approach:
   - Use an underlying collection (such as Stack or array) bounded by maxSize.
   - push(x): If size < maxSize, push x.
   - pop(): If non-empty, pop and return top element; else return -1.
   - increment(k, val): Iterate up to min(size, k) and add val.
2. Optimal Lazy Propagation Approach (O(1) inc):
   - Maintain an auxiliary `inc[]` array. When `increment(k, val)` is invoked, add `val` only at index `min(k, size) - 1`.
   - When popping at index `i`, propagate `inc[i]` downward to `inc[i - 1]` before returning `stack[i] + inc[i]`.

Time Complexity:
- push: O(1)
- pop: O(1)
- increment: O(min(k, size)) with direct simulation, or O(1) with lazy propagation array
Space Complexity: O(maxSize) bounded by the maximum capacity
*/

import java.util.Stack;

class CustomStack 
{
    private Stack<Integer> st;
    private int maxSize;

    public CustomStack(int maxSize) 
    {
        this.st = new Stack<>();
        this.maxSize = maxSize;
    }

    public void push(int x) 
    {
        if (st.size() >= maxSize) 
        {
            return;
        }
        st.push(x);
    }

    public int pop() 
    {
        if (!st.isEmpty()) 
        {
            return st.pop();
        }
        return -1;
    }

    public void increment(int k, int val) 
    {
        int limit = Math.min(st.size(), k);
        for (int i = 0; i < limit; i++) 
        {
            st.set(i, st.get(i) + val);
        }
    }

    public static void main(String[] args) 
    {
        CustomStack customStack = new CustomStack(3);
        customStack.push(1); // stack becomes [1]
        customStack.push(2); // stack becomes [1, 2]
        System.out.println("Pop: " + customStack.pop()); // return 2 --> [1]
        customStack.push(2); // stack becomes [1, 2]
        customStack.push(3); // stack becomes [1, 2, 3]
        customStack.push(4); // stack still [1, 2, 3], cannot add 4
        customStack.increment(5, 100); // stack becomes [101, 102, 103]
        customStack.increment(2, 100); // stack becomes [201, 202, 103]
        System.out.println("Pop: " + customStack.pop()); // return 103 --> [201, 202]
        System.out.println("Pop: " + customStack.pop()); // return 202 --> [201]
        System.out.println("Pop: " + customStack.pop()); // return 201 --> []
        System.out.println("Pop: " + customStack.pop()); // return -1 (empty)
    }
}
