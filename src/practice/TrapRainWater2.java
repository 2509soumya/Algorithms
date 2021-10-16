package practice;

import java.util.PriorityQueue;

public class TrapRainWater2 {

    class Pair implements Comparable<Pair>{
        int row;
        int col;
        int height;
        Pair(int row,int col,int height){
            this.row=row;
            this.col=col;
            this.height=height;
        }

        @Override
        public int compareTo(Pair o) {
            return this.height-o.height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        int m=heightMap.length;
        int n=heightMap[0].length;

        PriorityQueue<Pair> pq=new PriorityQueue<>();
        boolean[][] visited=new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0||i==m-1||j==n-1){
                  pq.offer(new Pair(i,j,heightMap[i][j]));
                  visited[i][j]=true;
                }
            }
        }


        int[][] dir=new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
        int tot_wat=0;
        while(!pq.isEmpty()){
            Pair rem=pq.poll();
            for(int dirnum=0;dirnum<dir.length;dirnum++){
                int new_i=rem.row+dir[dirnum][0];
                int new_j=rem.col+dir[dirnum][1];
                if(new_i<0||new_j<0||new_i>=m||new_j>=n||visited[new_i][new_j]){
                  continue;
                }else{
                    visited[new_i][new_j]=true;
                    tot_wat+=Math.max(0,rem.height-heightMap[new_i][new_j]);
                    pq.offer(new Pair(new_i,new_j,Math.max(rem.height,heightMap[new_i][new_j])));
                }
            }
        }

       return tot_wat;
    }

    public static void main(String[] args) {
        TrapRainWater2 trapRainWater2=new TrapRainWater2();
        int ans=trapRainWater2.trapRainWater(new int[][]{{3,3,3,3,3},{3,2,2,2,3},{3,2,1,2,3},{3,2,2,2,3},{3,3,3,3,3}});
        System.out.println("Total accumulated water "+ans);
    }
}
