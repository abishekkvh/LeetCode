/*
Problem: Kth Largest Element in an Array (LeetCode 215)
Category: QuickSelect / Advanced Sorting
Difficulty: Medium

Approach:
Use QuickSelect (similar to QuickSort partition).
We partition array and only recurse into required side.

Time Complexity:
- Average: O(n)
- Worst: O(n^2)

Space Complexity: O(1)
*/

#include <vector>
using namespace std;

class Solution {
public:

    int partition(vector<int>& nums, int left, int right) {
        int pivot = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums[i], nums[j]);
                i++;
            }
        }

        swap(nums[i], nums[right]);
        return i;
    }

    int quickSelect(vector<int>& nums, int left, int right, int k) {
        if (left <= right) {
            int pivotIndex = partition(nums, left, right);

            if (pivotIndex == k)
                return nums[pivotIndex];
            else if (pivotIndex < k)
                return quickSelect(nums, pivotIndex + 1, right, k);
            else
                return quickSelect(nums, left, pivotIndex - 1, k);
        }

        return -1;
    }

    int findKthLargest(vector<int>& nums, int k) {
        int n = nums.size();
        // kth largest → index = n - k
        return quickSelect(nums, 0, n - 1, n - k);
    }
};