class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] rooms = new int[n];
        int[] count = new int[n];
        Arrays.sort(meetings , (a,b) -> a[0] - b[0]);


        for(int j=0;j<meetings.length;j++){
            int roomminim = 9999999;
            int roomscore = 9999999;
            boolean bagat = false;

            for(int i=0;i<n;i++){
                System.out.print(rooms[i]+" ");
            }
            for(int i=0;i<n;i++){
                if(bagat==true) break;
                
                if(rooms[i]<=meetings[j][0]){
                    rooms[i] = meetings[j][1];
                    count[i]++;
                    bagat = true;

                }
                else{
                   if(roomscore>rooms[i]){
                        roomscore = rooms[i];
                        roomminim = i;
                   }
                }
            }
            System.out.println();
            if(!bagat){
                rooms[roomminim] += meetings[j][1]-meetings[j][0];
                count[roomminim]++;

            }
        }


        int ans = n;
        int ansmin = -1;
        for(int i=n-1;i>=0;i--){
            System.out.println(count[i]);
            if(count[i]>=ansmin){
                ans = i;
                ansmin = count[i];
            }
        }
        


        return ans;

    }
}