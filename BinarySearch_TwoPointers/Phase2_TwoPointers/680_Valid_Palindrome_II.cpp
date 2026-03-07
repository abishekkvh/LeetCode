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

class Solution {
public:

    bool isPalindrome(string &s, int left, int right) {
        while (left < right) {
            if (s[left] != s[right])
                return false;
            left++;
            right--;
        }
        return true;
    }

    bool validPalindrome(string s) {

        int left = 0;
        int right = s.size() - 1;

        while (left < right) {

            if (s[left] != s[right]) {

                return isPalindrome(s, left + 1, right) ||
                       isPalindrome(s, left, right - 1);
            }

            left++;
            right--;
        }

        return true;
    }
};