package neetCode150.twoPointers;

import java.util.Arrays;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
public class TwoSum2 {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            }
            if (sum < target) {
                left++;
            }
            if (sum == target) {
                return new int[]{left+1, right+1};
            }

        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] result = twoSum(nums, 9);
        System.out.println(Arrays.toString(result));
    }
}
