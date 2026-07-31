class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for(int i : piles){
            if (i > max)
                max = i;
        }

        int minSpeed=0;

        int start = 1, end = max;
        while(start <= end){
            int mid = (end+start)/2;
            if(isValid(piles, mid, h)){
                minSpeed = mid;
                end = mid-1;
            }else{
                start = mid + 1;
            }
        }
        
        return minSpeed;
    }

    public boolean isValid(int[] piles, int rate, int h){
        int hours = 0;
        for(int i = 0; i < piles.length; i++){
            hours += Math.ceil(((double) piles[i])/((double) rate));
        }

        return hours <= h;
    }
}
