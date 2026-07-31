class MinStack {
    Deque<Integer> stack = new ArrayDeque<>(), mins = new ArrayDeque<>();

    public MinStack() {
    }
    
    public void push(int val) {
        stack.push(val);
        if(mins.size() == 0 || val <= mins.peek()){
            mins.push(val);
        }
    }
    
    public void pop() {
        Integer val = stack.pop();
        if(mins.peek().equals(val)){
            mins.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}
