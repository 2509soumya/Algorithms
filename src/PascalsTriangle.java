public class PascalsTriangle {

    public void printpascalsTri(){

        int dp[][]=new int[5][5];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    dp[i][j]=1;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
                }
            }
        }

        //print dp
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle=new PascalsTriangle();
        pascalsTriangle.printpascalsTri();
    }
}
