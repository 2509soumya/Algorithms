public class KthAncestorBinaryLifting {

    int[][] dp;

    public int getKthAncestor(int node, int k) {
        for(int i=0;i<17;i++){
           int mask=1<<i;
           if((k&mask)>0){
               node=dp[i][node];
               if(node==-1){
                   return -1;
               }
           }
        }
        return node;
    }

    public void initializedp(int n, int[] parent){
        dp=new int[17][n];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<parent.length;j++){
               if(i==0){
                   dp[i][j]=parent[j];
               }else{
                   if(dp[i-1][j]==-1){
                       dp[i][j]=-1;
                   }else{
                       dp[i][j]=dp[i-1][dp[i-1][j]];
                   }
               }
            }
        }

    }
}
