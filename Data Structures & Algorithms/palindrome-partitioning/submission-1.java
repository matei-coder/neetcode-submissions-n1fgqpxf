class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> lista = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(s , lista , sb , 0);
        return ans;
    }
    public void backtrack(String s , List<String> lista , StringBuilder sb , int i){
        if(i == s.length()){
            if(sb.length()==0)
            ans.add(new ArrayList<>(lista));
            return;
        }
        char x = s.charAt(i);
        sb.append(x);
        if(isPalindrome(sb.toString())){           
            lista.add(new String(sb.toString()));            
            backtrack(s , lista , new StringBuilder() , i+1); 
            lista.remove(lista.size()-1);         
        }
        //sb.append(x);
        backtrack(s , lista , sb , i+1);
        sb.deleteCharAt(sb.length()-1);
        
       
        
        
       
    

    }



    public boolean isPalindrome(String s){
        int i=0 , n = s.length()-1;
        while(i<n-i&&s.charAt(i)==s.charAt(n-i)){
            i++;
        }
        if(i>=n-i) return true;
        else return false;
    }
}
