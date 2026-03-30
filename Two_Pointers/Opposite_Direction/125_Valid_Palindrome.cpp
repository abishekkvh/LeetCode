/*
Problem: Valid Palindrome (LeetCode 125)
Category: Two Pointers / Strings
Difficulty: Easy


Approach:
1. Use two pointers from both ends.
2. Skip non-alphanumeric characters.
3. Compare characters in lowercase.

Time Complexity: O(n)
Space Complexity: O(1)
*/

#include <string>
#include <cctype>
using namespace std;

class Solution {
public:
    bool isPalindrome(string s) 
    {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) 
        {

            // Skip non-alphanumeric from left
            while (left < right && !isalnum(s[left]))
                left++;

            // Skip non-alphanumeric from right
            while (left < right && !isalnum(s[right]))
                right--;

            // Compare lowercase characters
            if (tolower(s[left]) != tolower(s[right]))
                return false;

            left++;
            right--;
        }

        return true;
    }
};
