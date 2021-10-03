package heaps;

import java.util.PriorityQueue;

public class JumpGame6 {

    public int maxResult(int[] nums, int k) {
        if(nums.length==1){
            return nums[0];
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->b[1]-a[1]);
        pq.offer(new int[]{nums.length-1,nums[nums.length-1]});
        int res=0;

        for(int i=nums.length-2;i>=0;i--){
            while(pq.peek()[0]-i>k){
                pq.poll();
            }
            if(i==0){
                res=nums[i]+pq.peek()[1];
            }
            pq.offer(new int[]{i,nums[i]+pq.peek()[1]});
        }
        return res;
    }

    public static void main(String[] args) {
        JumpGame6 jumpGame6=new JumpGame6();
        int res=jumpGame6.maxResult(new int[]{10,-5,-2,4,0,3},3);
        System.out.println(res);
    }
}
