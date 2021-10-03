package dfs;

public class FloodFill {

    int[][] image;
    int[][] visited;


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.image=image;
        this.visited=new int[image.length][image[0].length];
        floodFill(sr,sc,newColor,image[sr][sc]);
        return this.image;
    }

    public void floodFill(int sr, int sc, int newColor,int startcolor) {
        if(sr<0 || sr >=image.length || sc<0 || sc>=image[0].length){
            return;
        }

        if(image[sr][sc]==startcolor && visited[sr][sc]==0){
            image[sr][sc]=newColor;
            visited[sr][sc]=1;
            floodFill(sr+1,sc,newColor,startcolor);
            floodFill(sr-1,sc,newColor,startcolor);
            floodFill(sr,sc+1,newColor,startcolor);
            floodFill(sr,sc-1,newColor,startcolor);
        }
    }

    public static void main(String[] args) {
        FloodFill floodFill=new FloodFill();
        floodFill.floodFill(new int[][]{{0,0,0},{0,1,1}},1,1,1);
        System.out.println("Done");
    }
}
