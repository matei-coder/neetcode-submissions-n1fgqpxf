class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int[] freq = new int[1001];
        for(int x : hand) freq[x]++;
        if(hand.length % groupSize != 0 )return false;
        int groups = hand.length/groupSize;


        //Arrays.sort(hand);
        for(int i=0;i<freq.length-groupSize;i++){
            while(freq[i] >0 ){
                int k  = freq[i];
                for(int j = i ; j< i+groupSize;j++){

                    if(freq[j] == 0) return false;
                    freq[j]-= k;
                    //ystem.out.print(j+ " ");
                }

                //System.out.println("");
            }
        }


        return true;
    }
}
