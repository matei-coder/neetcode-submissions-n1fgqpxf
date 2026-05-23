class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[numCourses];

        for (int[] e : prerequisites) {     // e[0] -> e[1]
            adj.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }

        // ajunge[i] = mulțimea de noduri care sunt prerechizită (directă/indirectă) pentru i
        BitSet[] ajunge = new BitSet[numCourses];
        for (int i = 0; i < numCourses; i++) ajunge[i] = new BitSet(numCourses);

        // Sortare topologică (Kahn)
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) q.add(i);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                // tot ce ajunge la u, ajunge și la v; plus u însuși
                ajunge[v].or(ajunge[u]);   // OR pe biți — moștenește strămoșii lui u
                ajunge[v].set(u);          // u e prerechizită directă a lui v

                if (--indegree[v] == 0) q.add(v);
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            // query[0] este prerechizită pentru query[1]?
            ans.add(ajunge[query[1]].get(query[0]));
        }
        return ans;
    }
}