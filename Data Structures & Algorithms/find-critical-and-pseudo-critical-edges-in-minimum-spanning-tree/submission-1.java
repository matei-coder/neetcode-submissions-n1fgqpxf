class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        // adj.get(u) = liste de {vecin, cost, indexMuchie}
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            adj.get(u).add(new int[]{v, w, i});
            adj.get(v).add(new int[]{u, w, i}); // graf neorientat
        }

        int costBaza = prim(n, adj, -1);

        List<Integer> critice = new ArrayList<>();
        List<Integer> pseudo  = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            // Test critic: scot muchia i
            if (prim(n, adj, i) > costBaza) {
                critice.add(i);
                continue;
            }
            // Test pseudo-critic: forțez muchia i
            if (primForteaza(n, adj, edges[i]) == costBaza) {
                pseudo.add(i);
            }
        }

        return Arrays.asList(critice, pseudo);
    }

    // Prim standard, cu opțiunea de a sări peste o muchie (skipIdx = -1 => nicio sărire)
    private int prim(int n, List<List<int[]>> adj, int skipIdx) {
        boolean[] viz = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{0, 0, -1}); // {nod, cost, indexMuchie}
        int total = 0, nrVizitate = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int nod = curr[0], cost = curr[1];
            if (viz[nod]) continue;
            viz[nod] = true;
            total += cost;
            nrVizitate++;
            for (int[] next : adj.get(nod)) {
                if (next[2] == skipIdx) continue;       // sar peste muchia exclusă
                if (!viz[next[0]]) pq.add(next);
            }
        }
        return nrVizitate == n ? total : Integer.MAX_VALUE; // deconectat => infinit
    }

    // Prim cu o muchie forțată în MST
    private int primForteaza(int n, List<List<int[]>> adj, int[] muchie) {
        int u = muchie[0], v = muchie[1], w = muchie[2];
        boolean[] viz = new boolean[n];
        viz[u] = true;
        viz[v] = true;          // ambele capete deja "în arbore"
        int total = w;          // costul muchiei forțate intră direct
        int nrVizitate = 2;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int[] next : adj.get(u)) if (!viz[next[0]]) pq.add(next);
        for (int[] next : adj.get(v)) if (!viz[next[0]]) pq.add(next);

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int nod = curr[0], cost = curr[1];
            if (viz[nod]) continue;
            viz[nod] = true;
            total += cost;
            nrVizitate++;
            for (int[] next : adj.get(nod))
                if (!viz[next[0]]) pq.add(next);
        }
        return nrVizitate == n ? total : Integer.MAX_VALUE;
    }
}