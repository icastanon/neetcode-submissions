class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int fixed = 0;
        while(nums[fixed] <= 0 && fixed <= nums.length-3){
            int l = fixed+1;
            int r = nums.length-1;
            while(l < r){
                int sum = nums[fixed] + nums[l] + nums[r];
                if(sum > 0){
                    r--;
                }else if(sum < 0){
                    l++;
                }else{
                    List<Integer> re = new ArrayList<>();
                    re.add(nums[fixed]); re.add(nums[l]); re.add(nums[r]);
                    result.add(re);
                    l++;
                    r--;
                    while(nums[l] == nums[l-1] && l < r){
                        l++;
                    }
                }
            }
            do{
                fixed++;
            }while(nums[fixed] == nums[fixed-1] && fixed < nums.length-1);
        }

        return result;
    }
}
