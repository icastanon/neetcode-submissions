class Solution {
    public int leastInterval(char[] tasks, int n) {
        Queue<Integer> maxHeap = new PriorityQueue(Comparator.reverseOrder());
        Queue<int[]> nextTime = new ArrayDeque<>();

        Map<Character, Integer> charCount = new HashMap<>();

        for(char c : tasks){
            Integer count = charCount.get(c);

            if(count != null){
                charCount.put(c, count+1);
            }else{
                charCount.put(c, 1);
            }
        }

        for(Character c : charCount.keySet()){
            System.out.println("Offering " + charCount.get(c));
            maxHeap.offer(charCount.get(c));
        }

        int time = 1;

        while(!maxHeap.isEmpty() || !nextTime.isEmpty()){
            
            if(nextTime.peek() != null && time == nextTime.peek()[1]){
                //insert back into heap
                maxHeap.offer(nextTime.poll()[0]);
            }

            Integer max = maxHeap.poll();

            //decrement the occurence then insert into queue with the next time to process
            if(max!=null && max-1 > 0){
                int[] count = {max-1, time+n+1};
                nextTime.offer(count);
            }

            time++;


        }

        return time-1;
        
    }
}
