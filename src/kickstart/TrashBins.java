package kickstart;

import java.util.Scanner;

public class TrashBins {

    public static int totdistance(String canarrange,int num){
        int[] leftarr=new int[num];
        String leftstr="";
        int lastseen=-1;
        for(int i=0;i<canarrange.length();i++){
            int val=canarrange.charAt(i)-48;
           if(val==1){
               leftarr[i]=0;
               leftstr=leftstr+'0';
               lastseen=i;
           }else if(lastseen!=-1){
               leftarr[i]=i-lastseen;
               leftstr=leftstr+'0';
           }else{
               leftarr[i]=-1;
           }
        }

        int rlastseen=-1;
        for(int i=canarrange.length()-1;i>=0;i--){
            int val=canarrange.charAt(i)-48;
            if(val==1){
                leftarr[i]=0;
                rlastseen=i;
            }else{
                if(leftarr[i]==-1){
                    leftarr[i]=rlastseen-i;
                }else if(rlastseen!=-1){
                    leftarr[i]=Math.min(leftarr[i],rlastseen-i);
                }
            }
        }


        int totsum=0;
        for(int i=0;i<leftarr.length;i++){
            totsum+=leftarr[i];
        }
        return totsum;
    }





    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcases=scanner.nextInt();
        for(int i=1;i<=testcases;i++){
            int num=scanner.nextInt();
            String res=scanner.next();
            int ans=totdistance(res,num);
            System.out.println(String.format("Case #%s: %s",i,ans));
        }
    }
}
