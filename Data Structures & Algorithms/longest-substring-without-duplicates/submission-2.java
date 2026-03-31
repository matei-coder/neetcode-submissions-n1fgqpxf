class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        else if(s.length()==1) return 1;
        Set<Character> set = new HashSet<>();
        int maxim = 0;
        int j=0;
        set.add(s.charAt(j));
        for(int i=1;i<s.length();i++){          
            if(set.contains(s.charAt(i)))
            while(set.contains(s.charAt(i))&&j<i){
                set.remove(s.charAt(j++));
            }
           
            set.add(s.charAt(i));
            maxim=Math.max(maxim , i-j+1);
        }
        return maxim;
    }

}

