class Solution {
    // public int maxProfit(int[] prices) {
    //     int l = 0, r = prices.length-1, maxProfit = 0;
    //     while(r > l){
    //         int profit = prices[r]-prices[l];
    //         maxProfit = Math.max(maxProfit, profit);

    //         int nextProfitL = prices[r-1]-prices[l];

    //         if(nextProfitL >= profit){
    //             r--;
    //         }else{
    //             l++;
    //         }
    //     }

    //     return Math.max(0,maxProfit);
        
    // }

    public int maxProfit(int[] prices) {
        int l = 0, r = prices.length-1, maxProfit = 0;

        int currentMax = prices[prices.length-1];

        int[] sufixMax = new int[prices.length];

        for(int i = prices.length-1; i >= 0; i--){
            sufixMax[i] = currentMax;
            currentMax = Math.max(prices[i], currentMax);
        }

        int maxProf = 0;

        for(int i = 0; i < prices.length; i++){
            int profit = sufixMax[i] - prices[i];
            maxProf = Math.max(maxProf, profit);
        }

        return maxProf;
        
    }

    

        
}
