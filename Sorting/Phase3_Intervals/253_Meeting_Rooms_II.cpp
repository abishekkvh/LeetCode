/*
Problem: Meeting Rooms II (LeetCode 253)
Category: Interval / Heap / Sorting
Difficulty: Medium

Approach:
1. Sort meetings by start time.
2. Use a min heap to track end times.
3. If next meeting starts after earliest ending meeting,
   reuse the room (pop heap).
4. Otherwise, allocate new room.
5. Heap size = number of rooms required.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& intervals) {

        if (intervals.empty()) return 0;

        // Sort by start time
        sort(intervals.begin(), intervals.end());

        // Min heap to store end times
        priority_queue<int, vector<int>, greater<int>> minHeap;

        // Add first meeting's end time
        minHeap.push(intervals[0][1]);

        for (int i = 1; i < intervals.size(); i++) {

            // If meeting can reuse a room
            if (intervals[i][0] >= minHeap.top()) {
                minHeap.pop();
            }

            // Allocate room (push end time)
            minHeap.push(intervals[i][1]);
        }

        return minHeap.size();
    }
};