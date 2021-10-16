package gs;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class NumberChecker {
    static String findQualifiedNumbers(int[] numberArray) {

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<numberArray.length;i++){
            int num=numberArray[i];
            String numstr=String.valueOf(num);
            if(numstr.contains("1") && numstr.contains("2") && numstr.contains("3")){
                pq.offer(num);
            }
        }
        LinkedList<String> ans=new LinkedList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll()+"");
        }

        return String.join(",", ans);
    }

    public static void main(String[] args) {
        System.out.println(findQualifiedNumbers(new int[]{2,123,1231,}));
    }
}
