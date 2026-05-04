    class Solution {
        public String reorganizeString(String s) {
            int freq[] = new int[26];
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                freq[c-'a']++;
            }
            PriorityQueue<Character> pq = new PriorityQueue<>((a,b) ->{
                return freq[b-'a'] -freq[a-'a'];
            });
             for (char c = 'a'; c <= 'z'; c++) {
                if (freq[c - 'a'] > 0) pq.add(c);
            }
            StringBuilder sb = new StringBuilder();
            while (!pq.isEmpty()) {
    char first = pq.poll();
    freq[first - 'a']--;
    sb.append(first);

    if (!pq.isEmpty()) {
        char second = pq.poll();
        freq[second - 'a']--;
        sb.append(second);
        if (freq[first - 'a'] > 0) pq.add(first);   // first se adauga primul
        if (freq[second - 'a'] > 0) pq.add(second);  // second dupa
    } else {
        if (freq[first - 'a'] > 0) pq.add(first);
    }
}

for (int i = 1; i < sb.length(); i++) {
    if (sb.charAt(i) == sb.charAt(i - 1)) return "";
}
return sb.toString();

        // check simplu la final
           

        }
    }