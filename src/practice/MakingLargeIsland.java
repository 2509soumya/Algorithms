package practice;

import java.util.*;

public class MakingLargeIsland {

    int[][] grid;

    public int largestIsland(int[][] grid) {
        this.grid=grid;

        boolean visited[][]=new boolean[grid.length][grid.length];
        int[][] indexarr=new int[grid.length][grid.length];
        int idx=1;
        Map<Integer,Integer> indextoarea=new HashMap<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int area=dfs(i,j,visited,idx,indexarr);
                    indextoarea.put(idx,area);
                    idx++;
                }
            }
        }

        int finalmaxarea=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    int totarea=1;
                    int[][] dir={{0,-1},{0,1},{1,0},{-1,0}};
                    Set<Integer> idxes=new HashSet<>();
                    for(int k=0;k<dir.length;k++){
                        int newi=i+dir[k][0];
                        int newj=j+dir[k][1];
                        if(newi<0||newj<0||newi>=visited.length||newj>=visited.length){
                            continue;
                        }else{
                            if(indexarr[newi][newj]>0){
                                idxes.add(indexarr[newi][newj]);
                            }
                        }
                    }
                    for(Integer index : idxes){
                        totarea+=indextoarea.get(index);
                    }
                    finalmaxarea=Math.max(totarea,finalmaxarea);
                }
            }
        }

        return finalmaxarea;
    }

    public int dfs(int i,int j,boolean[][] visited,int index,int[][] indexarr){
        if(i<0||j<0||i>=visited.length||j>=visited.length||visited[i][j]||grid[i][j]==0){
            return 0;
        }

        visited[i][j]=true;
        indexarr[i][j]=index;

        int totislandlen=1;
        int[][] dir={{0,-1},{0,1},{1,0},{-1,0}};
        for(int k=0;k<dir.length;k++){
            totislandlen+=dfs(i+dir[k][0],j+dir[k][1],visited,index,indexarr);
        }
        return totislandlen;
    }

    public static void main(String[] args) {
        MakingLargeIsland makingLargeIsland=new MakingLargeIsland();
        int ans=makingLargeIsland.largestIsland(new int[][]{{1,0},{0,1}});
        System.out.println("Answer is "+ans);
    }
}
