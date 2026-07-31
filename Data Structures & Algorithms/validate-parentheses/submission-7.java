class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        System.out.println(s.length());

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(s.charAt(i));
            }else if(c == ')'){
                if(stack.peek() != null && stack.peek() == '('){
                    stack.poll();
                }else{
                    return false;
                }
            }else if(c == '}'){
                if(stack.peek() != null && stack.peek() == '{'){
                    stack.poll();
                }else{
                    return false;
                }
            }else if(c == ']'){
                if(stack.peek() != null && stack.peek() == '['){
                    stack.poll();
                }else{
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
