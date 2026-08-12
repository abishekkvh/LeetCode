/*
Problem: Boats to Save People (LeetCode 881)
Category: Two Pointers / Greedy
Difficulty: Medium

Approach:
1. Sort the array of people.
2. Initialize two pointers: left (lightest person) and right (heaviest person).
3. Pair the heaviest person with the lightest person if their combined weight is within the limit.
   - If they can fit, move the left pointer to the right.
   - In either case, the heaviest person gets a boat, so move the right pointer to the left.
4. Increment the boat count at each step.

Time Complexity: O(n log n) (due to sorting)
Space Complexity: O(1) or O(log n) depending on the sorting algorithm


2,3,4,4

2 4 4
2 3 4
2 3 4
*/

package Two_Pointers.Opposite_Direction;

import java.util.Arrays;

class Boats_To_Save_People {
    public int numRescueBoats(int[] people, int limit) {
        int boats = 0;
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            // If the lightest and heaviest person can fit in the same boat
            if (people[left] + people[right] <= limit) {
                left++;
            }
            // The heaviest person always gets a boat
            right--;
            boats++;
        }
        return boats;
    }

    public static void main(String[] args) {
        Boats_To_Save_People solver = new Boats_To_Save_People();

        System.out.println("Running LeetCode 881: Boats to Save People");
        System.out.println("===========================================");

        // Test Case 1
        int[] people1 = { 1, 2 };
        int limit1 = 3;
        System.out.println("Test Case 1:");
        System.out.println("People: " + Arrays.toString(people1) + ", Limit: " + limit1);
        System.out.println("Expected output: 1");
        System.out.println("Actual output:   " + solver.numRescueBoats(people1, limit1));
        System.out.println();

        // Test Case 2
        int[] people2 = { 3, 2, 2, 1 };
        int limit2 = 3;
        System.out.println("Test Case 2:");
        System.out.println("People: " + Arrays.toString(people2) + ", Limit: " + limit2);
        System.out.println("Expected output: 3");
        System.out.println("Actual output:   " + solver.numRescueBoats(people2, limit2));
        System.out.println();

        // Test Case 3
        int[] people3 = { 3, 5, 3, 4 };
        int limit3 = 5;
        System.out.println("Test Case 3:");
        System.out.println("People: " + Arrays.toString(people3) + ", Limit: " + limit3);
        System.out.println("Expected output: 4");
        System.out.println("Actual output:   " + solver.numRescueBoats(people3, limit3));
        System.out.println();
    }
}
