package zalando;

public class NextPositive {

    public int solution(int[] A) {
        // write your code in Java SE 8
        boolean[] nextpositive=new boolean[1000001];
        for(int i=0;i<A.length;i++){
            if(A[i]>0){
                nextpositive[A[i]]=true;
            }
        }

        for(int i=1;i<nextpositive.length;i++){
            if(!nextpositive[i]){
                return i;
            }
        }
        return 1000001;
    }

    public static void main(String[] args) {
        NextPositive nextPositive=new NextPositive();
        int ans=nextPositive.solution(new int[]{1, 3, 6, 4, 1, 2});
        System.out.println(ans);
    }
}
