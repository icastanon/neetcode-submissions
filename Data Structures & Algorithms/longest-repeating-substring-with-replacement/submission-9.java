class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> cFreq = new HashMap<>();
        int l = 0, r = 0, maxLength = 0;
        boolean rShifted = true;
        while(r < s.length()){
            Character c = s.charAt(r);
            if(rShifted){
                cFreq.put(c, cFreq.getOrDefault(c, 0)+1);
            }
        
            int mostFreq = getMostFreq(cFreq);
            int strSize = r-l+1;

            if(isSubstringValid(strSize, mostFreq, k)){
                maxLength = Math.max(maxLength, strSize);
                r++;
                rShifted = true;
            }else{
                int rightShifts = strSize - (mostFreq + k);
                c = s.charAt(l);
                while(rightShifts > 0){
                    cFreq.put(c, cFreq.get(c)-1);
                    l++;
                    rightShifts--;
                }
                rShifted = false;
            }
        }
        return maxLength;
    }

    public boolean isSubstringValid(int strSize, int mostFreq, int k){
        return mostFreq+k >= strSize ;
    }

    public int getMostFreq(Map<Character, Integer> map){
        int max = 0;
        for(Character c : map.keySet()){
            if(map.get(c) > max){
                max = map.get(c);
            }
        }

        return max;
    }

    
}
