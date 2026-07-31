class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> positionSpeed = new HashMap<>();
        Integer fleetCount = 0;
        for(int i = 0; i < position.length; i++){
            positionSpeed.put(position[i], speed[i]);
        }

        Arrays.sort(position);

        //stack of times to arrive
        Deque<Double> stack = new ArrayDeque<>();
        
        for(int pos : position){
            fleetCount++;
            Double timeToArrive = ((double) (target - pos)) / positionSpeed.get(pos);
            System.out.println("Time to arrive " + timeToArrive);
            
                //if time to arrive < stack.peek() -> add to stack and increment fleet count
           
                //else (if time to arrive >= stack.peek()) -> increment fleet count, then -> pop from stack and decrement fleet count until stack.peek() > current element time to arrive
            while(!stack.isEmpty() && timeToArrive >= stack.peek()){
                System.out.println("Fleet count decreased");
                fleetCount--;
                stack.poll();
            }
                
            stack.push(timeToArrive);
        }

        return fleetCount;
    }

    // 30, 20, 10, 5, 25

    // 1.33, 2
}
