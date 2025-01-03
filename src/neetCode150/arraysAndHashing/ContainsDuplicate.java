package neetCode150.arraysAndHashing;

import java.util.HashMap;

// https://leetcode.com/problems/contains-duplicate/
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        boolean result = false;
        HashMap<Integer,Integer> numsFrequencyMap = new HashMap<>();
        for (int num : nums) {
            numsFrequencyMap.put(num, numsFrequencyMap.getOrDefault(num,0) + 1 );
        }
        for (Integer value : numsFrequencyMap.values()) {
            if (value > 1) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int nums [] = {1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }
}
