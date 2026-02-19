/*
Problem: Array Partition (LeetCode 561)
Category: Sorting / Greedy
Difficulty: Easy

Approach:
1. Sort the array.
2. Pair adjacent elements.
3. Sum the smaller element of each pair.
   (After sorting, the smaller element is at even indices.)

Time Complexity: O(n log n)
Space Complexity: O(1)
*/

#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int arrayPairSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());

        int sum = 0;
        for (int i = 0; i < nums.size(); i += 2) {
            sum += nums[i];
        }

        return sum;
    }
};