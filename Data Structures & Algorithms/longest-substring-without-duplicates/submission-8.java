class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> charAndIndex = new HashMap<>();

        int currentCount = 0;

        for(int i = 0; i < s.length(); i++){
            Integer index = charAndIndex.get(s.charAt(i));
            if(Objects.isNull(index) || index <= (i-currentCount-1)){
                charAndIndex.put(s.charAt(i), i);
                currentCount++;
                max = Math.max(max, currentCount);
            }else{
                max = Math.max(max, currentCount);
                currentCount = i - index;
                charAndIndex.put(s.charAt(i), i);
            }
        }

        return max;
    }
}
