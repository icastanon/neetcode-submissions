class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for(Character c : s1.toCharArray()){
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> charCountS2 = new HashMap<>();

        int l=0, r=0;
        while(r < s2.length()){
            if(r-l+1 <= s1.length()){
                //if length is valid -> count current character at r and check permutation
                Character c = s2.charAt(r);
                charCountS2.put(c, charCountS2.getOrDefault(c, 0) + 1);

                if(isPermutation(charCount, charCountS2)){
                    return true;
                }

                r++;
            }else{
                //if length is invalid -> move left pointer once and subtract from current window frequencies
                Character c = s2.charAt(l);
                charCountS2.put(c, charCountS2.get(c) - 1);
                l++;
            }

            
        }

        return false;

        
    }

    public boolean isPermutation(HashMap<Character, Integer> m1, HashMap<Character, Integer> m2){
        Set<Character> m1Keys = m1.keySet(), m2Keys = m2.keySet();

        for(Character c : m1Keys){
            if(m2.get(c) != m1.get(c)){
                return false;
            }
        }
            

        return true;
    }
}
