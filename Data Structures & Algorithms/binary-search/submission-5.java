class Solution {
    // public int search(int[] nums, int target) {
    //     int middle = (int) Math.floor(nums.length/2);
    //     int start = 0, end = nums.length-1;

    //     while(start <= end && target != nums[middle]){
    //         if(nums[middle] > target){
    //             end = middle-1;
    //         }else if(nums[middle] < target){
    //             start = middle + 1;
    //         }

    //         middle = (int) Math.floor((end+start)/2);
    //     }

    //     return target == nums[middle] ? middle : -1;
    // }

    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;

        while(start <= end){
            int middle = start + (end-start) / 2;
            if(nums[middle] == target){
                return middle;
            }else if(nums[middle] > target){
                end = middle-1;
            }else{
                start = middle + 1;
            }
        }

        return -1;
    }
}

// 1 2 3 4 5 6 
