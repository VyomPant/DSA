package neetCode150.binarySearch;

/**
 * Not in Neetcode list still added
 * <a href="https://leetcode.com/problems/search-a-2d-matrix/">...</a>
 * Search a 2D Matrix You are given an m x n integer matrix matrix with the following two properties:
 * 1. Each row is sorted in non-decreasing order.
 * 2. The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 * You must write a solution in O(log(m * n)) time complexity.
 */
public class SearchSortedMatrix {
    /**
     * Not most optimal solution
     * Time Complexity : O(mlog(n))
     * Space Complexity : O(1) , int[] nums = matrix[i]; does not create a new array.
     * It just creates a reference to an existing row in matrix.
     * So, no new space is allocated for nums[].
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;         // Number of rows
        int n = matrix[0].length;      // Number of columns
        for (int i = 0; i < m; i++) { // iterate every row
            // inside each row perform a binary search
            int left = 0;
            int right = n - 1;
            while (left <= right) {
                int[] nums = matrix[i]; // extract each row
                int mid = left + (right - left) / 2;
                if (target > nums[mid]) {
                    left = mid + 1;
                }
                if (target < nums[mid]) {
                    right = mid - 1;
                }
                if (target == nums[mid]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Optimal solution
     * To meet the constraint of O(log(m * n)),
     * You need to treat the 2D matrix as a flattened 1D sorted array and perform binary search over it.
     * This works because the matrix follows this property:
     * The first integer of each row is greater than the last integer of the previous row.
     *
     * Time Complexity : O(log(m*n))
     * Space Complexity : O(1)
     */
    public boolean searchMatrixOptimal(int[][] matrix, int target) {
        int m = matrix.length; // Number of rows
        int n = matrix[0].length; // Number of columns

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Convert mid index to 2D indices
            int row = mid / n;
            int col = mid % n;

            int midVal = matrix[row][col];

            if (midVal == target) {
                return true;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

}
