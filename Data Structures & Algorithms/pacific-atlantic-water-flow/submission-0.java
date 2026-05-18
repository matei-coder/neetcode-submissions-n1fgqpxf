
class Solution {
    // Clasa ta helper pentru BFS
    class Coordonate {
        int x, y, val;
        Coordonate(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return ans;
        }

        int rows = heights.length;
        int cols = heights[0].length;

        Queue<Coordonate> q = new LinkedList<>();
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0) {
                    q.add(new Coordonate(i, j, heights[i][j]));
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Coordonate curr = q.poll();
            
            if (curr.x < 0 || curr.x >= rows || curr.y < 0 || curr.y >= cols || pacific[curr.x][curr.y]) {
                continue;
            }

            pacific[curr.x][curr.y] = true;

            for (int d = 0; d < 4; d++) {
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];

                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                    if (heights[nx][ny] >= curr.val && !pacific[nx][ny]) {
                        q.add(new Coordonate(nx, ny, heights[nx][ny]));
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == rows - 1 || j == cols - 1) {
                    q.add(new Coordonate(i, j, heights[i][j]));
                }
            }
        }

        while (!q.isEmpty()) {
            Coordonate curr = q.poll();
            
            if (curr.x < 0 || curr.x >= rows || curr.y < 0 || curr.y >= cols || atlantic[curr.x][curr.y]) {
                continue;
            }

            atlantic[curr.x][curr.y] = true;

            for (int d = 0; d < 4; d++) {
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];

                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                    if (heights[nx][ny] >= curr.val && !atlantic[nx][ny]) {
                        q.add(new Coordonate(nx, ny, heights[nx][ny]));
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(new ArrayList<>(List.of(i, j)));
                }
            }
        }

        return ans;
    }
}