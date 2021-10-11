package practice;

import java.util.*;

public class BiPartite {

    public boolean isBiPartite(int source, Map<Integer, List<Integer>> adjacencynode,int size){
        int[] visited=new int[size];
        Arrays.fill(visited,-1);

        Queue<int[]> nodelevelq=new LinkedList<>();
        nodelevelq.offer(new int[]{source,0});

        while(!nodelevelq.isEmpty()){
           int[] nextnode=nodelevelq.poll();
           int nodeid=nextnode[0];
           int nodel=nextnode[1];
           if(visited[nodeid]!=-1){
               if(visited[nodeid]!=nodel){
                   return false;
               }
           }else{
               int nnodel=(nodel+1)%2;
              for(int nodenxt : adjacencynode.get(nodeid)){
                  if(visited[nodeid]!=-1){
                      nodelevelq.offer(new int[]{nodenxt,nnodel});
                  }
              }
           }
        }

        return true;
    }
}
