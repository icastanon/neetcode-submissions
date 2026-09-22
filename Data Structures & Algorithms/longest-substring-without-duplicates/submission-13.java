class Solution {
    public int lengthOfLongestSubstring(String st) {
        char[] chars = st.toCharArray();
        int l = 0, r = 0;

        Set<Character> s = new HashSet<>();

        int maxSize = 0;

        while(r < chars.length){
            while(s.contains(chars[r])){
                s.remove(chars[l]);
                l++;
            }

            s.add(chars[r]);
            r++;
            maxSize = Math.max(maxSize, r - l);
        }

        return maxSize;
        
    }
}
