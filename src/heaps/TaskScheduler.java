package heaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {


    public int leastInterval(char[] tasks, int n) {
        int[] alphabet=new int[26];
        for(int i=0;i<tasks.length;i++){
            int idx=tasks[i]-'A';
            alphabet[idx]++;
        }

        Arrays.sort(alphabet);
        int totidle=(alphabet[25]-1)*n;
        for(int i=24;i>=0;i--){
            totidle=totidle-Math.min(alphabet[i],alphabet[25]-1);
        }

        return tasks.length+Math.max(0,totidle);
    }

    public static void main(String[] args) {
        TaskScheduler taskScheduler=new TaskScheduler();
        int res=taskScheduler.leastInterval(new char[]{'A','A','A','B','B','B'},2);
        System.out.println(res);
    }
}
