package uber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UberLocation {

    public int countUber(int[][] coordinates){
        Map<Integer,Integer> ubercount=new HashMap<>();
        int start=Integer.MAX_VALUE;
        int end=Integer.MIN_VALUE;
        for(int i=0;i<coordinates.length;i++){
            ubercount.putIfAbsent(coordinates[i][0],0);
            ubercount.put(coordinates[i][0],ubercount.get(coordinates[i][0])+1);

            if(coordinates[i][1]<Integer.MAX_VALUE){
                ubercount.putIfAbsent(coordinates[i][1]+1,0);
                ubercount.put(coordinates[i][1]+1,ubercount.get(coordinates[i][1]+1)-1);
            }
            start=Math.min(start,coordinates[i][0]);
            end=Math.max(end,coordinates[i][1]);
        }

        int counter=0;
        int num=0;

        for(int i=start;i<=end;i++){
            if(ubercount.containsKey(i)){
                num+=ubercount.get(i);
            }
            if(num>0){
                counter++;
            }
            if(i==Integer.MAX_VALUE){
                break;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        UberLocation uberLocation=new UberLocation();
        int ans=uberLocation.countUber(new int[][]{{Integer.MIN_VALUE,Integer.MAX_VALUE}});
        System.out.println("Answer is "+ans);
        List<Integer> al=new ArrayList<>();
    }
}
