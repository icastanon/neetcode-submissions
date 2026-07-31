class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        int result = -1;

        while(start <= end){
            int mid = start + (end - start)/2;
            System.out.println("Mid index: " + mid);
            System.out.println("Mid value: " + nums[mid]);
            if(nums[mid] == target){
                return mid;
            }else if(nums[start] <= nums[mid]){
                if(target <= nums[mid] && target >= nums[start]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                if(target <= nums[end] && target >= nums[mid]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }

        return result;
        
    }
}

// 6 7 8 1 2 3 4 5

// 4 5 1 2 3
