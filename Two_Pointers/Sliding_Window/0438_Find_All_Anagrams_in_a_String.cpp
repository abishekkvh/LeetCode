/*
Problem: Find All Anagrams in a String (LeetCode 438)
Category: Sliding Window / Hashing
Difficulty: Medium

Approach:
1. Maintain frequency array of size 26.
2. Use sliding window of size p.length().
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
    vector<int> findAnagrams(string s, string p) 
    {

        vector<int> result;

        if (s.size() < p.size()) return result;

        vector<int> freqP(26, 0);
        vector<int> freqS(26, 0);

        // Build frequency for p
        for (char c : p) 
        {
            freqP[c - 'a']++;
        }

        int k = p.size();

        for (int i = 0; i < s.size(); i++) 
        {

            // Add current character
            freqS[s[i] - 'a']++;

            // Remove character outside window
            if (i >= k) 
            {
                freqS[s[i - k] - 'a']--;
            }

            // Compare frequency arrays
            if (freqS == freqP) 
            {
                result.push_back(i - k + 1);
            }
        }

        return result;
    }
};