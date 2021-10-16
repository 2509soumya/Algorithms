package practice;

public class KthAncestor {
    int[][] dp;

    public KthAncestor(int n, int[] parent) {
        int setbits=0;
        int val=n;
        while(val>0){
            val=val>>1;
            setbits++;
        }
        dp=new int[setbits][n];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
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

    public int getKthAncestor(int node, int k) {
        int kthnode=node;
        for(int i=0;i<dp.length;i++){
            if((node & (1<<i+1))>0){
                kthnode=dp[i][kthnode];
                if(kthnode==-1){
                    return -1;
                }
            }
        }
        return kthnode;
    }

    public static void main(String[] args) {
        KthAncestor kthAncestor=new KthAncestor(7,new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.println(kthAncestor.getKthAncestor(3,1));
        System.out.println(kthAncestor.getKthAncestor(5,2));
        System.out.println(kthAncestor.getKthAncestor(6,3));
    }
}
