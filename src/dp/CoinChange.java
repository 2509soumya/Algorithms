package dp;

public class CoinChange {

    public int sumWays(int total,int k){

        int[][] dp=new int[k+1][total+1];

        for(int i=1;i<=k;i++){
            for(int j=1;j<=total;j++){
                if(j<i){
                    dp[i][j]=dp[i-1][j];
                }else if(j==i){
                    dp[i][j]=1+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i][j-i]+dp[i-1][j];
                }
            }
        }
        return dp[k][total];
    }

    public static void main(String[] args) {
        CoinChange coinChange=new CoinChange();
        int ans=coinChange.sumWays(5,2);
        System.out.println("Answer is "+ans);
    }

}
