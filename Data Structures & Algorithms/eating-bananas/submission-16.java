class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = piles[0];

        for(int i : piles){
            r = Math.max(r, i);
        }

        int minRate = r;

        while(l <= r){
            int mid = l + (r-l+1)/2;
            // System.out.println(mid);
            if(validRate(piles, h, mid)){
                minRate = Math.min(mid, minRate);
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        return minRate;
        
    }

    public boolean validRate(int[] piles, int h, int rate){
        int hourCount = 0;
        for(int i = 0; i < piles.length; i++){
            double hours = Math.ceil((double) piles[i] / (double) rate);
            hourCount+=hours;
        }

        // System.out.println(hourCount <= h);

        return hourCount <= h;
    }
}
