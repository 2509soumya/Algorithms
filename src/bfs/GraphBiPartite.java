package bfs;

import java.util.Arrays;
import java.util.stream.Collectors;

public class GraphBiPartite {

    public boolean isBipartite(int[][] graph) {

        int[] parition=new int[graph.length];
        Arrays.fill(parition,-1);

        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                //i -> source , j -> dest
                int source=i;
                int dest=graph[i][j];
                if(parition[source]==-1 && parition[dest]==-1){
                    parition[source]=1;
                    parition[dest]=2;
                }else if(parition[source]!=-1 && parition[dest]!=-1 && parition[source]==parition[dest]){
                    return false;
                }else if(parition[source]==-1 && parition[dest]!=-1){
                    parition[source]=(parition[dest]==1)?2:1;
                }else if(parition[dest]==-1 && parition[source]!=-1){
                    parition[dest]=(parition[source]==1)?2:1;
                }else{
                    continue;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        GraphBiPartite graphBiPartite=new GraphBiPartite();
        boolean res=graphBiPartite.isBipartite(new int[][]{{3},{2,4},{1},{0,4},{1,3}});
        System.out.println(res);
    }
}
