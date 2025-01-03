package neetCode150.arraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/description/
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();//key = arrayValue, value = index of the value in the array
        for(int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];// compliment + nums[i] = target
            //check if compliment exists in the hashmap, this implies there exists a number in the array in which we can add another number to achieve the target
            if(map.containsKey(compliment)) {
                return new int[] {map.get(compliment), i};
            }
            // add arrayValues(key) with indices(values) to the hashmap
            map.put(nums[i],i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int nums[] = {2,7,11,15};
        int[] result = twoSum(nums, 9);
        System.out.println(Arrays.toString(result)); // expected [0, 1]

        //expected [0,1] but got [I@5a39699c
        System.out.println(twoSum(nums,9));
        /*
        The issue here is with how you're trying to print the result of twoSum.
        Since twoSum returns an int[] array, printing it directly with System.out.println() will not display the array's
        contents but rather its memory reference.
        */
    }
}
