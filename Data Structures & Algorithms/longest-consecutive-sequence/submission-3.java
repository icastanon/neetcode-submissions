class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbs = new HashSet<>();
        for(int n : nums){
            numbs.add(n);
        }

        int maxCount = 0;

        for(int n : nums){
            int count = 1;
            if(!numbs.contains(n-1)){
                int i = n;
                while(numbs.contains(i+1)){
                    i++;
                    count++;
                }
            }

            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
        
    }
}
