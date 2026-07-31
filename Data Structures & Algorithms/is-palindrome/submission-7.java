class Solution {
    // public boolean isPalindrome(String s) {
    //     String parsed = s.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();;
    //     for(int i = parsed.length()-1; i >= parsed.length()/2; i--){
    //         if(parsed.charAt(i) != parsed.charAt(parsed.length()-1-i)){
    //             return false;
    //         }
    //     }

    //     return true;
        
    // }

    // public boolean isPalindrome(String s) {
    //     int rightIndex = s.length()-1;
    //     int leftIndex = 0;

    //     while(rightIndex > leftIndex){
    //         char leftChar = s.charAt(leftIndex), rightChar = s.charAt(rightIndex);
    //         while(!isAlpha(leftChar) && rightIndex > leftIndex){
    //             leftIndex++;
    //             leftChar = s.charAt(leftIndex);

    //         }
    //         while(!isAlpha(rightChar) && rightIndex > leftIndex){
    //             rightIndex--;
    //             rightChar = s.charAt(rightIndex);
    //         }

    //         if(Character.toUpperCase(leftChar) != Character.toUpperCase(rightChar)){
    //             return false;
    //         }

    //         leftIndex++;
    //         rightIndex--;
    //     }

    //     return true;
        
    // }

    // public static boolean isAlpha(char c){
    //     if((c >='A'&& c <= 'Z') || (c >='a'&& c <= 'z') ||(c >='0'&& c <= '9')){
    //         return true;
    //     }

    //     return false;
    // }

    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            while (l < r && !alphaNum(s.charAt(l))) {
                l++;
            }
            while (r > l && !alphaNum(s.charAt(r))) {
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++; r--;
        }
        return true;
    }

    public boolean alphaNum(char c) {
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }

}
