public class WaysReOrderArr {

    class Response{
        int numways;
        int count;
        Response(int numways,int count){
            this.numways=numways;
            this.count=count;
        }
    }


    TreeNode root=null;
    int dp[][];

    public int numOfWays(int[] nums) {
        for(int i=0;i<nums.length;i++){
            root=bstinsert(root,nums[i]);
        }
        int n=nums.length;
        dp=printpascalsTri(n);
        Response resp=numWaysRecurse(root);
        return resp.numways-1;
    }

    public Response numWaysRecurse(TreeNode currnode){
        if(currnode==null){
            return new Response(1,0);
        }

        Response lresp= numWaysRecurse(currnode.left);
        Response rresp= numWaysRecurse(currnode.right);
        int tot_c=lresp.count+rresp.count+1;
        int tot_ways;
        if(lresp.count+rresp.count>=0){
            tot_ways=dp[lresp.count+rresp.count][lresp.count]*lresp.numways*rresp.numways;
        }else{
            tot_ways=1;
        }
        return new Response(tot_ways,tot_c);
    }

    public int[][] printpascalsTri(int n){
        int dp[][]=new int[n][n];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    dp[i][j]=1;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
                }
            }
        }
        return dp;
    }



    public TreeNode bstinsert(TreeNode currNode,int val){
        if(currNode==null){
            return new TreeNode(val);
        }

        if(val>currNode.val){
            currNode.right=bstinsert(currNode.right,val);
        }else{
            currNode.left=bstinsert(currNode.left,val);
        }
        return currNode;
    }

    public static void main(String[] args) {
        WaysReOrderArr waysReOrderArr=new WaysReOrderArr();
        int ans=waysReOrderArr.numOfWays(new int[]{3,1,2,5,4,6});
        System.out.println("Answer is "+ans);
    }


}
