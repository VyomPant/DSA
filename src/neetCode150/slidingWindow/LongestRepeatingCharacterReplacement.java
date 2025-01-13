package neetCode150.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;

// https://leetcode.com/problems/longest-repeating-character-replacement/description/
public class LongestRepeatingCharacterReplacement {

    /*
    Time complexity:O(n)
    Space complexity:O(m)
    Where n is the length of the string and and m is the total number of unique characters in the string.
    */
    public static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>(); // Frequency map for characters
        int maxFreq = 0; // Most frequent character count in the current window
        int start = 0; // Start of the window
        int maxLength = 0; // Result

        for (int end = 0; end < s.length(); end++) {
            // Increment the frequency of the current character
            char currentChar = s.charAt(end);
            frequencyMap.put(s.charAt(end), frequencyMap.getOrDefault(s.charAt(end), 0) + 1);
            maxFreq = Math.max(maxFreq, frequencyMap.get(currentChar));

            // Calculate the window size
            int windowSize = end - start + 1;

            // Check if replacements exceed `k`
            if (windowSize - maxFreq > k) {
                // Shrink the window by moving `start` forward
                frequencyMap.put(s.charAt(start), frequencyMap.get(s.charAt(start)) - 1);
                start++;
            }

            // Update the result
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }


    public static void main(String[] args) {
        String input1 = "ABAB";
        String input2 = "AABABBA";
        System.out.printf("Length of the longest substring in %s without repeating characters is: %d%n", input1, characterReplacement(input1, 2));
        System.out.printf("Length of the longest substring in %s without repeating characters is: %d%n", input2, characterReplacement(input2, 1));
    }
}
