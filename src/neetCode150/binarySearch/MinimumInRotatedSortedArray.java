package neetCode150.binarySearch;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/">...</a>
 * You are given an array of length n which was originally sorted in ascending order. It has now been rotated between 1 and n times. For example, the array nums = [1,2,3,4,5,6] might become:
 * [3,4,5,6,1,2] if it was rotated 4 times.
 * [1,2,3,4,5,6] if it was rotated 6 times.
 * Notice that rotating the array 4 times moves the last four elements of the array to the beginning. Rotating the array 6 times produces the original array.
 *
 * Assuming all elements in the rotated sorted array nums are unique, return the minimum element of this array.
 * You must write a solution in O(log(n)) time complexity.
 */
public class MinimumInRotatedSortedArray {

    /**
     * Optimal solution : Binary Search
     * Time Complexity : O(log(n))
     * Space Complexity : O(1)
     * Intuition:
     * 1. A sorted (non-rotated) array always satisfies nums[left] < nums[right]. → So if this happens, we already know the whole subarray is sorted and the leftmost element is the smallest.
     * 2. The rotation “breaks” this sorted order at exactly one point — the minimum element.
     * 3. We can use binary search to narrow down where that “break” is:
     *  i. Check the middle element (mid).
     *  ii. Depending on whether nums [mid] lies in the left sorted half or right sorted half, we move our search window.
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int minValue = nums[0]; // keep track of the smallest value found so far

        while (left <= right) {
            // Case 1: current subarray is already sorted
            if (nums[left] < nums[right]) {
                // leftmost element is the minimum in this range
                minValue = Math.min(minValue, nums[left]);
                break;
            }

            int mid = left + (right - left) / 2;
            minValue = Math.min(minValue, nums[mid]);

            // Case 2: Left part [left..mid] is sorted
            if (nums[mid] >= nums[left]) {
                // Minimum must lie in the unsorted right part
                left = mid + 1;
            }
            // Case 3: Right part [mid..right] is sorted
            else {
                // Minimum must lie in the left part
                right = mid - 1;
            }
        }

        return minValue;
    }

    /**
     * Optimal solution : Binary Search (Lower Bound) , more clean concise code for interviews
     * Time Complexity : O(log(n))
     * Space Complexity : O(1)
     * Intuition:
     * 1. In a rotated sorted array, the minimum element is the only element that is smaller than its previous element (the “rotation point”).
     * 2. So, instead of storing results (res = Math.min(res, …)), this approach just keeps narrowing down the range until only that minimum element remains.
     * 3.We use binary search and maintain two pointers l → left index , r → right index:
     *  i. Compute m = l + (r - l) / 2.
     *  ii.Compare nums[m] with nums[r] , Why nums[r] ? Because nums[r] helps us know if the right half is sorted
     *  iii.Case 1: nums[m] < nums[r] -> The minimum lies in the left half, including m, Reason: If nums[m] < nums[r], the right half [m..r] is sorted — so the rotation point (minimum) must be at m or to its left. Hence r = m
     *  iv.Case 2: nums[m] > nums[r] -> The minimum lies in the right half, excluding m. Reason: If nums[m] > nums[r], that means the “break” (rotation point) is in the right half (because left is sorted). Hence l = m + 1
     *  v. Loop ends when l == r, At this point, both pointers point to the minimum element. Hence return nums[l];
     */

    public int findMinimum(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Continue searching until left and right converge
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Case 1: right half is sorted -> min lies in left half (including mid)
            if (nums[mid] < nums[right]) {
                right = mid;
            }
            // Case 2: left half is sorted -> min lies in right half (excluding mid)
            else {
                left = mid + 1;
            }
        }

        // When left == right, that index points to the smallest element
        return nums[left];
    }

    /**
     * Brute Force solution
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    public int findMinBruteForce(int[] nums) {
        return Arrays.stream(nums).min().getAsInt();
    }
}
