package dp;

public class EditDistance {
    public int minDistance(String word1, String word2) {

        if(word1.length()==0 && word2.length()==0){
            return 0;
        }else if(word1.length()==0){
            return word2.length();
        }else if(word2.length()==0){
            return word1.length();
        }

        int[][] dp=new int[word1.length()+1][word2.length()+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){

                /** boundary condition**/
                if(i==0 && j==0){
                    dp[i][j]=0;
                    continue;
                }
                else if(i==0){
                    dp[i][j]=j;
                }else if(j==0){
                    dp[i][j]=i;
                }else{
                    if(word1.charAt(i-1)==word2.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1];
                    }else{
                        dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                    }
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
