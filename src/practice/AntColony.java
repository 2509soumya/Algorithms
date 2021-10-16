package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AntColony {

    Map<Integer, List<Integer>> treemap;

    class Result{
        int count;
        int ways;
        Result(int count,int ways){
            this.count=count;
            this.ways=ways;
        }
    }

    public int waysToBuildRooms(int[] prevRoom) {
        treemap=new HashMap<>();
        for(int i=1;i<prevRoom.length;i++){
            treemap.putIfAbsent(prevRoom[i],new ArrayList<>());
            treemap.get(prevRoom[i]).add(i);
        }
        intcombination(prevRoom.length);
        return countTotalWays(0).ways;
    }

    public Result countTotalWays(int node){
        if(!treemap.containsKey(node)){
            return new Result(1,1);
        }
        int totalcountchildren=0;
        int singlepathcount=0;
        int res=1;
        for(Integer child : treemap.get(node)){
            Result val=countTotalWays(child);
            res*=val.ways;
            singlepathcount=val.count;
            totalcountchildren+=val.count;
        }
        return new Result(totalcountchildren+1,combinationval(totalcountchildren,singlepathcount)*res);
    }


    int[][] dp;
    public int combinationval(int prefix,int suffix){
        System.out.println(prefix+"C"+suffix);
        return dp[prefix][suffix];
    }

    public void intcombination(int n){
       dp=new int[n+1][n+1];

        for(int i=0;i<=n;i++){
          for(int j=0;j<=i;j++){
              if(j==0){
                  dp[i][j]=1;
              }else{
                  dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
              }
          }
        }
        System.out.println("done");
    }

    public static void main(String[] args) {
        AntColony antColony=new AntColony();
        int ans=antColony.waysToBuildRooms(new int[]{-1,0,0,1,2});
        System.out.println("Answer is "+ans);
    }
}
