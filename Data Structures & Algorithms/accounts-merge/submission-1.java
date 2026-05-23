class Solution {
    Map<String, String> parent = new HashMap<>();   // email -> părintele lui

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();  // email -> nume cont

        // --- PAS 1: inițializare + union ---
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if(!parent.containsKey(email)) parent.put(email , email);
                emailToName.put(email, name);
                union(email , account.get(1));
                // TODO: dacă emailul e nou, fă-l propriul părinte (parent.put(email, email))
                // TODO: reține emailToName.put(email, name)
                // TODO: unește emailul curent cu PRIMUL email al contului (account.get(1))
            }
        }

        // --- PAS 2: grupează emailurile după șef (find) ---
        Map<String, List<String>> groups = new HashMap<>();  // șef -> lista de emailuri
        for (String email : parent.keySet()) {
            String root = find(email);
            if(!groups.containsKey(root)) groups.put(root , new ArrayList<>());
            groups.get(root).add(email);
            // TODO: adaugă email în groups.get(root)  (creează lista dacă lipsește)
        }

        // --- PAS 3: construiește răspunsul ---
        List<List<String>> result = new ArrayList<>();
        for (String root : groups.keySet()) {
            List<String> emails = groups.get(root);

            PriorityQueue<String> pq = new PriorityQueue<>( (a, b) -> {
                return a.compareTo(b);
            });
            for(String email : emails){
                pq.add(email);
            }
            List<String> ans = new ArrayList<>();
            ans.add(emailToName.get(pq.peek()));
            while(!pq.isEmpty()){
                ans.add(pq.poll());
            }
            result.add(ans);

            
            // TODO: sortează emails
            // TODO: creează o listă nouă: [nume, email1, email2, ...]
            //       numele îl iei din emailToName.get(root) sau emailToName.get(orice email din grup)
            // TODO: result.add(listaConstruita)
        }

        return result;
    }

    // --- Union-Find pe String-uri ---
    String find(String x) {
       if( x!= parent.get(x)) parent.put(x, find(parent.get(x)));
        // TODO: path compression (recursiv sau iterativ)
        // dacă parent.get(x) != x, parent.put(x, find(parent.get(x)))
        // return parent.get(x)
        return parent.get(x);
    }

    void union(String a, String b) {
        // TODO: parent.put(find(a), find(b))
        parent.put(find(a) , find(b));
    }
}