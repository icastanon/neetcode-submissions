class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<StackObject> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        

        for(int i = 0; i < temperatures.length; i++){
            Integer currentVal = temperatures[i];
            while(!stack.isEmpty() && currentVal > stack.peek().number){
                result[stack.peek().index] = i - stack.poll().index;
            }

            stack.push(new StackObject(currentVal, i));
        }
        

        return result;
    }

    class StackObject{
        public Integer number;
        public Integer index;

        public StackObject(){

        }

        public StackObject(Integer number, Integer index){
            this.number = number;
            this.index = index;
        }
    }
}
