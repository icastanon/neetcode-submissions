class Solution {
    public int search(int[] nums, int target) {
        int middle = (int) Math.floor(nums.length/2);
        int start = 0, end = nums.length-1;

        while(start < end && target != nums[middle]){
            if(nums[middle] > target){
                end = middle-1;
            }else if(nums[middle] < target){
                start = middle + 1;
            }

            middle = (int) Math.floor((end+start)/2);
        }

        return target == nums[middle] ? middle : -1;
    }
}

// 1 2 3 4 5 6 
