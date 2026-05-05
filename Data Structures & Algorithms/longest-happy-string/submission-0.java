class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int[] freq = new int[]{a , b, c};
        PriorityQueue<Character> pq = new PriorityQueue<>((chara,charb)->{
            return freq[charb-'a']-freq[chara-'a'];
        });
        if(freq[0]>0)pq.add('a');
        if(freq[1]>0)pq.add('b');
        if(freq[2]>0)pq.add('c');
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            char first = pq.poll();
            if(sb.length()<2||sb.charAt(sb.length()-1)!=first||
            sb.charAt(sb.length()-2)!=first){
                
                sb.append(first);
                freq[first-'a']--;
               
            }
            else if(!pq.isEmpty()){
                char second = pq.poll();
                sb.append(second);
                freq[second-'a']--;
                if(freq[second-'a']>0) pq.add(second);

            }else{
                break;
            }
             if(freq[first-'a']>0) pq.add(first);

            
        }

        return sb.toString();
        

    }
}