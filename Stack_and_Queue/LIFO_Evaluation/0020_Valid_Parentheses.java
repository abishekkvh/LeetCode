/*
Problem: Valid Parentheses (LeetCode 20)
Category: Stack / LIFO Evaluation
Difficulty: Easy

Description:
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

Approach:
1. Initialize a Stack to store opening characters.
2. Traverse the input string character by character:
   - If the character is an opening bracket ('(', '{', or '['), push it onto the stack.
   - If it is a closing bracket, check if the stack is empty. If it is, the string is invalid.
   - Peek the top of the stack. If it matches the corresponding opening bracket for the current closing bracket, pop it. Otherwise, return false.
3. After the loop, if the stack is empty, return true (all brackets matched); otherwise, return false.

Alternative Approach (Hash Map):
- Maintain a map of closing bracket -> opening bracket.
- For each closing bracket, verify that the stack is non-empty and the top matches map.get(ch).

Time Complexity: O(n) where n is the length of the string.
Space Complexity: O(n) for the stack in the worst case (e.g., all opening brackets).
*/

import java.util.*;

class ValidParentheses 
{
    // Approach 1: Direct conditional matching (O(1) auxiliary space beyond stack)
    public static boolean isValid(String s) 
    {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) 
        {
            char ch = s.charAt(i);

            if (ch == '{' || ch == '(' || ch == '[') 
            {
                stack.push(ch);
            } 
            else 
            {
                if (stack.isEmpty()) 
                {
                    return false;
                }

                char top = stack.peek();

                if ((top == '{' && ch == '}') || (top == '(' && ch == ')') || (top == '[' && ch == ']')) 
                {
                    stack.pop();
                } 
                else 
                {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // Approach 2: Hash Map lookup for bracket matching
    public static boolean isValidWithMap(String s) 
    {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) 
        {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') 
            {
                stack.push(ch);
            } 
            else 
            {
                if (stack.isEmpty() || !map.get(ch).equals(stack.peek())) 
                {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) 
    {
        String s = "()[]{}";
        System.out.println("Approach 1 (Direct):  " + isValid(s));
        System.out.println("Approach 2 (HashMap): " + isValidWithMap(s));
    }
}
