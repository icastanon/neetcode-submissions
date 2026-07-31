class Solution {
    public int trap(int[] height) {
        int[] largestToLeft = new int[height.length];
        int[] largestToRight = new int[height.length];


        //populate largest from left
        int max = 0;
        for(int i = 0; i < height.length; i++){
            largestToLeft[i] = max;
            max = Math.max(height[i], max);
        }

        for(int i : largestToLeft){
            System.out.println(i);
        }

        //populate largest from right
        max = 0;
        for(int i = height.length-1; i >= 0; i--){
            largestToRight[i] = max;
            max = Math.max(height[i], max);
        }

        System.out.println();

        for(int i : largestToRight){
            System.out.println(i);
        }

        //calculate total water
        int total = 0;
        for(int i = 0; i < height.length; i++){
            if(height[i] >= largestToLeft[i] || height[i] >= largestToRight[i]){
                //no water can be trapped
                continue;
            }

            int waterAtI = Math.min(largestToLeft[i], largestToRight[i]) - height[i];
            total+=waterAtI;
        }

        return total;
        
    }
}
