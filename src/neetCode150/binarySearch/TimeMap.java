package neetCode150.binarySearch;

/*
 * TimeMap using HashMap + List + Binary Search
 *  * <a href="https://leetcode.com/problems/time-based-key-value-store/">...</a>
 *
 * For each key, we store a list of (timestamp, value) pairs.
 * LeetCode guarantees timestamps for each key are set in non-decreasing order.
 * Therefore, lists are always sorted → binary search becomes ideal.
 *
 * Time Complexity:
 *   set():  O(1)         appending to list
 *   get():  O(log n)     binary search for floor timestamp
 *
 * Space Complexity:
 *   O(n) for storing all (key, timestamp, value) entries
 */

import java.util.*;

public class TimeMap {
    // For each key: list of timestamp-value pairs sorted by timestamp
    private final Map<String, List<Pair>> store;

    public TimeMap() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        // Ensure list exists
        store.putIfAbsent(key, new ArrayList<>());
        // Append pair (timestamps are guaranteed non-decreasing)
        store.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) return "";

        List<Pair> pairs = store.get(key);

        int left = 0, right = pairs.size() - 1;
        String result = "";

        // Binary search to find largest timestamp <= given timestamp
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Pair midPair = pairs.get(mid);

            if (midPair.timestamp <= timestamp) {
                result = midPair.value; // candidate answer
                left = mid + 1;         // try to find closer timestamp
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    // Helper class to hold a timestamp-value pair
    // In java you need to import Pair class from import javafx.util.Pair;
    static class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}

