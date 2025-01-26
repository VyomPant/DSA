package neetCode150.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
76. Minimum Window Substring https://leetcode.com/problems/minimum-window-substring/description/
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s
such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
*/

public class MinimumWindowSubstring {
    /* Brute Force
    Time complexity:O(n^2) ,  where n is the length of s
    Space complexity:O(k), where k  is the total number of unique characters in t and s
    */

    public static String minWindowBruteForce(String s, String t) {
        int minLength = Integer.MAX_VALUE;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (containsAll(sub, t)) {
                    if (sub.length() < minLength) {
                        minLength = sub.length();
                        result = sub;
                    }
                }
            }
        }
        return result;
    }

    private static boolean containsAll(String sub, String t) {
        Map<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> subCount = new HashMap<>();
        for (char c : sub.toCharArray()) {
            subCount.put(c, subCount.getOrDefault(c, 0) + 1);
        }

        for (char c : tCount.keySet()) {
            if (subCount.getOrDefault(c, 0) < tCount.get(c)) {
                return false;
            }
        }
        return true;
    }


    /* Sliding window approach
    Time complexity:O(n+m) ,  where n is the length of s and m is the length of t
    Space complexity:O(k) , where k  is the number of unique characters in t
    */
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        Map<Character, Integer> tCharacterFrequencyMap = new HashMap<>();// stores character frequency of string t
        for (char c : t.toCharArray()) {
            tCharacterFrequencyMap.put(c, tCharacterFrequencyMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();// stores frequency of each character currently in the window
        int left = 0, right = 0; // start and end of window
        int matched = 0; // matched is a counter used to track how many unique characters from t are completely satisfied in the current sliding window of s.
        int minLen = Integer.MAX_VALUE; // min length window
        String result = "";

        while (right < s.length()) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            /* tCharacterFrequencyMap.containsKey(c): Checks if the character c is required by t. If c is not in t, it is ignored for tracking purposes.
            windowMap.get(c).equals(tCharacterFrequencyMap.get(c)): Ensures that the frequency of c in the current window is exactly equal to the frequency required in t. This means the character c is fully matched.
            */
            if (tCharacterFrequencyMap.containsKey(c) && windowMap.get(c).equals(tCharacterFrequencyMap.get(c))) {
                matched++;
            }
            /*while (matched == tCharacterFrequencyMap.size()) :This loop is triggered when all unique characters in t are fully satisfied in the current window (matched == tCharacterFrequencyMap.size()).
            Purpose: To shrink the window from the left (left pointer) as much as possible while still satisfying the constraints of t. The goal is to minimize the window size.
            */
            while (matched == tCharacterFrequencyMap.size()) {
                // Update result if smaller window is found
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    result = s.substring(left, right + 1);
                }

                // Shrink the window from the left
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (tCharacterFrequencyMap.containsKey(leftChar) && windowMap.get(leftChar) < tCharacterFrequencyMap.get(leftChar)) {
                    matched--;
                }
                left++;
            }

            right++;
        }
        return result;
    }

    /* Sliding window approach with space optimisation using array
    Time complexity:O(n) ,  Optimized character counting and window manipulation
    Space complexity:O(1)
    */
    public static String minWindowArray(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        int[] tFreq = new int[128];
        int[] windowFreq = new int[128];
        for (char c : t.toCharArray()) {
            tFreq[c]++;
        }

        int left = 0, right = 0, matched = 0, minLen = Integer.MAX_VALUE;
        String result = "";

        while (right < s.length()) {
            char c = s.charAt(right);
            windowFreq[c]++;
            if (tFreq[c] > 0 && windowFreq[c] <= tFreq[c]) {
                matched++;
            }

            while (matched == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    result = s.substring(left, right + 1);
                }

                char leftChar = s.charAt(left);
                windowFreq[leftChar]--;
                if (tFreq[leftChar] > 0 && windowFreq[leftChar] < tFreq[leftChar]) {
                    matched--;
                }
                left++;
            }

            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
