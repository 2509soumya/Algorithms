package segmenttree;

import java.util.TreeMap;

public class CalendarII {

    class Interval{
        int bookingend;
        int timesbooked;
        Interval(int bookingend,int timesbooked){
            this.bookingend=bookingend;
            this.timesbooked=timesbooked;
        }
    }

    TreeMap<Integer,Interval> intervalmap;

    public CalendarII() {
        intervalmap=new TreeMap<>();
    }

    public boolean book(int start, int end) {
        int updatedstart=start;
        if((intervalmap.floorEntry(start)!=null && intervalmap.floorEntry(start).getValue().bookingend>start) || (intervalmap.ceilingEntry(start)!=null && end>intervalmap.ceilingEntry(start).getKey())){
             if((intervalmap.floorEntry(start).getValue()!=null && intervalmap.floorEntry(start).getValue().timesbooked==2) || (intervalmap.ceilingEntry(start)!=null && intervalmap.ceilingEntry(start).getValue().timesbooked==2)){
                 return false;
             }else{
                 if(intervalmap.floorEntry(start)!=null && intervalmap.floorEntry(start).getValue().bookingend>start){
                     Interval prev_interval=intervalmap.floorEntry(start).getValue();
                     int prev_bookingend=prev_interval.bookingend;
                     prev_interval.bookingend=start;
                     if(prev_bookingend>end){
                         intervalmap.put(start,new Interval(end,2));
                         intervalmap.put(end,new Interval(prev_bookingend,1));
                     }else{
                         intervalmap.put(start,new Interval(prev_bookingend,2));
                         intervalmap.put(prev_bookingend,new Interval(end,1));
                         updatedstart=prev_bookingend;
                     }
                 }

                 if(intervalmap.ceilingEntry(updatedstart)!=null && end>intervalmap.ceilingEntry(updatedstart).getKey()){
                     Interval next_interval=intervalmap.ceilingEntry(updatedstart).getValue();
                     int next_bookingstart=intervalmap.ceilingEntry(updatedstart).getKey();
                     int next_bookingend=next_interval.bookingend;
                     intervalmap.put(updatedstart,new Interval(next_bookingstart,1));
                     next_interval.bookingend=end;
                     next_interval.timesbooked=2;
                     intervalmap.put(end,new Interval(next_bookingend,1));
                 }
                 return true;
             }
        }else{
            intervalmap.put(start,new Interval(end,1));
            return true;
        }
    }

    public static void main(String[] args) {
        CalendarII obj=new CalendarII();
        System.out.println(obj.book(10,20));
        System.out.println(obj.book(50,60));
        System.out.println(obj.book(10,40));
        System.out.println(obj.book(5,15));
        System.out.println(obj.book(5,10));
        System.out.println(obj.book(25,55));
    }
}
