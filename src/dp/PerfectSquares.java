package dp;

public class PerfectSquares {

        public int numSquares(int n) {


            int[] dp=new int[n+1];
            dp[0]=0;
            for(int i=1;i<=n;i++){
                int j=1;
                dp[i]=i;
                while(j*j<=i){
                    dp[i]=Math.min(dp[i],1+dp[i-j*j]);
                    j++;
                }
            }
            return dp[n];
        }

    public static void main(String[] args) {
        PerfectSquares perfectSquares=new PerfectSquares();
        int res=perfectSquares.numSquares(12);
        System.out.println("Result is "+res);
    }
}
