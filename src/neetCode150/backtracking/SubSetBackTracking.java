package neetCode150.backtracking;

import java.util.*;
/**
 * Given an integer array `nums` of **distinct elements**, return **all possible subsets** (the **power set**) of the array.
 * A subset **does not maintain order**, and the solution set **must not contain duplicates**.
 * <a href="https://leetcode.com/problems/subsets/">LeetCode Problem: Subsets</a>
 * I/P : nums = [1, 2, 3]
 * O/P : [
 *   [],        // empty subset
 *   [1],
 *   [2],
 *   [3],
 *   [1,2],
 *   [1,3],
 *   [2,3],
 *   [1,2,3]
 * ]
 * */
public class SubSetBackTracking {

    /**
     * Returns all subsets (the power set) of nums using backtracking.
     *
     * Key pattern:
     * - at each step, we either choose an element or skip it
     * - save the current partial solution (path)
     * - for-loop chooses next candidate, recursive call explores deeper
     * - after recursion, we undo the choice (backtrack) by removing last element
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();         // current partial solution
        backtrack(0, nums, path, result);
        return result;
    }

    /**
     * Helper function to explore all possible subsets of nums using backtracking.
     *
     * @param start the starting index of the current subset
     * @param nums the array of numbers to consider
     * @param path the current partial solution (a valid subset)
     * @param result the list of all valid subsets found so far
     */
    private void backtrack(int start, int[] nums, List<Integer> path, List<List<Integer>> result) {
        // Save current partial solution (a valid subset)
        result.add(new ArrayList<>(path)); // NOTE: copy the list

        // Explore further choices starting from index 'start'
        for (int i = start; i < nums.length; i++) {
            // ---------- CHOOSE ----------
            path.add(nums[i]);               // choose nums[i]
            // ---------- EXPLORE ----------
            backtrack(i + 1, nums, path, result); // explore with chosen element
            // ---------- UN-CHOOSE ----------
            path.remove(path.size() - 1);   // undo choice (backtrack)
        }
    }

    // Simple driver to test
    public static void main(String[] args) {
        SubSetBackTracking solver = new SubSetBackTracking();
        int[] nums = {1, 2, 3};
        List<List<Integer>> out = solver.subsets(nums);
        System.out.println(out);
    }
}
