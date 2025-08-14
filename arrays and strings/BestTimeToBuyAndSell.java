// Key Thought Process 🧠:

// The only thing that matters is:

// The lowest price so far (best day to buy).

// The max profit so far.

// We don’t need to check all pairs — we just update these two values while scanning the array once.

// Logic:

// Start with minPrice = Integer.MAX_VALUE (so any real price will be lower).

// maxProfit = 0 initially.

// For each day’s price:

// If this price is lower than minPrice, update minPrice (new best buy).

// Else, calculate profit if selling today → price - minPrice.

// If that profit is higher than maxProfit, update maxProfit.

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}