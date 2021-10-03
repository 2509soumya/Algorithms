package dp;

public class Kadanes {

    public int solve(int[] arr){
        int maxsofar=arr[0];
        int maxendhere=arr[0];

        for(int i=1;i<arr.length;i++){
            maxendhere+=arr[i];
            if(maxendhere<arr[i]){
                maxendhere=arr[i];
            }
            if(maxendhere>maxsofar){
                maxsofar=maxendhere;
            }
        }
        return maxsofar;
    }

    public static void main(String[] args) {
        Kadanes kadanes=new Kadanes();
        int result=kadanes.solve(new int[]{1,2,3,-1,-1,-2,4,5});
        System.out.println("Result is "+result);
    }
}
