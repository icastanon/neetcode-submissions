class Solution {
    class MaxHeap{
        Queue<Integer> heap;

        public MaxHeap(int[] stones){
            this.heap = new PriorityQueue<>();

            for(int i : stones){
                heap.offer(i * -1);
            }
        }

        public Integer poll(){
            if(heap.peek() == null){
                return 0;
            }

            return -1 * heap.poll();
        }

        public Integer peek(){
            if(heap.peek() == null){
                return 0;
            }

            return -1 * heap.peek();
        }

        public void offer(int val){
            heap.offer(-1 * val);
        }

        public int size(){
            return heap.size();
        }
    }

    public int lastStoneWeight(int[] stones) {
        // MaxHeap maxHeap = new MaxHeap(stones);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i : stones){
            maxHeap.offer(i);
        }

        while(maxHeap.size() > 1){
            Integer heaviest = maxHeap.poll();
            Integer second = maxHeap.poll();

            if(heaviest > second){
                Integer newStone = heaviest - second;

                maxHeap.offer(newStone);
            }
        }

        if(maxHeap.peek() == null){
            System.out.println("returning 0");
            return 0;
        }

        return maxHeap.poll();
        
    }
}
