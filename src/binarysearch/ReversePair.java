package binarysearch;

public class ReversePair {
    int totalreversepaircount=0;

    public int reversePairs(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return totalreversepaircount;
    }


    public int[] mergeSort(int[] arr,int start,int end){
        if(start==end){
            return new int[]{arr[start]};
        }

        int mid=(start+end)/2;
        int[] arr1=mergeSort(arr,start,mid);
        int[] arr2=mergeSort(arr,mid+1,end);
        int i_pointer=0;
        int j_pointer=0;
        int[] finalarr=new int[arr1.length+arr2.length];
        int index=0;

        countreversepairs(arr1,arr2);

        while(i_pointer<arr1.length && j_pointer<arr2.length){
            if(arr1[i_pointer]<=arr2[j_pointer]){
                finalarr[index]=arr1[i_pointer];
                i_pointer++;
            }else{
                finalarr[index]=arr2[j_pointer];
                j_pointer++;
            }
            index++;
        }

        while(i_pointer<arr1.length){
            finalarr[index]=arr1[i_pointer];
            i_pointer++;
            index++;
        }

        while(j_pointer<arr2.length){
            finalarr[index]=arr2[j_pointer];
            j_pointer++;
            index++;
        }

        return finalarr;
    }

    public void countreversepairs(int[] arr1,int[] arr2){
        int mod=1000000007;
        int i_pointer=0;
        int j_pointer=0;
        while(i_pointer<arr1.length && j_pointer<arr2.length){
            if((long)arr1[i_pointer]>(long)2*arr2[j_pointer]){
                totalreversepaircount+=(arr1.length-i_pointer);
                j_pointer++;
            }else{
                i_pointer++;
            }
        }
    }
}
