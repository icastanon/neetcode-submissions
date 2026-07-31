class Solution {
    public boolean hasDuplicate(int[] nums) {
        boolean hasDuplicate = false;
        Set<Integer> duplicates = new HashSet<>();
        for (int n : nums){
            if(duplicates.contains(n)){
                return true;
            }
            duplicates.add(n);
        }
        return false;
    }
}