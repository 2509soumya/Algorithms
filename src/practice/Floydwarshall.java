package practice;

import java.util.Arrays;
import java.util.List;

//all pair shortest path
//n-1 , number of relaxations for all the exisiting pairs in the graph checking path between a pair of nodes via any possible node
public class Floydwarshall {

    class Edge{
        int start;
        int end;
        int weight;
        Edge(int start,int end,int weight){
            this.start=start;
            this.end=end;
            this.weight=weight;
        }
    }
    public int[][] allpairshortestPath(List<Edge> edgelist,int nodesize){

        int[][] edgeweightmat=new int[nodesize][nodesize];
        for(int i=0;i<edgeweightmat.length;i++){
            Arrays.fill(edgeweightmat[i],Integer.MAX_VALUE);
            edgeweightmat[i][i]=0;
        }

        for(Edge edge : edgelist){
            int start=edge.start;
            int end=edge.end;
            edgeweightmat[start][end]=edge.weight;
        }

        //
        for(int node=0;node<nodesize;node++){
            for(int i=0;i<edgeweightmat.length;i++){
                for(int j=0;j<edgeweightmat[0].length;i++){
                    if(i==node || j==node){
                        continue;
                    }else{
                      if(edgeweightmat[i][node]!=Integer.MAX_VALUE && edgeweightmat[node][j]!=Integer.MAX_VALUE){
                          edgeweightmat[i][j]=Math.min(edgeweightmat[i][j],edgeweightmat[i][node]+edgeweightmat[node][j]);
                        }
                    }
                }
            }
        }

       return edgeweightmat;
    }
}
