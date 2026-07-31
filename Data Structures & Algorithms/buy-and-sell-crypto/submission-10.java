class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0], maxProfit = 0;
        for(int i : prices){
            if(i < min){
                min = i;
            }else{
                int profit = i - min;
                maxProfit = Math.max(profit, maxProfit);
            }
        }

        return maxProfit;
        
    }
}
