class Solution {
    public int countSubstrings(String s) {
        int[] dp = new int[s.length()];
        int count=0;

        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(isPal(s.substring(i,j+1))) {
                   
                    count ++;}
            }
        }

        return count;
    }

    public boolean isPal(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
