class Solution {
    List<String> ans = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        backtrack(sb , 0 , n , 0 );
        return ans;
        
    }
    public void backtrack(StringBuilder sb , int nrofleft , int n , int nrofright){
        if(nrofleft == n&& nrofright == n){
            ans.add(new String(sb.toString()));
            return;
        }
        if(nrofright<nrofleft){
            sb.append(")");
            backtrack(sb , nrofleft , n , nrofright+1);
            sb.deleteCharAt(sb.length()-1);
        }
        if(nrofleft<n){
            sb.append("(");
            backtrack(sb , nrofleft+1 , n , nrofright);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
}
