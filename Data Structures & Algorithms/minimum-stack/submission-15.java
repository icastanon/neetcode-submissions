class MinStack {
    Deque<Integer> minStack = null;
    Deque<Integer> stack = null;

    public MinStack() {
        minStack = new ArrayDeque();
        stack = new ArrayDeque();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.peek() == null || minStack.peek() >= val){
            minStack.push(val);
        }
    }
    
    public void pop() {
        int val = stack.poll();
        if(val == minStack.peek()){
            minStack.poll();
        }
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
