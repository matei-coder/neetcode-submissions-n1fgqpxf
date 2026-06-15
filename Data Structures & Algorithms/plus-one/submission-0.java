class Solution {
    public int[] plusOne(int[] digits) {
        int desumat =1;
        List<Integer> lista = new ArrayList<>();
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]+desumat<10){
                digits[i]+=desumat;
                desumat=0;
                lista.add(digits[i]);
            }
            else{
                digits[i]=(digits[i]+desumat)%10;
                desumat = 1;
                lista.add(digits[i]);
            }
        }
        if(desumat==1) lista.add(1);

        Collections.reverse(lista);
        int[] ans = new int[lista.size()];
        for(int i=0;i<lista.size();i++){
            ans[i] = lista.get(i);
        }
        return ans;

    }
}
