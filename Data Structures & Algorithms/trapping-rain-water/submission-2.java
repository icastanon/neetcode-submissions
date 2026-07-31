class Solution {
    public int trap(int[] height) {
        int currentMax = height[0];
        int[] prefixMax = new int[height.length];
        for(int i = 0; i < height.length; i++){
            prefixMax[i] = currentMax;
            currentMax = Math.max(height[i], currentMax);
        }

        System.out.println(Arrays.toString(prefixMax));

        currentMax = height[height.length-1];
        int[] sufixMax = new int[height.length];
        for(int i = height.length-1; i >= 0; i--){
            sufixMax[i] = currentMax;
            currentMax = Math.max(height[i], currentMax);
        }

        System.out.println(Arrays.toString(sufixMax));

        int totalWater = 0;

        for(int i = 0; i < height.length; i ++){
            int waterCol = Math.min(prefixMax[i], sufixMax[i]) - height[i];
            if(waterCol > 0)
                totalWater += waterCol;
        }

        return totalWater;
    }
}
