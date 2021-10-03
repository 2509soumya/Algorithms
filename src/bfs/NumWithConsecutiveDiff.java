package bfs;

import java.util.*;

public class NumWithConsecutiveDiff {

    public int[] numsSameConsecDiff(int n, int k) {
        Queue<String> bfsq=new LinkedList<>();
        for(int i=1;i<=9;i++){
            bfsq.offer(i+"");
        }

        Set<String> ans=new HashSet<>();

        while(!bfsq.isEmpty()){
            String num=bfsq.poll();
            if(num.length()<n){
                int lastdigit=num.charAt(num.length()-1)-'0';
                int forward=lastdigit+k;
                int backward=lastdigit-k;
                if(forward<=9){
                    bfsq.offer(num+""+forward);
                }
                if(backward>=0){
                    bfsq.offer(num+""+backward);
                }
            }else{
                ans.add(num);
            }
        }

        int[] ansewew=new int[ans.size()];
        int idx=0;
        for(String num : ans){
            ansewew[idx++]=Integer.parseInt(num);
        }
        return ansewew;
    }

    public static void main(String[] args) {
        NumWithConsecutiveDiff numWithConsecutiveDiff=new NumWithConsecutiveDiff();
        int[] ans=numWithConsecutiveDiff.numsSameConsecDiff(3,7);
        System.out.println("Checkpoint");
    }
}
