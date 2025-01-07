package neetCode150.arraysAndHashing;

import java.util.*;

// https://leetcode.com/problems/longest-consecutive-sequence/description/

public class LongestConsecutiveSequence {
    /* Time complexity:O(n)
       Space complexity:O(n) */
    public static int longestConsecutiveUsingSet(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int res = 0; // if nums if empty
        // add all nums into a set
        for (int num : nums) {
            numSet.add(num);
        }
        // iterate set and check for sequence
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) { // if this is the first element of the sequence
                int length = 1; // length of longest sequence is 1 for 1 element
                while (numSet.contains(num + length)) {// while numSet contains num+1, num+2,num+3....
                    length++;
                }
                res = Math.max(res, length);
            }
        }
        return res;
    }

    /* Time complexity:O(n)
      Space complexity:O(n) */
    public static int longestConsecutiveUsingMap(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int res = 0;

        for (int num : nums) {
            if (!mp.containsKey(num)) {
                mp.put(num, mp.getOrDefault(num - 1, 0) + mp.getOrDefault(num + 1, 0) + 1);
                mp.put(num - mp.getOrDefault(num - 1, 0), mp.get(num));
                mp.put(num + mp.getOrDefault(num + 1, 0), mp.get(num));
                res = Math.max(res, mp.get(num));
            }
        }
        return res;
    }

    /* Time complexity:O(nlogn)
      Space complexity:O(n) */
    public static int longestConsecutiveUsingSorting(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0, curr = nums[0], streak = 0, i = 0;

        while (i < nums.length) {
            if (curr != nums[i]) {
                curr = nums[i];
                streak = 0;
            }
            while (i < nums.length && nums[i] == curr) {
                i++;
            }
            streak++;
            curr++;
            res = Math.max(res, streak);
        }
        return res;
    }


    public static void main(String[] args) {
        int [] nums = {100,4,200,1,3,2};
        int [] nums2 = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutiveUsingSet(nums2));
        System.out.println(longestConsecutiveUsingMap(nums2));
        System.out.println(longestConsecutiveUsingSorting(nums2));
    }
}
