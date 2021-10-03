package dp;

public class MatrixMulltiplication {

    public int findMinCostMatrixMultiplication(int[] mat){
        //  A B C D E
        //  10 20 30 40 50 60

        int[][] dp=new int[mat.length-1][mat.length-1];

        for(int gap=0;gap<dp.length;gap++){
            for(int i=0,j=gap;j<dp.length;i++,j++){

                if(gap==0){
                    dp[i][j]=0;
                }else{
                    int pointer1x=i;
                    int pointer1y=i;
                    int pointer2x=i+1;
                    int pointer2y=j;
                    int mincost=Integer.MAX_VALUE;
                    while(pointer1y<j && pointer2x<dp.length){
                        mincost=Math.min(mincost,dp[pointer1x][pointer1y]+dp[pointer2x][pointer2y]+mat[pointer1x]*mat[pointer1y+1]*mat[pointer2y+1]);
                        pointer1y++;
                        pointer2x++;
                    }
                    dp[i][j]=mincost;
                }
            }
        }

       return dp[0][mat.length-1-1];
    }


    public static void main(String[] args) {
        MatrixMulltiplication matrixMulltiplication=new MatrixMulltiplication();
        int res=matrixMulltiplication.findMinCostMatrixMultiplication(new int[]{10,20,30,40,50});
        System.out.println("Answer is "+res);
    }
}
