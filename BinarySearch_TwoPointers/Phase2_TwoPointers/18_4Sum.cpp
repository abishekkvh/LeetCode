/*
Problem: 4Sum (LeetCode 18)
Category: Two Pointers
Difficulty: Medium

Frequently Asked In: Amazon, Microsoft, Google, Adobe, Facebook

Approach:
1. Sort the array.
2. Fix two elements using two loops.
3. Use two pointers to find remaining two elements.
4. Skip duplicates to avoid repeated quadruplets.

Time Complexity: O(n^3)
Space Complexity: O(1) (excluding result)
*/

#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {

        sort(nums.begin(), nums.end());
        vector<vector<int>> result;
        int n = nums.size();

        for (int i = 0; i < n - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < n - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {

                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {

                        result.push_back({nums[i], nums[j], nums[left], nums[right]});

                        while (left < right && nums[left] == nums[left + 1])
                            left++;

                        while (left < right && nums[right] == nums[right - 1])
                            right--;

                        left++;
                        right--;
                    }

                    else if (sum < target)
                        left++;
                    else
                        right--;
                }
            }
        }

        return result;
    }
};