package dp;

public class PallindromePartitioning {

    public int minCut(String s) {
        int[][] dp=new int[s.length()][s.length()];
        boolean[][] pallinarr=new boolean[s.length()][s.length()];

        for(int gap=0;gap<pallinarr.length;gap++){
            for(int i=0,j=gap;j<pallinarr.length;i++,j++){
                if(gap==0){
                    pallinarr[i][j]=true;
                    continue;
                }
                if(s.charAt(i)==s.charAt(j)){
                    if(gap==1){
                        pallinarr[i][j]=true;
                    }else{
                        pallinarr[i][j]=pallinarr[i+1][j-1];
                    }
                }else{
                    pallinarr[i][j]=false;
                }
            }
        }

        for(int gap=0;gap<dp.length;gap++){
            for(int i=0,j=gap;j<dp.length;i++,j++){
                if(pallinarr[i][j]){
                    dp[i][j]=0;
                }
                else{
                    int mincuts=Integer.MAX_VALUE;
                    for(int k=i;k<j;k++){
                        mincuts=Math.min(mincuts,dp[i][k]+dp[k+1][j]);
                    }
                    dp[i][j]=mincuts+1;
                }
            }
        }
        return dp[0][s.length()-1];
    }

    public static void main(String[] args) {
        PallindromePartitioning pallindromePartitioning=new PallindromePartitioning();
        int mincuts=pallindromePartitioning.minCut("a");
        System.out.println("Mincuts is "+mincuts);
    }
}
