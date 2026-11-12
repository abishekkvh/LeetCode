/*
Problem: Group Anagrams (LeetCode 49)
Category: Arrays & Hashing
Difficulty: Medium

Approach:
1. Iterate through the array of strings and group anagrams together.
2. For each unvisited string, compare against remaining strings using character frequency matching.
3. Track visited strings with a boolean `used` array to avoid duplicate groupings.
4. Collect grouped anagram lists into the final result.

Time Complexity: O(n^2 * k) where n is number of strings, k is max string length
Space Complexity: O(n * k)
*/

import java.util.*;

class GroupAnagrams {
    static boolean valid(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            int count = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), count + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            int count = map.getOrDefault(t.charAt(i), 0);

            if (count == 0)
                return false;

            map.put(t.charAt(i), count - 1);
        }

        return true;
    }

    static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] used = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if (used[i]) {
                continue;
            }

            List<String> temp = new ArrayList<>();
            for (int j = i; j < strs.length; j++) {
                if (valid(strs[i], strs[j]) && !used[j]) {
                    temp.add(strs[j]);
                    used[j] = true;
                }
            }

            result.add(temp);
        }
        
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
