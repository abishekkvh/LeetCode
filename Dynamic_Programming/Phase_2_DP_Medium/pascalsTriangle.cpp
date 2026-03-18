/*
Problem: Pascal's Triangle (LeetCode 118)
Category: Dynamic Programming
Difficulty: Easy

Problem Statement:
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal’s triangle:
- First and last elements of each row are 1
- Every other element is sum of two elements from previous row

Approach:
1. Create a 2D vector to store rows
2. For each row:
      - First and last element = 1
      - Middle elements:
            triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j]

Time Complexity: O(n^2)
Space Complexity: O(n^2)
*/

#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> generate(int numRows) 
    {
        vector<vector<int>> triangle;

        for(int i = 0; i < numRows; i++)
        {
            vector<int> row(i + 1, 1); // all 1s initially

            for(int j = 1; j < i; j++)
            {
                row[j] = triangle[i-1][j-1] + triangle[i-1][j];
            }

            triangle.push_back(row);
        }

        return triangle;
    }
};

int main()
{
    int n;
    cout << "Enter number of rows: ";
    cin >> n;

    Solution obj;
    vector<vector<int>> result = obj.generate(n);

    cout << "Pascal's Triangle:\n";

    for(auto row : result)
    {
        for(int val : row)
        {
            cout << val << " ";
        }
        cout << endl;
    }

    return 0;
}