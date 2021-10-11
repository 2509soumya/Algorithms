package practice;

import java.util.*;

public class Djikstras {

    class Edge{
        int dest;
        int weight;
        Edge(int dest,int weight){
            this.dest=dest;
            this.weight=weight;
        }
    }

    public int[] shortestpath(int startnode, Map<Integer, List<Edge>> adjacencymap,int size){

        PriorityQueue<Edge> pq=new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        boolean[] visited=new boolean[size];
        int[] shortestpath=new int[size];
        Arrays.fill(shortestpath,Integer.MAX_VALUE);

        visited[startnode]=true;
        for(Edge e : adjacencymap.get(startnode)){
            pq.offer(e);
        }

        while(pq.size()>0){
            Edge e=pq.poll();
            if(visited[e.dest]){
                shortestpath[e.dest]=Math.min(e.weight,shortestpath[e.dest]);
                continue;
            }
            visited[e.dest]=true;
            shortestpath[e.dest]=e.weight;
            for(Edge e1:adjacencymap.get(e.dest)){
              if(!visited[e1.dest]){
                  pq.offer(new Edge(e1.dest,e1.weight+e.weight));
              }
            }
        }

       return shortestpath;
    }
}
