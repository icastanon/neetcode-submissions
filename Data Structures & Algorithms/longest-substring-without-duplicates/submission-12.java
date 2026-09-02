public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int l = 0, res = 0;

        for (int r = 0; r < s.length(); r++) {
            if (mp.containsKey(s.charAt(r)) && mp.get(s.charAt(r)) >= l) {
                l = mp.get(s.charAt(r)) + 1;
            }
            mp.put(s.charAt(r), r);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}