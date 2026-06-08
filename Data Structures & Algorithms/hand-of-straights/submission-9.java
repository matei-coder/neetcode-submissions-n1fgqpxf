class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int[] freq = new int[1001];
        int min = 9999999;
        int max = -1;
        for(int x : hand) {
            min = Math.min(x, min);
            max = Math.max(x , max);
            freq[x]++;
            
            }
        if(hand.length % groupSize != 0 )return false;
        int groups = hand.length/groupSize;


        //Arrays.sort(hand);
        for(int i=min;i<=max;i++){
            if(freq[i] >0 ){
                int k  = freq[i];
                for(int j = i ; j< i+groupSize;j++){

                    if(freq[j] == 0) return false;
                    freq[j]-= k;
                    System.out.print(j+ " ");
                }

                System.out.println("");
            }
        }


        return true;
    }
}
