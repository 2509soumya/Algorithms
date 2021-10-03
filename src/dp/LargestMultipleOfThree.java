package dp;

import java.util.Arrays;

public class LargestMultipleOfThree {

    public String largestMultipleOfThree(int[] digits) {
        int sum=0;
        for(int i=0;i<digits.length;i++){
            sum+=digits[i];
        }
        boolean[] sumarr=new boolean[sum+1];
        String[] solution=new String[sum+1];
        Arrays.sort(digits);

        for(int i=0;i<digits.length;i++){
            for(int j=0;j<sumarr.length;j++){

                if(j>digits[i] && sumarr[j-digits[i]]){
                    sumarr[j]=true;
                    solution[j]=solution[j]!=null?(digits[i]+solution[j-digits[i]]):(digits[i]+"");
                }else if(j==digits[i]){
                    sumarr[j]=true;
                    solution[j]=digits[i]+"";
                }


            }
        }

        String finalres="";
        for(int k=0;k<=sumarr.length;k++){
            if(k%3==0 && sumarr[k]){
                finalres=solution[k];
            }
        }

        return finalres;
    }

    public static void main(String[] args) {
        LargestMultipleOfThree largestMultipleOfThree=new LargestMultipleOfThree();
        String res=largestMultipleOfThree.largestMultipleOfThree(new int[]{8,6,7,1,0});
        System.out.println("Result is "+res);
    }
}
