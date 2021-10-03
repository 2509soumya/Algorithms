package heaps;

public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {

        int[] iterative_arr=new int[1000];
        for(int i=0;i<trips.length;i++){
            int start=trips[i][1];
            int end=trips[i][2];
            int passengers=trips[i][0];
            iterative_arr[start]+=passengers;
            iterative_arr[end]-=passengers;
        }

        int cum=0;
        for(int j=0;j<iterative_arr.length;j++){
            cum+=iterative_arr[j];
            if(cum>capacity){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CarPooling carPooling=new CarPooling();
        boolean ans=carPooling.carPooling(new int[][]{{2,1,5},{3,3,7}},4);
        System.out.println(ans);
    }
}
