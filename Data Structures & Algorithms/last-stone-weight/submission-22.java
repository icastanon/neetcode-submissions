class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : stones){
            maxHeap.offer(i);
        }

        while(maxHeap.size() > 1){
            int head = maxHeap.poll();
            int second = maxHeap.poll();

            if(head != second){
                maxHeap.offer(head - second);
            }
        }

        Integer result = maxHeap.poll();

        return result == null ? 0 : result;
    }
}
