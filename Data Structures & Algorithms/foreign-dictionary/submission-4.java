class Solution {
    public String foreignDictionary(String[] words) {

        Set<Integer> lit = new HashSet<>();
        List<List<Integer>> adj = new ArrayList<>();



        for(int i=0;i<26;i++) adj.add(new ArrayList<>());

        for(String word:words){
            for(char c:word.toCharArray()){
                lit.add(i(c));
            }
        }

        for(int i=0;i<words.length-1;i++){
            String word1 = words[i];
            String word2 = words[i+1];
            int k=0;
            while(word1.length()>k&&word2.length()>k&&word1.charAt(k)==word2.charAt(k)){
                k++;
            }
            if((word2.length()<word1.length())&&k==word2.length()) return "";
            if(word1.length()>k)
                adj.get(i(word1.charAt(k))).add(i(word2.charAt(k)));
            
        }
        
       
 
        //Ordine Topologica
        Queue<Integer> q = new LinkedList<>();
        int[] nareintrari = new int[26];
        for(int i = 0; i < adj.size(); i++)
            for(int neighbor : adj.get(i))
                nareintrari[neighbor]++;
        for(int i=0;i<adj.size();i++){
            if(nareintrari[i]==0&&lit.contains(i)) q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        
        while(!q.isEmpty()){
            int curr = q.poll();
            sb.append((char)(curr+'a'));
            for(int vecin : adj.get(curr)){
                nareintrari[vecin]--;
                if(nareintrari[vecin]==0) q.add(vecin);
            }
        }
        if(sb.length() != lit.size()) return "";

        return sb.toString();

    

    }

    public int i(char x){
        return x-'a';
    }




    
}
