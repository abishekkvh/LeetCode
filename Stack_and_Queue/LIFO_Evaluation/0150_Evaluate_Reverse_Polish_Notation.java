/*
Problem: Evaluate Reverse Polish Notation (LeetCode 150)
Category: Stack & Queue / LIFO Evaluation
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
   - If the token is an operator, pop the top two operands from the stack (note order: second pop is left operand, first pop is right operand).
   - Apply the operator and push the result back onto the stack.
3. After all tokens are processed, the only remaining value in the stack is the final result.

Time Complexity: O(n) where n is the number of tokens
Space Complexity: O(n) for storing operands in the stack
*/

import java.util.*;

class EvaluateReversePolishNotation 
{
    public static int evalRPN(String[] tokens) 
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

    private static boolean isOperator(String token) 
    {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static int applyOperator(int a, int b, String operator) 
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
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) 
    {
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println("Output 1: " + evalRPN(tokens1)); // Expected: 9

        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println("Output 2: " + evalRPN(tokens2)); // Expected: 6

        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println("Output 3: " + evalRPN(tokens3)); // Expected: 22
    }
}
