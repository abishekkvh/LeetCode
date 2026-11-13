/*
Problem: Maximum Consecutive Floors Without Special Floors (LeetCode 2274)
Category: Arrays & Hashing / Intervals
Difficulty: Medium

Approach:
1. Sort the special floors array in ascending order.
2. The consecutive floors without special floors can occur in three segments:
   - Below the first special floor: `special[0] - bottom`
   - Between adjacent special floors: `special[i] - special[i-1] - 1`
   - Above the last special floor: `top - special[last]`
3. Track and return the maximum interval length across all segments.

Time Complexity: O(k log k) where k is the length of special floors array (dominated by sorting)
Space Complexity: O(log k) auxiliary space for sorting
*/

import java.util.*;

class MaximumConsecutiveFloorsWithoutSpecialFloors {
    static int maxConsecutive(int bottom, int top, int[] special) {
        int maxFloors = 0;
        Arrays.sort(special);

        // Check range below the first special floor
        if (special[0] - bottom > maxFloors) {
            maxFloors = special[0] - bottom;
        }

        // Check gaps between consecutive special floors
        for (int i = 0; i < special.length - 1; i++) {
            int len = special[i + 1] - special[i] - 1;
            if (len > maxFloors) {
                maxFloors = len;
            }
        }

        // Check range above the last special floor
        if (top - special[special.length - 1] > maxFloors) {
            maxFloors = top - special[special.length - 1];
        }

        return maxFloors;
    }

    public static void main(String args[]) {
        int bottom = 2, top = 9;
        int special[] = {4, 6};

        System.out.println(maxConsecutive(bottom, top, special));
    }
}

