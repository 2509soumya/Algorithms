package arrayshard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestDuplicate {

    int coeff=26;
    int mod=1000000007;
    int[] powerlookup;
    String s;

    public String longestDupSubstring(String s){
        this.s=s;
        this.powerlookup=new int[s.length()];
        powerlookup[0]=1;
        for(int i=1;i<powerlookup.length;i++){
            powerlookup[i]=(powerlookup[i-1]*coeff)%mod;
        }

        int lo=1;
        int hi=s.length();
        String maxsofar="";
        while(lo<hi){
            int mid=(lo+hi)/2;
            String res=checkforduplicate(mid);
            if(res!=""){
                maxsofar=res;
                lo=mid+1;
            }else{
                hi=mid;
            }
        }
        return maxsofar;
    }

    public String checkforduplicate(int size){
        Map<Integer,String> supposedhashes=new HashMap<>();

        int currhash=0;
        int currsize=0;
        for(int i=0;i<s.length();i++){
            int currcharnum=s.charAt(i)-'a';
            currsize++;
            if(currsize<=size){
                currhash+=(powerlookup[currsize-1]*currcharnum)%mod;
                if(currsize==size){
                    supposedhashes.put(currhash,s.substring(i-size+1,i+1));
                }
            }else{
                currhash=((currhash-(s.charAt(i-size)-'a'))/coeff+((powerlookup[size-1]*currcharnum)%mod))%mod;
                if(supposedhashes.containsKey(currhash) && s.substring(i-size+1,i+1).equalsIgnoreCase(supposedhashes.get(currhash))){
                    return s.substring(i-size+1,i+1);
                }
                supposedhashes.put(currhash,s.substring(i-size+1,i+1));
            }
        }
        return "";
    }

    public static void main(String[] args) {
        LongestDuplicate longestDuplicate=new LongestDuplicate();
        String ans=longestDuplicate.longestDupSubstring("banana");
        System.out.println(ans);
    }
}
