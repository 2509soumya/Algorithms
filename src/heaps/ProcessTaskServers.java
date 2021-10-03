package heaps;

import java.util.*;

public class ProcessTaskServers {

    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> availableserverq=new PriorityQueue<>((a, b)-> a[1]==b[1]?(a[0]-b[0]):(a[1]-b[1]));
        PriorityQueue<int[]> unavailableserverq=new PriorityQueue<>((a, b)-> a[1]==b[1]?(a[0]-b[0]):(a[1]-b[1]));

        for(int i=0;i<servers.length;i++){
            int[] serverelem={i,servers[i]};
            availableserverq.offer(serverelem);
        }

        int[] res=new int[tasks.length];
        int time=0;



        for(int j=0;j<tasks.length;j++){
            int taskidx=tasks[j];
            if(availableserverq.isEmpty()){
                int[] unavailable_server=unavailableserverq.poll();
                availableserverq.offer(new int[]{unavailable_server[0],servers[unavailable_server[0]]});
                time=unavailable_server[1];
            }
            
            while(!unavailableserverq.isEmpty() && unavailableserverq.peek()[1]==time){
                int[] unavailable_server=unavailableserverq.poll();
                availableserverq.offer(new int[]{unavailable_server[0],servers[unavailable_server[0]]});
            }
            int[] serverelem=availableserverq.poll();
            res[j]=serverelem[0];
            unavailableserverq.offer(new int[]{serverelem[0],time+taskidx});
            time++;
        }
        return res;
    }

    public static void main(String[] args) {
        ProcessTaskServers processTaskServers=new ProcessTaskServers();
        int[] taskarr=processTaskServers.assignTasks(new int[]{3,3,2},new int[]{1,2,3,2,1,2});
        System.out.println(taskarr);
    }
}
