class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i <= nums.length-3; i++){
            int l = i+1; int r = nums.length-1;
            while(r > l){
                int sum = nums[l] + nums[r];
                int target = -1 * (nums[i]);
                if(sum < target){
                    l++;
                }else if(sum > target){
                    r--;
                }else{
                    //we have a triplet
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[l]);
                    triplet.add(nums[r]);
                    if(!result.contains(triplet)){
                        result.add(triplet);
                    }

                    r--;
                    l++;
                }
            }
        }

        return result;
    }
}
