/*
Problem: Minimum Window Substring (LeetCode 76)
Category: Sliding Window
Difficulty: Hard

Approach:
1. Use frequency array for required characters.
2. Expand right pointer to include characters.
3. When all characters matched → shrink window from left.
4. Track minimum length window.

Time Complexity: O(n)
Space Complexity: O(1)
*/

#include <vector>
#include <string>
#include <climits>
using namespace std;

class Solution 
{
public:
    string minWindow(string s, string t) 
    {

        vector<int> freq(128, 0);

        // Count required characters
        for (char c : t) 
        {
            freq[c]++;
        }

        int left = 0, right = 0;
        int count = t.size();
        int minLen = INT_MAX;
        int start = 0;

        while (right < s.size()) 
        {

            // If character needed
            if (freq[s[right]] > 0) 
            {
                count--;
            }

            freq[s[right]]--;
            right++;

            // When all characters matched
            while (count == 0) 
            {

                if (right - left < minLen) 
                {
                    minLen = right - left;
                    start = left;
                }

                freq[s[left]]++;

                // If removing breaks condition
                if (freq[s[left]] > 0) 
                {
                    count++;
                }

                left++;
            }
        }

        return (minLen == INT_MAX) ? "" : s.substr(start, minLen);
    }
};