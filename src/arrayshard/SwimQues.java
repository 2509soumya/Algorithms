package arrayshard;

public class SwimQues {

    public void dfs(int t,int i,int j,boolean[][] visited,int[][] grid){
        if(i>=visited.length || j>=visited.length || i<0 || j<0 || visited[i][j] || grid[i][j]>t){
            return;
        }
        visited[i][j]=true;
        dfs(t,i+1,j,visited,grid);
        dfs(t,i-1,j,visited,grid);
        dfs(t,i,j+1,visited,grid);
        dfs(t,i,j-1,visited,grid);
    }



    public int swimWater(int[][] grid){
        int lo=0;
        int hi=50*50;

        while(lo<hi){
          int mid=(lo+hi)/2;
          boolean[][] visited=new boolean[grid.length][grid[0].length];
          dfs(mid,0,0,visited,grid);
          if(visited[grid.length-1][grid.length-1]){
            hi=mid;
          }else{
              lo=mid+1;
          }
        }
        return lo;
    }

    public static void main(String[] args) {
        SwimQues swimQues=new SwimQues();
        int ans=swimQues.swimWater(new int[][]{{0,2},{1,3}});
        System.out.println(ans);
    }
}
