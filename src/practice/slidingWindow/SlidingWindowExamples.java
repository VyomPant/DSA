package practice.slidingWindow;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/*
The sliding window is a common technique often used to optimize solutions for problems involving sequences (like arrays or strings).
It helps reduce the time complexity from O(n^2) or higher to O(n)
by maintaining a subset of the data within a "window" and moving that window across the data to evaluate conditions.

How Sliding Window Works
1.Define a Window: A window is a subset of elements from a sequence (array or string).
It could represent a subarray, substring, or any range of elements you're working with.

2.Sliding Mechanism: The window is initially at the start of the sequence.
You "slide" it by adding new elements to the end and/or removing elements from the start.

3.Adjusting Window: Depending on the problem, you may need to expand or shrink the window dynamically while maintaining a valid state (e.g., the sum, product, or frequency of elements meets certain criteria).

4.Optimize Solution: Use the sliding window to avoid redundant calculations, enabling you to solve the problem efficiently.

Types of Sliding Window Problems
1.Fixed-size window: The window size is predefined and constant. Example: Finding the maximum sum of a subarray of size k.
2.Variable-size window: The window size changes dynamically based on conditions. Example: Finding the smallest subarray with a sum greater than S.

Key Points to Remember
Fixed-size window problems (like Examples 1 and 4) focus on maintaining a constant-sized subset.
Variable-size window problems (like Examples 2 and 3) involve dynamically adjusting the window size based on conditions.
Optimization: Sliding window avoids redundant calculations, reducing time complexity to O(n)
*/
public class SlidingWindowExamples {
    // Example 1: Find the maximum sum of any subarray of size k in an array.
    public static int maxSumSubarray(int[] arr, int k) {
        int maxSum = 0, currentSum = 0;

        // First, calculate the sum of the initial window
        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }
        maxSum = currentSum;

        // Slide the window through the array
        for (int i = k; i < arr.length; i++) {
            currentSum += arr[i] - arr[i - k]; // Add new element, remove the old one
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    /* Example 2: Find the length of the longest substring without repeating characters.
    Time complexity:O(n)
    Space complexity:O(m)
    Where n is the length of the string and and m is the total number of unique characters in the string.
    */
    public static int longestUniqueSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>(); // for O(1) lookup in the window
        int maxLength = 0;// result (longest window's size = end - start + 1)
        int start = 0; // starting point of the window

        for (int end = 0; end < s.length(); end++) {
            // Shrink the window until the current character is unique
            while (charSet.contains(s.charAt(end))) {
                charSet.remove(s.charAt(start));
                start++;
            }
            charSet.add(s.charAt(end)); // add the character in th
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    // Example 3: Find the length of the smallest subarray with a sum greater than or equal to S
    public static int smallestSubarrayWithSum(int[] arr, int s) {
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0, start = 0;

        for (int end = 0; end < arr.length; end++) {
            currentSum += arr[end];

            // Shrink the window until the sum is smaller than S
            while (currentSum >= s) {
                minLength = Math.min(minLength, end - start + 1);
                currentSum -= arr[start];
                start++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    // Example 4: Find the maximum element in all subarrays of siz K
    public static int[] maxInAllSubarrays(int[] arr, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[arr.length - k + 1];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            // Remove elements that are out of the window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove elements smaller than the current element
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            deque.addLast(i);

            // Add the maximum for this window to the result
            if (i >= k - 1) {
                result[index++] = arr[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Maximum sum of subarray of size " + k + ": " + maxSumSubarray(arr, k));

        String input = "abcabcbb";
        System.out.println("Length of the longest substring without repeating characters: " + longestUniqueSubstring(input));

        arr = new int[]{2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println("Smallest subarray length with sum >= " + s + ": " + smallestSubarrayWithSum(arr, s));

        arr = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        k = 3;
        int[] result = maxInAllSubarrays(arr, k);

        System.out.print("Maximums of all subarrays of size " + k + ": ");
        for (int max : result) {
            System.out.print(max + " ");
        }
    }
}
