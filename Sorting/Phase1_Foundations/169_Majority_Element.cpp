/*
Problem: Majority Element (LeetCode 169)
Category: Sorting
Difficulty: Easy

Approach:
Sort the array.
Since the majority element appears more than n/2 times,
it will always occupy the middle position after sorting.

Time Complexity: O(n log n)
Space Complexity: O(1) (ignoring sort recursion stack)
*/

#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int majorityElement(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        return nums[nums.size() / 2];
    }
};