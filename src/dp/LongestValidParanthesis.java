package dp;

import java.util.Stack;

public class LongestValidParanthesis {


    public int longestValidParentheses(String s) {
        int[] dp=new int[s.length()];
        Stack<Integer> open_count=new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(open_count.size()>0){
                    int idx=open_count.pop();
                    if(idx==0){
                        dp[i]=i-idx+1;
                    }else{
                        dp[i]=dp[idx-1]+(i-idx+1);
                    }
                }
            }else{
                open_count.push(i);
            }
        }

        int finalans=0;
        for(int j=0;j<s.length();j++){
            finalans=Math.max(finalans,dp[j]);
        }
        return finalans;
    }
}
