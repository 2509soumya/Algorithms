package dp;

public class EggDroppingProblem {

    public int totalattempts(int eggs,int floors){

        int[][] dp=new int[eggs+2][floors+2];

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(i==1){
                    dp[i][j]=j;
                }else if(j==1){
                    dp[i][j]=1;
                }else{
                    int dropatfloor=1;
                    int min_tot=Integer.MAX_VALUE;
                    while(dropatfloor<=j){
                        int attemptsifbreaks=dp[i-1][dropatfloor-1];
                        int attemptsifdoesntbreak=dp[i][j-dropatfloor];
                        int max_attempts=Math.max(attemptsifbreaks,attemptsifdoesntbreak);
                        min_tot=Math.min(min_tot,max_attempts+1);
                        dropatfloor++;
                    }
                    dp[i][j]=min_tot;
                }
            }
        }
        return dp[eggs+1][floors+1];
    }

    public static void main(String[] args) {
        EggDroppingProblem eggDroppingProblem=new EggDroppingProblem();
        int res=eggDroppingProblem.totalattempts(2,6);
        System.out.println("Answer is "+res);
    }
}
