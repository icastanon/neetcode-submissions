class Solution {
    public int lastStoneWeight(int[] stones) {

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
