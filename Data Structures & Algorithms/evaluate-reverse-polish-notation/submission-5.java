class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        Integer numCount = 0;
        for(String s : tokens){
            if(s.equals("+")){
                Integer num2 = Integer.valueOf(stack.pop()), num1 = Integer.valueOf(stack.pop());
                Integer result = num1 + num2;
                stack.push(Integer.toString(result));

            }else if(s.equals("-")){
                Integer num2 = Integer.valueOf(stack.pop()), num1 = Integer.valueOf(stack.pop());
                Integer result = num1 - num2;
                stack.push(Integer.toString(result));

            }else if(s.equals("*")){
                Integer num2 = Integer.valueOf(stack.pop()), num1 = Integer.valueOf(stack.pop());
                Integer result = num1 * num2;
                stack.push(Integer.toString(result));
                
            }else if(s.equals("/")){
                Integer num2 = Integer.valueOf(stack.pop()), num1 = Integer.valueOf(stack.pop());
                Integer result = num1 / num2;
                stack.push(Integer.toString(result));
                
            }else{
                stack.push(s);
                numCount++;
            }
        }

        return Integer.valueOf(stack.pop());
        
    }
}
