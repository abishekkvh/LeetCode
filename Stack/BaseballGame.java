package Stack;

/*
Problem: Baseball Game (LeetCode 682)
Category: Stack
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

public class BaseballGame {
    public static int calPoints(String[] operations) {

        Stack<Integer> op = new Stack<>();
        int result = 0;

        for (String ch : operations) {
            if (ch.equals("+")) {
                int op1 = op.get(op.size() - 1);
                int op2 = op.get(op.size() - 2);
                op.push(op1 + op2);
            } else if (ch.equals("D")) {
                int doubled = op.peek() * 2;
                op.push(doubled);
            } else if (ch.equals("C")) {
                op.pop();
            } else {
                op.push(Integer.parseInt(ch));
            }
        }

        int ans = 0;
        for (int num : op) {
            ans += num;
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] operations = { "5", "2", "C", "D", "+" };
        System.out.println(calPoints(operations));
    }
}
