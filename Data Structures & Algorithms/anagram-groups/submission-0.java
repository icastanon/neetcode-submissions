class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Character>, List<String>> anagramMap = new HashMap<>();
        for(String s : strs){
            List<Character> sortedChars = getSortedChars(s);
            List<String> mapValue = anagramMap.get(sortedChars);
            if(Objects.nonNull(mapValue)){
                mapValue.add(s);
            }else{
                List<String> sA = new ArrayList<>();
                sA.add(s);
                anagramMap.put(sortedChars, sA);
            }
        }

        List<List<String>> stringLists = new ArrayList<>();
        for(List<Character> k : anagramMap.keySet()){
            stringLists.add(anagramMap.get(k));
        }

        return stringLists;
        
    }

    private static List<Character> getSortedChars(String s){
        List<Character> chars = new ArrayList<>();
        char[] charArray = s.toCharArray();
        for(char c : charArray){
            chars.add(c);
        }

        Collections.sort(chars);

        return chars;
    }
}
