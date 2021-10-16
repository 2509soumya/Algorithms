package practice;

public class TrappingTwoPointer {

    public int trapTwop(int[] waterarr){
        int wat=0;
        int lp=0;
        int rp=waterarr.length-1;

        int lmax=waterarr[lp];
        int rmax=waterarr[rp];
        lp++;
        rp--;
        while(lp<=rp){
            if(lmax<=rmax){
                if(waterarr[lp]>lmax){
                    lmax=waterarr[lp];
                }else{
                    wat+=(lmax-waterarr[lp]);
                }
                lp++;
            }else{
                if(waterarr[rp]>rmax){
                    rmax=waterarr[rp];
                }else{
                    wat+=(rmax-waterarr[rp]);
                }
                rp--;
            }
        }
        return wat;
    }

    public static void main(String[] args) {
        TrappingTwoPointer trappingTwoPointer=new TrappingTwoPointer();
        int ans=trappingTwoPointer.trapTwop(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println("Water trapped is "+ans);
    }
}
