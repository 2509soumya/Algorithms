package dp;

public class SplitArrayWithSameAverage {

    int[] nums;
    int n;
    int sum;

    public boolean splitArraySameAverage(int[] nums) {
        this.nums=nums;
        this.n=nums.length;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        this.sum=sum;
        return recursive(0,0,0);
    }


    public boolean recursive(int idx,int sumsofar,int n1){
        if(idx>=n){
            return false;
        }
        if(n1>0 && ((double)sumsofar/n1==((double)(sum-sumsofar)/(n-n1)))){
            return true;
        }
        System.out.println("Sum so far : "+sumsofar);

        boolean include=recursive(idx+1,sumsofar+nums[idx],n1+1);
        boolean exclude=recursive(idx+1,sumsofar,n1);
        return include || exclude;
    }

    public static void main(String[] args) {
        SplitArrayWithSameAverage splitArrayWithSameAverage=new SplitArrayWithSameAverage();
        boolean ans=splitArrayWithSameAverage.splitArraySameAverage(new int[]{1,2,3,4,5,6,7,8});
        System.out.println("Answer is "+ans);
    }
}
