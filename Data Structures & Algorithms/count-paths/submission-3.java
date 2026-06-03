class Solution {
    public int uniquePaths(int m, int n) {

        long x =combinari(n+m-2 , n-1);
        return (int)x;

    }


    private long combinari(int n, int k) {
        long rez = 1;
        
        for (int i = 1; i <= k; i++) {
            rez = rez * (n - k + i) / i;
        }
        
        return rez;
    }

   
}
