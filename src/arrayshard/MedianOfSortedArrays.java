package arrayshard;

public class MedianOfSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int lo=0;
       int hi=nums1.length-1;
       int tot_len=nums1.length+nums2.length;


       while(lo<=hi){
          int mid=(lo+hi)/2+1;
          int nl=mid-lo;
          int nr=(tot_len+1)/2-nl;

          if((mid==0)){
              if(nums1[mid]>nums2[nr-1]){
                  if(tot_len%2==0){
                      return (nums2[nr-1]+nums1[mid])/2.0;
                  }else{
                      return Math.min(nums1[mid],nums2[nr-1]);
                  }
              }else{
                  if(tot_len%2==0){
                      return (nums2[nr]+nums2[nr-1])/2.0;
                  }else{
                      return nums2[nr-1];
                  }
              }
          }else if(nr==0){
              if(nums2[nr]>nums2[mid-1]){
                  if(tot_len%2==0){
                      return (nums2[nr]+nums1[mid-1])/2.0;
                  }else{
                      return Math.min(nums1[mid-1],nums2[nr]);
                  }
              }else{
                  if(tot_len%2==0){
                      return (nums1[mid]+nums1[mid-1])/2.0;
                  }else{
                      return nums1[mid-1];
                  }
              }
          }
          else if(nums2[nr]>=nums1[mid-1] && nums1[mid]>=nums2[nr-1]){
             if(tot_len%2==0){
                 return (Math.max(nums1[mid-1],nums2[nr-1])+Math.min(nums1[mid],nums2[nr]))/2.0;
             }else{
                 return Math.max(nums1[mid-1],nums2[nr-1]);
             }
          }else if(nums2[nr-1]>nums1[mid]){
              lo=mid+1;
          }else{
              hi=mid-1;
          }
       }

        int nr=(tot_len/2+1)-nums1.length;
        if(nums1[0]>nums2[nr-1]){
            if(tot_len%2==0){
                return (nums2[nr-1]+nums1[0])/2.0;
            }else{
                return Math.min(nums1[0],nums2[nr-1]);
            }
        }else{
            if(tot_len%2==0){
                return (nums2[nr]+nums2[nr-1])/2.0;
            }else{
                return nums2[nr-1];
            }
        }

    }

    public static void main(String[] args) {
        MedianOfSortedArrays medianOfSortedArrays=new MedianOfSortedArrays();
        double result=medianOfSortedArrays.findMedianSortedArrays(new int[]{1,2},new int[]{3,4});
        System.out.println("Result is "+result);
    }
}
