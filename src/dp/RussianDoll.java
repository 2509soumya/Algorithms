package dp;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDoll {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, Comparator.comparingInt((int[] a) -> a[0]));
        int[] dp=new int[envelopes.length];
        int tot=0;
        for(int i=0;i<envelopes.length;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(envelopes[j][0]<envelopes[i][0] && envelopes[j][1]<envelopes[i][1]){
                    max=Math.max(max,dp[j]);
                }
            }
            dp[i]=max+1;
            tot=Math.max(tot,dp[i]);
        }
        return tot;
    }
}
