/*
Problem: Assign Cookies (LeetCode 455)
Category: Greedy + Sorting
Difficulty: Easy

Approach:
1. Sort children's greed factors.
2. Sort cookie sizes.
3. Use two pointers.
4. Always try to satisfy the least greedy child first.

This ensures maximum children are satisfied.

Time Complexity: O(n log n + m log m)
Space Complexity: O(1)
*/

#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());

        int child = 0;
        int cookie = 0;

        while (child < g.size() && cookie < s.size()) {
            if (s[cookie] >= g[child]) {
                child++;   // child satisfied
            }
            cookie++;      // move to next cookie
        }

        return child;
    }
};