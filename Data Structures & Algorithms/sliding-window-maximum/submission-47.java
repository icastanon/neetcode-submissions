class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l =0, r = 0;
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<int[]> maxPQ = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        for(int i = 0; i < k-1; i++){
            maxPQ.add(new int[]{nums[r], r});
            r++;
        }

        while(r < nums.length){
            maxPQ.add(new int[]{nums[r], r});

            while(maxPQ.peek()[1] < l){
                maxPQ.remove();
            }

            result[l] = maxPQ.peek()[0];
            r++;

            l++;  
        }

        // System.out.println(maxPQ.peek());

        return result;
    }
}

