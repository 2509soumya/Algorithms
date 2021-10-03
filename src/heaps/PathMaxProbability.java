package heaps;

import java.util.*;

public class PathMaxProbability {

    class Edge implements Comparable<Edge>{
        int end;
        double prob;
        List<Integer> visited_paths;
        Edge(int end,double prob){
            this.end=end;
            this.prob=prob;
            this.visited_paths=new ArrayList<>();
        }

        Edge(int end,double prob,List<Integer> visited_paths){
            this.end=end;
            this.prob=prob;
            this.visited_paths=visited_paths;
        }

        @Override
        public int compareTo(Edge comparewith){
            return Double.compare(comparewith.prob, this.prob);
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        Map<Integer, List<Edge>> node_adjacencymap=new HashMap<>();
        PriorityQueue<Edge> pq=new PriorityQueue<>();

        for(int i=0;i<edges.length;i++){
            int[] edge=edges[i];
            Edge edgeobj=new Edge(edge[1],succProb[i]);
            if(node_adjacencymap.containsKey(edge[0])){
                node_adjacencymap.get(edge[0]).add(edgeobj);
            }else{
                List<Edge> edgelist=new ArrayList<>();
                edgelist.add(edgeobj);
                node_adjacencymap.put(edge[0],edgelist);
            }
            if(edge[0]==start){
                edgeobj.visited_paths.add(start);
                pq.offer(edgeobj);
            }
            //////
            Edge edgeobj1=new Edge(edge[0],succProb[i]);
            if(node_adjacencymap.containsKey(edge[1])){
                node_adjacencymap.get(edge[1]).add(edgeobj1);
            }else{
                List<Edge> edgelist=new ArrayList<>();
                edgelist.add(edgeobj1);
                node_adjacencymap.put(edge[1],edgelist);
            }
            if(edge[1]==start){
                edgeobj1.visited_paths.add(start);
                pq.offer(edgeobj1);
            }

        }

        Set<Integer> traversednodes=new HashSet<>();
        traversednodes.add(start);
        double[] max=new double[n+1];
        Arrays.fill(max,-1);

        while(!pq.isEmpty()){
           Edge q_path=pq.poll();
            if(!traversednodes.contains(q_path.end)){
                traversednodes.add(q_path.end);
                max[q_path.end]=max[q_path.end]==-1?q_path.prob:Math.max(max[q_path.end],q_path.prob);
                if(node_adjacencymap.containsKey(q_path.end)){
                    List<Edge> nodesfromhere=node_adjacencymap.get(q_path.end);
                    for(Edge edge: nodesfromhere){
                        if(!q_path.visited_paths.contains(edge.end)){
                            List<Integer> newpath=new ArrayList<>(q_path.visited_paths);
                            newpath.add(edge.end);
                            pq.offer(new Edge(edge.end,q_path.prob*edge.prob,newpath));
                        }
                    }
                }
            }
        }
       return max[end];
    }

    public static void main(String[] args) {
        PathMaxProbability pathMaxProbability=new PathMaxProbability();
        double res=pathMaxProbability.maxProbability(3,new int[][]{{0,1},{1,2},{0,2}},new double[]{0.5,0.5,0.2},0,2);
        System.out.println("Result is "+res);
    }
}
