package segmenttree;

public class SegmentTree {

    int[] segmentspace;

    public void constructsegTree(int[] nums,int nodeidx,int start,int end){
        System.out.println(nodeidx+"----"+start+"-"+end);
        if(start==end){
            segmentspace[nodeidx]=nums[start];
            return;
        }
        int mid=(start+end)/2;
        int lnodeidx=2*nodeidx+1;
        int rnodeidx=2*nodeidx+2;
        constructsegTree(nums,lnodeidx,start,mid);
        constructsegTree(nums,rnodeidx,mid+1,end);
        segmentspace[nodeidx]=Math.max(segmentspace[lnodeidx],segmentspace[rnodeidx]);
    }


    public int querySegTreeRecurse(int nodeidx,int start,int end,int l,int r){
        if(l>end || r<start){
            return Integer.MIN_VALUE;
        }

        if((start==l && end==r) || start==end){
            return segmentspace[nodeidx];
        }else{
            int mid=(start+end)/2;
            int loutput=querySegTreeRecurse(nodeidx*2+1,start,mid,l,r);
            int routput=querySegTreeRecurse(nodeidx*2+2,mid+1,end,l,r);
            return Math.max(loutput,routput);
        }

    }

    public static void main(String[] args) {
        int[] nums= {101,98,1,2,3,4};
        SegmentTree segmentTree=new SegmentTree();
        segmentTree.segmentspace=new int[nums.length*2+1];
        segmentTree.constructsegTree(nums,0,0,nums.length-1);

        for(int i=0;i<segmentTree.segmentspace.length;i++){
            System.out.print(segmentTree.segmentspace[i]+" ");
        }
    }
}
