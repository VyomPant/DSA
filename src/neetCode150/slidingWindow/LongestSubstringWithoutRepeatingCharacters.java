package neetCode150.slidingWindow;

import java.util.HashSet;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSubstringWithoutRepeatingCharacters {
   /*
    Time complexity:O(n)
    Space complexity:O(m)
    Where n is the length of the string and and m is the total number of unique characters in the string.
    */
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>(); // for O(1) lookup in the window
        int maxLength = 0;// result (longest window's size = end - start + 1)
        int start = 0; // starting point of the window

        for (int end = 0; end < s.length(); end++) {
            // Shrink the window until the current character is unique
            while (charSet.contains(s.charAt(end))) {
                charSet.remove(s.charAt(start));
                start++;
            }
            charSet.add(s.charAt(end)); // add the character in the set
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }


    public static void main(String[] args) {
        String input1 = "abcabcbb";
        String input2 = "bbbbbbb";
        System.out.printf("Length of the longest substring in %s without repeating characters is: %d%n", input1, lengthOfLongestSubstring(input1));
        System.out.printf("Length of the longest substring in %s without repeating characters is: %d%n", input2, lengthOfLongestSubstring(input2));
    }
}
