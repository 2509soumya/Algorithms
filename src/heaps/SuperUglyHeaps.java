package heaps;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SuperUglyHeaps {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res=new int[n+1];
        res[0]=1;
        PriorityQueue<int[]> uglynumqueue=new PriorityQueue<>((a, b)->a[2]-b[2]);
        for(int i=0;i<primes.length;i++){
            int[] pointerhere={i,0,primes[i]};
            uglynumqueue.offer(pointerhere);
        }

        int count=1;
        Set<Integer> traversed=new HashSet<>();
        while(count<n){
            int[] ug_num=uglynumqueue.poll();
            if(!traversed.contains(ug_num[2])){
                res[count]=ug_num[2];
                traversed.add(ug_num[2]);
                int[] newelem={ug_num[0],ug_num[1]+1,(primes[ug_num[0]]*(res[ug_num[1]+1]))};
                uglynumqueue.offer(newelem);
                count++;
            }else{
                int[] newelem={ug_num[0],ug_num[1]+1,(primes[ug_num[0]]*(res[ug_num[1]+1]))};
                uglynumqueue.offer(newelem);
            }
        }
        return res[count-1];
    }

    public static void main(String[] args) {
        SuperUglyHeaps superUglyHeaps=new SuperUglyHeaps();
        System.out.println(superUglyHeaps.nthSuperUglyNumber(15,new int[]{3,5,7,11,19,23,29,41,43,47}));
    }
}
