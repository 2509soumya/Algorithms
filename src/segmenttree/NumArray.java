package segmenttree;

public class NumArray {

    int[] segarr;
    int[] nums;

    public void constructsegTree(){
        segarr=new int[4*nums.length];
        insertIntosegtree(1,0,nums.length-1);
    }

    public void insertIntosegtree(int nodeidx,int start,int end){
        if(start==end){
            segarr[nodeidx]=nums[start];
            return;
        }

        int mid=(start+end)/2;
        int lidx=2*nodeidx;
        int ridx=2*nodeidx+1;
        insertIntosegtree(lidx,start,mid);
        insertIntosegtree(ridx,mid+1,end);
        segarr[nodeidx]=segarr[lidx]+segarr[ridx];
    }

    public int query(int nodeidx,int start,int end,int l,int r){
        if(r<start || l > end){
            return 0;
        }else if(l==start && r==end){
            return segarr[nodeidx];
        }else if(start==end){
            return segarr[nodeidx];
        }else{
            int mid=(start+end)/2;
            int lres=query(2*nodeidx,start,mid,l,r);
            int rres=query(2*nodeidx+1,mid+1,end,l,r);
            return lres+rres;
        }
    }

    public NumArray(int[] nums) {
        this.nums=nums;
        constructsegTree();
    }

    public void update(int index, int val) {
        updateRecurse(1,0,nums.length-1,index,val);
    }

    public void updateRecurse(int nodeidx,int start,int end,int index, int val){
        if(start==end){
            segarr[nodeidx]=val;
            nums[start]=val;
        }else{
            int mid=(start+end)/2;
            int lidx=2*nodeidx;
            int ridx=2*nodeidx+1;
            if(start<=index && index<=mid){
                updateRecurse(lidx,start,mid,index,val);
            }else{
                updateRecurse(ridx,mid+1,end,index,val);
            }
            segarr[nodeidx]=segarr[lidx]+segarr[ridx];
        }
    }

    public int sumRange(int left, int right) {
     return query(1,0,nums.length-1,left,right);
    }

    public static void main(String[] args) {
        NumArray numArray=new NumArray(new int[]{-28,-39,53,65,11,-56,-65,-39,-43,97});
        System.out.println(numArray);
        /*numArray.update(4,6);
        numArray.update(0,2);
        numArray.update(0,9);
        System.out.println(numArray.sumRange(4,4));
        numArray.update(3,8);
        System.out.println(numArray.sumRange(0,4));*/
    }
}
