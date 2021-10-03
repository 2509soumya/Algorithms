package dfs;

import java.util.ArrayList;
import java.util.List;

public class PathWithMinEffort {

    class Coordinate{
        int x;
        int y;
        Coordinate(int x,int y){
            this.x=x;
            this.y=y;
        }
        @Override
        public boolean equals(Object comparewith){
            Coordinate comparewithnew=(Coordinate)comparewith;
            if(this.x==comparewithnew.x && this.y==comparewithnew.y){
                return true;
            }else{
                return false;
            }
        }
    }

    int mineffort=Integer.MAX_VALUE;

    public int minimumEffortPath(int[][] heights) {
        dfs(heights,0,0,new ArrayList<>(),-1,0,0);
        return mineffort;
    }

    public void dfs(int[][] heights, int i, int j, List<Coordinate> visited, int maxsofar, int parentx, int parenty){

        if(i<0||i>=heights.length||j<0||j>=heights[0].length||visited.contains(new Coordinate(i,j))){
            return;
        }

        visited.add(new Coordinate(i,j));
        int valhere=Math.max(maxsofar,Math.abs(heights[parentx][parenty]-heights[i][j]));

        if(i==heights.length-1 && j==heights[0].length-1){
            mineffort=Math.min(mineffort,valhere);
            return;
        }

        dfs(heights,i+1,j,visited,valhere,i,j);
        dfs(heights,i-1,j,visited,valhere,i,j);
        dfs(heights,i,j+1,visited,valhere,i,j);
        dfs(heights,i,j-1,visited,valhere,i,j);
    }
}
