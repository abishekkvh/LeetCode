/*
Problem: Valid Anagram (LeetCode 242)
Category: Sorting / Strings
Difficulty: Easy

Approach:
If two strings are anagrams,
their sorted versions will be identical.

Steps:
1. If lengths differ → return false.
2. Sort both strings.
3. Compare.

Time Complexity: O(n log n)
Space Complexity: O(1) (ignoring sort stack)
*/

#include <string>
#include <algorithm>
using namespace std;

class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.length() != t.length())
            return false;

        sort(s.begin(), s.end());
        sort(t.begin(), t.end());

        return s == t;
    }
};