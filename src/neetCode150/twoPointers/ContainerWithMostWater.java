package neetCode150.twoPointers;

// https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {
    /*
    Time complexity:O(n)
    Space complexity:O(1)
    */
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * Math.abs(right - left);
            maxArea = Math.max(maxArea, area);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int height2[] = {1, 1};
        System.out.println(maxArea(height));
        System.out.println(maxArea(height2));
    }
}
