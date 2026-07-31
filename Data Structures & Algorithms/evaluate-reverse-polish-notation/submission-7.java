class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        Integer numCount = 0;
        for(String s : tokens){
            if(s.equals("+")){
                Integer num2 = Integer.valueOf(stack.pop()), num1 = Integer.valueOf(stack.pop());
                Integer result = num1 + num2;
                stack.push(result);

            }else if(s.equals("-")){
                Integer num2 = Integer.valueOf(stack.pop()), num1 = Integer.valueOf(stack.pop());
                Integer result = num1 - num2;
                stack.push(result);

            }else if(s.equals("*")){
                Integer num2 = Integer.valueOf(stack.pop()), num1 = Integer.valueOf(stack.pop());
                Integer result = num1 * num2;
                stack.push(result);
                
            }else if(s.equals("/")){
                Integer num2 = Integer.valueOf(stack.pop()), num1 = Integer.valueOf(stack.pop());
                Integer result = num1 / num2;
                stack.push(result);
                
            }else{
                stack.push(Integer.valueOf(s));
                numCount++;
            }
        }

        return stack.pop();
        
    }
}
