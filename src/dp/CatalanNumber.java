package dp;

public class CatalanNumber {

    public void generateCatalan(int n){
        int[] arr=new int[n+1];
        arr[0]=1;
        for(int i=1;i<=n;i++){
            int ans=0;
            for(int j=0;j<i;j++){
                ans+=arr[j]*arr[i-j-1];
            }
            arr[i]=ans;
        }
        System.out.println("catalan: ");
        for(int i=0;i<=n;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        CatalanNumber catalanNumber=new CatalanNumber();
        catalanNumber.generateCatalan(10);
    }
}
