class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length-1;

        while(true){
            int sum = numbers[l] + numbers[r];
            if(sum > target){
                r--;
            }else if(sum < target){
                l++;
            }else{
                return new int[]{l+1, r+1};
            }
        }
    }
}
