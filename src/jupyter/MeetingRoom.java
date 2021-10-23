package jupyter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom {

    //[0,30]  [5,10] [15,20]

    // 0  5  10 15 20 30
    public int minRoomsRequired(int[][] startendarr){

        Arrays.sort(startendarr, Comparator.comparingInt(a -> a[0]));


        int minmeetingrooms=0;
        int currmeetingrooms=0;
        PriorityQueue<Integer> endtimeq=new PriorityQueue<>();
        for(int i=0;i<startendarr.length;i++){

            if(endtimeq.isEmpty()){
                endtimeq.offer(startendarr[i][1]);
            }else{
                if(endtimeq.peek()<startendarr[i][0]){
                    endtimeq.poll();
                }
                endtimeq.offer(startendarr[i][1]);
            }
            currmeetingrooms=endtimeq.size();
            minmeetingrooms=Math.max(currmeetingrooms,minmeetingrooms);
        }
        return minmeetingrooms;
    }

    public static void main(String[] args) {
        MeetingRoom sol=new MeetingRoom();
        int ans=sol.minRoomsRequired(new int[][]{{0,30},{5,10},{15,20}});
        System.out.println(ans);
    }
}
