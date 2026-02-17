/*
Problem: Custom Sort String (LeetCode 791)
Category: Custom Comparator / Sorting
Difficulty: Medium

Approach:
1. Store the custom order positions in a map.
2. Sort string 's' based on the custom order.
3. Characters not present in 'order' are placed at the end.

Time Complexity: O(n log n)
Space Complexity: O(1)
*/

#include <string>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    string customSortString(string order, string s) {
        vector<int> priority(26, 26);  // default large priority

        // Assign priority based on custom order
        for (int i = 0; i < order.size(); i++) {
            priority[order[i] - 'a'] = i;
        }

        // Sort based on custom priority
        sort(s.begin(), s.end(), [&](char a, char b) {
            return priority[a - 'a'] < priority[b - 'a'];
        });

        return s;
    }
};