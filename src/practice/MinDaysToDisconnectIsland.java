package practice;

public class MinDaysToDisconnectIsland {
    int singlecelldisconnect=4;
    int[][] grid;

    public int minDays(int[][] grid) {
        int connectedcomp=0;
        this.grid=grid;

        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    connectedcomp++;
                    dfs(i,j,visited);

                    if(connectedcomp>1){
                        return 0;
                    }else{
                        ans=(singlecelldisconnect==0)?1:singlecelldisconnect;
                    }
                }
            }
        }


        return ans;
    }

    public int dfs(int i,int j,boolean[][] visited){
        if(i<0||j<0||i>=visited.length||j>=visited[0].length||grid[i][j]==0){
            return 0;
        }else if(visited[i][j]){
            return 1;
        }

        visited[i][j]=true;
        int totconnectedcell=0;
        int[][] dir={{0,-1},{0,1},{1,0},{-1,0}};
        for(int k=0;k<dir.length;k++){
            totconnectedcell+=dfs(i+dir[k][0],j+dir[k][1],visited);
        }
        singlecelldisconnect=Math.min(singlecelldisconnect,totconnectedcell);
        return 1;
    }

    public static void main(String[] args) {
        MinDaysToDisconnectIsland minDaysToDisconnectIsland=new MinDaysToDisconnectIsland();
        int mindays=minDaysToDisconnectIsland.minDays(new int[][]{{1,1,0,1,1},{1,1,1,1,1},{1,1,0,1,1},{1,1,1,1,1}});
        System.out.println("Min days "+mindays );
    }
}
