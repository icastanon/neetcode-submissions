class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numAndIndex = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            int difference = target - nums[i];
            Integer diffIndex = numAndIndex.get(difference);
            if(Objects.nonNull(diffIndex)){
                int[] indexes = new int[2];
                indexes[0] = i < diffIndex ? i : diffIndex;
                indexes[1] = i > diffIndex ? i : diffIndex;
                return indexes;
            }
            numAndIndex.put(nums[i],i);
        }

        return null;
    }
}
