class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] suffixes = new int[nums.length];
        int[] prefixes = new int[nums.length];

        int prev = 1;
        for(int i = nums.length-1; i >= 0; i--){
            suffixes[i] = prev;
            prev = prev * nums[i];
        }

        prev = 1;
        for(int i = 0; i < nums.length; i++){
            prefixes[i] = prev;
            prev = prev * nums[i];
        }

        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            result[i] = suffixes[i]*prefixes[i];
        }

        return result;
        
    }
}  
