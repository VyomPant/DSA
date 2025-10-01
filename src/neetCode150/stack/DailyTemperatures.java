package neetCode150.stack;

import java.util.Arrays;
import java.util.Stack;
/*
     * Problem: For each day, find how many days you have to wait until a warmer temperature.
     * If there is no future warmer day, the answer is 0.
        https://leetcode.com/problems/daily-temperatures/description/
        Given an array of integers temperatures represents the daily temperatures,
        return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
        If there is no future day for which this is possible, keep answer[i] == 0 instead.
*/

public class DailyTemperatures {
    /* Brute force Solution
     using two loops Time complexity:O(n^2)
     Space complexity:O(n) */
    public int[] dailyTemperaturesBruteForce(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    /* Note : In Java, when you create an int[] array like this:
     int[] res = new int[n];
    All the values in the array are automatically initialized to 0 by default, because int is a primitive data type in Java.
     */


    /*
     * Optimized Solution using a Stack (Monotonic Decreasing Stack)
     * Time Complexity: O(n)  -> Each index is pushed and popped at most once
     * Space Complexity: O(n) -> Stack to store indices
     */

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n]; // array to store the result (default initialized to 0)
        Stack<Integer> stack = new Stack<>(); // stack to store indices of days

        // Iterate through each day's temperature
        for (int i = 0; i < n; i++) {

            // Check if current day's temperature is warmer than the temperature
            // at the day represented by the index at the top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();          // Pop the index of the previous cooler day
                answer[prevIndex] = i - prevIndex;   // Number of days until a warmer temperature
            }

            // Push current day's index onto the stack
            // This day might be a future warmer day for upcoming days
            stack.push(i);
        }

        // Any indices left in the stack don't have a warmer future day
        // answer[i] for them remains 0 (default value)

        return answer;
    }


    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] answer = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(answer));
    }
}
