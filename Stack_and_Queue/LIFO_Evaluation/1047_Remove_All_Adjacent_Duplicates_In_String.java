/*
Problem: Remove All Adjacent Duplicates In String (LeetCode 1047)
Category: Stack / LIFO Evaluation
Difficulty: Easy

Approach:
LIFO Stack for Adjacent Cancellation:
1. Initialize a character stack to hold the active sequence of characters.
2. Traverse the input string character by character:
   - If the stack is not empty and the top character equals the current character, pop the top character (canceling the adjacent duplicate pair).
   - Otherwise, push the current character onto the stack.
3. Reconstruct and return the resulting string from the characters remaining in the stack.

Time Complexity: O(n) where n is the length of the string s
Space Complexity: O(n) for the stack and StringBuilder auxiliary storage
*/

import java.util.*;

class RemoveAdjacentDuplicates 
{
    public static String removeDuplicates(String s) 
    {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) 
        {
            char ch = s.charAt(i);

            if (!st.isEmpty() && st.peek() == ch) 
            {
                st.pop();
            } 
            else 
            {
                st.push(ch);
            }
        }

        for (char ch : st) 
        {
            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) 
    {
        String s1 = "abbaca";
        System.out.println("Output 1: " + removeDuplicates(s1)); // Expected: "ca"

        String s2 = "azxxzy";
        System.out.println("Output 2: " + removeDuplicates(s2)); // Expected: "ay"
    }
}
