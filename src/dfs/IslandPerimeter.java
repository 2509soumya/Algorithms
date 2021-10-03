package dfs;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int perimeter_so_far=0;
        int prev_breadth=-1;
        for(int i=0;i<grid.length;i++){
            int breadth=0;
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    breadth++;
                }
            }
            if(prev_breadth==-1){
                perimeter_so_far+=(2*breadth+2);
            }else{
                perimeter_so_far+=(2*breadth+2);
                perimeter_so_far-=2*Math.min(prev_breadth,breadth);
            }
            prev_breadth=breadth;
        }
        return perimeter_so_far;
    }

    public static void main(String[] args) {
        IslandPerimeter islandPerimeter=new IslandPerimeter();
        int totperimeter=islandPerimeter.islandPerimeter(new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}});
        System.out.println(totperimeter);
    }
}
