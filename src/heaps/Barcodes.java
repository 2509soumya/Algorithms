package heaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Barcodes {

    public int[] rearrangeBarcodes(int[] barcodes) {

        Map<Integer,Integer> numfreqmap=new HashMap<>();
        for(int i=0;i<barcodes.length;i++){
            if(numfreqmap.containsKey(barcodes[i])){
                numfreqmap.put(barcodes[i],numfreqmap.get(barcodes[i])+1);
            }else{
                numfreqmap.put(barcodes[i],1);
            }
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->b[1]-a[1]);
        for(Map.Entry<Integer,Integer> entry : numfreqmap.entrySet()){
            int num=entry.getKey();
            int freq=entry.getValue();
            int[] elem={num,freq};
            pq.offer(elem);
        }


        int[] res=new int[barcodes.length];

        int idx=0;
        while(!pq.isEmpty()){
            int[] a=pq.poll();
            res[idx++]=a[0];
            if(pq.isEmpty()){
                break;
            }
            int[] b=pq.poll();
            res[idx++]=b[0];
            update(a,pq);
            update(b,pq);
        }

        return res;
    }

    public void update(int[] elem,PriorityQueue<int[]> pq){
        if(elem[1]>1){
            pq.offer(new int[]{elem[0],elem[1]-1});
        }
    }

    public static void main(String[] args) {
        Barcodes barcodes=new Barcodes();
        int[] res=barcodes.rearrangeBarcodes(new int[]{7,7,7,8,5,7,5,5,5,8});
        System.out.println(res);
    }
}
