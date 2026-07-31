class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.add(nums[0]);
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(nums[0], 1);

        List<Integer> result = new ArrayList<>();

        int l = 0, r = 0;
        while(r < nums.length){
            int windowSize = r-l+1;
            if(windowSize == k){
                while(counts.getOrDefault(maxHeap.peek(), 0) == 0){
                    maxHeap.poll();
                }
                int max = maxHeap.peek();
                result.add(max);
                //move left
                counts.put(nums[l], counts.get(nums[l])-1);
                l++;
            }
            //move right pointer
            r++;
            if(r < nums.length){
                // if(maxHeap.peek() == null || maxHeap.peek() != nums[r]){
                    maxHeap.add(nums[r]);
                    counts.put(nums[r], counts.getOrDefault(nums[r], 0)+1);
                // }
                
            }
        }

        int[] res = new int[result.size()];

        for(int i = 0; i < result.size(); i++){
            res[i] = result.get(i);
        }

        return res;
        
    }
}
