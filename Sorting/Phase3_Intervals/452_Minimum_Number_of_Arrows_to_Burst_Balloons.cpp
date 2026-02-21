/*
Problem: Minimum Number of Arrows to Burst Balloons (LeetCode 452)
Category: Interval / Greedy
Difficulty: Medium

Approach:
1. Sort balloons by end coordinate.
2. Shoot first arrow at end of first balloon.
3. If next balloon starts after arrow position → need new arrow.
4. Otherwise, it gets burst by current arrow.

Time Complexity: O(n log n)
Space Complexity: O(1)
*/

#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {

        if (points.empty()) return 0;

        // Sort by end coordinate
        sort(points.begin(), points.end(), [](auto &a, auto &b) {
            return (long)a[1] < (long)b[1];
        });

        int arrows = 1;
        long arrowPos = points[0][1];

        for (int i = 1; i < points.size(); i++) {
            if (points[i][0] > arrowPos) {
                arrows++;
                arrowPos = points[i][1];
            }
        }

        return arrows;
    }
};