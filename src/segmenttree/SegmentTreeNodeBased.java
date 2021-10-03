package segmenttree;

public class SegmentTreeNodeBased {

    class SegmentNode{
        int startidx,endidx;
        int val;
        SegmentNode left,right;
        SegmentNode(int startidx,int endidx,int val){
            this.startidx=startidx;
            this.endidx=endidx;
            this.val=val;
        }
        SegmentNode(int startidx,int endidx,SegmentNode left,SegmentNode right,int val){
            this.startidx=startidx;
            this.endidx=endidx;
            this.left=left;
            this.right=right;
            this.val=val;
        }
    }

    int[] nums;
    SegmentNode root;

    public SegmentTreeNodeBased(int[] nums) {
        this.nums=nums;
        root=constructsegTree(0,nums.length-1);
        System.out.println("Segment tree constructed ..");
    }

    public SegmentNode constructsegTree(int start,int end){
        if(start==end){
            return new SegmentNode(start,end,nums[start]);
        }else{
            int mid=(start+end)/2;
            SegmentNode lnode=constructsegTree(start,mid);
            SegmentNode rnode=constructsegTree(mid+1,end);
            return new SegmentNode(start,end,lnode,rnode,lnode.val+rnode.val);
        }
    }

    public int rangeQuery(int start,int end,SegmentNode root){
        if (root.endidx == end && root.startidx == start) {
            return root.val;
        } else {
            int mid = root.startidx + (root.endidx - root.startidx) / 2;
            if (end <= mid) {
                return rangeQuery(start, end,root.left);
            } else if (start >= mid+1) {
                return rangeQuery( start, end , root.right);
            }  else {
                return rangeQuery(mid+1, end, root.right) + rangeQuery(start, mid,root.left);
            }
        }
    }

    public void pointupdate(int pos,int newval,SegmentNode root){
        if(root.startidx==pos && root.endidx==pos){
            root.val=newval;
        }else{
            int mid = root.startidx + (root.endidx - root.startidx) / 2;
            if(pos<=mid){
                pointupdate(pos,newval,root.left);
            }else{
                pointupdate(pos,newval,root.right);
            }
            root.val=root.left.val+root.right.val;
        }
    }
    public void update(int pos,int newval){
        pointupdate(pos,newval,root);
    }

    public int query(int start,int end){
       return rangeQuery(start,end,root);
    }

    public static void main(String[] args) {
        SegmentTreeNodeBased segmentTreeNodeBased=new SegmentTreeNodeBased(new int[]{1, 3, 5});
        System.out.println(segmentTreeNodeBased.query(0,2));
        segmentTreeNodeBased.update(0,10);
        System.out.println(segmentTreeNodeBased.query(0,2));
        System.out.println("Done");
    }


}
