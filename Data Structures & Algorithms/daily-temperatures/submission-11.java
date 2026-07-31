class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<StackObject> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++){
            int temp = temperatures[i];
            
            while(!stack.isEmpty() && temp > stack.peek().value){
                StackObject o = stack.poll();
                int days = i - o.index;
                result[o.index] = days;
            }

            stack.push(new StackObject(temp, i));
        }

        return result;
        
    }

    class StackObject{
        public int value;
        public int index;

        public StackObject(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
}
