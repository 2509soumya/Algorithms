package heaps;

import java.util.PriorityQueue;

public class SingleThreadedCPU {

    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> availableheap=new PriorityQueue<>((a, b)->a[1]==b[1]?(a[0]-b[0]):(a[1]-b[1]));
        PriorityQueue<int[]> standbyheap=new PriorityQueue<>((a,b)->a[1]-b[1]);

        for(int i=0;i<tasks.length;i++){
            standbyheap.offer(new int[]{i,tasks[i][0]});
        }

        int time=1;
        int[] order=new int[tasks.length];
        int idx=0;
        while(!(standbyheap.isEmpty() && availableheap.isEmpty())){

            while(!standbyheap.isEmpty() && standbyheap.peek()[1]<=time){
                int[] standby_task=standbyheap.poll();
                availableheap.offer(new int[]{standby_task[0],tasks[standby_task[0]][1]});
            }
            if(availableheap.isEmpty()){
                int[] standby_task=standbyheap.poll();
                availableheap.offer(new int[]{standby_task[0],tasks[standby_task[0]][1]});
                time=standby_task[1];
            }

            int[] serverelem=availableheap.poll();
            order[idx++]=serverelem[0];
            time+=serverelem[1];
        }
        return order;
    }

    public static void main(String[] args) {
        SingleThreadedCPU singleThreadedCPU=new SingleThreadedCPU();
        int[] order=singleThreadedCPU.getOrder(new int[][]{{1,2},{2,4},{3,2},{4,1}});
        System.out.println(order);
    }
}
