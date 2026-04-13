class Solution {
    public int mySqrt(long x) {
        long l=0, r=x;
        long ans = x;
        while(l<=r){
            long m =(r-l)/2+l;
            if(m*m==x) 
                return (int)m;
            else if(m*m>x) {
                r=m-1;
            }
            else {
                ans = m;
                l=m+1;
            }
        }
        return (int)ans;
    }
}