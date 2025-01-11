package neetCode150.twoPointers;

// https://leetcode.com/problems/trapping-rain-water/description/

/*  The formula for the trapped water at index i is given by: min(height[l], height[r]) - height[i].
    where height[l] denotes the maximum height to the left of the current element i
    and height[r]  denotes the maximum height to the right of the current element i
*/
public class TrappingRainWater {

    /*- Time complexity:O(n)
       Space complexity:O(n)
    */
    public static int trapUsingTwoArrays(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int[] leftMaxHeight = new int[n]; // stores the maximum height to the left of an element
        int[] rightMaxHeight = new int[n]; // stores the maximum height to the right of an element
        // computing leftMaxHeight
        leftMaxHeight[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMaxHeight[i] = Math.max(leftMaxHeight[i - 1], height[i]);
        }
        // computing rightMaxHeight
        rightMaxHeight[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMaxHeight[i] = Math.max(rightMaxHeight[i + 1], height[i]);
        }

        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(leftMaxHeight[i], rightMaxHeight[i]) - height[i];
        }
        return trappedWater;
    }

    /*- Time complexity:O(n)
       Space complexity:O(1)
    */
    public static int trapUsingTwoPointer(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int leftPointer = 0;
        int rightPointer = n - 1;
        /* now we won't use two arrays to store the left and right max height
        we will calculate them it on the fly for each element i (Space Optimisation) */
        int leftMaxHeight = height[leftPointer];
        int rightMaxHeight = height[rightPointer];
        int trappedWater = 0;

        while (leftPointer < rightPointer) {
            if (leftMaxHeight < rightMaxHeight) {
                leftPointer++;
                leftMaxHeight = Math.max(leftMaxHeight, height[leftPointer]);
                trappedWater += leftMaxHeight - height[leftPointer];
            } else {
                rightPointer--;
                rightMaxHeight = Math.max(rightMaxHeight, height[rightPointer]);
                trappedWater += rightMaxHeight - height[rightPointer];
            }
        }
        return trappedWater;
    }

    public static void main(String[] args) {
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        int height2[] = {4,2,0,3,2,5};
        System.out.println(trapUsingTwoArrays(height));
        System.out.println(trapUsingTwoPointer(height));
        System.out.println(trapUsingTwoArrays(height2));
        System.out.println(trapUsingTwoPointer(height2));
    }
}
