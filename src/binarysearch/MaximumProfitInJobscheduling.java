package binarysearch;

import java.util.*;

public class MaximumProfitInJobscheduling {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int[][] lookup=new int[startTime.length][3];
        for(int i=0;i<lookup.length;i++){
            lookup[i][0]=startTime[i];
            lookup[i][1]=endTime[i];
            lookup[i][2]=profit[i];
        }

        Arrays.sort(lookup, Comparator.comparingInt(a -> a[0]));
        TreeMap<Integer,Integer> timetoprofit=new TreeMap<>();

        for(int i=0;i<lookup.length;i++){
            int[] valhere=lookup[i];
            int previousprofit=0;
            if(timetoprofit.floorEntry(valhere[0])!=null){
                previousprofit=timetoprofit.floorEntry(valhere[0]).getValue();
            }
            previousprofit+=valhere[2];
            timetoprofit.put(valhere[1],previousprofit);
        }
        int max=0;
        for(Integer profits : timetoprofit.values()){
            max=Math.max(max,profits);
        }
        return max;
    }


}
