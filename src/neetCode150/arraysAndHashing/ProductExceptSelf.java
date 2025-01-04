package neetCode150.arraysAndHashing;

import java.util.Arrays;

/*- Time complexity:O(n)
   Space complexity:O(n)
   https://leetcode.com/problems/product-of-array-except-self/description/
*/
public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        // nums = [1, 2, 3, 4]
        int n = nums.length;
        int[] res = new int[n]; // stores result
        int[] prefixProduct = new int[n]; // stores the product of all elements before the current element of nums
        int[] suffixProduct = new int[n]; // stores the product of all elements after the current element of nums
        prefixProduct[0] = 1;
        suffixProduct[n - 1] = 1;
        //compute prefixProduct
        for (int i = 1; i < n; i++) {
            prefixProduct[i] = nums[i - 1] * prefixProduct[i - 1];
        } // prefixProduct[] = [1,1,2,6]

        //compute suffixProduct
        for (int i = n - 2; i >= 0; i--) {
            suffixProduct[i] = nums[i + 1] * suffixProduct[i + 1];
        } // prefixProduct[] = [24,12,8,6]

        // compute result (res = prefixProduct * suffixProduct )
        for (int i = 0; i < n; i++) {
            res[i] = prefixProduct[i] * suffixProduct[i];
        }
        return res;
    }

    /*- Time complexity:O(n)
       Space complexity:O(1)
    */
    public static int[] productExceptSelfOptimal(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        // nums = [1, 2, 3, 4]
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }// res = [1,1,2,6] (result now currently stores prefixProduct)

        //compute suffixProduct for each element and multiply it with already computed prefixProduct to obtain result
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= suffixProduct;
            suffixProduct *= nums[i];
            /*  res = [1,1,2,6],  suffixProduct = 1
            *  res = [1,1,8,6], suffixProduct = 4
            *  res =  [1,12,8,6], suffixProduct = 12
            *  res = [24,12,8,6], suffixProduct = 24 */
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(productExceptSelf(nums)));
        System.out.println("Output: " + Arrays.toString(productExceptSelfOptimal(nums)));
    }

}
