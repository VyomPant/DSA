package neetCode150.binarySearch;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/koko-eating-bananas/description/">...</a>
 Problem Summary: Koko Eating Bananas

 Koko has a list of banana piles (each pile has some number of bananas).

 She eats at a fixed speed k bananas per hour.

 If a pile has fewer than k bananas, she eats the entire pile in one hour.

 She can only eat from one pile per hour.

 You're given the array piles[] and a number h (total hours she has to eat all bananas).

 Goal: Find the minimum integer speed k such that she can eat all bananas in h hours.
 */
public class KokoEatingBananas {

    /**
     * Brute Force Approach – Try Every Possible Speed
     * Intuition: Start from k = 1 (slowest speed) and go upwards until you find the first speed where she can finish all the bananas within h hours.
     * Time Complexity: O(m * n), where m = max(piles) and n = size of piles[]
    * */
    public int minEatingSpeedBruteForce(int[] piles, int h) {
        int speed = 1;  // Start from the slowest possible speed

        while (true) {
            long hoursNeeded = 0;

            for (int pile : piles) {
                // Calculate total hours needed to eat each pile at current speed ,
                // i. Hour needed to finish a pile = size of that pile / eating speed
                // ii. Add hour for each pile to get total hours
                // iii. Use Math.ceil to account for partial hours
                hoursNeeded += (int) Math.ceil((double) pile / speed);
            }

            // If she can finish within h hours, we found our answer
            if (hoursNeeded <= h) {
                return speed;
            }

            // Try the next higher speed
            speed++;
        }
    }

    /**
     * Optimised Approach – Binary Search
     * Intuition: Instead of checking every speed, we use binary search:
     *             i.   The minimum possible speed is 1.
     *             ii.  The maximum possible speed is max(piles) (if she eats the largest pile in one hour).
     *             iii. Binary search the minimum k such that she can eat all bananas in h hours.
     * Time Complexity: O(n * log(m)), where m = max(piles) and n = size of piles[]
     *                  Binary search on speed: O(log(m))
     *                  For each speed, check time needed: O(n)
     * */
    public int minEatingSpeed(int[] bananaPiles, int maxHours) {
        int minSpeed = 1;
        int maxSpeed = Arrays.stream(bananaPiles) // Max pile size is the upper bound
                .max()
                .orElse(0);

        int bestSpeed = maxSpeed;

        while (minSpeed <= maxSpeed) {
            int midSpeed = minSpeed + (maxSpeed - minSpeed) / 2;

            long totalHours = 0;
            for (int pile : bananaPiles) {
                // Calculate total hours needed to eat each pile at current speed(midSpeed) ,
                // i. Hour needed to finish a pile = size of that pile / eating speed
                // ii. Add hour for each pile to get total hours
                // iii. Use Math.ceil to account for partial hours
                totalHours += (int) Math.ceil((double) pile / midSpeed);
            }

            if (totalHours <= maxHours) {
                // Try a slower speed (left half), but store current as best so far
                bestSpeed = midSpeed;
                maxSpeed = midSpeed - 1;
            } else {
                // Need faster speed (right half)
                minSpeed = midSpeed + 1;
            }
        }

        return bestSpeed;
    }
}
