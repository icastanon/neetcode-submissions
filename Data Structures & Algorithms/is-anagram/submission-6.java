class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> charCount = new HashMap<>();

        for(char c : s.toCharArray()){
            Integer count = charCount.get(c);
            if(count == null){
                charCount.put(c, 1);
            }else{
                charCount.put(c, count+1);
            }
        }

        Map<Character, Integer> charCount2 = new HashMap<>();
        for(char c : t.toCharArray()){
            Integer count = charCount2.get(c);
            if(count == null){
                charCount2.put(c, 1);
            }else{
                charCount2.put(c, count+1);
            }
        }

        if(charCount.keySet().size() != charCount2.keySet().size())
            return false;

        for(char c : charCount.keySet()){
            if(!charCount.get(c).equals(charCount2.get(c)))
                return false;
        }

        return true;

    }
}
