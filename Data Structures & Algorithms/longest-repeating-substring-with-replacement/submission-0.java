class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character ,Integer> map = new HashMap<>();
        int j=0;
        int maxim=0;
        int maxFreq=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
             map.put(c , map.getOrDefault(c,0)+1);
            maxFreq = Math.max(maxFreq, map.getOrDefault(c,0));
           
            
            if((i-j+1)-maxFreq>k){
                char l = s.charAt(j);
                map.put(l, map.get(l) - 1);
                j++;
            }



             maxim = Math.max(maxim , i-j+1);

        }
        return maxim;
    }
}
