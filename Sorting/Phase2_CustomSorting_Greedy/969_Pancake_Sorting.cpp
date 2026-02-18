/*
Problem: Pancake Sorting (LeetCode 969)
Category: Simulation / Sorting
Difficulty: Medium

Approach:
1. For current size from n to 1:
   - Find index of maximum element.
   - Flip it to the front.
   - Flip it to its correct position.
2. Repeat for remaining unsorted portion.

Time Complexity: O(n^2)
Space Complexity: O(1) (ignoring output list)
*/

#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    vector<int> pancakeSort(vector<int>& arr) {
        vector<int> result;
        int n = arr.size();

        for (int currSize = n; currSize > 1; currSize--) {

            // Find index of max element in arr[0...currSize-1]
            int maxIndex = max_element(arr.begin(), arr.begin() + currSize) - arr.begin();

            // If max is not already at correct position
            if (maxIndex != currSize - 1) {

                // Flip max element to front
                reverse(arr.begin(), arr.begin() + maxIndex + 1);
                result.push_back(maxIndex + 1);

                // Flip it to correct position
                reverse(arr.begin(), arr.begin() + currSize);
                result.push_back(currSize);
            }
        }

        return result;
    }
};