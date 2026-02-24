/*
Problem: Maximum Units on a Truck (LeetCode 1710)
Category: Greedy / Sorting
Difficulty: Easy

Approach:
1. Sort box types in descending order of units per box.
2. Pick as many boxes as possible from highest unit type.
3. Continue until truck is full.

Time Complexity: O(n log n)
Space Complexity: O(1)
*/

#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int maximumUnits(vector<vector<int>>& boxTypes, int truckSize) {

        // Sort by units per box in descending order
        sort(boxTypes.begin(), boxTypes.end(), [](auto &a, auto &b) {
            return a[1] > b[1];
        });

        int totalUnits = 0;

        for (auto &box : boxTypes) {
            int boxesToTake = min(truckSize, box[0]);
            totalUnits += boxesToTake * box[1];
            truckSize -= boxesToTake;

            if (truckSize == 0)
                break;
        }

        return totalUnits;
    }
};