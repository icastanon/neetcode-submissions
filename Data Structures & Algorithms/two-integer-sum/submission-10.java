class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numAndIndex = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            numAndIndex.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++){
            Integer differenceIndex = numAndIndex.get(target-nums[i]);
            if(differenceIndex != null && differenceIndex != i){
                return new int[]{i, differenceIndex};
            }
        }

        return null;
        
    }
}
