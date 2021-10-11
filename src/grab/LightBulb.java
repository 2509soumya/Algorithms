package grab;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LightBulb {

    public int solution(int[] A) {
        int[] mintoright=new int[A.length];
        int minsofar=Integer.MAX_VALUE;
        for(int i=A.length-1;i>0;i--){
            minsofar=Math.min(minsofar,A[i]);
            mintoright[i]=minsofar;
        }

        int max_so_far=Integer.MIN_VALUE;
        int moment=0;
        for(int j=0;j<A.length;j++){
            max_so_far=Math.max(max_so_far,A[j]);
            if(j==A.length-1 || max_so_far<mintoright[j+1]){
                moment++;
            }
        }
        return moment;
    }

    public static void main(String[] args) {
        LightBulb lightBulb=new LightBulb();
        int soln=lightBulb.solution(new int[]{6,5,4,3,2});
        System.out.println("Solution is "+soln);
    }
}
