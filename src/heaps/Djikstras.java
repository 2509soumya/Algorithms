package heaps;

import java.util.*;

public class  Djikstras {

    public static void main(String[] args) {
        Djikstras djikstras=new Djikstras();
        int[] shortestpatharr=djikstras.shortestPath(new int[][]{{1,2,1},{2,3,2},{1,3,1}},2,3);
        int max=-1;
        for(int i=1;i<shortestpatharr.length;i++){
            if(i!=2){
                if(shortestpatharr[i]==-1){
                    max=-1;
                    break;
                }
                max=Math.max(max,shortestpatharr[i]);
            }
        }
        System.out.println("MAX PATH: "+max);
    }

    class Edge implements Comparable<Edge>{
        int end;
        int weight;
        Edge(int end,int weight){
            this.end=end;
            this.weight=weight;
        }

        @Override
        public int compareTo(Edge comparewith){
          return this.weight-comparewith.weight;
        }
    }

    public int[] shortestPath(int[][] path,int fromNode,int nodes){
        Map<Integer, List<Edge>> node_adjacencymap=new HashMap<>();
        PriorityQueue<Edge> pq=new PriorityQueue<>();

        for(int i=0;i<path.length;i++){
            int[] edge=path[i];
            Edge edgeobj=new Edge(edge[1],edge[2]);
            if(node_adjacencymap.containsKey(edge[0])){
                node_adjacencymap.get(edge[0]).add(edgeobj);
            }else{
                List<Edge> edgelist=new ArrayList<>();
                edgelist.add(edgeobj);
                node_adjacencymap.put(edge[0],edgelist);
            }
            if(edge[0]==fromNode){
                pq.offer(edgeobj);
            }
        }

        Set<Integer> traversednodes=new HashSet<>();
        traversednodes.add(fromNode);
        int[] min=new int[nodes+1];
        Arrays.fill(min,-1);

        while(!pq.isEmpty()){
            Edge q_path=pq.poll();
            if(!traversednodes.contains(q_path.end)){
                traversednodes.add(q_path.end);
                min[q_path.end]=min[q_path.end]==-1?q_path.weight:Math.min(min[q_path.end],q_path.weight);
                if(node_adjacencymap.containsKey(q_path.end)){
                    List<Edge> nodesfromhere=node_adjacencymap.get(q_path.end);
                    for(Edge edge: nodesfromhere){
                        pq.offer(new Edge(edge.end,q_path.weight+edge.weight));
                    }
                }
            }
        }
       return min;
    }

}
