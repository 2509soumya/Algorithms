package useful;

public class EuclidsDivision {

    public int hcf(int a,int b){
        if(b==0){
            return a;
        }else{
            return hcf(b,a%b);
        }
    }

    public static void main(String[] args) {
        EuclidsDivision euclidsDivision=new EuclidsDivision();
        int ans=euclidsDivision.hcf(15,24);
        System.out.println("Answer is "+ans);
    }

}
