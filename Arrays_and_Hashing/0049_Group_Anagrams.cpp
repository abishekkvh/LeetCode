#include <iostream>
#include <vector>       
#include <string>       
#include <unordered_map> 

using namespace std;

class Solution
{
    public:
    vector<vector<string>> groupAnagrams(vector<string>& strs)
    {
        unordered_map<string, vector<string>> anagramMap;

        for(string word : strs)
        {
            string countKey(26, 0);

            for(char c : word)
            {
                countKey[c - 'a']++;
            }

            anagramMap[countKey].push_back(word);

            cout << "Key generated: ";
            for(char count : countKey) cout << (int)count << " "; 
            cout << " -> Vector currently holds: ";
            for(const string& s : anagramMap[countKey]) 
            {
                cout << s << " ";
            }
            cout << endl;
        }

        vector<vector<string>> result;

        for(auto pair : anagramMap)
        {
            result.push_back(std::move(pair.second));
        }

        return result;
    }
};

int main() 
{
    Solution solution;

    vector<string> testInput = {"eat", "tea", "tan", "ate", "nat", "bat"};
    vector<vector<string>> groupedAnagrams = solution.groupAnagrams(testInput);
    
    cout << "[\n";
    for (const auto& group : groupedAnagrams) 
    {
        cout << "  [";
        for (size_t i = 0; i < group.size(); ++i) 
        {
            cout << "\"" << group[i] << "\"";
            if (i < group.size() - 1) 
            {
                cout << ", ";
            }
        }
        cout << "]\n";
    }
    cout << "]\n";
    
    return 0;
}
