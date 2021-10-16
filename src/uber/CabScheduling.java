package uber;

import java.util.PriorityQueue;

public class CabScheduling {


    private int efficientCabScheduling(int n, int[] cabTripTime) {
        int low = 0;
        int hi = Integer.MAX_VALUE;
        int mid = hi + (low - hi) / 2;
        while (low < hi) {
            mid = hi + (low - hi) / 2;
            int trips = 0;
            for (int k : cabTripTime) {
                trips += (mid / k);
            }
            if (trips == n) {
                break;
            } else if (trips < n) {
                low = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        CabScheduling cabScheduling=new CabScheduling();
        int ans=cabScheduling.efficientCabScheduling    (25,new int[]{50, 6, 16, 48, 23, 11, 16, 46, 17, 22, 32, 41, 25, 5});
        System.out.println("Answer is "+ans);
    }
}
