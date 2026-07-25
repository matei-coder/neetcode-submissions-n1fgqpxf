class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> {
            return b-a;
        });
        Map<Integer , Integer> scoase = new HashMap<>();
        int ans[] = new int[nums.length - k+1];
        int id=0;
        for(int i=0;i<k;i++){
            pq.add(nums[i]);
        }
        ans[id++] = pq.peek();

        for(int i=k;i<nums.length;i++){
            pq.add(nums[i]);
            scoase.put(nums[i-k] , scoase.getOrDefault(nums[i-k] , 0)+1);

            while(scoase.containsKey(pq.peek())){
                if(scoase.get(pq.peek()) == 1){
                    scoase.remove(pq.poll());
                }else{
                    scoase.put( pq.peek() , scoase.get(pq.poll())-1);
                }
            }
            ans[id++] = pq.peek();

        }




        return ans;
    }
}
