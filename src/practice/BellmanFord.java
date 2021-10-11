package practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BellmanFord {
    class Edge{
        int start;
        int dest;
        int weight;
        Edge(int start,int dest,int weight){
            this.start=start;
            this.dest=dest;
            this.weight=weight;
        }
    }

    public int[] singleSourceShortestPath(int nodesize,List<Edge> edgelist,int source){
        int[] shortestPath=new int[nodesize];
        Arrays.fill(shortestPath,Integer.MAX_VALUE);
        shortestPath[source]=0;

        for(int i=0;i<nodesize;i++){
            for(int j=0;j<edgelist.size();j++){
                Edge e=edgelist.get(j);
                if(shortestPath[e.start]==Integer.MAX_VALUE){
                    continue;
                }
                shortestPath[e.dest]=Math.min(shortestPath[e.dest],shortestPath[e.start]+e.weight);
            }
        }
        return shortestPath;
    }
}
