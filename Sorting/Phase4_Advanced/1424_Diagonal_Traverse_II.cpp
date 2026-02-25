/*
Problem: Diagonal Traverse II (LeetCode 1424)
Category: Custom Sorting / Coordinates
Difficulty: Medium

Approach:
1. Store each element as (row+col, row, value).
2. Sort by:
   - First: diagonal number (ascending)
   - Second: row (descending)
3. Extract values in sorted order.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

#include <vector>
#include <tuple>
#include <algorithm>
using namespace std;

class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& nums) {

        vector<tuple<int,int,int>> elements;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums[i].size(); j++) {
                elements.push_back({i + j, -i, nums[i][j]});
            }
        }

        sort(elements.begin(), elements.end());

        vector<int> result;
        for (auto &t : elements) {
            result.push_back(get<2>(t));
        }

        return result;
    }
};