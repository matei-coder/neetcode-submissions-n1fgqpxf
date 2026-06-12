/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() ==0 )return true;

        int[][] intervals2 = new int[intervals.size()][2];
        for(int i=0;i<intervals.size();i++){
            intervals2[i][0] = intervals.get(i).start;
            intervals2[i][1] = intervals.get(i).end;

        }
        Arrays.sort(intervals2 , (a , b) -> Integer.compare(a[0] ,b[0]));
        int n = intervals2.length;
        int maxim = intervals2[0][1];
        for(int i=1;i<n;i++){
            if(maxim>intervals2[i][0]){
                return false;
            }
            else maxim= Math.max(maxim , intervals2[i][1]);
        }

        return true;

    }
}
