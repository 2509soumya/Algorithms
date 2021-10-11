package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


//Used to find stronly connected components in directed graphs
/*
* 1-dfs traversal of graph and put the elements in a stack (topological sort)
* 2-reverse edges of graph to stop flow from SCC1 - SCC2(Strongly connected component 1 to 2
* 3-Now pop elements from stack and again do a dfs and count SCC for the graph
* */
public class KosarajuAlgorithm {

    public int findStronglyConnected(List<List<Integer>> adjacencylist){

        boolean[] visited=new boolean[adjacencylist.size()];
        Stack<Integer> dfsstack=new Stack<>();
        for(int i=0;i<adjacencylist.size();i++){
            if(!visited[i]){
                dfs(i,adjacencylist,visited,dfsstack);
            }
        }

        //transpose graph
        List<List<Integer>> transposedadjacencylist=new ArrayList<>();
        for(int i=0;i<adjacencylist.size();i++){
            transposedadjacencylist.add(i,new ArrayList<>());
        }
        for(int i=0;i<adjacencylist.size();i++){
            for(Integer endnode: adjacencylist.get(i)){
                transposedadjacencylist.get(endnode).add(i);
            }
        }

        int connectcompcount=0;
        boolean[] newvisited=new boolean[adjacencylist.size()];
        while(!dfsstack.isEmpty()){
            int node=dfsstack.pop();
            if(!newvisited[node]){
                connectcompcount++;
                dfsNoStack(node,transposedadjacencylist,newvisited);
            }
        }

       return connectcompcount;
    }

    public void dfs(int node,List<List<Integer>> adjacencylist,boolean[] visited,Stack<Integer> dfsstack){

        visited[node]=true;
        for(Integer connectednode: adjacencylist.get(node)){
            if(!visited[connectednode]){
                dfs(connectednode,adjacencylist,visited,dfsstack);
            }
        }
        dfsstack.push(node);
    }
    public void dfsNoStack(int node,List<List<Integer>> adjacencylist,boolean[] visited){

        visited[node]=true;
        for(Integer connectednode: adjacencylist.get(node)){
            if(!visited[connectednode]){
                dfsNoStack(connectednode,adjacencylist,visited);
            }
        }
    }
}
