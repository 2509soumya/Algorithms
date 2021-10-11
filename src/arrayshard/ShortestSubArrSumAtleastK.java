package arrayshard;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubArrSumAtleastK {

    public int shortestSubarray(int[] nums, int k) {

        if(nums.length==1 && nums[0]>=k){
            return 1;
        }

       int[] prefixsum=new int[nums.length+1];
       for(int i=0;i<nums.length;i++){
           prefixsum[i+1]=prefixsum[i]+nums[i];
       }


        Deque<Integer> integerdq=new ArrayDeque<>();
        int res=nums.length+1;
        for(int i=0;i<nums.length+1;i++){
           while(!integerdq.isEmpty() && prefixsum[i]-prefixsum[integerdq.peekFirst()]>=k){
               res=Math.min(res,i-integerdq.pollFirst());
           }
           while(!integerdq.isEmpty() && prefixsum[integerdq.peekLast()]>=prefixsum[i]){
               integerdq.pollLast();
           }
           integerdq.offerLast(i);
       }

       return res==nums.length+1?-1:res;
    }

    public static void main(String[] args) {
        ShortestSubArrSumAtleastK shortestSubArrSumAtleastK=new ShortestSubArrSumAtleastK();
        int res=shortestSubArrSumAtleastK.shortestSubarray(new int[]{2,-1,2},3);
        System.out.println("Result is "+res);
    }
}
