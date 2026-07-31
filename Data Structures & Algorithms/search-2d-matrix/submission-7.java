class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length-1;
        while(l <= r){
            int mid = l + (r-l+1)/2;
            if(matrix[mid][0] <= target && matrix[mid][matrix[mid].length-1] >= target){
                return bs(matrix[mid], target);
            }else if(matrix[mid][matrix[mid].length-1] < target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        return false;
        
    }

    public boolean bs(int[] nums, int target){
        int l = 0, r = nums.length-1;
        while(l <= r){
            int mid = l + (r-l+1)/2;
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] < target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        return false;
    }
}
