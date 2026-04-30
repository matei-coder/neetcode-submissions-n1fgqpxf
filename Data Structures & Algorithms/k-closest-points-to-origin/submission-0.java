class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a , b) ->toDistance(a.x , a.y)-toDistance(b.x , b.y));
        for(int i=0;i<points.length;i++){
            int x = points[i][0];
            int y= points[i][1];

            pq.add(new Tuple(x , y));
        }
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++){
            Tuple t = pq.poll();
            ans[i] = new int[]{t.x , t.y};
        }

        return ans;
       
        

    }
    public int toDistance(int x , int y){
        return (x*x+y*y);
    }

    class Tuple{
        int x, y;

        Tuple(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
