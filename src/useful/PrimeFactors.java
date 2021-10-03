package useful;

public class PrimeFactors {

    public void printAllprimeFactors(int n){


        for(int i=2;i/2<n;){
            if(n%i==0){
                System.out.println(i);
                n=n/i;
            }else{
                i++;
            }
        }
    }

    public static void main(String[] args) {
         PrimeFactors primeFactors=new PrimeFactors();
         primeFactors.printAllprimeFactors(63);
    }
}
