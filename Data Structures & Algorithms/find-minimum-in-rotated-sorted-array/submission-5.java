class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length-1;
        int min = nums[0];

        while(start <= end){
            int mid = (end+start) / 2;
            if(nums[start] <= nums[mid]){
                min = nums[start] < min ? nums[start] : min;
                start = mid + 1;
            }else{
                min = nums[mid] < min ? nums[mid] : min;
                end = mid - 1;
            }
        }

        return min;
        
    }

}

//  3 4 5 6 7 1 2

//  2 3 4 5 6 1 