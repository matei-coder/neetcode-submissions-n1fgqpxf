    class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            int[] rank = new int[26];
            for(int i=0;i<order.length();i++){
                int idx = order.charAt(i) - 'a';
                rank[idx] = i ;
            }

            for(int i=0;i<words.length-1;i++){
                if(!compare(words[i] , words[i+1] , rank)) return false;
            }
            return true;
        }

        public boolean compare(String a , String b , int[] rank){
            int i=0, j=0;
            while(i<a.length()&&j<b.length()){
                if(rank[a.charAt(i) - 'a']>rank[b.charAt(j)-'a']){
                    return false;
                }
                else if(rank[a.charAt(i) - 'a']==rank[b.charAt(j)-'a']){
                    i++;
                    j++;
                }
                else{
                return true;
                }
            }
            if(a.length()<=b.length())
            return true;
            else return false;
        }
    }