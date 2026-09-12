class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int[] freq = new int[2001];
        for(int x: nums){
            freq[x+1000]++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->{
            return freq[a]-freq[b];
        });
        for(int x = 0;x<=2000;x++){
            maxHeap.add(x);
            while(maxHeap.size() > k ) maxHeap.poll();
        }

        int[] ans = new int[k];
        int ix =0;
        while(!maxHeap.isEmpty()){
            ans[ix++] = maxHeap.poll() - 1000;
        }

        return ans;
    }
}
