package neetCode150.arraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/group-anagrams/description/
public class GroupAnagrams {
    /*
    Time complexity: O(m*nlogn)
    Space complexity: O(m*n)
    Where
    𝑚 is the number of strings and
    𝑛 is the length of the longest string.
    */
    public static List<List<String>> groupAnagrams(String[] strs) {
        String[] sortedStrs = new String[strs.length];
        Map<String, List<String>> anagramMap = new HashMap<>();//key = sorted string, value = corresponding anagrams
        //sort all strings alphabetically eg strs = {"eat", "tea"};
        // Now, strs will be ["aet", "aet"]
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            sortedStrs[i] = new String(charArray);
           /* anagramMap.putIfAbsent(sortedStrs[i], new ArrayList<>());
            anagramMap.get(sortedStrs[i]).add(strs[i]);*/
            // use computeIfAbsent instead of above code
            anagramMap.computeIfAbsent(sortedStrs[i], k -> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(anagramMap.values());
        /* inefficient rather do   return new ArrayList<>(anagramMap.values());
        Iterating through the map and adding each list to result
        List<List<String>> result = new ArrayList<>();
        for (List<String> values : anagramMap.values()) {
            result.add(values);  // Adding the list to result
        }
        return result; */
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupedAnagramList = groupAnagrams(strs);
        System.out.println("original input");
        for (String str : strs) {
            System.out.print(str + " ");
        }
        System.out.println();
        System.out.println("Output:");
        for (List<String> anagramGroup : groupedAnagramList) {
            for (String anagram : anagramGroup) {
                System.out.print(anagram + " ");
            }
            System.out.println();
        }
    }

    /*
    Time complexity:𝑂(𝑚∗𝑛)
    Space complexity:𝑂(𝑚)
    Where
    𝑚 is the number of strings and
    𝑛 is the length of the longest string.
    */
    public static List<List<String>> groupAnagramsWithoutSorting(String[] strs) {
        // HashMap where key is the character frequency string and value is a list of anagrams.
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String s : strs) {
            // Create an array to count frequency of each character (26 lowercase English letters).
            int[] charCount = new int[26];
            for (char c : s.toCharArray()) {
                charCount[c - 'a']++;
            }
            // Convert the frequency array to a unique key String.
            StringBuilder keyBuilder = new StringBuilder();
            for (int count : charCount) {
                keyBuilder.append(count).append("#"); // "#" separates counts for clarity.
            }
            String key = keyBuilder.toString();

            // Insert into hashmap using the frequency-based key.
            anagramMap.putIfAbsent(key, new ArrayList<>());
            anagramMap.get(key).add(s);
        }

        // Return the list of grouped anagrams.
        return new ArrayList<>(anagramMap.values());
    }
}
