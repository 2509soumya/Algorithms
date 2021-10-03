package dp;

public class KConcatenationMaxSum {


    public int KConcantenationSum(int[] nums,int k){
        int totsum=0;

        int singlearr_maxendhere=nums[0];
        int singlearr_maxsofar=nums[0];

        for(int i=0;i<nums.length;i++){
            singlearr_maxendhere+=nums[i];
            if(nums[i]>singlearr_maxendhere){
                singlearr_maxendhere=nums[i];
            }
            if(singlearr_maxendhere>singlearr_maxsofar){
                singlearr_maxsofar=singlearr_maxendhere;
            }
            totsum+=nums[i];
        }

        if(k==1){
            return singlearr_maxsofar;
        }

        int[] kadanes_two=new int[nums.length*2];
        for(int j=0;j<kadanes_two.length;j++){
            kadanes_two[j]=nums[j%nums.length];
        }

        int max_sofar=kadanes_two[0];
        int max_endhere=kadanes_two[0];

        for(int i=1;i<kadanes_two.length;i++){
            max_endhere+=kadanes_two[i];
            if(kadanes_two[i]>max_endhere){
                max_endhere=kadanes_two[i];
            }
            if(max_endhere>max_sofar){
                max_sofar=max_endhere;
            }
        }

        if(totsum>0){
            return (k-2)*totsum+max_sofar;
        }else{
            return max_sofar;
        }

    }

    public static void main(String[] args) {
        KConcatenationMaxSum kConcatenationMaxSum=new KConcatenationMaxSum();
        int ans=kConcatenationMaxSum.KConcantenationSum(new int[]{1,2},3);
        System.out.println(ans);
    }

}
