class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean gasit1 = false;
        boolean gasit2 = false;
        boolean gasit3 = false;


        for(int[] t : triplets){
            if(t[0]<=target[0]&&t[1]<=target[1]&&t[2]<=target[2]){
                if(t[0]==target[0]) gasit1=true;
                if(t[1]==target[1]) gasit2=true;
                if(t[2]==target[2]) gasit3=true;
            }
        }

        if(gasit1&&gasit2&&gasit3) return true;
        return false;
    }
}
