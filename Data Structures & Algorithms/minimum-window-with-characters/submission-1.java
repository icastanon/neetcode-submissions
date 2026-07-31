class Solution {
    public String minWindow(String s, String t) {
        String smallestString = "";
        boolean stringInitialized = false;
        int l = 0, r = 0;
        HashMap<Character, Integer> m = new HashMap<>();
        for(int i = 0; i < t.length(); i ++){
            Character c = t.charAt(i);
            m.put(c, m.getOrDefault(c, 0)+1);
        }

        HashMap<Character, Integer> windowMap = new HashMap<>();
        boolean windowDecreased = false;

        windowMap.put(s.charAt(0), 1);

        StringBuilder windowString = new StringBuilder();
        windowString.append(s.charAt(0));

        while(r < s.length()){
            if(isValid(m, windowMap)){
                //update smallestString if the current windowString is smaller than smallestString
                if(windowString.length() < smallestString.length() || !stringInitialized){
                    smallestString = windowString.toString();
                    stringInitialized = true;
                }

                //update hashmap(decrement current character at l)
                Character c = s.charAt(l);
                windowMap.put(c, windowMap.getOrDefault(c, 0)-1);

                //update windowString (pop from the front)
                windowString.deleteCharAt(0);

                //then increment l by one (the idea is to attempt to shrink as much as possible as soon as we find a valid string)
                l++;
            }else{
                //increment r (expand the string attempting to make it valid)
                r++;
                if(r >= s.length()){
                    break;
                }
                Character c = s.charAt(r);
                windowString.append(c);
                windowMap.put(c, windowMap.getOrDefault(c, 0)+1);
            }
        }

        return smallestString;
        
    }

    private boolean isValid(HashMap<Character, Integer> targetMap, HashMap<Character, Integer> windowMap){
        for(Character c : targetMap.keySet()){
            if(windowMap.getOrDefault(c, 0) < targetMap.get(c)){
                return false;
            }
        }

        return true;
    }
}
