/*
Problem: Merge Sorted Array (LeetCode 88)
Category: Sorting / Two Pointer Technique
Difficulty: Easy

Approach:
We use three pointers starting from the end of both arrays.
Compare elements from nums1 and nums2 and place the larger one
at the end of nums1.

This avoids extra space and works in-place.

Time Complexity: O(m + n)
Space Complexity: O(1)
*/

#include <vector>
using namespace std;

class Solution 
{
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) 
    {
        int i = m - 1;          // Pointer for nums1
        int j = n - 1;          // Pointer for nums2
        int k = m + n - 1;      // Pointer for placement in nums1

        // Merge from the back
        while (i >= 0 && j >= 0) 
        {
            if (nums1[i] > nums2[j]) 
            {
                nums1[k--] = nums1[i--];
            } 
            else 
            {
                nums1[k--] = nums2[j--];
            }
        }

        // If nums2 still has elements
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
};