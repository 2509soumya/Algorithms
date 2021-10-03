package dp;

import java.util.*;

public class TopologicalSort {

    public int[] findTopologicalSortedOrder(int[][] adjacencylist){
        boolean[] visited=new boolean[adjacencylist.length];
        Stack<Integer> nodeorder=new Stack<>();
        for(int i=0;i<adjacencylist.length;i++){
             if(!visited[i]){
                 boolean isnoncyclic=dfs(adjacencylist,i,visited,nodeorder,"");
                 if(!isnoncyclic){
                     return new int[]{};
                 }
             }
        }
        int[] toposorted=new int[nodeorder.size()];
        for(int i=toposorted.length-1;i>=0;i--){
            toposorted[i]=nodeorder.pop();
        }
        return toposorted;
    }

    public boolean dfs(int[][] adjacencylist , int fromNode,boolean[] visited,Stack<Integer> nodeorder,String path){

        if(visited[fromNode]){
            return path.contains("-"+fromNode+"-")?false:true;
        }

        if(adjacencylist[fromNode]==null){
            nodeorder.push(fromNode);
            visited[fromNode]=true;
            return true;
        }else{
            visited[fromNode]=true;
            boolean noncyclic=true;
            path+="-"+fromNode+"-";
            for(int i=0;i<adjacencylist[fromNode].length;i++){
                noncyclic=noncyclic && dfs(adjacencylist,adjacencylist[fromNode][i],visited,nodeorder,path);
            }
            nodeorder.push(fromNode);
            return noncyclic;
        }
    }


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> coursemap=new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            coursemap.putIfAbsent(prerequisites[i][0],new ArrayList<>());
            coursemap.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[][] adjacencylist=new int[numCourses][];
        for(int i=0;i<adjacencylist.length;i++){
            if(coursemap.containsKey(i)){
                int[] newarr=new int[coursemap.get(i).size()];
                int j=0;
                for(Integer dependentcourse : coursemap.get(i)){
                    newarr[j]=dependentcourse;
                    j++;
                }
                adjacencylist[i]=newarr;
            }
        }
        int[] result=findTopologicalSortedOrder(adjacencylist);

        for(int j=0;j<result.length;j++){
            System.out.println(result[j]);
        }
        return result;
    }

    public static void main(String[] args) {
        TopologicalSort topologicalSort=new TopologicalSort();
        topologicalSort.findOrder(2,new int[][]{{0,1},{1,0}});
    }
}
