/*
Problem: Maximum Gap (LeetCode 164)
Category: Bucket Sort / Pigeonhole Principle
Difficulty: Hard

Approach:
1. Find min and max.
2. Compute bucket size = ceil((max - min) / (n - 1)).
3. Create buckets storing only min and max.
4. Compute max gap between consecutive non-empty buckets.

Time Complexity: O(n)
Space Complexity: O(n)
*/

#include <vector>
#include <climits>
#include <cmath>
using namespace std;

class Solution {
public:
    int maximumGap(vector<int>& nums) {

        int n = nums.size();
        if (n < 2) return 0;

        int minVal = INT_MAX;
        int maxVal = INT_MIN;

        for (int num : nums) {
            minVal = min(minVal, num);
            maxVal = max(maxVal, num);
        }

        if (minVal == maxVal) return 0;

        int bucketSize = ceil((double)(maxVal - minVal) / (n - 1));
        int bucketCount = (maxVal - minVal) / bucketSize + 1;

        vector<int> bucketMin(bucketCount, INT_MAX);
        vector<int> bucketMax(bucketCount, INT_MIN);
        vector<bool> used(bucketCount, false);

        // Place numbers into buckets
        for (int num : nums) {
            int index = (num - minVal) / bucketSize;
            bucketMin[index] = min(bucketMin[index], num);
            bucketMax[index] = max(bucketMax[index], num);
            used[index] = true;
        }

        int maxGap = 0;
        int prevMax = minVal;

        for (int i = 0; i < bucketCount; i++) {
            if (!used[i]) continue;

            maxGap = max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }

        return maxGap;
    }
};