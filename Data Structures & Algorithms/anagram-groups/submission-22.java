class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            String code = code(s);
            List<String> anagrams = map.get(code);
            if(anagrams != null){
                anagrams.add(s);
            }else{
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(code, l);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for(String s : map.keySet()){
            result.add(map.get(s));
        }

        return result;
        
    }

    public String code(String st){
        int[] counts = new int[26];
        for(char c : st.toCharArray()){
            counts[c-'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for(char c = 'a'; c <= 'z'; c++){
            sb.append(c);
            sb.append(counts[c - 'a']);
        }

        // System.out.println(sb.toString());

        return sb.toString();
    }
}
