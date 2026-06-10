class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) return new int[][]{newInterval};
        //int[][] ans = new int[1001][2];
        List<int[]> ans = new ArrayList<>();

        int i=0;
        //inainte de newInterval
        while(i<intervals.length&&intervals[i][1]<newInterval[0]){
            int[] interval = intervals[i];
            ans.add(new int[]{interval[0] , interval[1]});   
            i++;
            if(i>=intervals.length) break;   
        }

        //in interval
        int minim = newInterval[0];
        int maxim = newInterval[1];
        while(i<intervals.length&&intervals[i][0]<=newInterval[1]){
            minim = Math.min(minim , intervals[i][0]);
            maxim = Math.max(maxim , intervals[i][1]);
            i++;
            if(i>=intervals.length) break;
        }
        ans.add(new int[]{minim , maxim});


        //dupa interval
        while(i<intervals.length){
                        int[] interval = intervals[i];

             ans.add(new int[]{interval[0] , interval[1]});
             i++;
        }



        return ans.toArray(new int[0][]);









        
    }
}
