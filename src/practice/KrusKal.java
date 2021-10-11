package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KrusKal {

   static class Edge implements  Comparable<Edge>{
        int start;
        int dest;
        int weight;
        Edge(int start,int dest,int weight){
            this.start=start;
            this.dest=dest;
            this.weight=weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight-o.weight;
        }
    }

    int[] parentarr;
    int[] rank;

    public int KruskalMst(List<List<Edge>> edges){
     List<Edge> sortededgelist=new ArrayList<>();

      for(List<Edge> edgelist : edges){
          sortededgelist.addAll(edgelist);
      }
      Collections.sort(sortededgelist);
      this.parentarr=new int[edges.size()];
      this.rank=new int[edges.size()];

      int cost=0;
      for(int i=0;i<sortededgelist.size();i++){
          Edge e=sortededgelist.get(i);
          boolean un=union(e.start,e.dest);
          if(un){
              cost+=e.weight;
          }
      }
      return cost;
    }

    public boolean union(int x,int y){
      int px=find(x);
      int py=find(y);
      if(px==py){
          return false;
      }else if(rank[px]>rank[py]){
          parentarr[py]=px;
          return true;
      }else if(rank[py]>rank[px]){
          parentarr[px]=py;
          return true;
      }else{
          rank[px]=rank[px]+1;
          parentarr[py]=px;
          return true;
      }
    }

    public int find(int node){
     if(parentarr[node]==-1){
         return node;
     }
     int absp=find(parentarr[node]);
     parentarr[node]=absp;
     return absp;
    }
}
