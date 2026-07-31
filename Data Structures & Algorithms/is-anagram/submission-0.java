class Solution {
    public boolean isAnagram(String s, String t) {
        ArrayList<Character> sA = new ArrayList<>();
        ArrayList<Character> tA = new ArrayList<>();

        for(char c : s.toCharArray()){
            sA.add(Character.valueOf(c));
        }

        for(char c : t.toCharArray()){
            tA.add(Character.valueOf(c));
        }

        Collections.sort(sA);
        Collections.sort(tA);

        if(sA.equals(tA)){
            return true;
        }
        return false;
    }
}
