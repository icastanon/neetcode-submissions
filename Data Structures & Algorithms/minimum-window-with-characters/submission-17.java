class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tCounts = new HashMap<>();
        for(Character c : t.toCharArray()){
            tCounts.put(c, tCounts.getOrDefault(c, 0)+1);
        }

        char[] sChars = s.toCharArray();
        int l = 0, r = 0;

        String shortestString = "";

        Map<Character, Integer> sCounts = new HashMap<>();
        sCounts.put(sChars[0], 1);

        while(r < sChars.length){
            if(isValid(tCounts, sCounts)){
                String currentSubstr = s.substring(l, r+1);
                shortestString = (shortestString.equals("") || currentSubstr.length() < shortestString.length()) ? 
                                currentSubstr : shortestString;

                //shrink window
                sCounts.put(sChars[l], sCounts.get(sChars[l])-1);
                l++;
            }else{
                //increase window
                r++;
                if(r < sChars.length){
                    sCounts.put(sChars[r], sCounts.getOrDefault(sChars[r], 0)+1);
                }
            }
        }

        return shortestString;

    }

    public boolean isValid(Map<Character, Integer> tCounts, Map<Character, Integer> sCounts){
        for(char c : tCounts.keySet()){
            if(tCounts.get(c) > sCounts.getOrDefault(c, 0)){
                return false;
            }
        }

        return true;
    }
}
