#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution 
{
public:
    void backtrack(vector<int>& nums, vector<vector<int>>& result, vector<int>& current, vector<bool>& visited) 
    {
        if (current.size() == nums.size()) 
        {
            result.push_back(current);
            return;
        }

        for (int i = 0; i < nums.size(); i++) 
        {
            if (visited[i]) continue;

            if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;

            visited[i] = true;
            current.push_back(nums[i]);

            backtrack(nums, result, current, visited);

            current.pop_back();
            visited[i] = false;
        }
    }

    vector<vector<int>> permuteUnique(vector<int>& nums) 
    {
        vector<vector<int>> result;
        vector<int> current;
        vector<bool> visited(nums.size(), false);
    
        sort(nums.begin(), nums.end());
        
        backtrack(nums, result, current, visited);
        return result;
    }
};

int main() 
{
    Solution solver;

    vector<int> nums = {1, 1, 2};
    vector<vector<int>> uniquePermutations = solver.permuteUnique(nums);
    
    cout << "Unique Permutations:" << endl;
    for (const auto& perm : uniquePermutations) 
    {
        cout << "[ ";
        for (int num : perm) 
        {
            cout << num << " ";
        }
        cout << "]" << endl;
    }
    
    return 0;
}
