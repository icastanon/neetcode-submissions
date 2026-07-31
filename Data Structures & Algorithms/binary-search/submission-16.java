class Solution {
    // public int search(int[] nums, int target) {
    //     int l = 0, r = nums.length-1;
    //     while(r >= l){
    //         int mid = l + (r-l+1)/2;
    //         if(nums[mid] == target){
    //             return mid;
    //         }else if(nums[mid] < target){
    //             l = mid+1;
    //         }else{
    //             r = mid-1;
    //         }
    //     }

    //     return -1;
        
    // }

    //recursive
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;

        return binarySearch(l, r, target, nums);
        
    }

    public int binarySearch(int l, int r, int target, int[] nums){
        int mid = l + (r-l+1)/2;
        if(r < l){
            return -1;
        }else if(nums[mid] == target){
            return mid;
        }else if(nums[mid] < target){
            return binarySearch(mid+1, r, target, nums);
        }else{
            return binarySearch(l, r-1, target, nums);
        }
    }

}
//0 1 2 3 4 5 6 7 8
