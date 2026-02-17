/*
Problem: Sort Characters By Frequency (LeetCode 451)
Category: Custom Sorting / HashMap
Difficulty: Medium

Approach:
1. Count frequency using unordered_map.
2. Store characters in a vector.
3. Sort the vector based on frequency (descending).
4. Build result string accordingly.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

#include <string>
#include <unordered_map>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    string frequencySort(string s) {
        unordered_map<char, int> freq;

        // Count frequency
        for (char c : s) 
        {
            freq[c]++;
        }

        // Store unique characters
        vector<char> chars;
        for (auto &p : freq) 
        {
            chars.push_back(p.first);
        }

        // Custom sort based on frequency
        sort(chars.begin(), chars.end(), [&](char a, char b) 
        {
            return freq[a] > freq[b];
        });

        // Build result
        string result;
        for (char c : chars) 
        {
            result.append(freq[c], c);
        }

        return result;
    }
};