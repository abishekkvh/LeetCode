/*
Problem: Baseball Game (LeetCode 682)
Category: Stack / LIFO Evaluation
Difficulty: Easy

Description:
You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.
You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:
- An integer x: Record a new score of x.
- '+': Record a new score that is the sum of the previous two scores.
- 'D': Record a new score that is the double of the previous score.
- 'C': Invalidate the previous score, removing it from the record.

Return the sum of all the scores on the record.

Approach:
1. Use a Stack to keep track of the scores.
2. Iterate through each operation in the input array:
   - If the operation is "+", retrieve the top two scores from the stack, sum them, and push the sum back onto the stack.
   - If the operation is "D", double the top score and push the result onto the stack.
   - If the operation is "C", remove the top score from the stack.
   - Otherwise, parse the operation as an integer and push it onto the stack.
3. Finally, iterate through the stack and sum all the scores to get the final answer.

Time Complexity: O(n) where n is the number of operations.
Space Complexity: O(n) to store the scores in the stack.
*/

import java.util.*;

class BaseballGame 
{
    public static int calPoints(String[] operations) 
    {
        Stack<Integer> stack = new Stack<>();

        for (String op : operations) 
        {
            if (op.equals("+")) 
            {
                int top = stack.pop();
                int second = stack.peek();
                stack.push(top);
                stack.push(top + second);
            } 
            else if (op.equals("D")) 
            {
                stack.push(stack.peek() * 2);
            } 
            else if (op.equals("C")) 
            {
                stack.pop();
            } 
            else 
            {
                stack.push(Integer.parseInt(op));
            }
        }

        int total = 0;
        for (int score : stack) 
        {
            total += score;
        }

        return total;
    }

    public static void main(String[] args) 
    {
        String[] ops1 = {"5", "2", "C", "D", "+"};
        System.out.println("Output 1: " + calPoints(ops1)); // Expected: 30

        String[] ops2 = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println("Output 2: " + calPoints(ops2)); // Expected: 27
    }
}
