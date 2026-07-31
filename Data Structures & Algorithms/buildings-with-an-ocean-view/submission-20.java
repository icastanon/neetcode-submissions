class Solution {
    public int[] findBuildings(int[] heights) {
        int[] sufixes = new int[heights.length];
        int currentMax = heights[heights.length-1];
        for(int i = heights.length-1; i >= 0; i--){
            sufixes[i] = currentMax;
            if(heights[i] >= currentMax){
                currentMax = heights[i];
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < heights.length; i++){
            if(heights[i] > sufixes[i] || i == heights.length-1){
                result.add(i);
            }
        }

        int[] resultArray = new int[result.size()];

        for(int i = 0; i < result.size(); i++){
            resultArray[i] = result.get(i);
        }

        return resultArray;


    }
}