class Solution {

    // public int maxProfit(int[] prices) {

    //     int currentMax = prices[prices.length-1];

    //     int[] sufixMax = new int[prices.length];

    //     for(int i = prices.length-1; i >= 0; i--){
    //         sufixMax[i] = currentMax;
    //         currentMax = Math.max(prices[i], currentMax);
    //     }

    //     int maxProf = 0;

    //     for(int i = 0; i < prices.length; i++){
    //         int profit = sufixMax[i] - prices[i];
    //         maxProf = Math.max(maxProf, profit);
    //     }

    //     return maxProf;
        
    // }

    //BETTER SOLUTION 

    public int maxProfit(int[] prices) {
        int currentMin = prices[0];
        int maxProf = 0;

        for(int i = 1; i < prices.length; i++){
            int profit = prices[i] - currentMin;
            if(profit < 0){
                currentMin = prices[i];
            }else{
                maxProf = Math.max(maxProf, profit);
            }
        }

        return maxProf;    
    }

}
        
