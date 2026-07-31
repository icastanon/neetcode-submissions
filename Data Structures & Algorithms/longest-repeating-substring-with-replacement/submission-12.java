class Solution {
    public int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        int l = 0, r = 0;

        int windowSize = 0;
        Map<Character, Integer> charCounts = new HashMap<>();
        int maxSize = 0;
        char mostFrequentChar = chars[0];

        while(r < chars.length){
            char rightChar = chars[r];
            charCounts.put(rightChar, charCounts.getOrDefault(rightChar, 0)+1);
            windowSize++;

            mostFrequentChar = charCounts.get(rightChar) <= charCounts.get(mostFrequentChar) ? mostFrequentChar : rightChar;
            int mostFrequentCount = charCounts.get(mostFrequentChar);

            if(mostFrequentCount + k < windowSize){
                //window is invalid
                charCounts.put(chars[l], charCounts.get(chars[l])-1);
                l++;
                windowSize--;
            }

            maxSize = Math.max(windowSize, maxSize);
            r++;
        }

        return maxSize;
        
    }
}
// k=5
// AAAAABBBBBCBBBBBBBBB
