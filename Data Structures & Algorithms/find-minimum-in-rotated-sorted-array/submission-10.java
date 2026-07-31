class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int l = 0, r = nums.length-1;

        while(l <= r){
            int mid = l+(r-l)/2;
            // System.out.println("Mid: " + mid);
            // System.out.print("Right Sorted?: ");
            boolean rightSorted = isSorted(nums[mid+1], nums[r]);
            // System.out.print("Left Sorted?: ");
            boolean leftSorted = isSorted(nums[l], nums[mid]);
            if(rightSorted && leftSorted){
                //  System.out.println("Returing");
                return Math.min(nums[l], nums[mid+1]);
            }else if(rightSorted){
                r = mid;
            }else{
                l = mid;
            }
        }

        return nums[r];
        
    }

    public boolean isSorted(int l, int r){
        // System.out.println(r+ " >= "+ l +" ?: " + (r>=l));
        return r >= l;
    }
}

// 8 9 1 2 3 4 5 6 7
