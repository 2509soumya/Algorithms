package dp;

public class ShortestPathObstacleElim {

    int[][] grid;
    int k;

    public int shortestPath(int[][] grid, int k) {
        this.grid=grid;
        this.k=k;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int[][][] memo=new int[grid.length][grid[0].length][k+1];
        int res=shortestPathrecursive(0,0,k,visited,memo,"(0,0)-");
        return (res==Integer.MAX_VALUE)?-1:res-1;
    }

    public int shortestPathrecursive(int curri,int currj,int obstaclessremaning,boolean[][] visited,int[][][] memo,String path){
        if(curri<0 || curri > grid.length-1 || currj <0 || currj > grid[0].length-1 || visited[curri][currj]){
            return Integer.MAX_VALUE;
        }

        if(curri==11 && currj==6 && obstaclessremaning==1){
            System.out.println("Check");
            System.out.println(path);
        }

        if(grid[curri][currj]==1){
            obstaclessremaning--;
        }
        if(obstaclessremaning<0){
            return Integer.MAX_VALUE;
        }

        if(memo[curri][currj][obstaclessremaning]!=0){
            return memo[curri][currj][obstaclessremaning];
        }
        if(curri==grid.length-1 && currj==grid[0].length-1){
            return 1;
        }

        visited[curri][currj]=true;


        int r=shortestPathrecursive(curri,currj+1,obstaclessremaning,visited,memo,path+"("+curri+"-"+(currj+1)+")-");
        int l=shortestPathrecursive(curri,currj-1,obstaclessremaning,visited,memo,path+"("+curri+"-"+(currj-1)+")-");
        int u=shortestPathrecursive(curri-1,currj,obstaclessremaning,visited,memo,path+"("+(curri-1)+"-"+(currj)+")-");
        int d=shortestPathrecursive(curri+1,currj,obstaclessremaning,visited,memo,path+"("+(curri+1)+"-"+(currj)+")-");
        int res=Math.min(d,Math.min(Math.min(r,l),u));
        int finalresult=(res==Integer.MAX_VALUE)?Integer.MAX_VALUE:res+1;
        memo[curri][currj][obstaclessremaning]=finalresult;
        visited[curri][currj]=false;
        return finalresult;
    }

    public static void main(String[] args) {
        ShortestPathObstacleElim shortestPathObstacleElim=new ShortestPathObstacleElim();
        int ans=shortestPathObstacleElim.shortestPath(new int[][]{{0,0,0,0,0,0,0,0,0,0},{0,1,1,1,1,1,1,1,1,0},{0,1,0,0,0,0,0,0,0,0},{0,1,0,1,1,1,1,1,1,1},{0,1,0,0,0,0,0,0,0,0},{0,1,1,1,1,1,1,1,1,0},{0,1,0,0,0,0,0,0,0,0},{0,1,0,1,1,1,1,1,1,1},{0,1,0,1,1,1,1,0,0,0},{0,1,0,0,0,0,0,0,1,0},{0,1,1,1,1,1,1,0,1,0},{0,0,0,0,0,0,0,0,1,0}},1);
        System.out.println("Answer is "+ans);
    }
}
