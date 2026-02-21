/*
Problem: Insert Interval (LeetCode 57)
Category: Interval / Sorting
Difficulty: Medium

Approach:
1. Add all intervals that end before newInterval starts.
2. Merge overlapping intervals with newInterval.
3. Add remaining intervals.

Time Complexity: O(n)
Space Complexity: O(n)
*/

#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {

        vector<vector<int>> result;
        int i = 0;
        int n = intervals.size();

        // Step 1: Add intervals that end before newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.push_back(intervals[i]);
            i++;
        }

        // Step 2: Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = min(newInterval[0], intervals[i][0]);
            newInterval[1] = max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.push_back(newInterval);

        // Step 3: Add remaining intervals
        while (i < n) {
            result.push_back(intervals[i]);
            i++;
        }

        return result;
    }
};