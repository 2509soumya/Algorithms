package dp;

public class StoneGame {

    public int findMaxScore(int[] arr){

        int[][] dp=new int[arr.length][arr.length];
        for(int gap=0;gap<dp.length;gap++){
            for(int i=0,j=gap;j<dp.length;i++,j++){
                if(gap==0){
                    dp[i][j]=arr[j];
                }else if(gap==1){
                    dp[i][j]=Math.max(arr[i],arr[j]);
                }else{
                    dp[i][j]=Math.max(Math.min(dp[i+2][j],dp[i+1][j-1])+arr[i],Math.min(dp[i][j-2],dp[i+1][j-1])+arr[j]);
                }
            }
        }
       return dp[0][arr.length-1];
    }

    public static void main(String[] args) {
        StoneGame stoneGame=new StoneGame();
        int ans=stoneGame.findMaxScore(new int[]{20,30,2,10});
        System.out.println("Result is "+ans);
    }
}
