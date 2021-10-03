package dp;

public class LISBinarySearch {

    public int lisBinarySearch(int[] arr){


        int subseqidx=0;
        int[] subseq=new int[arr.length];
        subseq[subseqidx]=arr[0];

        for(int i=1;i<arr.length;i++){

            if(subseq[subseqidx]<arr[i]){
                subseqidx++;
                subseq[subseqidx]=arr[i];
            }else{
                int l=0;
                int r=subseqidx;
                while(l<r){
                    int mid=(l+r)/2;
                    if(subseq[mid]<arr[i]){
                        l=mid+1;
                    }else{
                        r=mid-1;
                    }
                }

                subseq[l]=arr[i];

            }
        }
        return subseqidx+1;
    }

    public static void main(String[] args) {
        LISBinarySearch lisBinarySearch=new LISBinarySearch();
        int res=lisBinarySearch.lisBinarySearch(new int[]{4,10,4,3,8,9});
        System.out.println(res);
    }



}
