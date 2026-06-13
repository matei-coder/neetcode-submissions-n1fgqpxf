class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int[] count = new int[n];

        // camere libere, ordonate dupa index
        PriorityQueue<Integer> free = new PriorityQueue<>();
        for (int i = 0; i < n; i++) free.offer(i);

        // camere ocupate: {timp_eliberare, index}, dupa timp apoi index
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0])
                                   : Long.compare(a[1], b[1])
        );

        for (int[] m : meetings) {
            long start = m[0], end = m[1];

            // elibereaza camerele terminate pana la start
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                free.offer((int) busy.poll()[1]);
            }

            if (!free.isEmpty()) {
                int room = free.poll();
                count[room]++;
                busy.offer(new long[]{end, room});
            } else {
                long[] e = busy.poll();
                long freeTime = e[0];
                int room = (int) e[1];
                count[room]++;
                busy.offer(new long[]{freeTime + (end - start), room});
            }
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[ans]) ans = i;
        }
        return ans;
    }
}