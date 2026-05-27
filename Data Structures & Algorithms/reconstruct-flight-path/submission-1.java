class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), x -> new PriorityQueue<>())
               .add(ticket.get(1));
        }

        LinkedList<String> rasp = new LinkedList<>();
        dfs("JFK", rasp, adj);
        return rasp;
    }

    public void dfs(String curr, LinkedList<String> rasp,
                    Map<String, PriorityQueue<String>> adj) {
        PriorityQueue<String> dests = adj.get(curr);
        while (dests != null && !dests.isEmpty()) {
            String next = dests.poll();   // consuma biletul definitiv
            dfs(next, rasp, adj);
        }
        rasp.addFirst(curr);              // post-order + inversare
    }
}