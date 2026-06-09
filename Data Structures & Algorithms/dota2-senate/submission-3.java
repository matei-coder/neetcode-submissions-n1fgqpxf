class Solution {
    // class Node{
    //     Node back; 
    //     Node front;
    //     char val;

    //     Node(char val){
    //         this.back = null;
    //         this.val = val;
    //         this.front = null;
    //     }
    // }



    public String predictPartyVictory(String senate) {
        int rcount = 0;
        int dcount = 0;
        String d = "Dire";
        String r = "Radiant";



        int[] senat = new int[senate.length()];
        boolean cevaschimbat = true;
        while(cevaschimbat==true){
            cevaschimbat = false;
            for(int i =0;i<senate.length();i++){
                char c = senate.charAt(i);
                if(senat[i]==0){
                if(c=='R'){
                        
                        if(dcount>0){
                            senat[i] =1;
                            dcount--;
                            cevaschimbat=true;
                        }
                        else{
                            rcount++;
                        }
                }
                else if(c == 'D'){
                        
                        if(rcount>0){
                            senat[i]=1;
                            rcount--;
                            cevaschimbat=true;
                        }
                        else{
                            dcount++;
                        }

                }

                }
                

            }
        }
        for(int i=0;i<senate.length();i++){
            if(senat[i]==0){
                if(senate.charAt(i)=='R') return r;
                else return d;
            }
        }


     return d;
    }
}