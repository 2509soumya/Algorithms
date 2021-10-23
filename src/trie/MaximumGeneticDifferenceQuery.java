package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumGeneticDifferenceQuery {

    class TrieNode{
        TrieNode[] children;
        int count;
        int endval;
        TrieNode(TrieNode[] children,int count,int endval){
            this.children=children;
            this.count=count;
            this.endval=endval;
        }
        TrieNode(){
            this.children=new TrieNode[2];
        }
    }

    TrieNode root;
    Map<Integer, List<Integer>> adjacencylist;
    Map<Integer,List<Integer>> nodetoqueryidx;
    int[][] queries;
    int[] result;

    public int[] maxGeneticDifference(int[] parents, int[][] queries) {
        this.root=new TrieNode();
        this.result=new int[queries.length];
        this.queries=queries;

        adjacencylist=new HashMap<>();
        for(int i=0;i<parents.length;i++){
            adjacencylist.putIfAbsent(parents[i],new ArrayList<>());
            adjacencylist.get(parents[i]).add(i);
        }

        nodetoqueryidx=new HashMap<>();
        for(int i=0;i< queries.length;i++){
            nodetoqueryidx.putIfAbsent(queries[i][0],new ArrayList<>());
            nodetoqueryidx.get(queries[i][0]).add(i);
        }
        dfs(-1,new boolean[parents.length]);
        return result;
    }

    public void dfs(int node,boolean[] visited){
        //answer queries first
        if(node!=-1){
            insert(node);
        }
        if(nodetoqueryidx.containsKey(node)){
            insert(node);
            for(Integer queryidx : nodetoqueryidx.get(node)){
                int ans=query(queries[queryidx][1]);
                result[queryidx]=ans;
            }
        }

        if(adjacencylist.containsKey(node)){
            for(Integer child: adjacencylist.get(node)){
                dfs(child,visited);
            }
        }

        if(node!=-1)
        backtrack(node);
    }

    public void insert(int num){
        TrieNode curr=root;
        for(int i=17;i>=0;i--){
            int l=(1<<i) & num;
            int idx=l==0?0:1;
            if(curr.children[idx]==null){
                curr.children[idx]=new TrieNode();
            }
            curr=curr.children[idx];
            curr.count=curr.count+1;
        }
        curr.endval=num;
    }

    public int query(int val){
        TrieNode curr=root;
        for(int i=17;i>=0;i--){
            int l=(1<<i) & val;
            int idx=l==0?1:0;
            int comp=l==0?0:1;
            if(curr.children[idx]!=null && curr.children[idx].count>0){
                curr=curr.children[idx];
            }else if(curr.children[comp]!=null && curr.children[comp].count>0){
                curr=curr.children[comp];
            }else{
                return 0;
            }
        }
        return curr.endval^val;
    }

    public void backtrack(int num){
        TrieNode curr=root;
        for(int i=17;i>=0;i--){
            int l=(1<<i) & num;
            int idx=l==0?0:1;
            curr=curr.children[idx];
            curr.count=curr.count-1;
        }
    }


    public static void main(String[] args) {
        MaximumGeneticDifferenceQuery maximumGeneticDifferenceQuery=new MaximumGeneticDifferenceQuery();
        int[] ans=maximumGeneticDifferenceQuery.maxGeneticDifference(new int[]{-1,0,1,1},new int[][]{{0,2},{3,2},{2,5}});
        System.out.println("Answer is ");
        System.out.println(ans[0]+"-"+ans[1]+"-"+ans[2]);
    }
}
