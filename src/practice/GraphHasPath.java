package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphHasPath {

    public boolean hasPath(int src, int dest, Map<Integer, List<Integer>> adjacencymap,List<Integer> visitedarr){

          if(src==dest){
              return true;
          }
          if(!adjacencymap.containsKey(src) || visitedarr.contains(src)){
              return false;
          }

          visitedarr.add(src);
          for(Integer node: adjacencymap.get(src)){
              boolean haspath=hasPath(node,dest,adjacencymap,visitedarr);
              if(haspath){
                  return true;
              }
          }
        return false;
    }

    public static void main(String[] args) {
        GraphHasPath graphHasPath=new GraphHasPath();
        graphHasPath.hasPath(0,6,new HashMap<>(),new ArrayList<>());
    }
}
