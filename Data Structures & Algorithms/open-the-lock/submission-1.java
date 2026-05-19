class Solution {
    class Lock{
        char[] s;
        int durata;
        Lock(char[] s , int durata){
            this.s = s;
            this.durata = durata;
            
        }
    }



    public int openLock(String[] deadends, String target) {
        Set<String> harta = new HashSet<>();
        for(String x: deadends) harta.add(x);
        Queue<Lock> q = new LinkedList<>();
       
        
        q.add(new Lock(new char[]{'0', '0', '0', '0'}, 0)); 
        while(!q.isEmpty()){
            Lock curr = q.poll();
            

            
            char[] pass = curr.s;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<4;i++){
                sb.append(pass[i]);
            }
            if(target.equals(sb.toString())) return curr.durata;
            if(harta.contains(sb.toString())) continue;
            harta.add(sb.toString());

            
            for (int i = 0; i < 4; i++) {
                char temp = pass[i];

                pass[i] = (pass[i] == '9') ? '0' : (char)(pass[i] + 1);
                q.add(new Lock(pass.clone(), curr.durata + 1));
                pass[i] = temp;

    
                pass[i] = (pass[i] == '0') ? '9' : (char)(pass[i] - 1);
                q.add(new Lock(pass.clone(), curr.durata + 1));
                pass[i] = temp;
                }

            



        }


        return -1;

    }
}
     
