package practice;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class TopologicalSort {

    Stack<Integer> stack=new Stack<>();

    public int[] topoTraverse(Map<Integer,List<Integer>> adjacencymap,int size){
        boolean[] visited=new boolean[size];

        for(int nodeid=0;nodeid<size;nodeid++){
            if(!visited[nodeid]){
                dfs(nodeid,adjacencymap,visited);
            }
        }

        int[] ans=new int[size];
        int counter=size-1;
        while(!stack.isEmpty()){
           ans[counter]=stack.pop();
           counter--;
        }
        return ans;
    }

    public void dfs(int sourcenode, Map<Integer,List<Integer>> adjacencymap, boolean visited[]){
        visited[sourcenode]=true;
        for(Integer nxt : adjacencymap.get(sourcenode)){
            if(!visited[nxt]){
                dfs(nxt,adjacencymap,visited);
            }
        }
        stack.push(sourcenode);
    }
}
