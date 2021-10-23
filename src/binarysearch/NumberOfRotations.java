package binarysearch;

public class NumberOfRotations {


    public int numRotations(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]<arr[mid-1] && arr[mid]<arr[mid+1]){
                start=mid;
                break;
            }

            if(arr[mid]<arr[start]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }

        return  start;
    }


    public static void main(String[] args) {
        NumberOfRotations numberOfRotations=new NumberOfRotations();
        int minindex=numberOfRotations.numRotations(new int[]{4,5,1,2,3});
        System.out.println(minindex);
    }

}
