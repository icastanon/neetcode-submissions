class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length-1;
        int maxArea = getArea(l,r,heights);

        // System.out.println("area: " + lastArea);

        while(r > l){
            int currentArea = getArea(l,r,heights);
            // int nextArea = getArea(l,r-1,heights);
            // System.out.println("second area: " + nextArea);
            if(heights[r] > heights[l]){
                l++;
            }else if(heights[r] < heights[l]){
                r--;
            }else{
                r--;
            }

            if(currentArea > maxArea){
                maxArea = currentArea;
            } 
        }

        return maxArea;
        
        
    }

    public int getArea(int index1, int index2, int[] heights){
            int shorterHeight = heights[index1] <= heights[index2] ? heights[index1] : heights[index2];
            int length = index2 - index1;
            int area = shorterHeight * length;

            return area;
    }
}
