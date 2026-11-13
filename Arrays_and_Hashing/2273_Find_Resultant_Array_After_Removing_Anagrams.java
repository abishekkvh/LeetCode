/*
Problem: Find Resultant Array After Removing Anagrams (LeetCode 2273)
Category: Arrays & Hashing
Difficulty: Easy

Approach:
1. Initialize a result list with all input words.
2. Iteratively inspect consecutive adjacent pairs (words[i] and words[i-1]).
3. If words[i] and words[i-1] are anagrams of each other (verified via character frequency counts), remove words[i] from the sequence.
4. Continue until no two adjacent elements are anagrams.

Time Complexity: O(N * K) where N is number of words, K is max length of a word
Space Complexity: O(N * K)
*/

import java.util.*;

class FindResultantArrayAfterRemovingAnagrams {
    static List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            result.add(words[i]);
        }

        for (int i = 1; i < result.size(); i++) {
            if (isAnagram(result.get(i), result.get(i - 1))) {
                result.remove(i);
                i--;
            }
        }
        
        return result;
    }

    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> map = new HashMap<>();

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

    public static void main(String[] args) {
        String words[] = {"abba", "baba", "bbaa", "cd", "cd"};
        System.out.println(removeAnagrams(words));
    }
}
