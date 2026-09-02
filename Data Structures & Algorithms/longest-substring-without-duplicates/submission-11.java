class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        
        int l = 0, r = 1;
        
        Set<Character> unique = new HashSet<>();
        unique.add(s.charAt(l));
        int maxSize = 0;
        while(r < s.length()){
            if(unique.contains(s.charAt(r))){
                maxSize = Math.max(maxSize, unique.size());
                //shift left pointer to the right
                while(s.charAt(l) != s.charAt(r)){
                    unique.remove(s.charAt(l));
                    l++;
                }
                unique.remove(s.charAt(l));
                l++;
            }

            unique.add(s.charAt(r));
            r++;
        }

        return Math.max(maxSize, unique.size());
    }

}
