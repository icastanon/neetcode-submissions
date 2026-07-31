class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        //at most 26 characters so these two maps will be O(1) space?
        Map<Character, Integer> s1Counts = new HashMap<>();
        Map<Character, Integer> s2Counts = new HashMap<>();
        s2Counts.put(s2.charAt(0), 1);

        for(int i = 0; i < s1.length(); i++){
            s1Counts.put(s1.charAt(i), s1Counts.getOrDefault(s1.charAt(i), 0)+1);
        }

        int l = 0, r = 0;
        char[] chars = s2.toCharArray();

        while(r < chars.length){
            int windowSize = r-l+1;
 
            if(windowSize < s1.length()){
                r++;
                s2Counts.put(s2.charAt(r), s2Counts.getOrDefault(s2.charAt(r), 0)+1);
            }else if(windowSize == s1.length()){
                if(isPermutation(s1Counts, s2Counts)){
                    return true;
                }
                r++;
                if(r < chars.length){
                    s2Counts.put(chars[r], s2Counts.getOrDefault(chars[r], 0)+1);
                }
                

                s2Counts.put(chars[l], s2Counts.get(chars[l])-1);
                l++;
            }
        }

        return false;
        
    }

    public boolean isPermutation( Map<Character, Integer> s1Counts,  Map<Character, Integer> s2Counts){
        //only 26 letters in the alphabet so this loop is at most 26? meaning O(1)?
        for(Character c : s1Counts.keySet()){
            if(!s1Counts.get(c).equals(s2Counts.getOrDefault(c, 0))){
                return false;
            }
        }

        return true;
    }
}
