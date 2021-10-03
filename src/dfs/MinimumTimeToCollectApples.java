package dfs;

import java.util.*;

public class MinimumTimeToCollectApples {

    List<Integer> visited=new ArrayList<>();
    List<Boolean> hasApple;
    Map<Integer,List<Integer>> adjacency_map;
    int totsum=0;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        this.hasApple=hasApple;
        this.visited=new ArrayList<>();
        adjacency_map=new HashMap<>();
        for(int i=0;i<edges.length;i++){
            if(adjacency_map.containsKey(edges[i][0])){
                adjacency_map.get(edges[i][0]).add(edges[i][1]);
            }else{
                List<Integer> subordinates=new ArrayList<>();
                subordinates.add(edges[i][1]);
                adjacency_map.put(edges[i][0],subordinates);
            }

            if(adjacency_map.containsKey(edges[i][1])){
                adjacency_map.get(edges[i][1]).add(edges[i][0]);
            }else{
                List<Integer> subordinates=new ArrayList<>();
                subordinates.add(edges[i][0]);
                adjacency_map.put(edges[i][1],subordinates);
            }
        }
        getTheSum(0);
        return totsum;
    }


    public boolean getTheSum(int root){
        visited.add(root);
        List<Integer> childrenlist=adjacency_map.get(root);
        boolean hasapplehere=hasApple.get(root);
        for(Integer child : childrenlist){
            if(!visited.contains(child)){
                if(getTheSum(child)){
                    hasapplehere=true;
                    totsum+=2;
                }
            }
        }
        return hasapplehere;
    }

    public static void main(String[] args) {
        MinimumTimeToCollectApples minimumTimeToCollectApples=new MinimumTimeToCollectApples();
        int val=minimumTimeToCollectApples.minTime(7,new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}}, Arrays.asList(false,false,true,false,true,true,false));
        System.out.println("Answer is "+val);
    }
}
