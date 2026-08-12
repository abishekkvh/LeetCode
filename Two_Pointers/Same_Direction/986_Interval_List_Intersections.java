/*
Problem: Interval List Intersections (LeetCode 986)
Category: Two Pointers / Same Direction
Difficulty: Medium

Approach:
1. Use two pointers, i and j, starting at 0 to iterate through firstList and secondList respectively.
2. At each step, find the intersection of the two intervals:
   - The start of the intersection is the maximum of the start points: max(firstList[i][0], secondList[j][0])
   - The end of the intersection is the minimum of the end points: min(firstList[i][1], secondList[j][1])
3. If start <= end, they overlap. Add [start, end] to the result.
4. Move the pointer of the interval that ends earlier (i.e., compare firstList[i][1] and secondList[j][1]).
5. Repeat until we reach the end of either list.

Time Complexity: O(m + n) where m and n are the lengths of firstList and secondList.
Space Complexity: O(1) auxiliary space (excluding the output array).
*/

package Two_Pointers.Same_Direction;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Interval_List_Intersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        List<int[]> result = new ArrayList<>();

        while (i < firstList.length && j < secondList.length) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);

            if (start <= end) {
                result.add(new int[] { start, end });
            }

            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void print2DArray(int[][] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(Arrays.toString(arr[i]));
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Interval_List_Intersections solver = new Interval_List_Intersections();

        System.out.println("Running LeetCode 986: Interval List Intersections");
        System.out.println("================================================");

        // Test Case 1
        int[][] firstList1 = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
        int[][] secondList1 = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
        System.out.println("Test Case 1:");
        System.out.print("First List:  ");
        print2DArray(firstList1);
        System.out.print("Second List: ");
        print2DArray(secondList1);
        System.out.print("Expected:    [[1, 2], [5, 5], [8, 10], [15, 23], [24, 24], [25, 25]]\n");
        System.out.print("Actual:      ");
        print2DArray(solver.intervalIntersection(firstList1, secondList1));
        System.out.println();

        // Test Case 2
        int[][] firstList2 = { { 1, 3 }, { 5, 9 } };
        int[][] secondList2 = {};
        System.out.println("Test Case 2:");
        System.out.print("First List:  ");
        print2DArray(firstList2);
        System.out.print("Second List: ");
        print2DArray(secondList2);
        System.out.print("Expected:    []\n");
        System.out.print("Actual:      ");
        print2DArray(solver.intervalIntersection(firstList2, secondList2));
        System.out.println();
    }
}
