class Solution {
    List<String> ans = new ArrayList<>();
    //cifra = cod asci 'a' + 3*(cifra-2) + 1/+2/+3
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(digits , 0 , sb);
        return ans;
    }
    public void backtrack(String digits , int start , StringBuilder sb ){
        if(start==digits.length()){
            ans.add(new String(sb.toString()));
            return;
        }
        char x = digits.charAt(start);
        if(x-'0'<=6){
        for(int i=0;i<3;i++){
            
            sb.append((char)('a'+3*((int)(x-'0')-2) +i));
            backtrack(digits , start+1 , sb);
            sb.deleteCharAt(sb.length()-1);
        }
        }
        else{
            if(x-'0'==7){
                for(int i=0;i<4;i++){           
                    sb.append((char)('a'+3*((int)(x-'0')-2) +i));
                    backtrack(digits , start+1 , sb);
                    sb.deleteCharAt(sb.length()-1);
                }
            }
            else if(x-'0'==8){
                for(int i=0;i<3;i++){           
                    sb.append((char)('a'+3*((int)(x-'0')-2) +i+1));
                    backtrack(digits , start+1 , sb);
                    sb.deleteCharAt(sb.length()-1);
                }
            }
            else if(x-'0'==9){
                for(int i=0;i<4;i++){           
                    sb.append((char)('a'+3*((int)(x-'0')-2) +i+1));
                    backtrack(digits , start+1 , sb);
                    sb.deleteCharAt(sb.length()-1);
                }
            }

            
        }
    }
}
