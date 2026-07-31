class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int l = 0, r = chars.length-1;

        while(true){
            while(!isValid(chars[r]) && r>0){
                r--;
            }

            while(!isValid(chars[l]) && l < chars.length-1){
                l++;
            }

            if(l >= r){
                break;
            }

            if(chars[l] != chars[r]){
                return false;
            }
            l++;
            r--;
        }

        return true;
        
    }

    public boolean isValid(char c){
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
