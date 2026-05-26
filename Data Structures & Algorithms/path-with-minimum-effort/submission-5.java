class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        int n = heights.length;
        int m = heights[0].length;

        int[][] effort = new int[n][m];
        for (int[] row : effort) Arrays.fill(row, Integer.MAX_VALUE);
        effort[0][0] = 0;

        // {efort, x, y}, ordonate după cel mai mic efort mai întâi
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currEffort = curr[0], x = curr[1], y = curr[2];

            if (x == n - 1 && y == m - 1) return currEffort;
            if (currEffort > effort[x][y]) continue; // intrare învechită, sari peste

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                int newEffort = Math.max(currEffort,
                        Math.abs(heights[x][y] - heights[nx][ny]));

                if (newEffort < effort[nx][ny]) {
                    effort[nx][ny] = newEffort;
                    pq.add(new int[]{newEffort, nx, ny});
                }
            }
        }

        return 0; // se atinge doar dacă grila are o singură celulă
    }
}