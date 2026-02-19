/*
Problem: Can Make Arithmetic Progression From Sequence (LeetCode 1502)
Category: Sorting / Pattern Verification
Difficulty: Easy

Approach:
1. Sort the array.
2. Calculate common difference between first two elements.
3. Verify all consecutive differences are equal.

Time Complexity: O(n log n)
Space Complexity: O(1)
*/

#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    bool canMakeArithmeticProgression(vector<int>& arr) {
        sort(arr.begin(), arr.end());

        int diff = arr[1] - arr[0];

        for (int i = 2; i < arr.size(); i++) {
            if (arr[i] - arr[i - 1] != diff)
                return false;
        }

        return true;
    }
};