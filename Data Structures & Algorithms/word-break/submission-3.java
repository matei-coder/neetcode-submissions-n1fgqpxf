class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        Set<Integer> setdeInt = new HashSet<>();

        boolean[] dp = new boolean[s.length()];
        for(String st : wordDict) set.add(st);
        setdeInt.add(0);
        for(int i=0;i<s.length();i++){
            boolean b = false;
            for(int x: setdeInt)
            if(set.contains(s.substring(x , i+1))) 
                dp[i] = true;
            

            if(dp[i]) setdeInt.add(i+1);
        }

        return dp[s.length()-1];
    }
}
