package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {

    class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }


    public int shortestBridge(int[][] grid) {

        Queue<Pair> bfsq=new LinkedList<>();
        boolean[][] visited=new boolean[grid.length][grid[0].length];

        outerloop:
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,bfsq,visited);
                    break outerloop;
                }
            }
        }

        int level=0;
        //find the rest of 1's
        while(!bfsq.isEmpty()){
            System.out.println(level+"-"+bfsq.size());
            int qsize=bfsq.size();
            while(qsize>0){
                Pair qpair=bfsq.poll();
                int i=qpair.x;
                int j=qpair.y;

                if(checkValidCoord(i+1,j,visited,grid)){
                    visited[i+1][j]=true;
                    if(grid[i+1][j]==1){
                        return level;
                    }
                    bfsq.offer(new Pair(i+1,j));
                }

                if(checkValidCoord(i-1,j,visited,grid)){
                    visited[i-1][j]=true;
                    if(grid[i-1][j]==1){
                        return level;
                    }
                    bfsq.offer(new Pair(i-1,j));
                }

                if(checkValidCoord(i,j+1,visited,grid)){
                    visited[i][j+1]=true;
                    if(grid[i][j+1]==1){
                        return level;
                    }
                    bfsq.offer(new Pair(i,j+1));
                }

                if(checkValidCoord(i,j-1,visited,grid)){
                    visited[i][j-1]=true;
                    if(grid[i][j-1]==1){
                        return level;
                    }
                    bfsq.offer(new Pair(i,j-1));
                }

                qsize--;
            }
            level++;
        }

        return 0;
    }


    public boolean checkValidCoord(int i,int j,boolean[][] visited,int[][] grid){
        if(i<0 ||j<0||i>=grid.length||j>=grid[0].length||visited[i][j]){
            return false;
        }else{
            return true;
        }
    }


    public void dfs(int[][] grid, int i, int j, Queue<Pair> bfsq, boolean[][] visited){
        if(i<0 ||j<0||i>=grid.length||j>=grid[0].length||visited[i][j]||grid[i][j]==0){
            return;
        }
        visited[i][j]=true;
        bfsq.offer(new Pair(i,j));
        dfs(grid,i,j+1,bfsq,visited);
        dfs(grid,i,j-1,bfsq,visited);
        dfs(grid,i-1,j,bfsq,visited);
        dfs(grid,i+1,j,bfsq,visited);
    }

    public static void main(String[] args) {
        ShortestBridge shortestBridge=new ShortestBridge();
        int res=shortestBridge.shortestBridge(new int[][]{{0,1,0},{0,0,0},{0,0,1}});
        System.out.println("result is "+res);
    }
}
