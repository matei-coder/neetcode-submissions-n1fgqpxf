class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] lista = new int[n+1];
        
        for(int[] q : trust){
            int ai = q[0];
            int bi = q[1];
            lista[ai] = -1;
            if(lista[bi]!=-1)lista[bi]+=1;

        }

        for(int i =1;i<=n;i++){
            if(lista[i]==n-1) return i;
        }

        return -1;
    }
}