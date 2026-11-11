/*
Problem: Word Pattern (LeetCode 290)
Category: Arrays & Hashing / Hash Map
Difficulty: Easy

Approach:
1. Split string `s` into tokens by whitespace.
2. If the pattern length does not equal the word count, bijection is impossible -> return false.
3. Maintain a HashMap (Character -> String) and a HashSet (seen words) to ensure a 1-to-1 bijective mapping.
4. For each character and corresponding word:
   - If character is already mapped, verify it matches the current word.
   - If character is unmapped, ensure the word is not already claimed by another character.
5. Return true if all pairs satisfy the bijection.

Time Complexity: O(N) where N is number of words / characters in pattern
Space Complexity: O(U) where U is number of unique words and characters
*/

import java.util.*;

class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        List<String> str = new ArrayList<>(Arrays.asList(s.split(" ")));
        HashSet<String> set = new HashSet<>();

        if (pattern.length() != str.size()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = str.get(i);
            String mappedWord = map.getOrDefault(c, " ");

            if (!mappedWord.equals(word)) {
                if (mappedWord.equals(" ")) {
                    if (!set.contains(word)) {
                        map.put(c, word);
                        set.add(word);
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "cat dog cat";
        String pattern = "aba";

        System.out.println(wordPattern(pattern, s));
    }
}
