class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<List<Integer>> buckets = new ArrayList<>();
        for(int i=0;i<=n;i++) buckets.add( new ArrayList<>());
        int freq[] = new int[2001];
        for(int x: nums){
            freq[x+1000]++;
        }
        for(int i=0;i<freq.length;i++){
            int val = freq[i];
            buckets.get(val).add(i-1000);
        }
        int ans[] = new int[k];
        int ix =0;
        for(int i=n;i>=0 && ix<k ;i --){
            for(int frequencies : buckets.get(i)){
                ans[ix++] = frequencies;
                if(ix == k) break;
            }
        }


        return ans;
    }
}
