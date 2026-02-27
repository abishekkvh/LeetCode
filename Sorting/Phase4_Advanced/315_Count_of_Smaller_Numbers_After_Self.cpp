/*
Problem: Count of Smaller Numbers After Self (LeetCode 315)
Category: Merge Sort / Inversion Counting
Difficulty: Hard

Approach:
1. Use modified merge sort.
2. Track original indices.
3. While merging, count how many elements from right
   are placed before left elements.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

#include <vector>
using namespace std;

class Solution {
public:

    void mergeSort(vector<pair<int,int>>& nums,
                   vector<int>& counts,
                   int left, int right) {

        if (right - left <= 1) return;

        int mid = left + (right - left) / 2;

        mergeSort(nums, counts, left, mid);
        mergeSort(nums, counts, mid, right);

        vector<pair<int,int>> temp;
        int i = left;
        int j = mid;
        int rightCount = 0;

        while (i < mid && j < right) {
            if (nums[j].first < nums[i].first) {
                temp.push_back(nums[j]);
                rightCount++;
                j++;
            } else {
                counts[nums[i].second] += rightCount;
                temp.push_back(nums[i]);
                i++;
            }
        }

        while (i < mid) {
            counts[nums[i].second] += rightCount;
            temp.push_back(nums[i]);
            i++;
        }

        while (j < right) {
            temp.push_back(nums[j]);
            j++;
        }

        for (int k = left; k < right; k++) {
            nums[k] = temp[k - left];
        }
    }

    vector<int> countSmaller(vector<int>& nums) {

        int n = nums.size();
        vector<pair<int,int>> indexedNums;
        vector<int> counts(n, 0);

        for (int i = 0; i < n; i++) {
            indexedNums.push_back({nums[i], i});
        }

        mergeSort(indexedNums, counts, 0, n);

        return counts;
    }
};