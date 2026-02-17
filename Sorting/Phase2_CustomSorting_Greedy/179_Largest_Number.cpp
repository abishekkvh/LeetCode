/*
Problem: Largest Number (LeetCode 179)
Category: Custom Comparator / Lexicographical Sorting
Difficulty: Medium

Approach:
1. Convert integers to strings.
2. Sort using custom comparator:
   For two numbers a and b,
   compare (a + b) vs (b + a).
3. If (a + b) is larger, a should come first.
4. Handle edge case: if largest element is "0", return "0".

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

#include <vector>
#include <string>
#include <algorithm>
using namespace std;

class Solution {
public:
    string largestNumber(vector<int>& nums) {

        vector<string> strNums;

        // Convert integers to strings
        for (int num : nums) {
            strNums.push_back(to_string(num));
        }

        // Custom comparator
        sort(strNums.begin(), strNums.end(), [](string a, string b) {
            return a + b > b + a;
        });

        // Edge case: if highest value is "0"
        if (strNums[0] == "0")
            return "0";

        // Build result
        string result;
        for (string s : strNums) {
            result += s;
        }

        return result;
    }
};