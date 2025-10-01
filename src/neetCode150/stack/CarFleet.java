package neetCode150.stack;

/* https://leetcode.com/problems/car-fleet/description/
There are n cars at given miles away from the starting mile 0, traveling to reach the mile target.

You are given two integer arrays position and speed, both of length n, where position[i] is the starting mile of the ith car and speed[i] is the speed of the ith car in miles per hour.

A car cannot pass another car, but it can catch up and then travel next to it at the speed of the slower car.

A car fleet is a single car or a group of cars driving next to each other. The speed of the car fleet is the minimum speed of any car in the fleet.

If a car catches up to a car fleet at the mile target, it will still be considered as part of the car fleet.

Return the number of car fleets that will arrive at the destination.


Example 1:

Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]

Output: 3

Explanation:

The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12. The fleet forms at target.
The car starting at 0 (speed 1) does not catch up to any other car, so it is a fleet by itself.
The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.
*/

import java.util.Arrays;
import java.util.Stack;

class CarFleet {

    /*
     * Optimized Solution using a Stack
     * Time Complexity: O(nlogn)
     * Space Complexity: O(n)
    * */
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length; // number of cars

        // 1. Create a pair of car and their respective speeds
        int[][] positionSpeedMapping = new int[n][2];
        for (int i = 0; i < n; i++) {
            positionSpeedMapping[i][0] = position[i]; //position
            positionSpeedMapping[i][1] = speed[i]; //speed
        }

        // 2. Sort the cars in decreasing order of their starting position
        Arrays.sort(positionSpeedMapping, (a, b) -> Integer.compare(b[0], a[0]));

        // Stack to store the time taken to reach target
        Stack<Double> stack = new Stack<>();

        // 3. Process each car
        for (int[] p : positionSpeedMapping) {
            int currentCarposition = p[0];
            int currentCarspeed = p[1];

            // 3.1. calculate time for current car and push into stack
            double currentCarTime = (double) (target - currentCarposition) / currentCarspeed;
            stack.push(currentCarTime);


            // 3.2. if current car on top takes less that or equal time than the one behind it, it means it will catch up -> that car becomes part of the same fleet -> so we can discard it
            // in this way our stack will store only one element for each distinct fleet

            Double previousCarTime = stack.get(stack.size() - 2);      // Time for car just before current one

            if (stack.size() >= 2 &&
                stack.peek() <= stack.get(stack.size() - 2)) {
                // remove current car since it merges with the car ahead and becomes part of the same fleet
                stack.pop();
            }

        }
        return stack.size(); // stack stores only one element for each distinct fleet
    }
}
