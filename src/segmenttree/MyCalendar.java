package segmenttree;

import java.util.TreeMap;

public class MyCalendar {
    TreeMap<Integer,Integer> treemap;

    public MyCalendar() {
        treemap=new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if(((treemap.floorEntry(start)!=null && treemap.floorEntry(start).getValue()>start)) || (treemap.ceilingEntry(start)!=null && end >=treemap.ceilingEntry(start).getKey())){
            return false;
        }else{
            treemap.put(start,end);
            return true;
        }
    }

    public static void main(String[] args) {
        MyCalendar myCalendar=new MyCalendar();
        System.out.println(myCalendar.book(10,20));
        System.out.println(myCalendar.book(15,25));
        System.out.println(myCalendar.book(20,30));
    }

}
