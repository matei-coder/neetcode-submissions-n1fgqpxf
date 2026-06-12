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
    public int minMeetingRooms(List<Interval> intervals) {
        int nrOfRooms=0;
        List<List<Interval>> rooms = new ArrayList<>();
        intervals.sort((a,b) -> Integer.compare(a.start , b.start));
        for(int i=0;i<intervals.size();i++){
            Interval interval = intervals.get(i);
            if(rooms.isEmpty()||
            freeRoom(rooms , interval)==-1){
                rooms.add(new ArrayList<>());
                rooms.get(rooms.size()-1).add(interval);
                nrOfRooms++;
            }
        }
        return nrOfRooms;
    }


    public int freeRoom(List<List<Interval>> rooms  , Interval interval){
        int start = interval.start;
        for(int i =0;i< rooms.size();i++){
            List<Interval> room = rooms.get(i);
            if(room.get(room.size()-1).end<=start){              
                room.add(interval);
                return i;
            }
        }
        return -1;
    }
}
