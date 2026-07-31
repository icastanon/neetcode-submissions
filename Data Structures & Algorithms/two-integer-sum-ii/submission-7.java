class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length-1;
        while(r > l){
            int sum = numbers[l] + numbers[r];
            if(sum < target){
                l++;
                continue;
            }else if(sum > target){
                r--;
                continue;
            }else{
                int[] result = new int[2];
                result[0] = l+1;
                result[1] = r+1;
                return result;
            }
        }

        return null;
        
    }
}
