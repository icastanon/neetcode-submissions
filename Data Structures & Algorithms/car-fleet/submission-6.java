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
            
            while(!stack.isEmpty() && timeToArrive >= stack.peek()){
                System.out.println("Fleet count decreased");
                fleetCount--;
                stack.poll();
            }
                
            stack.push(timeToArrive);
        }

        return fleetCount;
    }
}
