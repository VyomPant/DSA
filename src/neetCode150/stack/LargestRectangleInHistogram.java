package neetCode150.stack;

import java.util.Stack;

/** <a href="https://leetcode.com/problems/largest-rectangle-in-histogram/">...</a>
 Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
 return the area of the largest rectangle in the histogram.
 * */
public class LargestRectangleInHistogram {

    /**
     * Brute Force Solution using a two loops
     * Time Complexity: O(n^2) → For each bar, we may scan the entire array left and right.
     * Space Complexity: O(1) → No extra data structures.
     */
    public int largestRectangleAreaBruteForce(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        // Iterate through each bar
        for (int i = 0; i < n; i++) {
            int height = heights[i];

            // Expand to the left, can only expand if height is greater than or equal to current bar's height
            int left = i;
            while (left > 0 && heights[left - 1] >= height) {
                left--;
            }

            // Expand to the right, can only expand if height is greater than or equal to current bar's height
            int right = i;
            while (right < n - 1 && heights[right + 1] >= height) {
                right++;
            }

            int width = right - left + 1; // Total width the current bar can extend
            int area = height * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    /**
     * Optimized Solution using a Stack (Monotonic Stack)
     * Time Complexity: O(n)  -> Each index is pushed and popped at most once
     * Space Complexity: O(n) -> Stack to store indices
     * 🤔 Intuition

     To find the largest rectangle, we want to:
     For every bar, expand left and right as far as bars are taller or equal to it.
     This gives us the maximum width for the given height.
     Area = height × width
     But instead of brute-force (previous approach) for every bar,we use a monotonic stack to keep track of increasing heights and compute areas efficiently.

     🧠 Key Idea: Monotonic Stack

     1. We maintain a stack of indices of bars.
     2. The stack is monotonically increasing in terms of heights.
     3. When we find a bar shorter than the one at the top of the stack, we pop from the stack and calculate the area with the popped height as the smallest bar (i.e., height of rectangle).
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        Stack<Integer> stack = new Stack<>(); // Stack to store indices of bars

        // Loop through all bars, including one extra iteration to flush out stack
        for (int i = 0; i <= n; i++) {
            // For the last iteration, we use height 0 to empty the stack
            // The loop runs from i = 0 to i <= n. So we go one step beyond the array.
            // When i == n, we're not accessing any real bar. Instead, we pretend there's a bar of height 0 at the end.
            // Purpose:This ensures that All the remaining bars still in the stack are processed.
            // Especially bars that never encountered a smaller bar on their right.
            // This is a clever trick to flush out all bars from the stack and compute their areas properly.
            int currentHeight = (i == n) ? 0 : heights[i];

            // While the stack is not empty and current height is less than the height at stack top
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int topIndex = stack.pop(); // Pop the top
                int height = heights[topIndex]; // Height of the rectangle

                // After popping the current bar (whose height we're using to calculate area),
                // we need to know how far left and right this bar can extend, width = right boundary - left boundary
                // i is the right boundary (current index where we found a smaller bar).
                // stack.peek() is the index of the previous smaller bar on the left
                // If stack is empty, width = i (means we went back all the way to index 0)
                // Else, width = distance between current index and index after the new top

                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                int area = height * width; // Calculate area
                maxArea = Math.max(maxArea, area); // Update max area
            }

            // Push current index to stack
            stack.push(i);
        }

        return maxArea;
    }
}
