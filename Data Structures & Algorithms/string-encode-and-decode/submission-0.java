class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder("");
        for(String s : strs){
            int length = s.length();
            sb.append(String.valueOf(length));
            sb.append('#');
            for(char c : s.toCharArray()){
                sb.append(c);
            }
        }

        return sb.toString();

    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int index = 0;
        while(index < str.length()){
            StringBuilder strLengthStr = new StringBuilder("");
            while(str.charAt(index) != '#'){
                strLengthStr.append(str.charAt(index));
                index++;
            }   

            Integer strLength = Integer.valueOf(strLengthStr.toString());

            strs.add(str.substring(index+1, index+strLength+1));

            index+=(strLength+1);
        }

        return strs;
    }
}
