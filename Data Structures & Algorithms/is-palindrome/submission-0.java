class Solution {
    public boolean isPalindrome(String s) {
        String parsed = s.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();;
        for(int i = parsed.length()-1; i >= parsed.length()/2; i--){
            if(parsed.charAt(i) != parsed.charAt(parsed.length()-1-i)){
                return false;
            }
        }

        return true;
        
    }
}
