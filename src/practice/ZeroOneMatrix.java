package practice;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    int[][] mat;
    Queue<int[]> coordinateq;

    public int[][] nearestOneDistance(int[][] mat){
        this.coordinateq=new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    mat[i][j]=-1;
                }else{
                    coordinateq.offer(new int[]{i,j});
                }
            }
        }
        mat=this.mat;

        while(!coordinateq.isEmpty()){
            int[] coordinate=coordinateq.poll();
            checkAndUpdateMatrix(coordinate[0]+1,coordinate[1],mat[coordinate[0]][coordinate[1]]);
            checkAndUpdateMatrix(coordinate[0]-1,coordinate[1],mat[coordinate[0]][coordinate[1]]);
            checkAndUpdateMatrix(coordinate[0],coordinate[1]+1,mat[coordinate[0]][coordinate[1]]);
            checkAndUpdateMatrix(coordinate[0],coordinate[1]-1,mat[coordinate[0]][coordinate[1]]);
        }
        return mat;
    }

    public void checkAndUpdateMatrix(int i,int j,int baseval){
        if(i<0||i>=mat.length||j>0||j>=mat[0].length||mat[i][j]>=0){
            return;
        }else{
            mat[i][j]=baseval+1;
            coordinateq.offer(new int[]{i,j});
        }
    }
}
