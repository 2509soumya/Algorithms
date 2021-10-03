package dp;

public class PallindromePartitioningIII {

    int[][] pallinarr;

    public int palindromePartition(String s, int k) {
        pallinarr=new int[s.length()][s.length()];
        for(int gap=0;gap<pallinarr.length;gap++){
            for(int i=0,j=gap;j<pallinarr.length;i++,j++){
                if(gap==0){
                    pallinarr[i][j]=0;
                    continue;
                }
                if(s.charAt(i)==s.charAt(j)){
                    if(gap==1){
                        pallinarr[i][j]=0;
                    }else{
                        pallinarr[i][j]=pallinarr[i+1][j-1];
                    }
                }else{
                    pallinarr[i][j]=pallinarr[i+1][j-1]+1;
                }
            }
        }
        Integer[][][] dp=new Integer[s.length()][s.length()][k+1];
        return pallindromeRecurse(s,k,0,s.length()-1,dp);
    }



    public int pallindromeRecurse(String s,int k,int i,int j,Integer[][][] dp){
        if(dp[i][j][k]!=null){
            return dp[i][j][k];
        }

        if(j-i+1==k){
            return 0;
        }else if(k==1){
            return pallinarr[i][j];
        }

        int minchanges=Integer.MAX_VALUE;
        for(int idx=0;idx<=s.length()-k;idx++){
            minchanges=Math.min(minchanges,pallinarr[i][idx]+pallindromeRecurse(s,k-1,idx+1,j,dp));
        }
        dp[i][j][k]=minchanges;
        return minchanges;
    }

    public static void main(String[] args) {
        PallindromePartitioningIII pallindromePartitioningIII=new PallindromePartitioningIII();
        int res=pallindromePartitioningIII.palindromePartition("leetcode",8);
        System.out.println("Result is "+res);
    }


}
