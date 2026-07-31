class MinStack {
    Deque<Integer> stack = new ArrayDeque<>(), mins = new ArrayDeque<>();

    public MinStack() {
    }
    
    public void push(int val) {
        stack.push(val);
        if(mins.size() == 0 || val <= mins.peek()){
            mins.push(val);
            System.out.println("Pushed to mins " + val);
        }
    }
    
    public void pop() {
        Integer val = stack.pop();
        System.out.println("Popped from stack " + val);
        System.out.println("Peeking from mins " + (mins.peek() == val));
        if(mins.peek().equals(val)){
            mins.pop();
            System.out.println("Popped from mins " + val);
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}
