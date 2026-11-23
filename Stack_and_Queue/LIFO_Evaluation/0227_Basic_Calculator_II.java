/*
Problem: Basic Calculator II (LeetCode 227)
Category: Stack & Queue / LIFO Evaluation
Difficulty: Medium

Description:
Given a string s which represents an expression, evaluate this expression and return its value. 
The integer division should truncate toward zero.
The expression contains only integers, operators '+', '-', '*', '/', and empty spaces.

Approach:
LIFO Stack for Operator Precedence:
1. Iterate through the expression character by character, maintaining the current number being formed and the previous operator (`sign`, initialized to '+').
2. When a digit is encountered, accumulate it: `num = num * 10 + (ch - '0')`.
3. When an operator or the last character of the string is reached:
   - '+': Push `num` onto the stack.
   - '-': Push `-num` onto the stack.
   - '*': Pop previous operand, multiply by `num`, and push result back.
   - '/': Pop previous operand, divide by `num`, and push result back.
   - Update `sign = ch` and reset `num = 0`.
4. After processing the entire string, sum all values present in the stack to produce the final evaluated expression result.

Time Complexity: O(n) where n is the length of string s
Space Complexity: O(n) for the operand stack
*/

import java.util.*;

class BasicCalculatorII 
{
    public static int calculate(String s) 
    {
        Stack<Integer> st = new Stack<>();
        int num = 0;
        char sign = '+';
        int result = 0;

        for (int i = 0; i < s.length(); i++) 
        {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) 
            {
                num = num * 10 + (ch - '0');
            }

            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) 
            {
                if (sign == '+') 
                {
                    st.push(num);
                } 
                else if (sign == '-') 
                {
                    st.push(-num);
                } 
                else if (sign == '*') 
                {
                    st.push(st.pop() * num);
                } 
                else if (sign == '/') 
                {
                    st.push(st.pop() / num);
                }

                sign = ch;
                num = 0;
            }
        }

        while (!st.isEmpty()) 
        {
            result += st.pop();
        }

        return result;
    }

    public static void main(String[] args) 
    {
        String s1 = "3+2*2";
        System.out.println("Output 1: " + calculate(s1)); // Expected: 7

        String s2 = " 3/2 ";
        System.out.println("Output 2: " + calculate(s2)); // Expected: 1

        String s3 = " 3+5 / 2 ";
        System.out.println("Output 3: " + calculate(s3)); // Expected: 5
    }
}
