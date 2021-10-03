package dfs;

import java.util.*;

//Topological sorting
public class CourseScheduleII {

    int[] visited;
    Stack<Integer> topostack;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjacencylist=new HashMap<>();
        visited=new int[numCourses];
        topostack=new Stack<>();

        for(int i=0;i<prerequisites.length;i++){
            adjacencylist.putIfAbsent(prerequisites[i][1],new ArrayList<>());
            adjacencylist.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] res=new int[numCourses];

        if(iscyclic(numCourses,adjacencylist)){
            return res;
        }

        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                dfs(i,adjacencylist);
            }
        }

        int idx=0;
        while(!topostack.isEmpty()){
            res[idx]=topostack.pop();
            idx++;
        }
        return res;
    }

    public void dfs(int node, Map<Integer, List<Integer>> dfs){
        visited[node]=1;
        if(dfs.containsKey(node)){
            for(Integer child : dfs.get(node)){
                if(visited[child]==0){
                    dfs(child,dfs);
                }
            }
        }
        topostack.push(node);
    }


    public boolean iscyclic(int numCourses,Map<Integer, List<Integer>> adjacencylist){
        int[] visited=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(iscyclichelper(i,adjacencylist,visited)){
                return true;
            }
        }
        return false;
    }

    public boolean iscyclichelper(int node,Map<Integer, List<Integer>> adjacencylist,int[] visited){
        if(visited[node]==1){
            return true;
        }
        visited[node]=1;
        if(adjacencylist.containsKey(node)){
            return false;
        }else{
            for(int child : adjacencylist.get(node)){
                 if(iscyclichelper(child,adjacencylist,visited)){
                     return true;
                 }
            }
        }
        visited[node]=0;
        return false;
    }

    public static void main(String[] args) {
        CourseScheduleII courseScheduleII=new CourseScheduleII();
        courseScheduleII.findOrder(2,new int[][]{{1,0}});
    }
}
