class Solution {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];           // nodurile sunt 1..n
        for (int i = 1; i <= n; i++) parent[i] = i;  // fiecare e propriul lider

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            // dacă u și v sunt deja conectate, muchia asta închide un ciclu
            if (find(u) == find(v)) return edge;
            union(u, v);
        }
        return new int[0];   // nu se ajunge aici (problema garantează un ciclu)
    }

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);  // path compression
        return parent[x];
    }

    void union(int a, int b) {
        parent[find(a)] = find(b);
    }
}