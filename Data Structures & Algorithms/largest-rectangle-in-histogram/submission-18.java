class Solution {
    public int largestRectangleArea(int[] heights) {
        Map<Integer, Integer> heightIndex = new HashMap<>();
        Deque<Integer> heightStack = new ArrayDeque<>();

        int maxArea = 0;
        int i = 0;

        while(i < heights.length){
            int currentHeight = heights[i];

            int area = 0;
            int poppedHeight = 0;
            int index = i;

            while(!heightStack.isEmpty() && currentHeight <= heightStack.peek()){
                poppedHeight = heightStack.poll();
                area=(i - heightIndex.get(poppedHeight)) * poppedHeight;
                index = heightIndex.get(poppedHeight);
                maxArea = Math.max(area, maxArea);
            }

            heightIndex.put(currentHeight, index);
            heightStack.push(currentHeight);

            i++;
        }
        // 1 2 3 1 1

        while(!heightStack.isEmpty()){
            int poppedHeight = heightStack.poll();
            int poppedIndex = heightIndex.get(poppedHeight);
            int area = (i-poppedIndex) * poppedHeight;
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;

        

        // return Math.max(maxArea,  i * Math.min(heights[0], heights[i-1]));
        
    }
}
// 1 2 3 1
