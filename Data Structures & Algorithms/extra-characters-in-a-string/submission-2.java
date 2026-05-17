class Solution {

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    TrieNode root = new TrieNode();

    public void addToTrie(String word){
        TrieNode curr = root;
        for(int i=word.length()-1; i>=0;i--){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx]==null){
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }

        curr.isEnd = true;
    }


    public int minExtraChar(String s, String[] dictionary) {

        for(String x: dictionary){
            addToTrie(x);
        }
        int n = s.length();
        int[] dp = new int[n+1];
        for(int i=1 ; i<= n ;i++){
            dp[i] = dp[i-1]+1;
            TrieNode curr = root;
            for (int j = i - 1; j >= 0; j--) {
                int idx = s.charAt(j) - 'a';
                if (curr.children[idx] == null) {
                    break;  // nu mai există drum → STOP
                }
                curr = curr.children[idx];
                
                if (curr.isEnd) {
                    // am găsit cuvântul s[j..i-1] în dicționar
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        
        return dp[n];

        }





    }
