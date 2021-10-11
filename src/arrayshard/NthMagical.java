package arrayshard;

import java.util.HashSet;
import java.util.Set;

public class NthMagical {

    public int nthMagicalNumber(int n, int a, int b) {
        int a_multifactor=1;
        int b_multifactor=1;

        Set<Integer> present=new HashSet<>();
        int finalans=0;

        int idx=0;
        while(idx<n){
            int ans=-1;
            if(a_multifactor*a<=b_multifactor*b){
                ans=a_multifactor*a;
                a_multifactor++;
            }else{
                ans=b_multifactor*b;
                b_multifactor++;
            }

            if(!present.contains(ans)){
                idx++;
                present.add(ans);
                finalans= ans;
            }
        }
        return finalans;
    }

    public static void main(String[] args) {
        NthMagical nthMagical=new NthMagical();
        int ans=nthMagical.nthMagicalNumber(5,2,4);
        System.out.println("Answer is "+ans);
    }
}
