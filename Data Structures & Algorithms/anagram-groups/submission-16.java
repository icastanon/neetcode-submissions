class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            String code = code(s);
            if(map.get(code) != null){
                map.get(code).add(s);
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

        // System.out.println(checkAnagram("str", "trs"));

        return result;
        
    }

    public boolean checkAnagram(String s, String st){
        // Map<Character, Integer> counts = new HashMap<>();
        // for(char c : s.toCharArray()){
        //     Integer count = counts.get(c);
        //     if(count != null){
        //         counts.put(c, count +1);
        //     }else{
        //         counts.put(c, 1);
        //     }
        // }

        // Map<Character, Integer> counts2 = new HashMap<>();
        // for(char c : st.toCharArray()){
        //     Integer count = counts2.get(c);
        //     if(count != null){
        //         counts2.put(c, count +1);
        //     }else{
        //         counts2.put(c, 1);
        //     }
        // }

        // if(counts.size() != counts2.size()){
        //     return false;
        // }

        // for(Character c : counts.keySet()){
        //     if(!counts.get(c).equals(counts2.get(c))){
        //         return false;
        //     }
        // }


        return code(s).equals(code(st));
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
