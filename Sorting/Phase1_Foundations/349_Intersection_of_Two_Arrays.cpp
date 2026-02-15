/*
Problem: Intersection of Two Arrays (LeetCode 349)
Category: Sorting / Two Pointer Technique
Difficulty: Easy

Approach:
1. Sort both arrays.
2. Use two pointers to traverse both arrays.
3. If elements match → add to result (avoid duplicates).
4. Move pointers accordingly.

Time Complexity: O(n log n + m log m)
Space Complexity: O(min(n, m))
*/

#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());

        vector<int> result;
        int i = 0, j = 0;

        while (i < nums1.size() && j < nums2.size()) {
            if (nums1[i] == nums2[j]) {
                if (result.empty() || result.back() != nums1[i]) {
                    result.push_back(nums1[i]);
                }
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j]) {
                i++;
            }
            else {
                j++;
            }
        }

        return result;
    }
};