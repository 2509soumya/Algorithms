package dp;

public class MinimumSkipsToArriveOnTime {
    int[] dist;
    int speed;
    int hoursbefore;

    public int minSkips(int[] dist, int speed, int hoursBefore) {
        this.dist=dist;
        this.speed=speed;
        this.hoursbefore=hoursBefore;
        int ans=minSkips(0,0.0);
        return (ans==Integer.MAX_VALUE)?-1:ans;
    }

    public int minSkips(int index,double tsf){
        if(tsf>hoursbefore){
            return Integer.MAX_VALUE;
        }
        if(index>=dist.length){
            return 0;
        }

        double tth=(double)dist[index]/speed;
        tsf=tth+tsf;

        if(tsf-Math.ceil(tsf)==0){
            return minSkips(index+1,tsf);
        }else{
            int withskip=minSkips(index+1,tsf);
            int withoutskip=minSkips(index+1,Math.ceil(tsf));

            return Math.min(withskip==Integer.MAX_VALUE?withskip:withskip+1,withoutskip);
        }
    }

    public static void main(String[] args) {
        MinimumSkipsToArriveOnTime minimumSkipsToArriveOnTime=new MinimumSkipsToArriveOnTime();
        int ans=minimumSkipsToArriveOnTime.minSkips(new int[]{7,3,5,5},1,10);
        System.out.println("Answer is "+ans);
    }
}
