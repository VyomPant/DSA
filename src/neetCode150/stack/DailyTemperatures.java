package neetCode150.stack;

import java.util.Arrays;
import java.util.Stack;
/*
https://leetcode.com/problems/daily-temperatures/description/
Given an array of integers temperatures represents the daily temperatures,
return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
If there is no future day for which this is possible, keep answer[i] == 0 instead.
*/

public class DailyTemperatures {
    /* Time complexity:O(1)
     Space complexity:O(n) */
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // Stack to store indices

        for (int i = 0; i < n; i++) {
            /* We're going day by day, i being the current day's index.
            We check if today’s temperature (temperatures[i]) is warmer than the temperature at the top index of the stack (temperatures[stack.peek()]).

            If so, we found a future warmer day for that earlier day!

            We pop the index, calculate how many days passed: i - prevIndex, and set answer[prevIndex].
             */
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex; // diff in days
            }
            stack.push(i); // Push current day's index to stack
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] answer = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(answer));
    }
}
