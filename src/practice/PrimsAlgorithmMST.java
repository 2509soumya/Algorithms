package practice;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class PrimsAlgorithmMST {
    class Edge{
        int dest;
        int start;
        int weight;
        Edge(int start,int dest,int weight){
            this.start=start;
            this.dest=dest;
            this.weight=weight;
        }
    }

    public int[] mst(Map<Integer, List<Edge>> adjacencymap,int size){
        int start=0;
        boolean[] visited=new boolean[size];
        int[] parent=new int[size];
        parent[0]=-1;
        PriorityQueue<Edge> pq=new PriorityQueue<>(Comparator.comparingInt(e->e.weight));

        while(pq.size()>0){
            Edge e=pq.poll();
            if(visited[e.dest]){
                continue;
            }
            parent[e.dest]=e.start;
            visited[e.dest]=true;
            for(Edge edge : adjacencymap.get(e.dest)){
                if(!visited[edge.dest]){
                    pq.offer(edge);
                }
            }
        }
        return parent;
    }

}
