class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) sb.append(str).append('§');
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int last=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '§'){
                ans.add(str.substring(last , i));
                last=i+1;
            }
        }

        return ans;
    }
}
