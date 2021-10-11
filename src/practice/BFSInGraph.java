package practice;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFSInGraph {

    public void traverseBFS(int source,Map<Integer, List<Integer>> adjacencynode,int size){
        Queue<Integer> bfsq=new LinkedList<>();
        boolean[] visited=new boolean[size];

        bfsq.offer(source);
        while(!bfsq.isEmpty()){

                int node=bfsq.poll();
                if(!visited[node] && adjacencynode.containsKey(node)){
                    visited[node]=true;
                  for(Integer nextnode : adjacencynode.get(node)){
                    if(!visited[nextnode]){
                        bfsq.offer(nextnode);
                    }
                  }
                }
        }
    }
}
