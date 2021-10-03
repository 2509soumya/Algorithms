package dp;

public class MaxSumSubArrayAtLeastK {

    public int maxSumAtLeastK(int[] nums,int k){

        int sum=0;
        Integer[] kadanesdp=new Integer[nums.length];

        int maxsofar=Integer.MIN_VALUE;
        int maxendhere=Integer.MIN_VALUE;
        int finalans=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(i>=k){
                sum=sum-nums[i-k];
                int ans=kadanesdp[i-k]+sum;
                finalans=Math.min(ans,finalans);
            }
            maxendhere+=nums[i];
            if(nums[i]>maxendhere){
                maxendhere=nums[i];
            }
            if(maxendhere>maxsofar){
                maxsofar=maxendhere;
            }
            kadanesdp[i]=maxendhere;
        }

        return finalans;
    }
}
