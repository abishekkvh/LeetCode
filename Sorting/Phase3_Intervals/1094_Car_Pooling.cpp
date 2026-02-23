/*
Problem: Car Pooling (LeetCode 1094)
Category: Interval / Line Sweep / Sorting
Difficulty: Medium

Approach:
1. Convert each trip into two events:
   - +passengers at start location
   - -passengers at end location
2. Sort events by location.
3. Traverse events and track current passengers.
4. If capacity exceeded → return false.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {

        vector<pair<int, int>> events;

        // Create events
        for (auto &trip : trips) {
            int passengers = trip[0];
            int start = trip[1];
            int end = trip[2];

            events.push_back({start, passengers});     // pickup
            events.push_back({end, -passengers});      // drop
        }

        // Sort by location
        sort(events.begin(), events.end());

        int currentPassengers = 0;

        for (auto &event : events) {
            currentPassengers += event.second;

            if (currentPassengers > capacity)
                return false;
        }

        return true;
    }
};