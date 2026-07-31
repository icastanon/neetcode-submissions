class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums){
            numSet.add(num);
        }

        
        int maxSeq = 0;
        for(int num : nums){
            int currentSeq = 1;
            if(!numSet.contains(num - 1)){
                //count sequence
                int next = num+1;
                while(numSet.contains(next)){
                    currentSeq++;
                    next++;
                }

                maxSeq = Math.max(currentSeq, maxSeq);
            }
        }

        return maxSeq;
    }
}
