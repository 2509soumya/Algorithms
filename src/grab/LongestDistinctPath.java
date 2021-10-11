package grab;

import java.util.HashSet;
import java.util.Set;

public class LongestDistinctPath {

    static class Tree{
         int x;
         Tree l;
         Tree r;
         Tree(int x,Tree l,Tree r){
             this.x=x;
             this.l=l;
             this.r=r;
         }
    }

    Set<Integer> path =new HashSet<>();

    public int solution(Tree T) {
        return longestdistinctpath(T);
    }

    public int longestdistinctpath(Tree tree){
        if(tree==null){
            return 0;
        }

        if(!path.contains(tree.x)){
            path.add(tree.x);
            int l=longestdistinctpath(tree.l);
            int r=longestdistinctpath(tree.r);
            path.remove(tree.x);
            int maxpath=Math.max(l,r);
            return maxpath==Integer.MIN_VALUE?0:maxpath+1;
        }else{
            return Integer.MIN_VALUE;
        }
    }


    public static void main(String[] args) {
        LongestDistinctPath longestDistinctPath=new LongestDistinctPath();
        int ans=longestDistinctPath.solution(null);
        System.out.println("Answer is "+ans);
    }
}
