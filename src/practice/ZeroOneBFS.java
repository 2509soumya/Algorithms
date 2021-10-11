package practice;

import java.util.*;

public class ZeroOneBFS {

    class Edge{
        int dest;
        int weight;
        Edge(int dest,int weight){
            this.dest=dest;
            this.weight=weight;
        }
    }

    public int solve(List<List<Integer>> adjacencylist,int start,int end){
        Map<Integer,List<Edge>> weightedgraph=new HashMap<>();

        for(int i=0;i<adjacencylist.size();i++){
            weightedgraph.putIfAbsent(i,new ArrayList<>());
            for(Integer dest : adjacencylist.get(i)){
                weightedgraph.putIfAbsent(dest,new ArrayList<>());
                weightedgraph.get(i).add(new Edge(dest,0));
                weightedgraph.get(dest).add(new Edge(i,1));
             }
        }

        Deque<Edge> arrdq=new ArrayDeque<>();
        boolean[] visited=new boolean[weightedgraph.size()];
        arrdq.offer(new Edge(start,0));
        while(!arrdq.isEmpty()){
            Edge ex=arrdq.poll();
            visited[ex.dest]=true;
            if(ex.dest==end){
                return ex.weight;
            }

            for(Edge neigbr: weightedgraph.get(ex.dest)){
                if(!visited[neigbr.dest]){
                    if(neigbr.weight==0){
                        arrdq.push(new Edge(neigbr.dest,ex.weight));
                    }else{
                        arrdq.offer(new Edge(neigbr.dest,ex.weight+1));
                    }
                }
            }
        }
        return -1;
    }
}
