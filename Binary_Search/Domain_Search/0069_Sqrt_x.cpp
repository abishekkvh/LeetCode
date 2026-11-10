/*
Problem: Sqrt(x) (LeetCode 69)
Category: Binary Search on Answer
Difficulty: Easy

Frequently Asked In: Amazon, Microsoft, Google

Approach:
We search for largest integer 'mid' such that:
mid * mid <= x

Search space:
0 → x

Time Complexity: O(log x)
Space Complexity: O(1)
*/

class Solution {
public:
    int mySqrt(int x) {

        if (x < 2) return x;

        long left = 1;
        long right = x;
        long ans = 0;

        while (left <= right) {

            long mid = left + (right - left) / 2;

            if (mid * mid == x)
                return mid;
            else if (mid * mid < x) {
                ans = mid;          // possible answer
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return ans;
    }
};