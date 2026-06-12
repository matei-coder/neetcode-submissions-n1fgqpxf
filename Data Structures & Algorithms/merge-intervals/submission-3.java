class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();

        Arrays.sort(intervals , (a,b) -> {
            return Integer.compare(a[0] , b[0]);
        });

        
        int i=0;
        while(i<n){
            int maxim = intervals[i][1];
            
            int j=i+1;
            while(j<n&&maxim>=intervals[j][0]){
                maxim = Math.max(maxim , intervals[j][1]);
                j++;
            }
            ans.add(new int[]{intervals[i][0], maxim });
            i=j;
        }

        return ans.toArray(new int[0][]);



    }
}
