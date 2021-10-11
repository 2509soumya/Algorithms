package practice;

import java.util.List;
import java.util.Map;

public class ConnectedComponents {


    public int getConnectedComponents(Map<Integer, List<Integer>> adjacencymap,int size){
        int connectedcomponent=0;
        boolean[] visited=new boolean[size];
        for(int i=0;i<size;i++){
           if(!visited[i]){
               connectedcomponent++;
               dfs(i,adjacencymap,visited);
           }
        }
       return connectedcomponent;
    }

    public void dfs(int node,Map<Integer, List<Integer>> adjacencymap,boolean[] visited){
       if(visited[node] || !adjacencymap.containsKey(node)){
           return;
       }
       visited[node]=true;
       for(Integer nextnode :adjacencymap.get(node)){
           dfs(nextnode,adjacencymap,visited);
       }
    }
}
