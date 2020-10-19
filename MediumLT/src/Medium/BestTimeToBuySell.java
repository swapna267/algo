package Medium;

public class BestTimeToBuySell {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));

    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int localMax = 0;

        int buyPrice = Integer.MAX_VALUE;

        for (int i=0;i<prices.length;i++) {
            if(prices[i] < buyPrice) {
                buyPrice = prices[i];
                if (localMax > maxProfit) {
                    maxProfit = localMax;
                }
                continue;
            }

            int profit = prices[i]-buyPrice;
            if (profit > localMax) {
                localMax = profit;
            }
        }

        return Math.max(maxProfit,localMax);
    }

}
