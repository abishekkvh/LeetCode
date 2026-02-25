/*
Problem: H-Index (LeetCode 274)
Category: Sorting / Distribution Analysis
Difficulty: Medium

Approach:
1. Sort citations in descending order.
2. Find maximum h such that citations[h-1] >= h.

Time Complexity: O(n log n)
Space Complexity: O(1)
*/

#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int hIndex(vector<int>& citations) {

        sort(citations.begin(), citations.end(), greater<int>());

        int h = 0;

        for (int i = 0; i < citations.size(); i++) {
            if (citations[i] >= i + 1)
                h = i + 1;
            else
                break;
        }

        return h;
    }
};