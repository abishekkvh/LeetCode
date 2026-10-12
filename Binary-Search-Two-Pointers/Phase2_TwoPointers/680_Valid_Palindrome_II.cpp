/*
Problem: Valid Palindrome II (LeetCode 680)
Category: Two Pointers
Difficulty: Easy

Frequently Asked In: Google, Amazon, Meta, Microsoft

Approach:
1. Use two pointers from both ends.
2. If characters mismatch:
   try skipping either left or right character.
3. If either remaining substring is palindrome → true.

Time Complexity: O(n)
Space Complexity: O(1)
*/

#include <string>
using namespace std;

w