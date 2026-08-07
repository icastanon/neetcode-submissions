class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for(char c : tasks){
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        Queue<Character> maxHeap = new PriorityQueue<>((a, b) -> charCounts.get(b) - charCounts.get(a));
        for(char c : charCounts.keySet()){
            maxHeap.offer(c);
        }

        Map<Character, Integer> nextCycles = new HashMap<>();
        Queue<Character> processed = new ArrayDeque<>();

        int t = 1;

        while(!maxHeap.isEmpty() || !processed.isEmpty()){
            if(!processed.isEmpty() && t >= nextCycles.get(processed.peek())){
                char c = processed.poll();
                maxHeap.offer(c);
            }

            if(!maxHeap.isEmpty()){
                //process
                char c = maxHeap.poll();
                int newCount = charCounts.get(c)-1;
                charCounts.put(c, newCount);

                if(newCount > 0){
                    int nextCycle = t + n + 1;
                    nextCycles.put(c, nextCycle);
                    processed.offer(c);
                }
                
            }

            
            
            t++;
        }

        return t-1;
        

    }
}
