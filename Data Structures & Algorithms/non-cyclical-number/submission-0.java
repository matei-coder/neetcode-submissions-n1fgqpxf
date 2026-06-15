class Solution {
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();
        while(n!=1){
            if(s.contains(n)) return false;
            else{
                s.add(n);
                n = sumsq(n);
            }
        }

        return true;
    }
    public int sumsq (int n){
        int s=0;
        while(n>0){
            s=s+(n%10)*(n%10);
            n/=10;
        }
        return s;
    }
}
