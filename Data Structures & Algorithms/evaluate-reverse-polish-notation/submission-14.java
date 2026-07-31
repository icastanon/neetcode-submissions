class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        Integer output = 0;
        for(String s : tokens){
            if(s.equals("+")){
                stack.push(stack.poll() + stack.poll());
            }else if(s.equals("-")){
                int num2 = stack.poll();
                int num1 = stack.poll();
                stack.push(num1 - num2);
            }else if(s.equals("*")){
                int num2 = stack.poll();
                int num1 = stack.poll();
                stack.push(num1 * num2);
            }else if(s.equals("/")){
                int num2 = stack.poll();
                int num1 = stack.poll();
                stack.push(num1 / num2);
            }else{
                stack.push(Integer.valueOf(s));
            }
        }

        return stack.poll();
        
    }
}
