/*
Problem: Non-overlapping Intervals (LeetCode 435)
Category: Interval / Greedy
Difficulty: Medium

Approach:
1. Sort intervals based on end time.
2. Keep track of the last selected interval's end.
3. If current interval overlaps → remove it.
4. Otherwise, update end.

Time Complexity: O(n log n)
Space Complexity: O(1)
*/

#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {

        if (intervals.empty()) return 0;

        // Sort by end time
        sort(intervals.begin(), intervals.end(), [](auto &a, auto &b) {
            return a[1] < b[1];
        });

        int count = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals[i][0] < end) {
                // Overlapping → remove this interval
                count++;
            } else {
                // No overlap → update end
                end = intervals[i][1];
            }
        }

        return count;
    }
};