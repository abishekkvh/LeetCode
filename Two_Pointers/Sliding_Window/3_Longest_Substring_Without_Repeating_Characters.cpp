/*
Problem: Longest Substring Without Repeating Characters (LeetCode 3)
Category: Sliding Window
Difficulty: Medium

Approach:
1. Use sliding window with a frequency map.
2. Expand right pointer.
3. If duplicate found → shrink window from left.
4. Track max length.

Time Complexity: O(n)
Space Complexity: O(1)
*/

#include <vector>
#include <string>
using namespace std;

class Solution 
{
public:
    int lengthOfLongestSubstring(string s) 
    {

        vector<int> freq(256, 0);

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.size(); right++) 
        {

            freq[s[right]]++;

            // If duplicate exists → shrink window
            while (freq[s[right]] > 1) 
            {
                freq[s[left]]--;
                left++;
            }

            maxLen = max(maxLen, right - left + 1);
        }

        return maxLen;
    }
};