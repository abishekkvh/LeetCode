package Stack;

/*
Problem: Evaluate Reverse Polish Notation (LeetCode 150)
Category: Stack
Difficulty: Medium

Description:
You are given an array of strings tokens that represents an arithmetic expression in Reverse Polish Notation.
Evaluate the expression and return the result as an integer.

In Reverse Polish Notation:
- Operators follow their operands.
- Each operand may be an integer or another expression.
- The valid operators are '+', '-', '*', and '/'.
- Division between two integers always truncates toward zero.
- The input is always a valid expression, so every operator will have enough operands.

Approach:
1. Use a Stack to store integer operands.
2. Iterate through each token in the input array:
   - If the token is a number, parse it as an integer and push it onto the stack.
   - If the token is an operator, pop the top two operands from the stack.
   - Apply the operator to the operands in the correct order and push the result back onto the stack.
3. After all tokens are processed, the only value left in the stack is the final result.

Time Complexity: O(n) where n is the number of tokens.
Space Complexity: O(n) for storing operands in the stack.
*/

import java.util.Stack;

public class EvaluateReverse 
{
    public int evalRPN(String[] tokens) 
    {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) 
        {
            if (isOperator(token)) 
            {
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(a, b, token);
                stack.push(result);
            } 
            else 
            {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) 
    {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int applyOperator(int a, int b, String operator) 
    {
        switch (operator) 
        {
            case "+": 
                return a + b;
            case "-": 
                return a - b;
            case "*": 
                return a * b;
            case "/": 
                return a / b;
            default: 
                throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) 
    {
        EvaluateReverse solver = new EvaluateReverse();

        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println(solver.evalRPN(tokens1));

        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println(solver.evalRPN(tokens2));

        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(solver.evalRPN(tokens3));
    }
}
