package kickstart;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Festival {
   static class HappinessElem implements Comparable<HappinessElem>{
        int happinessnum;
        int start;
        int end;

        HappinessElem(int happinessnum,int start,int end){
            this.happinessnum=happinessnum;
            this.start=start;
            this.end=end;
        }

        @Override
        public int compareTo(HappinessElem comparewith){
            return this.happinessnum-comparewith.happinessnum;
        }

    }

    public static int eval(int[][] events,int days,int k){
        PriorityQueue<HappinessElem> pq=new PriorityQueue<>(Collections.reverseOrder());
        int[] isfilledarr=new int[days+1];
        int[] maxfest=new int[days+1];
        for(int i=0;i<events.length;i++){
            HappinessElem elem=new HappinessElem(events[i][0],events[i][1],events[i][2]);
            pq.offer(elem);
        }

        while(!pq.isEmpty()){
            HappinessElem elem=pq.poll();
            for(int j=elem.start;j<=elem.end;j++){
                if(isfilledarr[j]<k){
                    maxfest[j]+=elem.happinessnum;
                    isfilledarr[j]++;
                }
            }
        }

        int max=0;
        for(int i=0;i<maxfest.length;i++){
            max=Math.max(max,maxfest[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int testcases=sc.nextInt();
        for(int i=1;i<=testcases;i++){
            int days=Integer.parseInt(sc.next());
            int events=Integer.parseInt(sc.next());
            int k=Integer.parseInt(sc.next());
            int[][] evearray=new int[events][3];
            for(int j=0;j<events;j++){
                int happiness=Integer.parseInt(sc.next());
                int start=Integer.parseInt(sc.next());
                int end=Integer.parseInt(sc.next());
                int[] evehere={happiness,start,end};
                evearray[j]=evehere;
            }
            int res=eval(evearray,days,k);
            System.out.println(String.format("Case #%s: %s",i,res));
        }
    }
}
