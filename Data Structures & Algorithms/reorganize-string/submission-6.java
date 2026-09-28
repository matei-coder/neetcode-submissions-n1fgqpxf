class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return b[1] - a[1];
        });
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<freq.length;i++){
            if(freq[i]>0) pq.add(new int[]{i , freq[i]});
        }

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            char last = (sb.length()>0)? (sb.charAt(sb.length()-1)) : ' ';
            char dorit = (char)(curr[0] +'a');
            int nr = curr[1];
            //if(nr-1>0) pq.add(new int[]{ curr[0], nr-1});
            if(dorit!=last){
                sb.append(dorit);
                if(nr-1>0)
                    pq.add(new int[]{curr[0], nr-1});
            }
            else{
    boolean pus = false;
    q.add(curr);

    while(!pq.isEmpty()){
        int[] nou = pq.poll();

        if((char)(nou[0] +'a') != last){
            sb.append((char)(nou[0] + 'a'));

            if(nou[1]-1 > 0)
                pq.add(new int[]{nou[0], nou[1]-1});

            pus = true;
            break;
        }

        q.add(nou);
    }

    if(!pus) return "";

    while(!q.isEmpty()){
        pq.add(q.poll());
    }
}
            
            
        }



        return sb.toString();

    }
}