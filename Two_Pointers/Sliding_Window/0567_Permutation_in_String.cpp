/*
Problem: Permutation in String (LeetCode 567)
Category: Sliding Window / Frequency Count
Difficulty: Medium

Approach:
1. Maintain frequency array for s1 and current window in s2.
2. Slide window of size s1.length().
3. Compare frequency arrays.

Time Complexity: O(n)
Space Complexity: O(1)
*/

#include <vector>
#include <string>
using namespace std;

class Solution 
{
public:
    bool checkInclusion(string s1, string s2) 
    {

        int n1 = s1.size(), n2 = s2.size();
        if (n1 > n2) return false;

        vector<int> freq1(26, 0), freq2(26, 0);

        // Frequency of s1
        for (char c : s1) 
        {
            freq1[c - 'a']++;
        }

        for (int i = 0; i < n2; i++) 
        {

            // Add current character
            freq2[s2[i] - 'a']++;

            // Remove character outside window
            if (i >= n1) 
            {
                freq2[s2[i - n1] - 'a']--;
            }

            // Compare frequency arrays
            if (freq1 == freq2) 
            {
                return true;
            }
        }

        return false;
    }
};