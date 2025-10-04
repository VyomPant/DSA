package neetCode150.binarySearch;

/** <a href="https://leetcode.com/problems/binary-search/">...</a>
 Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums.
 If target exists, then return its index. Otherwise, return -1.
 You must write an algorithm with O(log n) runtime complexity.
 * */

class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // We use left + (right - left) / 2 to avoid integer overflow when left + right exceeds the maximum value of int.
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            }
            if (target == nums[mid]) {
                return mid;
            }
        }
        return -1;
    }
}