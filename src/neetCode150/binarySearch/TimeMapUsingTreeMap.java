package neetCode150.binarySearch;

/*
 * TimeMap using HashMap + TreeMap
 * <a href="https://leetcode.com/problems/time-based-key-value-store/">...</a>
 *
 * <a href="https://www.geeksforgeeks.org/java/treemap-in-java/">...</a>
 * For each key, we maintain a TreeMap that stores:
 *   timestamp -> value
 *
 * TreeMap allows us to efficiently find:
 *   floorEntry(timestamp) → largest timestamp <= given timestamp.
 *
 * Time Complexity:
 *   set():  O(log n)     because TreeMap insertion is O(log n)
 *   get():  O(log n)     floorEntry() is O(log n)
 *
 * Space Complexity:
 *   O(n) for storing all (key, timestamp, value) entries
 */

import java.util.*;

public class TimeMapUsingTreeMap {

    // For each key: TreeMap of timestamp → value (sorted by timestamp)
    private final Map<String, TreeMap<Integer, String>> store;

    public TimeMapUsingTreeMap() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        // Get the TreeMap for the key, create if absent
        store.computeIfAbsent(key, k -> new TreeMap<>())
                .put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) return "";

        TreeMap<Integer, String> timeValueMap = store.get(key);

        // Find largest timestamp <= given timestamp
        Map.Entry<Integer, String> entry = timeValueMap.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}

