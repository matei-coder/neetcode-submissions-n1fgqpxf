class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;
        Map <String , List<String>> rootToWord = new HashMap<>();
        for(String word : dict){
            char[] arr = word.toCharArray();
            for(int i=0;i<word.length();i++){
                char orig = arr[i];
                arr[i] = '*';
                String pattern = new String(arr);
                if(!rootToWord.containsKey(pattern)) rootToWord.put(pattern , new ArrayList<>());
                rootToWord.get(pattern).add(word);
                arr[i]= orig;                
            }
        }

        Queue<String> q = new LinkedList<>();
        Set<String> viz = new HashSet<>();
        q.add(beginWord);
        viz.add(beginWord);
        int level = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int j=0;j<size;j++){
                String nou = q.poll();
                if(nou.equals(endWord)) return level;
                    char[] arr = nou.toCharArray();
                for(int i=0;i<arr.length;i++){
                    char temp = arr[i];
                    arr[i] = '*';
                    String pattern = new String(arr);
                    arr[i] = temp;
                if(rootToWord.containsKey(pattern)){
                    for(String next : rootToWord.get(pattern)){
                        if(!viz.contains(next)){
                            q.add(next);
                            viz.add(next);
                        }
                    }
                }
            }

            }
            level++;
        }


        return 0;

    }
}
