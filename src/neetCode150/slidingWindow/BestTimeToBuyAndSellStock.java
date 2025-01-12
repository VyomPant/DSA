package neetCode150.slidingWindow;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// Note : you can only buy and sell a stock once (only one transaction is allowed)
public class BestTimeToBuyAndSellStock {
    /*
    Sliding Window approach
    Time complexity:O(n)
    Space complexity:O(1)
     */
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // To store the minimum price seen so far
        int maxProfit = 0;                // To store the maximum profit

        // Traverse the array
        for (int price : prices) {
            // Update the minimum price
            if (price < minPrice) {
                minPrice = price;
            }
            // Calculate the profit and update maxProfit
            else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }

    /*
    DP approach
    Time complexity:O(n)
    Space complexity:O(1)
    */
    public static int maxProfitUsingDP(int[] prices) {
        int maxProfit = 0; // To store the maximum profit
        int minimumPrice = prices[0]; // To store the minimum price seen so far
        /*In every iteration we do the following things
        1. compute the profit if we sold it for that current iteration
        2. update the minimumPrice and maxProfit  */
        for (int price : prices) {
            int currentProfit = price - minimumPrice;
            maxProfit = Math.max(maxProfit, currentProfit);
            minimumPrice = Math.min(minimumPrice, price);
        }
        return maxProfit;
    }

    /*
    Two pointer approach
    Time complexity:O(n)
    Space complexity:O(1)
    */
    public static int maxProfitUsingTwoPointers(int[] prices) {
        /*
         We maintain two pointers leftPointer and rightPointer
         leftPointer to find the optimal day to buy and rightPointer to find the optimal day to sell
         in order to get max profit in a single transaction
         */
        int leftPointer = 0;// the day we buy, initially day 1
        int rightPointer = 1;// the day we sell, initially the next day (day 2)
        int maxProfit = 0;

        while (rightPointer < prices.length) {
            if (prices[leftPointer] < prices[rightPointer]) { // if there is increase in price the next day sell and book profit
                int profit = prices[rightPointer] - prices[leftPointer];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                leftPointer = rightPointer;
            }
            rightPointer++;
        }
        return maxProfit;
    }

    /* if there is not restriction on the number of times you can buy and sell a stock then this function gives you the max profit
    Time complexity:O(n)
    Space complexity:O(1)
    */
    public static int maxProfitIfYouCanBuyAndSellAnyNumberOfTimes(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length ; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit = maxProfit + prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};
        int[] prices3 = {1, 3, 5, 8, 12};
        System.out.println("Max Profits for single buy and sell");
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit(prices2));
        System.out.println(maxProfit(prices3));
        System.out.println("Max Profits for any number of buy and sell");
        System.out.println(maxProfitIfYouCanBuyAndSellAnyNumberOfTimes(prices));
        System.out.println(maxProfitIfYouCanBuyAndSellAnyNumberOfTimes(prices2));
        System.out.println(maxProfitIfYouCanBuyAndSellAnyNumberOfTimes(prices3));

    }
}
