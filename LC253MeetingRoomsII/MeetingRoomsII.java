import java.util.*;

class Interval {
    int start, end;
    Interval(){start = 0; end = 0;}
    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

class MeetingRoomsII {
    public static int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0 || intervals == null) return 0;
        //Sort the intervals by start time first
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {return a.start - b.start;}
        });

        //maintain a min heap to track the minimum end time
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {return a.end - b.end;}
        });

        pq.offer(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            Interval curr = pq.poll();
            if(intervals[i].start >= curr.end) {
                //if the start time is later than the end time of previous one
                //then there is no need to start a new one and change the end time to the latest
                curr.end = intervals[i].end;
            } else {
                //if not then offer the invertal into the queue
                pq.offer(intervals[i]);
            }
            //put the curr interval back to the queue
            pq.offer(curr);
        }
        return pq.size();
    }

    public static void main(String[] args) {
        Interval[] test = new Interval[4];
        test[0] = new Interval(0, 30);
        test[1] = new Interval(5, 10);
        test[2] = new Interval(15, 20);
        test[3] = new Interval(10, 30);
        System.out.println(minMeetingRooms(test));
    }
}