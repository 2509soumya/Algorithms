package dp;

public class MatrixMultiplicationRecursion {

    public int findMinCostMatrixMultiplication(int[] mat){
        int[][] memo=new int[mat.length][mat.length];
        return findMinCostMatrixMultiplicationRecursive(mat,0,mat.length-1,memo);
    }

    public int findMinCostMatrixMultiplicationRecursive(int[] mat,int startidx,int endidx,int[][] memo){
        if(memo[startidx][endidx]>0){
            return memo[startidx][endidx];
        }

       if(endidx-startidx==2){
           return mat[startidx]*mat[startidx+1]*mat[endidx];
       }else if(endidx-startidx==1){
           return 0;
       }
        int mincost=Integer.MAX_VALUE;
        for(int i=startidx+1;i<endidx;i++){
            int sideleft=findMinCostMatrixMultiplicationRecursive(mat,startidx,i,memo);
            int sideright=findMinCostMatrixMultiplicationRecursive(mat,i,endidx,memo);
            int totcost=sideleft+sideright+mat[startidx]*mat[i]*mat[endidx];
            mincost=Math.min(totcost,mincost);
        }
        memo[startidx][endidx]=mincost;
        return mincost;
    }

    public static void main(String[] args) {
        MatrixMultiplicationRecursion matrixMultiplicationRecursion=new MatrixMultiplicationRecursion();
        int ans=matrixMultiplicationRecursion.findMinCostMatrixMultiplication(new int[]{10,20,30,40,50});
        System.out.println(ans);
    }

}
