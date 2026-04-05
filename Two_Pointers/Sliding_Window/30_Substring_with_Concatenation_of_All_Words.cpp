/*
Problem: Substring with Concatenation of All Words (LeetCode 30)
Category: Sliding Window / HashMap
Difficulty: Hard

Approach:
1. Use hashmap to store word frequencies.
2. Slide window in steps of word length.
3. Maintain current window word count.
4. If count exceeds → shrink window.
5. If all words matched → record index.

Time Complexity: O(n * wordLen)
Space Complexity: O(n)
*/

#include <vector>
#include <string>
#include <unordered_map>
using namespace std;

class Solution 
{
public:
    vector<int> findSubstring(string s, vector<string>& words) 
    {

        vector<int> result;
        if (words.empty()) return result;

        int wordLen = words[0].size();
        int wordCount = words.size();
        int windowSize = wordLen * wordCount;

        unordered_map<string, int> wordMap;

        for (string word : words) 
        {
            wordMap[word]++;
        }

        // Try all starting offsets
        for (int i = 0; i < wordLen; i++) 
        {

            unordered_map<string, int> windowMap;
            int left = i, count = 0;

            for (int j = i; j + wordLen <= s.size(); j += wordLen) 
            {

                string word = s.substr(j, wordLen);

                if (wordMap.count(word)) 
                {

                    windowMap[word]++;
                    count++;

                    // If more than required → shrink
                    while (windowMap[word] > wordMap[word]) 
                    {
                        string leftWord = s.substr(left, wordLen);
                        windowMap[leftWord]--;
                        left += wordLen;
                        count--;
                    }

                    // If valid window
                    if (count == wordCount) 
                    {
                        result.push_back(left);
                    }

                } 
                else 
                {
                    // Reset window
                    windowMap.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }

        return result;
    }
};