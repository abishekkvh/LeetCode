/*
Problem: Longest Substring Without Repeating Characters (LeetCode 3)
Category: Two Pointers / Sliding Window
Difficulty: Medium

Approach:
1. Maintain a sliding window [left, i] with a hash map recording the most recent index of each character.
2. When character `c` is encountered:
   - If `c` was seen within the current window (`map.get(c) >= left`), update `left = map.get(c) + 1`.
3. Update max window length: `longestSeen = max(longestSeen, i - left + 1)`.
4. Record `map.put(c, i)` and continue.

Time Complexity: O(n) where n is the length of string s
Space Complexity: O(min(m, n)) where m is the size of the character alphabet
*/

import java.util.*;

class LongestSubstringWithoutRepeatingCharacters {
    static int lengthOfLongestSubstring(String s) {
        int i, count, longestSeen = 0, left = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
                printTable(s, map, left);
            }

            count = i - left + 1;
            longestSeen = Math.max(longestSeen, count);
            map.put(c, i);
        }        

        return longestSeen;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        int longestSeen = lengthOfLongestSubstring(s);

        System.out.println("\nLongest Substring Length : " + longestSeen);
    }

    static void printTable(String s, HashMap<Character, Integer> map, int left) {
        for (int i = 0; i < s.length(); i++) {
            System.out.printf("%-10d", i);
        }

        System.out.println();

        for (int i = 0; i < s.length(); i++) {
            System.out.printf("%-10c", s.charAt(i));
        }

        System.out.println();

        for (int i = 0; i < s.length(); i++) {
            if (i == left) {
                System.out.printf("%-10s", ".");
            } else {
                System.out.printf("%-10s", " ");
            }
        }

        System.out.println();
        System.out.println();
    }
}
