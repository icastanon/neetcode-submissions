class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> chars = new HashMap<>();
        chars.put('(', ')');
        chars.put('{', '}');
        chars.put('[', ']');

        Deque<Character> stack = new ArrayDeque<>();

        for(Character c : s.toCharArray()){
            if(c == ')' || c == '}' || c == ']'){
                if(stack.size() == 0 || chars.getOrDefault(stack.pop(), '.') != c){
                    return false;
                }
            }else{
                stack.push(c);
            }
        }

        return stack.size() == 0;
        
    }
}
