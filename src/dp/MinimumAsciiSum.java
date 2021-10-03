package dp;

public class MinimumAsciiSum {

    public int minDeleteSum(String s1,String s2){
        int[][] dp=new int[s1.length()+1][s2.length()+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 && j==0){
                    dp[i][j]=0;
                    continue;
                }

                int i_idx=i-1;
                int j_idx=j-1;

                if(i==0){
                    dp[i][j]=dp[i][j-1]+(int)s2.charAt(j_idx);
                    continue;
                }
                if(j==0){
                    dp[i][j]=dp[i-1][j]+(int)s1.charAt(i_idx);
                    continue;
                }

                if(s1.charAt(i_idx)==s2.charAt(j_idx)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    int lu_sum=dp[i-1][j-1]+(int)s1.charAt(i_idx)+(int)s2.charAt(j_idx);
                    int cu_sum=dp[i-1][j]+(int)s1.charAt(i_idx);
                    int cl_sum=dp[i][j-1]+(int)s2.charAt(j_idx);
                    int ans=Math.min(lu_sum,Math.min(cu_sum,cl_sum));
                    dp[i][j]=ans;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        MinimumAsciiSum minimumAsciiSum=new MinimumAsciiSum();
        int res=minimumAsciiSum.minDeleteSum("seat","beat");
        System.out.println("Result is "+res);
    }
}
