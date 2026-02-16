/*
Problem: K Closest Points to Origin (LeetCode 973)
Category: Custom Sorting
Difficulty: Medium

Approach:
1. Sort points based on Euclidean distance from origin.
2. Return first k points.

We compare squared distances to avoid unnecessary sqrt computation.

Time Complexity: O(n log n)
Space Complexity: O(1) (ignoring output storage)
*/

#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {

        sort(points.begin(), points.end(), [](const vector<int>& a, const vector<int>& b) {
            int distA = a[0]*a[0] + a[1]*a[1];
            int distB = b[0]*b[0] + b[1]*b[1];
            return distA < distB;
        });

        return vector<vector<int>>(points.begin(), points.begin() + k);
    }
};