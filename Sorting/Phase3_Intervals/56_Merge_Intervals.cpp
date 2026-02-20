/*
Problem: Merge Intervals (LeetCode 56)
Category: Interval / Sorting
Difficulty: Medium

Approach:
1. Sort intervals based on starting time.
2. Iterate through intervals.
3. If current interval overlaps with previous, merge them.
4. Otherwise, add to result.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {

        if (intervals.empty()) return {};

        // Step 1: Sort by start time
        sort(intervals.begin(), intervals.end());

        vector<vector<int>> result;
        result.push_back(intervals[0]);

        // Step 2: Merge overlapping intervals
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals[i][0] <= result.back()[1]) {
                // Overlapping → merge
                result.back()[1] = max(result.back()[1], intervals[i][1]);
            } else {
                result.push_back(intervals[i]);
            }
        }

        return result;
    }
};