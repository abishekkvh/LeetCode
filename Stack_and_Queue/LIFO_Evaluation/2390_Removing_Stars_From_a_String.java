/*
Problem: Removing Stars From a String (LeetCode 2390)
Category: Stack / LIFO Evaluation
Difficulty: Medium

Approach:
LIFO Stack for Star-Triggered Deletion:
1. Maintain a stack of characters representing the current state of the string.
2. Iterate through each character in the input string:
   - If the character is '*', remove (pop) the closest non-star character to its left from the stack.
   - If the character is not '*', push it onto the stack.
3. Build and return the final string formed by the remaining characters in the stack.

Time Complexity: O(n) where n is the length of the string s
Space Complexity: O(n) for the stack and StringBuilder auxiliary storage
*/

import java.util.*;

class RemovingStars 
{
    public static String removeStars(String s) 
    {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) 
        {
            char ch = s.charAt(i);

            if (!st.isEmpty() && ch == '*') 
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
        String s1 = "leet**cod*e";
        System.out.println("Output 1: " + removeStars(s1)); // Expected: "lecoe"

        String s2 = "erase*****";
        System.out.println("Output 2: " + removeStars(s2)); // Expected: ""
    }
}
