class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Deque<TempAndIndex> stack = new ArrayDeque<>();
        int[] output = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++){
            int temp = temperatures[i];
            while(!stack.isEmpty() && stack.peek().temp < temp){
                int index = stack.poll().index;
                output[index] = i-index;
            }

            stack.push(new TempAndIndex(temp, i));
        }

        return output;
        
    }

    private class TempAndIndex{
        public int temp;
        public int index;

        public TempAndIndex(int temp, int index){
            this.temp = temp;
            this.index = index;
        }
    }
}
