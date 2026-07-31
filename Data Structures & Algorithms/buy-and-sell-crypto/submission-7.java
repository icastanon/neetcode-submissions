class Solution {
    public int maxProfit(int[] prices) {
        //find max from right to left
        int max = prices[prices.length-1];
        int[] maxes = new int[prices.length];
        for(int i = prices.length-1; i >= 0; i--){
            if(prices[i] >= max){
                max = prices[i];
            }
            maxes[i] = max;
        }

        //find min from left to right
        int min = prices[0];
        int[] mins = new int[prices.length];
        for(int i = 0; i < prices.length; i++){
            if(prices[i] <= min){
                min = prices[i]; 
            }
            mins[i] = min;
        }

        int maxProfit = maxes[0]-mins[0];
        //find answer
        for(int i = 0; i < prices.length; i++){
            int profit = maxes[i]-mins[i];
            if(profit > maxProfit){
                maxProfit = profit;
            }
        }

        if(maxProfit > 0){
            return maxProfit;
        }else{
            return 0;
        }
        
    }
}
