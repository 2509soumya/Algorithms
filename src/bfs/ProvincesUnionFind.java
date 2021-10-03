package bfs;

import java.util.Arrays;

public class ProvincesUnionFind {

    int[] parent;
    public int findCircleNum(int[][] isConnected) {
        parent=new int[isConnected.length];
        Arrays.fill(parent,-1);

        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(i!=j && isConnected[i][j]==1){
                    union(i,j);
                }
            }
        }

        int minusonecount=0;
        for(int i=0;i<parent.length;i++){
            if(parent[i]==-1){
                minusonecount++;
            }
        }

        return minusonecount;
    }

    public int find(int idx){
        while(parent[idx]!=-1){
            idx=parent[idx];
        }
        return idx;
    }

    public void union(int sourceidx,int destidx){
        int parent_s=find(sourceidx);
        int parent_d=find(destidx);
        if(parent_s!=parent_d){
            parent[parent_d]=parent_s;
        }
    }
}
