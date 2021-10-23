package binarysearch;

public class FloorAndCeil {

    public void floor(int[] arr,int elem){

        //floor
        int start=0;
        int end=arr.length-1;
        int res=-1;
        while(start<=end){
            int mid=(start+end)/2;
            res=arr[mid];
            if(arr[mid]<elem){
              start=mid+1;
            }else{
              end=mid-1;
            }
        }
        System.out.println("Floor is : "+res);
    }

    public void ceil(int[] arr,int elem){

        //floor
        int start=0;
        int end=arr.length-1;
        int res=-1;
        while(start<=end){
            int mid=(start+end)/2;
            res=arr[mid];
            if(arr[mid]<=elem){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        System.out.println("Ceil is : "+res);
    }

    public static void main(String[] args) {
        FloorAndCeil fc=new FloorAndCeil();
        fc.floor(new int[]{3,5,7,9,10},7);
        fc.ceil(new int[]{3,5,7,9,10},7);
    }
}
