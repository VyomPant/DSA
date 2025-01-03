package neetCode150.arraysAndHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/top-k-frequent-elements
public class TopKFrequentElements {
    /* Sorting
    - Time complexity:O(nlogn)
    - Space complexity:O(n)
    * */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> numsFrequencyMap = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            numsFrequencyMap.put(nums[i], numsFrequencyMap.getOrDefault(nums[i], 0) + 1);
        }

        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : numsFrequencyMap.entrySet()) {
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        }
        arr.sort((a, b) -> b[0] - a[0]);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int [] res = topKFrequent(nums, k);
        System.out.println("Output:");
        for (int i = 0; i<res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }
}
