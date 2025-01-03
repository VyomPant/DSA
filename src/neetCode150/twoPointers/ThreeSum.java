package neetCode150.twoPointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 2) {
            return result;
        }

        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        // add arrayValues(keys) with indices(values) to the hashmap (for fast retrieval)
        for (int i = 0; i < nums.length; i++) {
            valueIndexMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            //fixing one number
            int currentNumber = nums[i];
            // now we get two sum problem (x + y + currentNumber = 0 -> x + y = compliment of currentNumber)
            for (int j = i + 1; j < nums.length; j++) {
                int target = -currentNumber; //target (both numbers x and y should add up to this number)
                int compliment = target - nums[j];
                if (valueIndexMap.containsKey(compliment) && (valueIndexMap.get(compliment)!= j) && (valueIndexMap.get(compliment)!= i)) {// two sum is found third number is nums[i] for 3 sum
                    List<Integer> currentResultList = new ArrayList<>();
                    currentResultList.add(nums[j]);
                    currentResultList.add(compliment);
                    currentResultList.add(nums[i]);
                    result.add(currentResultList);
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums);
        for (List<Integer> triplet : res) {
            for (int num : triplet) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
