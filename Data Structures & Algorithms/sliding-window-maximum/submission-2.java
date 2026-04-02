class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] rasp = new int[nums.length-k+1];
        int it=0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> nums[b] - nums[a]);
        Set<Integer> deleted = new HashSet<>(); // acum contine indecsi

        for(int i=0;i<k;i++){
            maxHeap.offer(i);
           
        }
        rasp[it++]=nums[maxHeap.peek()];
        //deleted.add(maxHeap.peek());
        for(int i=k;i<nums.length;i++){
           maxHeap.offer(i);
           deleted.add(i - k);
           while (!maxHeap.isEmpty() && deleted.contains(maxHeap.peek())) {
                deleted.remove(maxHeap.peek());
                maxHeap.poll();
            }
            rasp[it++]=nums[maxHeap.peek()]; 
            
        }

        return rasp;

    }
}
