class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length-1;
        int maxArea = getArea(l,r,heights);

        while(r > l){
            int currentArea = getArea(l,r,heights);
            if(heights[r] > heights[l]){
                l++;
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
