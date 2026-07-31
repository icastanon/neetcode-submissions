class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(r >= l){
            int mid = l + (r-l+1)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        return -1;
        
    }
}
//0 1 2 3 4 5 6 7 8
